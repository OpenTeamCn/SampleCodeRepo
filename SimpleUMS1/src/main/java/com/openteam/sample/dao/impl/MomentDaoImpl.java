package com.openteam.sample.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.openteam.sample.bean.MomentBean;
import com.openteam.sample.bean.rowmapper.MomentRM;
import com.openteam.sample.dao.MomentDao;

public class MomentDaoImpl implements MomentDao {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@SuppressWarnings("unchecked")
	public MomentBean getLatestMoment(Long uid) {
		String sql = "SELECT * FROM moment_tab WHERE uid=? ORDER BY create_tm";//
		List<MomentBean> list = this.jdbcTemplate.query(sql,
				new Object[] { uid }, new MomentRM());
		if ((list == null) || (list.size() == 0)) {
			return null;
		}
		return (MomentBean) list.get(0);
	}
}