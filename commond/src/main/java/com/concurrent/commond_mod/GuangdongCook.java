package com.concurrent.commond_mod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GuangdongCook implements ICook {

	private Logger logger = LoggerFactory.getLogger(GuangdongCook.class);
	
	@Override
	public void doCook() {
		logger.info("广东厨师，广式点心");
	}

}
