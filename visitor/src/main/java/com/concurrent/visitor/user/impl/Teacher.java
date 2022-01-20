package com.concurrent.visitor.user.impl;

import java.math.BigDecimal;

import com.concurrent.visitor.user.User;
import com.concurrent.visitor.visitor.Visitor;

public class Teacher extends User {

	public Teacher(String name, String identity, String clazz) {
		super(name, identity, clazz);
	}
	
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
	public double entranceRatio() {
		
		  return BigDecimal.valueOf(Math.random() * 100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		
	}

	
}
