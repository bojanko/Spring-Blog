package com.blog.spring.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Comment {
	@Id
	@GeneratedValue
	private int id;
	
	public int getId(){
		return id;
	}
	
	@Column(nullable = false)
	@NotBlank(message = "Name is required!")
	private String name;

	public String getName(){
		return name;
	}
	
	public void setName(String n){
		name = n;
	}
	
	@Column(nullable = true)
	@NotBlank(message = "Email is required!")
	@Pattern( regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", message = "Email is invalid!")
	private String email;
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String e){
		email = e;
	}
	
	@Column(nullable = false)
	@NotBlank(message = "Message is required!")
	private String text;
	
	public String getText(){
		return text;
	}
	
	public void setText(String t){
		text = t;
	}
	
	@Column(nullable = false)
	private boolean allowed;
	
	public boolean getAllowed(){
		return allowed;
	}
	
	public void setAllowed(boolean a){
		allowed = a;
	}
	
	public Comment(){
	}
	
}
