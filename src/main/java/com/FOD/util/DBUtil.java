package com.FOD.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtil {
	
	//1.加载配置文件(写在静态代码块里面)
	private static BasicDataSource ds;
	static{
		Properties p = new Properties();
		try {
			//p.load(InputStream inStream);用输入流把配置文件读取进来
			p.load(DBUtil.class.getClassLoader().getResourceAsStream("db-config.properties"));
			String driver = p.getProperty("driver");
			String url = p.getProperty("url");
			String username = p.getProperty("user");
			String password = p.getProperty("password");
			String min_size = p.getProperty("min_size");
			String max_size = p.getProperty("max_size");
			
			//初始化连接池
		    ds = new BasicDataSource();
			//设置连接池的驱动包
			ds.setDriverClassName(driver);
			//设置连接池的url
			ds.setUrl(url);
			//设置连接池的用户名
			ds.setUsername(username);
			//设置连接池的用户密码
			ds.setPassword(password);
			//设置连接池的最小连接数量
			ds.setInitialSize(Integer.parseInt(min_size));
			//设置连接池的最大链接数量
			ds.setInitialSize(Integer.parseInt(max_size));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("配置文件读取失败!",e);
		}
	}
	
	/**
	 * 获取连接
	 */
	public static Connection getConnection(){
		Connection con = null;
		try {
			con = ds.getConnection();
			return con;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("获取连接失败!",e);
		}
		
	}
	
	/**
	 * 关闭连接
	 */
	public static void closeConnection(Connection con){
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("关闭连接失败!",e);
			}
		}
	}
	
	/**
	 * 回滚事物
	 */
	public static void rollback(Connection con){
		if(con!=null){
			try {
				con.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("回滚失败!",e);
			}
		}
	}
}
