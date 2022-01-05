package com.concurrent.proxy.agent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;

public class MapperFactoryBean<T> implements FactoryBean<T> {
	
	private Logger logger = LoggerFactory.getLogger(MapperFactoryBean.class);

	private Class<T> mapperInterface;
	
	public MapperFactoryBean(Class<T> mapperInterface) {
		this.mapperInterface = mapperInterface;
	}

	@Override
	public T getObject() throws Exception {
		
		InvocationHandler handler = (proxy,method,args)->{
			
			Select select = method.getAnnotation(Select.class);
			
			logger.info("SQL:{}",select.value().replace("#{uId}",args[0].toString()));
			
			return args[0]+"testttt";
			
		};
		
		return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[] {mapperInterface}, handler);
	}

	@Override
	public Class<?> getObjectType() {
		
		return mapperInterface;
	}
	
	@Override
	public boolean isSingleton() {
		
		return true;
	}

}
