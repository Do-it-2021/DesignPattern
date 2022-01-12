package com.concurrent.medium;

import java.io.Reader;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.concurrent.medium_mod.mediator.Resources;
import com.concurrent.medium_mod.mediator.SqlSession;
import com.concurrent.medium_mod.mediator.SqlSessionFactory;
import com.concurrent.medium_mod.mediator.SqlSessionFactoryBuilder;
import com.concurrent.medium_mod.po.User;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	
	private Logger logger = LoggerFactory.getLogger( AppTest.class);
   
	  /* @Test
	    public void test_queryUserInfoById() {
	        String resource = "mybatis-config-datasource.xml";
	        Reader reader;
	        try {
	            reader = Resources.getResourceAsReader(resource);
	            SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);

	            SqlSession session = sqlMapper.openSession();
	            try {
	                User user = session.selectOne("com.concurrent.medium_mod.dao.IUserDao.queryUserById", 1L);
	                logger.info("测试结果：{}", JSON.toJSONString(user));
	            } finally {
	                session.close();
	                reader.close();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	    }
	   
	   @Test
	    public void test_queryUserList() {
	        String resource = "mybatis-config-datasource.xml";
	        Reader reader;
	        try {
	            reader = Resources.getResourceAsReader(resource);
	            SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);

	            SqlSession session = sqlMapper.openSession();
	            try {
	                User req = new User();
	                req.setAge(18);
	                List<User> userList = session.selectList("com.concurrent.medium_mod.dao.IUserDao.queryUserList", req);
	                logger.info("测试结果：{}", JSON.toJSONString(userList));
	            } finally {
	                session.close();
	                reader.close();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }*/
	   
	   @Test
	   public void test_ChatRoom() {
		   
		   UserTest user = new UserTest("test");
		   
		   user.sendMessage("hello");
		  
		   
	   }
	
}
