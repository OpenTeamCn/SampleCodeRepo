package com.openteam.sample.bean.rowmapper;

import com.openteam.sample.bean.UserBean;
import com.openteam.sample.utils.DateUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class UserRM implements RowMapper {
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserBean bean = new UserBean();
		bean.setId(Long.valueOf(rs.getLong("id")));
		bean.setUid(Long.valueOf(rs.getLong("uid")));
		bean.setBirthday(DateUtil.getDateStrDay(rs.getDate("birthday")));
		bean.setPhoto(rs.getString("photo"));
		return bean;
	}
}