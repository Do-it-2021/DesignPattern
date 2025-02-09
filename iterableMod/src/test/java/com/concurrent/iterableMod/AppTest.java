package com.concurrent.iterableMod;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.concurrent.iterableMod.group.Employee;
import com.concurrent.iterableMod.group.GroupStructure;
import com.concurrent.iterableMod.group.Link;
import com.concurrent.iterableMod.lang.Iterator;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	
	  private Logger logger = LoggerFactory.getLogger(AppTest.class);
  
	@Test
	public void test_Iterable() {
		
		
		
		
		  GroupStructure groupStructure = new GroupStructure("1", "小傅哥");
	        groupStructure.add(new Employee("2", "花花", "二级部门"));
	        groupStructure.add(new Employee("3", "豆包", "二级部门"));
	        groupStructure.add(new Employee("4", "蹦蹦", "三级部门"));
	        groupStructure.add(new Employee("5", "大烧", "三级部门"));
	        groupStructure.add(new Employee("6", "虎哥", "四级部门"));
	        groupStructure.add(new Employee("7", "玲姐", "四级部门"));
	        groupStructure.add(new Employee("8", "秋雅", "四级部门"));

	        groupStructure.addLink("1", new Link("1", "2"));
	        groupStructure.addLink("1", new Link("1", "3"));

	        groupStructure.addLink("2", new Link("2", "4"));
	        groupStructure.addLink("2", new Link("2", "5"));

	        groupStructure.addLink("5", new Link("5", "6"));
	        groupStructure.addLink("5", new Link("5", "7"));
	        groupStructure.addLink("5", new Link("5", "8"));

	        Iterator<Employee> iterator = (Iterator<Employee>) groupStructure.iterator();
	        while (iterator.hasNext()) {
	            Employee employee = iterator.next();
	            logger.info("{}，雇员 Id：{} Name：{}", employee.getDesc(), employee.getuId(), employee.getName());
	        }
	}
}
