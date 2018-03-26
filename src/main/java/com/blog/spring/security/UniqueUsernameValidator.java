package com.blog.spring.security;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UniqueUsernameValidator implements
ConstraintValidator<Unique, String>{
	
	@Autowired
	CustomUserService userService;

	public void initialize(Unique constraintAnnotation) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		try{
			userService.loadUserByUsername(value);
			return false;
		}
		catch(UsernameNotFoundException ex){
			return true;
		}
	}

}
