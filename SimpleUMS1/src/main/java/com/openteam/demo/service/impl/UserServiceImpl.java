package com.openteam.demo.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.openteam.demo.bean.UserBean;
import com.openteam.demo.dao.UserDao;
import com.openteam.demo.service.UserService;
import com.openteam.demo.utils.DateUtil;

public class UserServiceImpl implements UserService {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserBean findUserById(Long uid) {
		return this.userDao.findUserById(uid);
	}

	public List<UserBean> getAllUser() {
		List<UserBean> userList = new ArrayList<UserBean>();
		for(int i=0 ;i < 5 ; i++) {
			UserBean bean = new UserBean();
			bean.setBirthday(DateUtil.getDateStrDay(new Date()));
			bean.setId(new Long(i));
			bean.setUid(new Long(100+i));
			bean.setPhoto("https://www.baidu.com/sample/test.image");
			userList.add(bean);
		}
		return userList;
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