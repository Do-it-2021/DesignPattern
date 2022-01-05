package com.concurrent.proxy;

import com.concurrent.proxy.agent.Select;

public interface IUserDao {

	@Select("select userName from user where id = #{uId}")
	String queryUserInfo(String uId);
}
