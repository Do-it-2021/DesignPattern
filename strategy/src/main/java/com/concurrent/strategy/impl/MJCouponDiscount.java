package com.concurrent.strategy.impl;

import java.math.BigDecimal;
import java.util.Map;

import com.concurrent.strategy.ICouponDiscount;

public class MJCouponDiscount implements ICouponDiscount<Map<String,String>> {

	
	/**
	 *满减
	 */
	@Override
	public BigDecimal discountAmount(Map<String,String> couponInfo, BigDecimal skuPrice) {
		
		String x = couponInfo.get("x");
		
		String o = couponInfo.get("n");
		
		if(skuPrice.compareTo(new BigDecimal(x))<0) return skuPrice;
		
		BigDecimal discountAmount = skuPrice.subtract(new BigDecimal(o));
		
		 if (discountAmount.compareTo(BigDecimal.ZERO) < 1) return BigDecimal.ONE;
		
		
		return discountAmount;
	}

	
}
