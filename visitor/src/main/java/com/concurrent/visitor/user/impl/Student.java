package com.concurrent.visitor.user.impl;

import com.concurrent.visitor.user.User;
import com.concurrent.visitor.visitor.Visitor;

public class Student extends User {

	public Student(String name, String identity, String clazz) {
		super(name, identity, clazz);
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
	public int ranking() {
		return (int)(Math.random()*100);
	}
	
}
