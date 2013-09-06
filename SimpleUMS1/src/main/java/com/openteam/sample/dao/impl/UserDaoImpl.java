package com.openteam.sample.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.openteam.sample.bean.UserBean;
import com.openteam.sample.bean.rowmapper.UserRM;
import com.openteam.sample.dao.UserDao;

public class UserDaoImpl implements UserDao {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@SuppressWarnings("unchecked")
	public UserBean findUserById(Long uid) {
		String sql = "SELECT * FROM uinfo_tab WHERE uid=?";
		List<UserBean> list = this.jdbcTemplate.query(sql,
				new Object[] { uid }, new UserRM());
		if ((list == null) || (list.size() == 0)) {
			return null;
		}
		return (UserBean) list.get(0);
	}
}