package com.ddlab.rnd.type1;

import org.springframework.beans.factory.annotation.Autowired;

import com.ddlab.rnd.log.AuditLogger;

@AuditLogger
public class Accounts {
	
	@Autowired
	private ICalculator calculator;

	public void setCalculator(ICalculator calculator) {
		this.calculator = calculator;
	}
	
	
	public int getCalculation( int a , int b ) {
		
		return calculator.add(a, b);
	}

}
