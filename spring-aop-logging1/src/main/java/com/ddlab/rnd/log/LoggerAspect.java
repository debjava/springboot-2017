package com.ddlab.rnd.log;

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
	
	protected static Logger log = LoggerFactory.getLogger(LoggerAspect.class);
	
	@Pointcut("within(@org.springframework.stereotype.Controller *)")
	public void allControllerBean() {
	}
	
	@Pointcut("within(@org.springframework.stereotype.Service *)")
	public void allServiceBean() {
	}

	@Pointcut("within(@org.springframework.stereotype.Repository *)")
	public void allRepositoryBean() {
	}
	
	@Pointcut("within(@com.ddlab.rnd.log.AuditLogger *)")
	public void otherBean() {
	}
	
	@Pointcut("execution(* *(..))")
	public void methodPointcut() {
	}
	
	@Around("otherBean() && methodPointcut()")
	public Object aroundCheckMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		log.debug("======================AOP Logging=========================");
		log.debug("Class Name : "+joinPoint.getTarget());
		log.debug("Method Signature : {}",joinPoint.getSignature());
		Object[] methodArguments = joinPoint.getArgs();
		for( Object obj : methodArguments )
			log.debug("Method argument : {}",obj);
		
		Date start = new Date();
		Object result = joinPoint.proceed();
		log.debug("Method return type : {}",BeanUtils.describe(result));
		log.debug("Method output if exists : "+result);
		Date end = new Date();
		log.debug(">>>>>>>> end of {} took {} millisec", 
				joinPoint.getSignature(), end.getTime() - start.getTime());
		log.debug("======================AOP Logging=========================");
		return result;
	}
	
	//For others
	@Around("allControllerBean() && methodPointcut()")
	public Object aroundControllerMethod(ProceedingJoinPoint joinPoint)
			throws Throwable {
		log.debug(">>>>>>>> invoking {}", joinPoint.getSignature());
		Date start = new Date();
		Object result = joinPoint.proceed();
		Date end = new Date();
		log.debug(">>>>>>>> return of {} with {}", joinPoint.getSignature(),
				BeanUtils.describe(result));
		
		log.debug(">>>>>>>> end of {} take {} millisec",
				joinPoint.getSignature(), end.getTime() - start.getTime());
		return result;
	}

	@Around("allServiceBean() && methodPointcut()")
	public Object aroundServiceMethod(ProceedingJoinPoint joinPoint)
			throws Throwable {
		log.debug(">>>>>>>> invoking {}", joinPoint.getSignature());
		Date start = new Date();
		Object result = joinPoint.proceed();
		Date end = new Date();
		log.debug(">>>>>>>> return of {} with {}", joinPoint.getSignature(),
				BeanUtils.describe(result));
		
		log.debug(">>>>>>> method arguments {} , {}", joinPoint.getArgs());
		
		
		log.debug(">>>>>>>> end of {} take {} millisec",
				joinPoint.getSignature(), end.getTime() - start.getTime());
		return result;
	}

	@Around("allRepositoryBean() && methodPointcut()")
	public Object aroundRepositoryMethod(ProceedingJoinPoint joinPoint)
			throws Throwable {
		log.debug(">>>>>>>> invoking {}", joinPoint.getSignature());
		Date start = new Date();
		Object result = joinPoint.proceed();
		Date end = new Date();
		log.debug(">>>>>>>> return of {} with {}", joinPoint.getSignature(),
				BeanUtils.describe(result));
		log.debug(">>>>>>>> end of {} take {} millisec",
				joinPoint.getSignature(), end.getTime() - start.getTime());
		return result;
	}
	

}
