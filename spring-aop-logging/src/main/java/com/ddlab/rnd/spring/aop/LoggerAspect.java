package com.ddlab.rnd.spring.aop;

import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggerAspect {
	private static final Logger logger = LoggerFactory
			.getLogger(LoggerAspect.class);

	@Pointcut("within(@org.springframework.stereotype.Controller *)")
	public void controllerBean() {
	}

	@Pointcut("within(@org.springframework.stereotype.Service *)")
	public void serviceBean() {
	}

	@Pointcut("within(@org.springframework.stereotype.Repository *)")
	public void repositoryBean() {
	}
	
	@Pointcut("within(@com.ddlab.rnd.spring.aop.Check *)")
	public void checkBean() {
	}
	
	
	@Around("checkBean() && methodPointcut()")
	public Object aroundCheckMethod(ProceedingJoinPoint joinPoint)
			throws Throwable {
		logger.debug(">>>>check>>>> invoking {}", joinPoint.getSignature());
		Date start = new Date();
		Object result = joinPoint.proceed();
		Date end = new Date();
		logger.debug(">>>>check>>>> return of {} with {}", joinPoint.getSignature(),
				BeanUtils.describe(result));
		
		logger.debug(">>>chek>>>> method arguments {} , {}", joinPoint.getArgs());
		
		
		logger.debug(">>>>>>>> end of {} take {} millisec",
				joinPoint.getSignature(), end.getTime() - start.getTime());
		return result;
	}

	
	

	@Pointcut("execution(* *(..))")
	public void methodPointcut() {
	}

	@Around("controllerBean() && methodPointcut()")
	public Object aroundControllerMethod(ProceedingJoinPoint joinPoint)
			throws Throwable {
		logger.debug(">>>>>>>> invoking {}", joinPoint.getSignature());
		Date start = new Date();
		Object result = joinPoint.proceed();
		Date end = new Date();
		logger.debug(">>>>>>>> return of {} with {}", joinPoint.getSignature(),
				BeanUtils.describe(result));
		
		logger.debug(">>>>>>>> end of {} take {} millisec",
				joinPoint.getSignature(), end.getTime() - start.getTime());
		return result;
	}

	@Around("serviceBean() && methodPointcut()")
	public Object aroundServiceMethod(ProceedingJoinPoint joinPoint)
			throws Throwable {
		logger.debug(">>>>>>>> invoking {}", joinPoint.getSignature());
		Date start = new Date();
		Object result = joinPoint.proceed();
		Date end = new Date();
		logger.debug(">>>>>>>> return of {} with {}", joinPoint.getSignature(),
				BeanUtils.describe(result));
		
		logger.debug(">>>>>>> method arguments {} , {}", joinPoint.getArgs());
		
		
		logger.debug(">>>>>>>> end of {} take {} millisec",
				joinPoint.getSignature(), end.getTime() - start.getTime());
		return result;
	}

	@Around("repositoryBean() && methodPointcut()")
	public Object aroundRepositoryMethod(ProceedingJoinPoint joinPoint)
			throws Throwable {
		logger.debug(">>>>>>>> invoking {}", joinPoint.getSignature());
		Date start = new Date();
		Object result = joinPoint.proceed();
		Date end = new Date();
		logger.debug(">>>>>>>> return of {} with {}", joinPoint.getSignature(),
				BeanUtils.describe(result));
		logger.debug(">>>>>>>> end of {} take {} millisec",
				joinPoint.getSignature(), end.getTime() - start.getTime());
		return result;
	}
}
