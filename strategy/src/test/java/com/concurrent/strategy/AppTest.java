package com.concurrent.strategy;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.concurrent.strategy.impl.MJCouponDiscount;
import com.concurrent.strategy.impl.NYGCouponDiscount;
import com.concurrent.strategy.impl.ZJCouponDiscount;
import com.concurrent.strategy.impl.ZKCouponDiscount;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	private Logger logger = LoggerFactory.getLogger(AppTest.class);
	
	 @Test
	 public void test_zj() {
	        // 直减；100-10，商品100元
	        Context<Double> context = new Context<Double>(new ZJCouponDiscount());
	        BigDecimal discountAmount = context.discountAmount(10D, new BigDecimal(100));
	        logger.info("测试结果：直减优惠后金额 {}", discountAmount);
	  }
	 
	 
	 @Test
	    public void test_mj() {
	        // 满100减10，商品100元
	        Context<Map<String,String>> context = new Context<Map<String,String>>(new MJCouponDiscount());
	        Map<String,String> mapReq = new HashMap<String, String>();
	        mapReq.put("x","100");
	        mapReq.put("n","10");
	        BigDecimal discountAmount = context.discountAmount(mapReq, new BigDecimal(100));
	        logger.info("测试结果：满减优惠后金额 {}", discountAmount);
	    }


	    @Test
	    public void test_zk() {
	        // 折扣9折，商品100元
	        Context<Double> context = new Context<Double>(new ZKCouponDiscount());
	        BigDecimal discountAmount = context.discountAmount(0.9D, new BigDecimal(100));
	        logger.info("测试结果：折扣9折后金额 {}", discountAmount);
	    }

	    @Test
	    public void test_nyg() {
	        // n元购；100-10，商品100元
	        Context<Double> context = new Context<Double>(new NYGCouponDiscount());
	        BigDecimal discountAmount = context.discountAmount(90D, new BigDecimal(100));
	        logger.info("测试结果：n元购优惠后金额 {}", discountAmount);
	    }

	
	
}
