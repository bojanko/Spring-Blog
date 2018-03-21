package com.blog.spring;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
            return "contact";
        }
		
        /*OBRADA PODATAKA*/
		System.err.println(contact.getName());
		System.err.println(contact.getEmail());
		System.err.println(contact.getText());
		
		setBasicPageInfo(model, "contact");
		model.addAttribute("contact", new ContactMessage());
		return "contact";
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
		
		return "home";
	}
}
