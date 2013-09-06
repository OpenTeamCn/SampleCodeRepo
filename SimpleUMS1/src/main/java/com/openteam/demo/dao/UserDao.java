package com.openteam.demo.dao;

import com.openteam.demo.bean.UserBean;

public interface UserDao {
	public UserBean findUserById(Long paramLong);
}