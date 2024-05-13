package com.librarymanagementsystem.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect
{

	private final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

	@Before("execution(* com.librarymanagementsystem.service.*.*(..))")
	public void logMethodCall(JoinPoint joinPoint)
	{
		logger.info("Method {} is called with arguments {}", joinPoint.getSignature(), joinPoint.getArgs());
	}

	@AfterReturning(pointcut = "execution(* com.librarymanagementsystem.service.*.*(..))", returning = "result")
	public void logMethodReturn(JoinPoint joinPoint, Object result)
	{
		logger.info("Method {} returned {}", joinPoint.getSignature(), result);
	}

	@AfterThrowing(pointcut = "execution(* com.librarymanagementsystem.service.*.*(..))", throwing = "exception")
	public void logException(JoinPoint joinPoint, Exception exception)
	{
		logger.error("Exception in method {}: {}", joinPoint.getSignature(), exception.getMessage());
	}
}