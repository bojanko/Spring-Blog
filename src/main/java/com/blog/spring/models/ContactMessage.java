package com.blog.spring.models;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

public class ContactMessage {
	@NotBlank(message = "Name is required!")
	private String name;
	
	public void setName(String n){
		name = n;
	}
	
	public String getName(){
		return name;
	}
	
	@NotBlank(message = "Email is required!")
	@Pattern( regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", message = "Email is invalid!")
	private String email;
	
	public void setEmail(String e){
		email = e;
	}
	
	public String getEmail(){
		return email;
	}
	
	@NotBlank(message = "Message is required!")
	private String text;
	
	public void setText(String t){
		text = t;
	}
	
	public String getText(){
		return text;
	}
}
