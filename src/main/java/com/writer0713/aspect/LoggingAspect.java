package com.writer0713.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

//	@Before("execution(* com.writer0713.services.*.*(..))")
	@Before("@annotation(CustomLogging)")
	public void LoggingAdvice() {
		System.out.println("Advice run!!!");
	}
}
