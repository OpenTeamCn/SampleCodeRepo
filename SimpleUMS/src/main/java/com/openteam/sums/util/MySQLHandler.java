/**
 * 
 */
package com.openteam.sums.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import com.openteam.sums.conf.Config;

/**
 * @author tgu011
 * 
 */
public class MySQLHandler {

    private static Connection connection = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;

    static {
        try {

            String databaseName = Config.MYSQLNAME;
            String host = BaeEnv.getBaeHeader(BaeEnv.BAE_ENV_ADDR_SQL_IP);
            String port = BaeEnv.getBaeHeader(BaeEnv.BAE_ENV_ADDR_SQL_PORT);
            String username = BaeEnv.getBaeHeader(BaeEnv.BAE_ENV_AK);
            String password = BaeEnv.getBaeHeader(BaeEnv.BAE_ENV_SK);

            String driverName = "com.mysql.jdbc.Driver";
            String dbUrl = "jdbc:mysql://";
            String serverName = host + ":" + port + "/";
            String connName = dbUrl + serverName + databaseName;

            Class.forName(driverName);
            connection = DriverManager.getConnection(connName, username, password);
            stmt = connection.createStatement();
        } catch (Exception e) {

        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    public static ResultSet select(String sql) {
        try {
            rs = stmt.executeQuery(sql);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return rs;
        //		ResultSetMetaData rsmd = rs.getMetaData();		//表的字段属性变量
        //		for (int i=1;i<=rsmd.getColumnCount();i++)		//按字段属性输出表的数据名
        //		{
        //			resp.getWriter().print(rsmd.getColumnName(i)+"\t");}
        //	
        //		while(rs.next())
        //		{
        //			resp.getWriter().printf("%-8d%-8d%-12s\n",rs.getInt("id"),rs.getInt("no"),rs.getString("name"));
        //		}
    }

}
