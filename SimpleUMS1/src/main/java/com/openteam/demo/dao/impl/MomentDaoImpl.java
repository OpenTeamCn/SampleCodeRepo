package com.openteam.demo.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.openteam.demo.bean.MomentBean;
import com.openteam.demo.bean.rowmapper.MomentRM;
import com.openteam.demo.dao.MomentDao;

public class MomentDaoImpl implements MomentDao {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@SuppressWarnings("unchecked")
	public MomentBean findMomentByUid(Long uid) {
		String sql = "SELECT * FROM moment_tab WHERE uid=?";
		List<MomentBean> list = this.jdbcTemplate.query(sql,
				new Object[] { uid }, new MomentRM());
		if ((list == null) || (list.size() == 0)) {
			return null;
		}
		return (MomentBean) list.get(0);
	}
}