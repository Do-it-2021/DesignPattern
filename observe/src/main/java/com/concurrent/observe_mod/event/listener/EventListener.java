package com.concurrent.observe_mod.event.listener;

import com.concurrent.observe.LotteryResult;

public interface EventListener {
	void doEvent(LotteryResult result);
}
