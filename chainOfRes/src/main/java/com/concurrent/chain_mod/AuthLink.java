package com.concurrent.chain_mod;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.concurrent.chainOfRes.AuthInfo;

public abstract class AuthLink {
	
	protected Logger logger = LoggerFactory.getLogger(AuthLink.class);
	
	protected SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	protected String levelUserId; //级别人员id
	
	protected String levelUserName;//级别人员姓名
	
	private AuthLink next;//责任链
	
	public AuthLink(String levelUserId,String levelUserName) {
		this.levelUserId = levelUserId;
		this.levelUserName = levelUserName;
	}
	
	public AuthLink next() {
		
		return next;
	}
	
	public AuthLink appendNext(AuthLink next) {
		this.next = next;
		return this;
	}
	
	public abstract AuthInfo doAuth(String uId,String orderId,Date authDate);

}
