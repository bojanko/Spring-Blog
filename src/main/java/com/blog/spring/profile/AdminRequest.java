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
	
	@OneToOne(targetEntity = CustomUser.class, orphanRemoval = true)
	private CustomUser user;
	
	public CustomUser getUser(){
		return user;
	}
	
	public void setUser(CustomUser u){
		user = u;
	}
	
	@Column(nullable = false)
	private boolean approved;
	
	public boolean getApproved(){
		return approved;
	}
	
	public void setApproved(boolean a){
		approved = a;
	}
	
	public AdminRequest(){
	}
}
