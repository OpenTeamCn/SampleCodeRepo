package com.openteam.sample.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.openteam.sample.bean.UserBean;
import com.openteam.sample.dao.UserDao;
import com.openteam.sample.rest.UserResource;
import com.openteam.sample.service.UserService;
import com.openteam.sample.utils.DateUtil;

public class UserServiceImpl implements UserService {
    
    private static Logger logger = Logger.getLogger(UserServiceImpl.class);
    
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserBean findUserByUid(Long uid) {
		return this.userDao.findUserByUid(uid);
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

	public Long saveUser(UserBean user) {
	    logger.info("Save user [name="+user.getName()+",birthday="+user.getBirthday()+"]");
	    return new Long(0);
	}

	public Long removeUser(Long uid) {
		return null;
	}

	public Long modifyUser(UserBean bean) {
		return null;
	}
}