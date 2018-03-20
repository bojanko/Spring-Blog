package com.blog.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.blog.spring.Page;

/**
 * Handles requests for the application pages.
 */
@Controller
public class PageController {
	@Autowired
	private PageDAO pageDAO;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		/*BASIC PAGE INFO*/
		model.addAttribute("title", "Welcome to home page!");
		model.addAttribute("page", "home");
		/*END BASIC PAGE INFO*/
		return "home";
	}
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about(Model model) {
		/*BASIC PAGE INFO*/
		model.addAttribute("title", "Welcome to about page!");
		model.addAttribute("page", "about");
		/*END BASIC PAGE INFO*/
		return "home";
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contact(Model model) {
		/*BASIC PAGE INFO*/
		model.addAttribute("title", "Welcome to contact page!");
		model.addAttribute("page", "contact");
		/*END BASIC PAGE INFO*/
		return "home";
	}
	
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(Model model) {
		Page home_page = new Page("Welcome to home page", "Content of home page", "home");
		Page about_page = new Page("Welcome to about page", "Content of about page", "about");
		Page contact_page = new Page("Welcome to contact page", "Content of contact page", "contact");
		pageDAO.addPage(home_page);
		pageDAO.addPage(about_page);
		pageDAO.addPage(contact_page);
		
		return "home";
	}
}
