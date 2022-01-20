package com.concurrent.visitor.user;

import com.concurrent.visitor.visitor.Visitor;

public abstract class User {

	public String name; //姓名
	
	public String identity;//身份
	
	public String clazz;//班级
	
	public User(String name,String identity,String clazz) {
		this.name = name;
		this.identity = identity;
		this.clazz = clazz;
	}
	
	//核心访问方法
	public abstract void accept(Visitor visitor);
	
}
