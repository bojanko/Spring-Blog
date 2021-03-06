package com.blog.spring.admin;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.blog.spring.dao.CommentDAO;
import com.blog.spring.dao.PageDAO;
import com.blog.spring.dao.PostDAO;
import com.blog.spring.helpers.Paginator;
import com.blog.spring.models.Comment;
import com.blog.spring.models.Page;
import com.blog.spring.models.Post;
import com.blog.spring.profile.AdminRequest;
import com.blog.spring.profile.AdminRequestDAO;
import com.blog.spring.security.CustomRole;
import com.blog.spring.security.CustomUser;
import com.blog.spring.security.CustomUserService;
import com.blog.spring.security.RoleDAO;


/**
 * Handles requests for the application pages.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	CustomUserService userService;
	
	@Autowired
	RoleDAO roleDAO;
	
	@Autowired
	CommentDAO commentDAO;
	
	@Autowired
	AdminRequestDAO adminRequestDAO;
	
	@Autowired
	PageDAO pageDAO;
	
	@Autowired
	PostDAO postDAO;
	
	@Autowired
	Paginator<Post> paginator;
	
	@RequestMapping(value = "/moderate", method = RequestMethod.GET)
	public String moderate(Model model) {
		/*GET COMMENTS*/
		List<Comment> comments = new ArrayList<Comment>();
		comments = commentDAO.getAllComments();
		
		model.addAttribute("comments", comments);

		return "admin/moderate";
	}
	/*BLOCK COMMENT*/
	@RequestMapping(value = "/moderate/block/{id}", method = RequestMethod.GET)
	public String moderate_block(Model model, @PathVariable(value = "id") int id) {
		Comment comm = commentDAO.getCommentById(id);
		comm.setAllowed(false);
		commentDAO.updateComment(comm);
		
		return "redirect:/admin/moderate";
	}
	/*ALLOW COMMENT*/
	@RequestMapping(value = "/moderate/allow/{id}", method = RequestMethod.GET)
	public String moderate_allow(Model model, @PathVariable(value = "id") int id) {
		Comment comm = commentDAO.getCommentById(id);
		comm.setAllowed(true);
		commentDAO.updateComment(comm);
		
		return "redirect:/admin/moderate";
	}
	
	
	
	@RequestMapping(value = "/requests", method = RequestMethod.GET)
	public String admin_requests(Model model) {
		/*GET REQUESTS*/
		List<AdminRequest> requests = new ArrayList<AdminRequest>();
		requests = adminRequestDAO.getAllAdminRequests();
		
		model.addAttribute("requests", requests);

		return "admin/admin_requests";
	}
	/*BLOCK REQUEST*/
	@RequestMapping(value = "/requests/block/{id}", method = RequestMethod.GET)
	public String moderate_block_request(Model model, @PathVariable(value = "id") int id) {
		AdminRequest request = adminRequestDAO.getAdminRequestById(id);
		request.setApproved(false);
		adminRequestDAO.updateAdminRequest(request);
		
		return "redirect:/admin/requests";
	}
	/*ALLOW REQUEST*/
	@RequestMapping(value = "/requests/allow/{id}", method = RequestMethod.GET)
	public String moderate_allow_request(Model model, @PathVariable(value = "id") int id) {
		AdminRequest request = adminRequestDAO.getAdminRequestById(id);
		request.setApproved(true);
		
		CustomUser user = request.getUser();
		CustomRole role = roleDAO.getRoleByName("ROLE_ADMIN");
		user.getAuthorities().add(role);
		
		userService.updateUser(user);
		adminRequestDAO.updateAdminRequest(request);
		
		return "redirect:/admin/requests";
	}
	
	

	@RequestMapping(value = "/page/{page}", method = RequestMethod.GET)
	public String edit_page(Model model, @PathVariable(value = "page") String page) {
		Page page_obj = pageDAO.getPageByName(page);
		
		model.addAttribute("page_obj", page_obj);
		model.addAttribute("success", false);
		
		return "admin/page";
	}
	/*HANDLE UPDATE*/
	@RequestMapping(value = "/page/{page}", method = RequestMethod.POST)
	public String edit_page_submit(@Valid @ModelAttribute("page_obj") Page page_obj,
			BindingResult bindingResult, Model model, @PathVariable(value = "page") String page) {
		
		/*PROVERA VALIDNOSTI FORME*/
        if (bindingResult.hasErrors()) {
        	model.addAttribute("success", false);
            return "admin/page";
        }
          
        /*UPDATE PAGE IN DATABASE*/
        Page db_page = pageDAO.getPageByName(page);
        db_page.setText(page_obj.getText());
        db_page.setTitle(page_obj.getTitle());
        pageDAO.updatePage(db_page);
		
		model.addAttribute("page_obj", page_obj);
		model.addAttribute("success", true);
		
		return "admin/page";
	}
	
	
	
	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public String posts(Model model) {
		/*GET POSTSS*/
		List<Post> posts = new ArrayList<Post>();
		posts = postDAO.getPostsPerPage(1, 10);
		paginator.setData(postDAO.getAllPosts(), 10, 1);
		
		model.addAttribute("posts", posts);
		model.addAttribute("paginator", paginator);

		return "admin/posts";
	}
	/*PAGES*/
	@RequestMapping(value = "/posts/page/{page}", method = RequestMethod.GET)
	public String posts_page(Model model, @PathVariable(value = "page") int page) {
		/*GET POSTSS*/
		List<Post> posts = new ArrayList<Post>();
		posts = postDAO.getPostsPerPage(page, 10);
		paginator.setData(postDAO.getAllPosts(), 10, page);
		
		model.addAttribute("posts", posts);
		model.addAttribute("paginator", paginator);

		return "admin/posts";
	}
	/*DELETE POST*/
	@RequestMapping(value = "/posts/delete/{id}", method = RequestMethod.GET)
	public String posts_delete(Model model, @PathVariable(value = "id") int id) {
		postDAO.deletePost(postDAO.getPostById(id));

		return "redirect:/admin/posts";
	}
	/*UPDATE POST*/
	@RequestMapping(value = "/posts/edit/{id}", method = RequestMethod.GET)
	public String posts_update(Model model, @PathVariable(value = "id") int id) {
		Post post = postDAO.getPostById(id);
		
		model.addAttribute("post", post);
		model.addAttribute("success", false);

		return "admin/post";
	}
	/*HANDLE UPDATE POST*/
	@RequestMapping(value = "/posts/edit/{id}", method = RequestMethod.POST)
	public String posts_update_submit(@Valid @ModelAttribute("post") Post post,
			BindingResult bindingResult, Model model, @PathVariable(value = "id") int id) {
		Post db_post = postDAO.getPostById(id);
		db_post.setTitle(post.getTitle());
		db_post.setText(post.getText());
		
		postDAO.updatePost(db_post);		
		
		model.addAttribute("post", post);
		model.addAttribute("success", true);

		return "admin/post";
	}
	/*INSERT POST*/
	@RequestMapping(value = "/posts/insert", method = RequestMethod.GET)
	public String posts_insert(Model model) {
		model.addAttribute("post", new Post());
		model.addAttribute("success", false);

		return "admin/post_insert";
	}
	/*HANDLE INSERT POST*/
	@RequestMapping(value = "/posts/insert", method = RequestMethod.POST)
	public String posts_insert_submit(@Valid @ModelAttribute("post") Post post,
			BindingResult bindingResult, Model model) {
		postDAO.addPost(post);	
		
		model.addAttribute("post", new Post());
		model.addAttribute("success", true);

		return "admin/post_insert";
	}
}
