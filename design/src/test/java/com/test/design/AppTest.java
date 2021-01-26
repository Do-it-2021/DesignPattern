package com.test.design;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

import junit.framework.TestCase;


public class AppTest 
    extends TestCase
{
	
	private Logger logger = LoggerFactory.getLogger(AppTest.class);
	
	
	@Test
	public void test_awardToUser() {
		
		PrizeController prizeController = new PrizeController();
		
		System.out.println("\r\n 模拟发放优惠券测试\r\n");
		
		AwardReq req01 = new AwardReq();
		
		req01.setuId("10001");

		req01.setAwardType(1);
		
		req01.setAwardNum("EGM1021010");
		
		req01.setBizId("7891201023");
		
		AwardRes awardRes01 = prizeController.awardToUser(req01);
		
		logger.info("请求参数:{}",JSON.toJSON(req01));
		
		logger.info("测试结果：{}",JSON.toJSON(awardRes01));
		
		
		////////////////////////////////////////////
		
		System.out.println("\r\n 模拟方法实物商品");
		
		AwardReq req02 = new AwardReq();
		
		req02.setuId("1001");
		
		req02.setAwardType(2);
		
		req02.setAwardNum("jijo5666");
		
		req02.setBizId("11510212511");
		
		Map<String,String> extMap = new HashMap<String,String>();
		
		extMap.put("conUserName","haha");
		
		extMap.put("conUserPhone","1512115");
		
		extMap.put("conUserAddress","jiajsjdkjf");
		
		req02.setExpMap(extMap);
		
		AwardRes awardRes02 = prizeController.awardToUser(req02);
		
		logger.info("请求参数：{}", JSON.toJSON(req02));
        logger.info("测试结果：{}", JSON.toJSON(awardRes02));
        
        //////////////////////////////////
        
        System.out.println("\r\n兑换卡\r\n");
        AwardReq req03 = new AwardReq();
        req03.setuId("10001");
        req03.setAwardType(3);
        req03.setAwardNum("AQY1xjkUodl8LO975GdfrYUio");

        AwardRes awardRes03 = prizeController.awardToUser(req03);
        logger.info("请求参数：{}", JSON.toJSON(req03));
        logger.info("测试结果：{}", JSON.toJSON(awardRes03));
		
	}
	
	 
	
	
    
}
