package com.blog.spring.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.blog.spring.dao.PageDAO;
import com.blog.spring.dao.PostDAO;
import com.blog.spring.helpers.Mailer;
import com.blog.spring.helpers.Paginator;
import com.blog.spring.models.ContactMessage;
import com.blog.spring.models.Page;
import com.blog.spring.models.Post;

/**
 * Handles requests for the application pages.
 */
@Controller
public class PageController {
	@Autowired
	private PageDAO pageDAO;
	@Autowired
	private PostDAO postDAO;
	@Autowired
	private Mailer mailer;
	@Autowired
	private Paginator<Post> paginator;
	
	private void setBasicPageInfo(Model model, String page_name){
		/*BASIC PAGE INFO*/
		Page page = pageDAO.getPageByName(page_name);
		model.addAttribute("title", page.getTitle());
		model.addAttribute("page", page.getPageName());
		model.addAttribute("txt", page.getText());
		/*END BASIC PAGE INFO*/
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		List<Post> posts = postDAO.getAllPosts();
		
		paginator.setData(posts, 1);
		System.err.println(paginator.getPrev());
		System.err.println(paginator.getLink1());
		System.err.println(paginator.getLink2());
		System.err.println(paginator.getLink3());
		System.err.println(paginator.getNext());
		
		setBasicPageInfo(model, "home");
		return "home";
	}
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about(Model model) {
		setBasicPageInfo(model, "about");
		return "about";
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contact(Model model) {
		setBasicPageInfo(model, "contact");
		model.addAttribute("success", false);
		model.addAttribute("contact", new ContactMessage());
		return "contact";
	}
	
	/*OBRADA POSLATE FORME*/
	@RequestMapping(value = "/contact", method = RequestMethod.POST)
	public String contact_submit(@Valid @ModelAttribute("contact") ContactMessage contact,
			BindingResult bindingResult, Model model) {
		
		/*PROVERA VALIDNOSTI FORME*/
        if (bindingResult.hasErrors()) {
        	setBasicPageInfo(model, "contact");
        	model.addAttribute("success", false);
            return "contact";
        }
		
        /*SLANJE PORUKE*/
		mailer.sendMail(contact.getEmail(), "hi@bojanko.com",
				"Contact from " + contact.getName(), contact.getText());
		
		setBasicPageInfo(model, "contact");
		model.addAttribute("success", true);
		return "redirect:/contact";
	}
	
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(Model model) {
		//DUMMY DATA FOR BASIC PAGE INFO
		/*Page home_page = new Page("Welcome to home page", "Content of home page", "home");
		Page about_page = new Page("Welcome to about page", "Content of about page", "about");
		Page contact_page = new Page("Welcome to contact page", "Content of contact page", "contact");
		pageDAO.addPage(home_page);
		pageDAO.addPage(about_page);
		pageDAO.addPage(contact_page);*/
		
		//DUMMY POSTS
		/*for(int i = 1; i < 17; i++){
			Post post = new Post();
			post.setComments(null);
			post.setTitle("Example post " + i);
			post.setText("This is example post " + i);
			postDAO.addPost(post);
		}*/
		
		return "home";
	}
}
