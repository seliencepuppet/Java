package com.hitrader.test;

import com.hitrader.dao.UserDao;
import com.hitrader.daoimpl.UserDaoImpl;
import com.hitrader.model.User;

public class Test {
	public static void main(String[] args) {
		User user = new User();
		user.setName("’≈”Ó‘Û");
		user.setPassword("123456");
		user.setAge(22);
		user.setEmail("15071567976@163.com");
		
		UserDao userDao = new UserDaoImpl();
		userDao.addUser(user);
	}
}
