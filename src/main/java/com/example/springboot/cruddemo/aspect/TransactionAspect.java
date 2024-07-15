package com.example.springboot.cruddemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Aspect
@Component
@Transactional
public class TransactionAspect {

	@Pointcut("execution(* com.example.springboot.thymeleafdemo.service.*.*(..))")
	private void forServicePackage() {}

	@Before("forServicePackage()")
	public void startTransaction() {
		System.out.println("Transaction started");
	}

	@After("forServicePackage()")
	public void commitTransaction() {
		System.out.println("Transaction committed");
	}

	@AfterThrowing("forServicePackage()")
	public void rollbackTransaction() {
		System.out.println("Transaction rolled back");
	}
}
