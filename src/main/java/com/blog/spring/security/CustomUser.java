package com.blog.spring.security;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class CustomUser implements UserDetails {

	@Id
	@GeneratedValue
	private int id;
	
	private static final long serialVersionUID = 6326000870285971193L;
	
	@Column(nullable = false)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@OneToMany(fetch = FetchType.EAGER, targetEntity = CustomRole.class, orphanRemoval = true)
	private Collection<CustomRole> roles;
	
	public CustomUser(){
	}
	
	public CustomUser(String u, String p, Collection<CustomRole> r) {
		username = u;
		password = p;
		roles = r;
	}

	public void setAuthorities(Collection<CustomRole> r) {
		roles = r;
	}

	public Collection<CustomRole> getAuthorities() {
		return roles;
	}

	public void setPassword(String p) {
		password = p;
	}
	
	public String getPassword() {
		return password;
	}

	public void setUsername(String u) {
		username = u;
	}
	
	public String getUsername() {
		return username;
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return true;
	}

}
