package com.concurrent.commond_mod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LuCook implements ICook {
	
	private Logger logger = LoggerFactory.getLogger(LuCook.class);
	
	@Override
	public void doCook() {
		
		logger.info("鲁菜师傅,正宗鲁菜");
	}

	
}
