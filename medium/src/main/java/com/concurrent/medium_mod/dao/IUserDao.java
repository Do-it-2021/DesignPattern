package com.concurrent.medium_mod.dao;

import com.concurrent.medium_mod.po.User;

public interface IUserDao {

	User queryUserById(Long id);
}
