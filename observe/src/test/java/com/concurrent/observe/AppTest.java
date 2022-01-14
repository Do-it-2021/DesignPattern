package com.concurrent.observe;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.concurrent.observe_mod.LotteryService;
import com.concurrent.observe_mod.LotteryServiceImpl;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	 private Logger logger = LoggerFactory.getLogger(AppTest.class);
	 
	 @Test
	 public void test() {
		 
	
		 LotteryService lotteryService = new LotteryServiceImpl();
		 
		 LotteryResult result = lotteryService.draw("2765789109875");
		 
		 logger.info("测试结果：{}", JSON.toJSONString(result));
		 
	 }
   
}
