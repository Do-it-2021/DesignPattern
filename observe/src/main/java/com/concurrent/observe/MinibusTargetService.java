package com.concurrent.observe;


public class MinibusTargetService {
	
	
	/** 模拟摇号
	 * @param uId
	 * @return
	 */
	public String lottery(String uId) {
		System.out.println("hashCode:"+uId.hashCode());
		return Math.abs(uId.hashCode())%2 == 0 ? "恭喜你,编码".concat(uId).concat("在本次摇号中签"):"很遗憾，编码".concat(uId).concat("在本次摇号未中签或摇号资格已过期");
	}
	
}
