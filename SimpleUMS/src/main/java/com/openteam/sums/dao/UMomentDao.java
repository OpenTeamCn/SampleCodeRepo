/**
 * 
 */
package com.openteam.sums.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.openteam.sums.bean.Moment;
import com.openteam.sums.util.MySQLHandler;

/**
 * @author tgu011
 *
 */
public class UMomentDao {

	private static final DateFormat FMTER = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static Moment getUInfo(){
		Moment moment = null;
		String sql = "";//TODO [gx]Write a sql to get the latest one
		ResultSet rs = MySQLHandler.select(sql);
		try {
			if (rs.next()) {
				moment = new Moment();
				moment.setId(rs.getInt("ID"));
				moment.setUid(rs.getInt("UID"));
				moment.setMoment(rs.getString("MOMENT"));
				moment.setCreate_tm(FMTER.format(rs.getTimestamp("CREATE_TM")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}
		return moment;
	}
}
