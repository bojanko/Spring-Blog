package com.blog.spring.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class DummyDataController {
	@Autowired
	private PageDAO pageDAO;
	@Autowired
	private PostDAO postDAO;

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
