package com.ddlab.rnd.type1;

import com.ddlab.rnd.log.AuditLogger;

@AuditLogger
public class CalculatorImpl implements ICalculator {

	public int add(int a, int b) {
		return a+b;
	}

}
