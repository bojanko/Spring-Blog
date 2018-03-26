package com.blog.spring.profile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.blog.spring.security.CustomUser;

@Entity
public class AdminRequest {
	@Id
	@GeneratedValue
	private int id;
	
	public int getId(){
		return id;
	}
	
	@OneToOne(targetEntity = CustomUser.class, orphanRemoval = true)
	private CustomUser user;
	
	public CustomUser getUser(){
		return user;
	}
	
	public void setUser(CustomUser u){
		user = u;
	}
	
	@Column(nullable = true)
	private Boolean approved;
	
	public Boolean getApproved(){
		return approved;
	}
	
	public void setApproved(Boolean a){
		approved = a;
	}
	
	public AdminRequest(){
	}
}
