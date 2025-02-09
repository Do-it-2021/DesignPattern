package com.concurrent.chain_mod;

import java.util.Date;

import com.concurrent.chainOfRes.AuthInfo;
import com.concurrent.chainOfRes.AuthService;

public class Level1AuthLink extends AuthLink {

	public Level1AuthLink(String levelUserId, String levelUserName) {
		super(levelUserId, levelUserName);
	}

	@Override
	public AuthInfo doAuth(String uId, String orderId, Date authDate) {
		
		Date date = AuthService.queryAuthInfo(levelUserId, orderId);
		if(null==date) {
			 return new AuthInfo("0001", "单号：", orderId, " 状态：待一级审批负责人 ", levelUserName);
		}
		
		AuthLink next = super.next();
		if (null == next) {
	            return new AuthInfo("0000", "单号：", orderId, " 状态：一级审批完成负责人", " 时间：", f.format(date), " 审批人：", levelUserName);
	       }
		
		 return next.doAuth(uId, orderId, authDate);
	}

}
