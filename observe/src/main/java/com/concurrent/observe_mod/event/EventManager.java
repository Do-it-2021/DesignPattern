package com.concurrent.observe_mod.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.concurrent.observe.LotteryResult;
import com.concurrent.observe_mod.event.listener.EventListener;

public class EventManager {
	
	Map<Enum<EventType>,List<EventListener>> listeners = new HashMap<>();
	
	public EventManager(Enum<EventType>... operations) {
		
		for(Enum<EventType> operation:operations) {
			this.listeners.put(operation,new ArrayList());
		}
	}
	
	/**订阅
	 * @param eventType
	 * @param listener
	 */
	public void subscribe(Enum<EventType> eventType,EventListener listener) {
		
		List<EventListener> users = listeners.get(eventType);
		
		users.add(listener);
	}
	

	/**取消订阅
	 * @param eventType
	 * @param listener
	 */
	public void unsubscribe(Enum<EventType> eventType,EventListener listener) {
		List<EventListener> users = listeners.get(eventType);
		users.remove(listener);
	}
	
	
	public enum EventType{
		MQ,Message
	}
	
	/**通知
	 * @param eventType 事件类型
	 * @param result 结果
	 */
	public void notify(Enum<EventType> eventType,LotteryResult result) {
		List<EventListener> users = listeners.get(eventType);
		
		for (EventListener listener : users) {
            listener.doEvent(result);
        }
	}
}
