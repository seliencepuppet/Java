package com.hitrader.daoimpl;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.hitrader.dao.UserDao;
import com.hitrader.model.User;

public class UserDaoImpl extends BaseDao implements UserDao{
	private Connection connection = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public boolean addUser(User user) {
		String sql = "insert into user(name, password, age, email) values (?, ?, ?, ?)";
		List<Object> params = new ArrayList<>();
		params.add(user.getName());
		params.add(user.getPassword());
		params.add(user.getAge());
		params.add(user.getEmail());
		return operUpdate(sql, params);
	}

	@Override
	public User selectUser(String name) {
		String sql = "select * from user where name = ?";
		List<Object> params = new ArrayList<>();
		params.add(name);
		List<User> list = new ArrayList<>();
		try {
			list = operQuery(sql, params, User.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public User selectUser(User user) {
		String sql = "select * from user where name = ? and password = ? and email = ? ";
		List<Object> params = new ArrayList<>();
		params.add(user.getName());
		params.add(user.getPassword());
		params.add(user.getEmail());
		List<User> list = new ArrayList<>();
		try {
			list = operQuery(sql, params, User.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(list.size() > 0){
			System.out.println(list.size());
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<User> selectAllUser() {
		String sql = "select * from user";
		List<User> list = new ArrayList<>();
		try {
			list = operQuery(sql, null, User.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(list.size() > 0){
			System.out.println(list.size());
			return list;
		}
		return null;
	}

	@Override
	public boolean insertUser(User user) {
		String sql = "insert into user(name, password, age, email) values (?, ?, ?, ?)";
		int res = 0;
		connection = getConn();
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ps.setInt(3, user.getAge());
			ps.setString(4, user.getEmail());
			res = ps.executeUpdate();
			if(res > 0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection, ps, null);
		}
		return false;
	}

}
