package com.tradeqq.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.tradeqq.daoimpl.BaseDao;
import com.tradeqq.entry.User;

public class Test {
	public static void main(String[] args){
		String sql = "select * from user where age>? and type=?";
		List<Object> params = new ArrayList<>();
		params.add(20);
		params.add(1);
		BaseDao baseDao = new BaseDao();
		List<User> list = new ArrayList();
		try{
			list = baseDao.operQuery(sql, params, User.class);
		}catch(Exception e){
			e.printStackTrace();
		}
		for(User user: list){
			System.out.println(user.toString());
		}
	}
	
	public boolean addUser(){
		String sql = "insert into user(cid, sname, password, age, sex) values (?, ?, ?, ?, ?)";
		BaseDao baseDao = new BaseDao();
		List<Object> params = new ArrayList<>();
		params.add(3);
		params.add("小王");
		params.add("xiaozhang");
		params.add(20);
		params.add("男");
		return baseDao.operUpdate(sql, params);
	}
}
