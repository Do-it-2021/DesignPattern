package com.concurrent.commond_mod;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XiaoEr {

	private Logger logger = LoggerFactory.getLogger(XiaoEr.class);
	
	private List<ICuisine> cuisineList = new ArrayList<ICuisine>();
	
	public void order(ICuisine cuisine) {
		cuisineList.add(cuisine);
	}
	
	public synchronized void placeOrder() {
		
		for(ICuisine cuisine:cuisineList) {
			cuisine.cook();
		}
		
		cuisineList.clear();
	}
}
