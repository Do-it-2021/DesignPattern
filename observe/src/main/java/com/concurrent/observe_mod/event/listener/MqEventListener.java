package com.concurrent.observe_mod.event.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.concurrent.observe.LotteryResult;

public class MqEventListener implements EventListener {
	
	private Logger logger = LoggerFactory.getLogger(MqEventListener.class);

	@Override
	public void doEvent(LotteryResult result) {
		   logger.info("记录用户 {} 摇号结果(MQ)：{}", result.getuId(), result.getMsg());
	}
	
	


}
