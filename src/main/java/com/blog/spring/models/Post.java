package com.blog.spring.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Post {
	@Id
	@GeneratedValue
	private int id;
	
	public int getId(){
		return id;
	}
	
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
	
	@OneToMany(targetEntity = Comment.class, orphanRemoval = true)
	private List<Comment> comments;
	
	public List<Comment> getComments(){
		return comments;
	}
	
	public void setComments(List<Comment> c){
		comments = c;
	}
	
	public Post(){
		comments = new ArrayList<Comment>();
	}
}
