package com.tradeqq.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {
	public static String driver = "com.mysql.jdbc.Driver";
	public static String path = "jdbc:mysql://localhost:3306/monitor";
	
	public Connection getConn(){
		Connection connection = null;
		try{
			Class.forName(driver);
			connection = DriverManager.getConnection(path, "root", "123456");
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		return connection;
	}
}
