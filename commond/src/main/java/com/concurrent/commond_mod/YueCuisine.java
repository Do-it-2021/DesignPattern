package com.concurrent.commond_mod;

public class YueCuisine implements ICuisine {
	
	private ICook cook;
	
	public YueCuisine(ICook cook) {
		super();
		this.cook = cook;
	}


	@Override
	public void cook() {
		cook.doCook();
	}

}
