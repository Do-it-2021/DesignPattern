package com.concurrent.template.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSON;
import com.concurrent.template.HttpClient;
import com.concurrent.template.NetMall;

import sun.misc.BASE64Encoder;

public class JDNetMall extends NetMall {

	public JDNetMall(String uId, String uPwd) {
		super(uId, uPwd);
	}
	
	 public Map<String, String> reptile(String skuUrl) {
	        String str = HttpClient.doGet(skuUrl);
	        Pattern p9 = Pattern.compile("(?<=title\\>).*(?=</title)");
	        Matcher m9 = p9.matcher(str);
	        Map<String, String> map = new ConcurrentHashMap<String, String>();
	        if (m9.find()) {
	            map.put("name", m9.group());
	        }
	        map.put("price", "5999.00");
	        logger.info("模拟京东商品爬虫解析：{} | {} 元 {}", map.get("name"), map.get("price"), skuUrl);
	        return map;
	    }

	    public String createBase64(Map<String, String> goodsInfo) {
	        BASE64Encoder encoder = new BASE64Encoder();
	        logger.info("模拟生成京东商品base64海报");
	        return encoder.encode(JSON.toJSONString(goodsInfo).getBytes());
	    }

		@Override
		protected Boolean login(String uId, String uPwd) {
			logger.info("模拟京东用户登录 uId：{} uPwd：{}", uId, uPwd);
	        return true;
		}
	
}
