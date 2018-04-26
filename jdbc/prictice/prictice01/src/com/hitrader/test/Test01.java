package com.hitrader.test;

import com.hitrader.dao.UserDao;
import com.hitrader.daoimpl.UserDaoImpl;
import com.hitrader.model.User;

public class Test01 {
	public static void main(String[] args) {
		String name = "’≈”Ó‘Û";
		
		UserDao userDao = new UserDaoImpl();
		User user = userDao.selectUser(name);
		System.out.println(user);
	}
}
