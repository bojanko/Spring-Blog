package com.blog.spring.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import com.blog.spring.security.CustomRole;
import com.blog.spring.security.CustomUser;
import com.blog.spring.security.CustomUserService;
import com.blog.spring.security.RoleDAO;
import com.blog.spring.security.UserDAO;

/**
 * Handles requests for the application pages.
 */
@Controller
public class DummyDataController {
	@Autowired
	private PageDAO pageDAO;
	@Autowired
	private PostDAO postDAO;
	@Autowired
	private CustomUserService userDetailsService;
	@Autowired
	private RoleDAO roleDAO;

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
		//DUMMY USER
		/*List<CustomRole> roles = new ArrayList<CustomRole>();
		CustomRole r_user = new CustomRole("ROLE_USER");
		CustomRole r_admin = new CustomRole("ROLE_ADMIN");
		roles.add(r_user);
		roles.add(r_admin);
		
		roleDAO.addRole(r_user);
		roleDAO.addRole(r_admin);
		
		CustomUser user = new CustomUser("admin", "password", roles);
		userDetailsService.addUser(user);*/
		
		CustomUser user = (CustomUser) userDetailsService.loadUserByUsername("admin");
		System.out.println(user.getUsername());
		
		return "home";
	}
}
