package com.concurrent.mem;

import java.util.Date;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	private Logger logger = LoggerFactory.getLogger(AppTest.class);
	
	@Test
	public void test() {
		
		Admin admin  = new Admin();
		
		ConfigOriginator configOriginator = new ConfigOriginator();
		
		configOriginator.setConfigFile(new ConfigFile("1000001", "配置内容A=哈哈", new Date(), "小哥"));
		admin.append(configOriginator.saveMemento());//保存配置
		
		configOriginator.setConfigFile(new ConfigFile("1000002", "配置内容B=呵呵", new Date(), "小哥"));
		admin.append(configOriginator.saveMemento());//保存配置
		
		configOriginator.setConfigFile(new ConfigFile("1000003", "配置内容C=哈哈呵呵", new Date(), "小哥"));
		admin.append(configOriginator.saveMemento());//保存配置
		
		
		configOriginator.getMemento(admin.undo());
		logger.info("历史配置(回滚)undo：{}", JSON.toJSONString(configOriginator.getConfigFile()));
		
		configOriginator.getMemento(admin.undo());
		logger.info("历史配置(回滚)undo：{}", JSON.toJSONString(configOriginator.getConfigFile()));
		
		
		// 历史配置(前进)
        configOriginator.getMemento(admin.redo());
        logger.info("历史配置(前进)redo：{}", JSON.toJSONString(configOriginator.getConfigFile()));

        // 历史配置(获取)
        configOriginator.getMemento(admin.get("1000002"));
        logger.info("历史配置(获取)get：{}", JSON.toJSONString(configOriginator.getConfigFile()));
		
	}
}
