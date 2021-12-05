package com.gk.learn.code.week05;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.pool.HikariPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Random;

public class HikariTest {

	public static void main(String[] args) throws Exception {
		HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3307/vueblog?useUnicode=true&characterEncoding=utf8&useSSL=false");
        config.setUsername("root");
        config.setPassword("root");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "10");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "1000");
        config.setMaximumPoolSize(10);
        // 设置连接超时
        config.setConnectionTimeout(30 * 60);
        HikariDataSource dataSource = new HikariDataSource(config);

        // 获取连接
		Connection connection = dataSource.getConnection();
		PreparedStatement stat = connection.prepareStatement("select * from vueblog.m_user where id = 2");
		// 5执行SQL语句
		ResultSet rs = stat.executeQuery();
		// 6处理结果集(遍历结果集合)
		while( rs.next() ){
			//显示数据
			System.out.println("执行结果：id:" + rs.getString(1) + " userName:" + rs.getString(2));
		}
		// 新增
		PreparedStatement stat1 = connection.prepareStatement("insert into vueblog.m_user (username,password) value ('wxg','root')");
		stat1.execute();

		// 更新
		PreparedStatement stat2 = connection.prepareStatement("update vueblog.m_user set username = ? where id = 2");
		stat2.setString(1, "wxh_" + new Random().nextInt(9));
		stat2.execute();

		// 删除
		PreparedStatement stat3 = connection.prepareStatement("delete from vueblog.m_user where username = 'wxg'");
		stat3.execute();

		// 7释放资源
		rs.close();
		stat.close();
		connection.close();
	}
}
