package com.concurrent.proxy;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	
	private Logger logger = LoggerFactory.getLogger(AppTest.class);
    /**
     * Rigorous Test :-)
     */
	
    @Test
    public void test_IUserDao() {
    	
    	 BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
         IUserDao userDao = beanFactory.getBean("userDao", IUserDao.class);
         String res = userDao.queryUserInfo("100001");
         logger.info("测试结果：{}", res);
    }
}
