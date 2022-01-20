package com.concurrent.visitor;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.concurrent.visitor.visitor.impl.Parent;
import com.concurrent.visitor.visitor.impl.Principal;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	private Logger logger = LoggerFactory.getLogger(AppTest.class);

    @Test
    public void test(){
        DataView dataView = new DataView();

        logger.info("\r\n家长视角访问：");
        dataView.show(new Parent());     // 家长

        logger.info("\r\n校长视角访问：");
        dataView.show(new Principal());  // 校长
    }
}
