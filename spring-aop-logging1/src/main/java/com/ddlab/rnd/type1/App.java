package com.ddlab.rnd.type1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		Accounts accounts = (Accounts) context.getBean("accounts");

		int result = accounts.getCalculation(10, 15);
		System.out.println("Result :::" + result);
	}
}
