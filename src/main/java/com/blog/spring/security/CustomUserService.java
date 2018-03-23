package com.blog.spring.security;

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

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			CustomUser user = userDAO.getUserByUsername(username);
			
			if(user == null){
				throw new UsernameNotFoundException("User not found!");
			}
			
			return user;
	}
	
	public void addUser(CustomUser user){
		user.setPassword(passEncoder.encode(user.getPassword()));
		userDAO.addUser(user);
	}
}
