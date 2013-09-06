package com.openteam.sample.dao;

import com.openteam.sample.bean.UserBean;

public interface UserDao {
	public UserBean findUserById(Long paramLong);
}