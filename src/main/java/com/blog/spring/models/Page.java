package com.blog.spring.models;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Page {
	@Id
	@GeneratedValue
	private int id;
	
	@Column(nullable = false)
	@NotBlank(message = "Title is required!")
	private String title;
	
	public String getTitle(){
		return title;
	}
	
	public void setTitle(String t){
		title = t;
	}
	
	@Column(nullable = false)
	@NotBlank(message = "Text is required!")
	private String text;
	
	public String getText(){
		return text;
	}
	
	public void setText(String t){
		text = t;
	}
	
	@Column(nullable = false)
	private String page_name;
	
	public String getPageName(){
		return page_name;
	}
	
	public void setPageName(String pn){
		page_name = pn;
	}
	
	public String getPage_name(){
		return page_name;
	}
	
	public Page(){
	}
	
	public Page(String tt, String txt, String pn){
		title = tt;
		text = txt;
		page_name = pn;
	}
	
}
