package com.ddlab.rnd.spring.aop;

import org.springframework.beans.factory.annotation.Autowired;

@Check
public class ATest {
	
	@Autowired
	private AService service;
	
	public void invoke() {
		
		service.m2("aaa", "bbb");
	}

	public void setService(AService service) {
		this.service = service;
	}
	
	

}
