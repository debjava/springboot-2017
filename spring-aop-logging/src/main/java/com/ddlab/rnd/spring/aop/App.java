package com.ddlab.rnd.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
		
		ATest test = (ATest) context.getBean("test");
		
		test.invoke();
	}
}
