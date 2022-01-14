package com.concurrent.observe;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*public class LotteryServiceImpl implements LotteryService {

	private Logger logger = LoggerFactory.getLogger(LotteryServiceImpl.class);
	
	private MinibusTargetService minibusTargetService = new MinibusTargetService();

	@Override
	public LotteryResult doDraw(String uId) {
		
		//摇号
		String lottery = minibusTargetService.lottery(uId);
		
		//发短信
		 logger.info("给用户 {} 发送短信通知(短信)：{}", uId, lottery);
		 
		 //发送MQ
		 logger.info("记录用户 {} 摇号结果(MQ)：{}", uId, lottery);
		
		return new LotteryResult(uId,lottery,new Date());
	}

	
}*/
