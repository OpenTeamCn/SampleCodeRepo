package com.openteam.sample.bean.rowmapper;

import com.openteam.sample.bean.MomentBean;
import com.openteam.sample.utils.DateUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class MomentRM implements RowMapper {
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		MomentBean bean = new MomentBean();
		bean.setId(Long.valueOf(rs.getLong("id")));
		bean.setUid(Long.valueOf(rs.getLong("uid")));
		bean.setCreate_tm(DateUtil.getDateStrTime(rs.getDate("create_tm")));
		bean.setMoment(rs.getString("moment"));
		return bean;
	}
}