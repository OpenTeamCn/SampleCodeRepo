package com.openteam.sample.dao;

import com.openteam.sample.bean.UserBean;

public interface UserDao {
	public UserBean findUserByUid(Long uid);
}