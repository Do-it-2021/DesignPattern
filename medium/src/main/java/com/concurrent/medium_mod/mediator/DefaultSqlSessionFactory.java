package com.concurrent.medium_mod.mediator;


public class DefaultSqlSessionFactory implements SqlSessionFactory {

	private final Configuration configuration;
	
	

	public DefaultSqlSessionFactory(Configuration configuration) {
		super();
		this.configuration = configuration;
	}



	@Override
	public SqlSession openSession() {
		
		return  new DefaultSqlSession(configuration.connection,configuration.mapperElement);
	}

	
	
	
}
