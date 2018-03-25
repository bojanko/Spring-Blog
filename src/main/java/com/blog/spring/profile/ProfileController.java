package com.blog.spring.profile;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.blog.spring.security.CustomUser;
import com.blog.spring.security.CustomUserService;


/**
 * Handles requests for the application pages.
 */
@Controller
@RequestMapping("/profile")
public class ProfileController {
	@Autowired
	CustomUserService userService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String profile(Principal principal, Model model) {
		model.addAttribute("user", new CustomUser());
		
		model.addAttribute("role",
				userService.loadUserByUsername(principal.getName()).getAuthorities());
		model.addAttribute("success", false);
		
		return "profile/profile";
	}
	/*PASSWORD CHANGE*/
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String password(@Validated(CustomUser.Group2.class) @ModelAttribute("user") CustomUser user,
			BindingResult bindingResult, Principal principal, Model model) {
		
		/*PROVERA VALIDNOSTI FORME*/
        if (bindingResult.hasErrors()) {
        	model.addAttribute("role",
    				userService.loadUserByUsername(principal.getName()).getAuthorities());
        	model.addAttribute("success", false);
        	
            return "profile/profile";
        }
		
		/*PROMENA ŠIFRE*/
        userService.setPassword((CustomUser) userService.loadUserByUsername(principal.getName()),
        		user.getPassword());
		
		model.addAttribute("user", new CustomUser());
		model.addAttribute("success", true);
		model.addAttribute("role",
				userService.loadUserByUsername(principal.getName()).getAuthorities());
		
		return "profile/profile";
	}
}
