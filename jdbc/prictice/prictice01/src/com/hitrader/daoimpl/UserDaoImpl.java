package com.hitrader.daoimpl;

import java.util.ArrayList;
import java.util.List;

import com.hitrader.dao.UserDao;
import com.hitrader.model.User;

public class UserDaoImpl extends BaseDao implements UserDao{

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

}
