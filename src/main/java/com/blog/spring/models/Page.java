package com.blog.spring.models;

import javax.persistence.*;

@Entity
public class Page {
	@Id
	@GeneratedValue
	private int id;
	
	@Column(nullable = false)
	private String title;
	
	public String getTitle(){
		return title;
	}
	
	public void setTitle(String t){
		title = t;
	}
	
	@Column(nullable = false)
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
	
	public Page(){
	}
	
	public Page(String tt, String txt, String pn){
		title = tt;
		text = txt;
		page_name = pn;
	}
	
}
