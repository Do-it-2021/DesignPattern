package com.concurrent.observe_mod;

import java.util.Date;

import com.concurrent.observe.LotteryResult;
import com.concurrent.observe.MinibusTargetService;

public class LotteryServiceImpl extends LotteryService {
		
	private MinibusTargetService minibusTargetService = new MinibusTargetService();

	@Override
	protected LotteryResult doDraw(String uId) {
		
		  // 摇号
        String lottery = minibusTargetService.lottery(uId);
        // 结果
        return new LotteryResult(uId, lottery, new Date());
		
	}
	
	
}
