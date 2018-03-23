package com.blog.spring.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class CustomRole implements GrantedAuthority {

	@Id
	@GeneratedValue
	private int id;
	
	private static final long serialVersionUID = 1761520177524566506L;
	
	@Column( nullable = false)
	private String role;
	
	public void setAuthority(String s) {
		role = s;
	}
	
	public String getAuthority() {
		return role;
	}

	public CustomRole(String r){
		role = r;
	}
	
	public CustomRole(){
	}
}
