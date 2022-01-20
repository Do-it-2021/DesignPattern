package com.concurrent.visitor.visitor;

import com.concurrent.visitor.user.impl.Student;
import com.concurrent.visitor.user.impl.Teacher;

public interface Visitor {

	//访问学生信息
	void visit(Student student);
	
	void visit(Teacher teacher);
}
