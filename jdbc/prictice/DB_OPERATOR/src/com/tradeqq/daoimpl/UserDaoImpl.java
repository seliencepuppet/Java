package com.tradeqq.daoimpl;

import java.util.ArrayList;
import java.util.List;

import com.tradeqq.dao.UserDao;
import com.tradeqq.entry.User;

public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public boolean addUser(User user) {
		String sql = "insert into user(cid, sname, password) values (?, ?, ?)";
		List<Object> params = new ArrayList();
		params.add(user.getCid());
		params.add(user.getSname());
		params.add(user.getPassword());
		return operUpdate(sql, params);
	}

	@Override
	public User selectUser(String sname) {
		String sql = "select * from user where sname = ?";
		List<Object> params = new ArrayList();
		params.add(sname);
		List<User> list = new ArrayList();
		try{
			list = operQuery(sql, params, User.class);
		}catch(Exception e){
			e.printStackTrace();
		}
		if(list.size > 0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public User selectUser(User user) {
		String sql = "select * from user where sname = ? and password = ? and type = ?";
		List<Object> params = new ArrayList();
		params.add(user.getSname());
		params.add(user.getPassword());
		params.add(user.getType());
		List<User> list = new ArrayList();
		try{
			list = operQuery(sql, params, User.class);
		}catch(Exception e){
			e.printStackTrace();
		}
		if(list.size > 0){
			return list.get(0);
		}
	}

}
