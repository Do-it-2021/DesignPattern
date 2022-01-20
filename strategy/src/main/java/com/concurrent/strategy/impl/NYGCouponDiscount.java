package com.concurrent.strategy.impl;

import java.math.BigDecimal;

import com.concurrent.strategy.ICouponDiscount;

public class NYGCouponDiscount implements ICouponDiscount<Double> {

	public BigDecimal discountAmount(Double couponInfo,BigDecimal skuPrice) {
		
		return new BigDecimal(couponInfo);
	}
}
