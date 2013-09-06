package com.openteam.sample.service;

import com.openteam.sample.bean.UserBean;

import java.util.List;

public interface UserService {
	public UserBean findUserById(Long paramLong);

	public List<UserBean> getAllUser();

	public Long saveUser(UserBean paramUserBean);

	public Long removeUser(Long paramLong);

	public Long modifyUser(UserBean paramUserBean);
}