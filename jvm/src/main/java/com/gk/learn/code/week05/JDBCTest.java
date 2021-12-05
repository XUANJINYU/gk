package com.gk.learn.code.week05;

import java.sql.*;
import java.util.Random;

public class JDBCTest {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		// 创建连接
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/vueblog?useUnicode=true" +
				"&characterEncoding=UTF-8" +
				"&autoReconnect=true&failOverReadOnly=false", "root", "root");
		// 创建会话  查询
		Statement stat = connection.createStatement();
		// 5执行SQL语句
		ResultSet rs = stat.executeQuery("select * from vueblog.m_user where id = 2");
		// 6处理结果集(遍历结果集合)
		while( rs.next() ){
			//显示数据
			System.out.println("执行结果：id:" + rs.getString(1) + " userName:" + rs.getString(2));
		}
		// 新增
		PreparedStatement stat1 = connection.prepareStatement("insert into vueblog.m_user (username,password) value ('wxg','root')");
		stat1.executeUpdate();

		// 更新
		PreparedStatement stat2 = connection.prepareStatement("update vueblog.m_user set username = ? where id = 2");
		stat2.setString(1, "wxh_" + new Random().nextInt(9));
		stat2.executeUpdate();

		// 删除
		PreparedStatement stat3 = connection.prepareStatement("delete from vueblog.m_user where username = 'wxg'");
		stat3.executeUpdate();

		// 7释放资源
		rs.close();
		stat.close();
		connection.close();
	}
}
