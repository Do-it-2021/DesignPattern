package com.concurrent.observe_mod.event.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.concurrent.observe.LotteryResult;

public class MessageEventListener implements EventListener {
	
	private Logger logger = LoggerFactory.getLogger(MessageEventListener.class);

	@Override
	public void doEvent(LotteryResult result) {
		  logger.info("给用户 {} 发送短信通知(短信)：{}", result.getuId(), result.getMsg());
	}
	
	
}
