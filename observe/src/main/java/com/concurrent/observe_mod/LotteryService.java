package com.concurrent.observe_mod;

import com.concurrent.observe.LotteryResult;
import com.concurrent.observe_mod.event.EventManager;
import com.concurrent.observe_mod.event.listener.MessageEventListener;
import com.concurrent.observe_mod.event.listener.MqEventListener;

public abstract class LotteryService {

	private EventManager eventManager;
	
	public LotteryService() {
		
		eventManager = new EventManager(EventManager.EventType.MQ,EventManager.EventType.Message);
		eventManager.subscribe(EventManager.EventType.MQ, new MqEventListener());
		eventManager.subscribe(EventManager.EventType.Message, new MessageEventListener());
	}
	
	public LotteryResult draw(String uId) {
		
		LotteryResult lotteryResult = doDraw(uId);
		//通知
		eventManager.notify(EventManager.EventType.MQ,lotteryResult);
		eventManager.notify(EventManager.EventType.Message, lotteryResult);
		return lotteryResult;
	}
	
	protected abstract LotteryResult doDraw(String uId);
}
