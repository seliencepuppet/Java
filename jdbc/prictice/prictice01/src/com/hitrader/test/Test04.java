package com.hitrader.test;

import com.hitrader.dao.UserDao;
import com.hitrader.daoimpl.UserDaoImpl;
import com.hitrader.model.User;

public class Test04 {
	public static void main(String[] args) {
		User user = new User();
		user.setName("’‘»’ÃÏ");
		user.setPassword("123456");
		user.setAge(30);
		user.setEmail("15021402839@qq.com");
		
		UserDao userDao = new UserDaoImpl();
		boolean flag = userDao.insertUser(user);
		System.out.println(flag);
	}
}
