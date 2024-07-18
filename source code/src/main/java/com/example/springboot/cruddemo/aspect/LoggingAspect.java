package com.example.springboot.cruddemo.aspect;

import com.example.springboot.cruddemo.entity.Log;
import com.example.springboot.cruddemo.storage.LogStorage;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

	private Logger myLogger = Logger.getLogger(getClass().getName());

	@Autowired
	private LogStorage logStorage;

	@Pointcut("execution(* com.example.springboot.cruddemo.controller.*.*(..))")
	private void forControllerPackage() {}

	@Pointcut("execution(* com.example.springboot.cruddemo.service.*.*(..)) && !execution(* com.example.springboot.cruddemo.service.LogService.*(..))")
	private void forServicePackage() {}

	@Pointcut("execution(* com.example.springboot.cruddemo.dao.*.*(..))")
	private void forDAOPackage() {}

	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
	private void forAppFlow() {}

	@Around("forAppFlow()")
	public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		String method = proceedingJoinPoint.getSignature().toShortString();
		myLogger.info("=====> in @Around: calling method: " + method);

		long begin = System.currentTimeMillis();

		Object result;

		try {
			result = proceedingJoinPoint.proceed();
		} catch (Exception e) {
			myLogger.warning("=====> in @Around: exception: " + e);

			Log log = new Log();
			log.setMethod(method);
			log.setArgs(Arrays.toString(proceedingJoinPoint.getArgs()));
			log.setException(e.toString());
			log.setTimestamp(new Date());

			logStorage.addLog(log);

			throw e;
		}

		long end = System.currentTimeMillis();
		long duration = end - begin;
		myLogger.info("=====> Duration: " + duration / 1000.0 + " seconds");

		Log log = new Log();
		log.setMethod(method);
		log.setArgs(Arrays.toString(proceedingJoinPoint.getArgs()));
		log.setResult(result != null ? result.toString() : "null");
		log.setDuration(duration);
		log.setTimestamp(new Date());

		logStorage.addLog(log);

		return result;
	}
}
