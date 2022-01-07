package com.concurrent.commond_mod;

public class ChuanCuisine implements ICuisine {
	
	private ICook cook;

	public ChuanCuisine(ICook cook) {
		super();
		this.cook = cook;
	}



	@Override
	public void cook() {
		cook.doCook();
	}

	
}
