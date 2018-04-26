package com.tradeqq.daoimpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BaseDao {
	public static String driver;
	public static String path;
	public static String name;
	public static String password;
	
	static{
		try{
			try{
				BufferedReader br = new BufferedReader(new FileReader(new File("config.pro")));
				driver = br.readLine().split("=")[1].trim();
				path = br.readLine().split("=")[1].trim();
				name = br.readLine().split("=")[1].trim();
				password = br.readLine().split("=")[1].trim();
			}catch(IOException e){
				e.printStackTrace();
			}
			Class.forName(driver);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public Connection getConnection(){
		Connection connection = null;
		try{
			connection = DriverManager.getConnection(path, name, password);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return connection;
	}
	
	public boolean operUpdate(String sql, List<Object> params){
		Connection connection = getConnection();
		PreparedStatement ps = null;
		int res = 0;
		try{
			ps = connection.prepareStatement(sql);
			for(int i = 0; i < params.size(); i++){
				ps.setObject(i+1, params.get(i));
			}
			res = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		close(connection, ps, null);
		if(res > 0){
			return true;
		}
		return false;
	}
	
	public void close(Connection connection, Statement statement, ResultSet rs){
		if(rs != null){
			try{
				rs.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		if(statement != null){
			try{
				statement.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		if(connection != null){
			try{
				connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	public <T> List<T> operQuery(String sql, List<Object> params, Class<T> cls) throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<T> data = new ArrayList<T>();
		try{
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			if(params != null){
				for(int i = 0; i < params.size(); i++){
					ps.setObject(i+1, params.get(i));
				}
			}
			
			rs = ps.executeQuery();
			ResultSetMetaData rsd = rs.getMetaData();
			while(rs.next()){
				T m = cls.newInstance();
				for(int i = 0; i < rsd.getColumnCount(); i++){
					String col_name = rsd.getColumnName(i+1);
					Object values = rs.getObject(col_name);
					Field field = cls.getDeclaredField(col_name);
					field.setAccessible(true);
					field.set(m, values);
				}
				data.add(m);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			close(conn, ps, rs);
		}
	}
}
