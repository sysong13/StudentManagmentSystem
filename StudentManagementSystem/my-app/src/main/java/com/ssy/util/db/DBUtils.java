package com.ssy.util.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DBUtils {
	
	public final static String DRIVER;
	public final static String DB_URL;
	public final static String USERNAME;
	public final static String PASSWORD;
	
	private static ResourceBundle rb = ResourceBundle.getBundle("jdbc-config");
	//���췽��˽�л���ȫ���Ǿ�̬��������Ҫʵ����
	private DBUtils() {}
	//ʹ�þ�̬����س���  Ҫ�����øı�����?
	static {
		DRIVER = rb.getString("driver");
		DB_URL = rb.getString("url");
		USERNAME = rb.getString("username");
		PASSWORD = rb.getString("password");
		try {
			Class.forName(DRIVER);
			System.out.println("SUCCESS: JDBC�������سɹ�");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR: JDBC��������ʧ��");
		}
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("��ȡSQL����ʧ��");
		}
		return conn;
	}
	
	public static void close(ResultSet rs, Statement stat, Connection conn) {
		try {
			if(rs!=null) rs.close();
			if(stat!=null) stat.close();
			if(conn!=null) conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	

}
