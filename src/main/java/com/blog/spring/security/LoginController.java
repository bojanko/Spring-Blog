package com.blog.spring.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(){
		return "login/login";
	}
	
	@RequestMapping(value = "/perform_login", method = RequestMethod.POST)
	public String login_submit(){
		return "login/login";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	/*POST IS REQUIRED IF CSRF IS USED*/
	public String logout(){
		return "login/login";
	}
}
