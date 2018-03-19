package com.blog.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application pages.
 */
@Controller
public class PageController {
	/**
	 * Simply selects the home view to render by returning its name.
	 */
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
}
