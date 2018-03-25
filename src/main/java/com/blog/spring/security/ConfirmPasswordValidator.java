package com.blog.spring.security;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ConfirmPasswordValidator implements
ConstraintValidator<ConfirmPassword, CustomUser>{
	

	public void initialize(ConfirmPassword constraintAnnotation) {
	}

	public boolean isValid(CustomUser user, ConstraintValidatorContext context) {
		return user.getPassword().equals(user.getPassword_confirm());
	}

}