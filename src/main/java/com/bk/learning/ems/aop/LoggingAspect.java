package com.bk.learning.ems.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class LoggingAspect {
	
	@Around("execution(* com.bk.learning.ems..*(..))")
	public Object logAroundAllMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
		String className = methodSignature.getDeclaringType().getSimpleName();
		String methodName = methodSignature.getName();
		
		log.debug(className + "." + methodName + " :: Execution started");
		
		final StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		Object result = proceedingJoinPoint.proceed();
		stopWatch.stop();
		
		log.debug(className + "." + methodName + " :: Execution ended in " + stopWatch.getTotalTimeMillis() + " ms");
		return result;
	}
	
	
	
	@AfterThrowing(pointcut = "execution(* com.bk.learning.ems..*(..))", throwing = "ex")
	public void logAfterThrowingAllMethods(JoinPoint joinPoint, Throwable ex) {
		
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		String className = methodSignature.getDeclaringType().getSimpleName();
		String methodName = methodSignature.getName();
		
		log.error(className + "." + methodName + " :: Exception occured - "+ex);
		
	}
	
}
