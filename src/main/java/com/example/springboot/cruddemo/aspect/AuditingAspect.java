package com.example.springboot.cruddemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class AuditingAspect {

	@Before("execution(* com.example.springboot.thymeleafdemo.service.*.save*(..))")
	public void beforeSave(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		// Assume that the first argument is the entity being saved
		Object entity = args[0];
		System.out.println("Audit: About to save entity: " + entity);
		System.out.println("Timestamp: " + new Date());
	}

	@Before("execution(* com.example.springboot.thymeleafdemo.service.*.delete*(..))")
	public void beforeDelete(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		// Assume that the first argument is the ID of the entity being deleted
		Object id = args[0];
		System.out.println("Audit: About to delete entity with ID: " + id);
		System.out.println("Timestamp: " + new Date());
	}
}
