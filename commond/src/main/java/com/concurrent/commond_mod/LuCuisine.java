package com.concurrent.commond_mod;

public class LuCuisine implements ICuisine {
	
	private ICook cook;
	
	

	public LuCuisine(ICook cook) {
		super();
		this.cook = cook;
	}



	@Override
	public void cook() {
		cook.doCook();
	}

}
