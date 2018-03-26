package com.blog.spring.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component 
public class LoggerAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(LoggerAspect.class);
	
	@Before(value="execution(* com.blog.spring.controllers.PageController.*(..))", argNames = "joinPoint")
	public void logger(JoinPoint joinPoint){
		logger.info("Welcome to "+joinPoint.getSignature().getName()+" page!");
	}
}
