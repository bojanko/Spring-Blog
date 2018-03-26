package com.blog.spring.security;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@ConfirmPassword(message = "Password and confirmation are different!",
groups = {com.blog.spring.security.CustomUser.Group2.class})
public class CustomUser implements UserDetails, Serializable {
	/*VALIDATION GROUPS*/
	public interface Group1{
	}
	public interface Group2{
	}

	@Id
	@GeneratedValue
	private int id;
	
	private static final long serialVersionUID = 6326000870285971193L;
	
	@Column(nullable = false)
	@NotBlank(message = "Username is required!", groups = {Group1.class})
	@Unique(message = "Username already exists!", groups = {Group1.class})
	private String username;
	
	@Column(nullable = false)
	@NotBlank(message = "Password is required!", groups = {Group2.class})
	@Size(min = 6, message = "Password has to be at least 6 characters long!", groups = {Group2.class})
	private String password;
	
	@Transient
	@NotBlank(message = "Password confirmation is required!", groups = {Group2.class})
	private String password_confirm;
	
	@ManyToMany(fetch = FetchType.EAGER, targetEntity = CustomRole.class)
	private Collection<CustomRole> roles;
	
	public CustomUser(){
		roles = new ArrayList<CustomRole>();
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

	public void setPassword_confirm(String p) {
		password_confirm = p;
	}
	
	public String getPassword_confirm() {
		return password_confirm;
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
