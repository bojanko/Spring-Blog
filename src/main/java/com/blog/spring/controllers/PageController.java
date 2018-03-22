package com.blog.spring.controllers;

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
		/*PRIBAVLJANJE POSTOVA I PROSLEDJIVANJE TEMPLEJTU*/
		List<Post> posts = postDAO.getPostsPerPage(1);
		paginator.setData(postDAO.getAllPosts(), 1);

		model.addAttribute("posts", posts);
		model.addAttribute("paginator", paginator );
		
		setBasicPageInfo(model, "home");
		return "home";
	}
	/*PRIKAZ STRANICA*/
	@RequestMapping(value = "/page/{page}", method = RequestMethod.GET)
	public String home_page(Model model, @PathVariable(value = "page") int page) {
		/*PRIBAVLJANJE POSTOVA I PROSLEDJIVANJE TEMPLEJTU*/
		List<Post> posts = postDAO.getPostsPerPage(page);
		paginator.setData(postDAO.getAllPosts(), page);

		model.addAttribute("posts", posts);
		model.addAttribute("paginator", paginator );
		
		setBasicPageInfo(model, "home");
		return "home";
	}
	/*PRIKAZ POSTA*/
	@RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
	public String post(Model model, @PathVariable(value = "id") int id) {
		/*PRIBAVLJANJE POSTOVA I PROSLEDJIVANJE TEMPLEJTU*/
		Post post = postDAO.getPostById(id);

		model.addAttribute("post", post);		
		return "post";
	}
	/*PRIKAZ POSTOVA WIDGET*/
	@RequestMapping(value = "/posts_widget", method = RequestMethod.GET)
	public String posts_widget(Model model) {
		/*PRIBAVLJANJE POSTOVA I PROSLEDJIVANJE TEMPLEJTU*/
		List<Post> posts = postDAO.getPostsPerPage(1, 3);

		model.addAttribute("posts", posts);		
		return "posts_widget";
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
}
