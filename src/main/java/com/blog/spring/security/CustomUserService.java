package com.blog.spring.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service( value = "userDetailsService")
public class CustomUserService implements UserDetailsService {
	@Autowired
	private PasswordEncoder passEncoder;
	
	@Autowired
    private UserDAO userDAO;
	
	@Autowired
    private RoleDAO roleDAO;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			CustomUser user = userDAO.getUserByUsername(username);
			
			if(user == null){
				throw new UsernameNotFoundException("User not found!");
			}
			
			return user;
	}
	
	public void addUser(CustomUser user){
		if(user.getAuthorities().isEmpty()){
			CustomRole role = roleDAO.getRoleByName("ROLE_USER");
			List<CustomRole> roles = new ArrayList<CustomRole>();
			roles.add(role);
			
			user.setAuthorities(roles);
		}
		
		user.setPassword(passEncoder.encode(user.getPassword()));
		
		userDAO.addUser(user);
	}
	
	public void setPassword(CustomUser user, String un){
		user.setPassword(passEncoder.encode(un));
		
		userDAO.updateUser(user);
	}
	
	public void updateUser(CustomUser user){
		userDAO.updateUser(user);
	}
}
