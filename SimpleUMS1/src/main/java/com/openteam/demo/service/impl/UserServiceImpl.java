package com.openteam.demo.service.impl;

import com.openteam.demo.bean.UserBean;
import com.openteam.demo.dao.UserDao;
import com.openteam.demo.service.UserService;
import java.util.List;

public class UserServiceImpl implements UserService {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserBean findUserById(Long uid) {
		return this.userDao.findUserById(uid);
	}

	public List<UserBean> getAllUser() {
		return null;
	}

	public Long saveUser(UserBean bean) {
		return null;
	}

	public Long removeUser(Long uid) {
		return null;
	}

	public Long modifyUser(UserBean bean) {
		return null;
	}
}