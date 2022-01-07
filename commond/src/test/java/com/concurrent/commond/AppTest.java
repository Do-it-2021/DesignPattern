package com.concurrent.commond;

import org.junit.Test;

import com.concurrent.commond_mod.ChuanCook;
import com.concurrent.commond_mod.ChuanCuisine;
import com.concurrent.commond_mod.GuangdongCook;
import com.concurrent.commond_mod.LuCook;
import com.concurrent.commond_mod.LuCuisine;
import com.concurrent.commond_mod.XiaoEr;
import com.concurrent.commond_mod.YueCuisine;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    
   /* @Test
    public void test_Xiaoer() {
    	
    	Xiaoer xiaoer = new Xiaoer();
    	
    	xiaoer.order(1);
    	xiaoer.order(2);
    	xiaoer.order(3);
    	xiaoer.order(4);
    	
    	xiaoer.placeOrder();
    	
    }*/
	
	@Test
	public void test_XiaoEr() {
		
		LuCuisine lu = new LuCuisine(new LuCook());
		ChuanCuisine chuan = new ChuanCuisine(new ChuanCook());
		YueCuisine yue = new YueCuisine(new GuangdongCook());
		
		XiaoEr xiaoEr = new XiaoEr();
		
		xiaoEr.order(lu);
		xiaoEr.order(chuan);
		xiaoEr.order(yue);
		
		xiaoEr.placeOrder();
		
	}
}
