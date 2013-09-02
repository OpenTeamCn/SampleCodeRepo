/**
 * 
 */
package com.openteam.sums.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.openteam.sums.bean.Moment;
import com.openteam.sums.bean.UInfo;
import com.openteam.sums.util.MySQLHander;

/**
 * @author tgu011
 *
 */
public class UInfoDao {

	public static UInfo getUInfo(){
		UInfo uinfo = null;
		String sql = "";
		ResultSet rs = MySQLHander.select(sql);
		try {
			while(rs.next()){
				uinfo = new UInfo();
				uinfo.setId(rs.getInt("ID"));
				uinfo.setUid(rs.getInt("UID"));
				uinfo.setName(rs.getString("NAME"));
				uinfo.setBirthday(rs.getDate("BIRTHDAY"));
				uinfo.setPhoto(rs.getString("PHOTO"));
				//TODO How to get the actual photo from baidu platform
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}
		return uinfo;
	}
}
