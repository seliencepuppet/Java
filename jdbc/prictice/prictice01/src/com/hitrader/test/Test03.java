package com.hitrader.test;

import java.util.ArrayList;
import java.util.List;

import com.hitrader.dao.UserDao;
import com.hitrader.daoimpl.UserDaoImpl;
import com.hitrader.model.User;

public class Test03 {
	public static void main(String[] args) {
		UserDao userDao = new UserDaoImpl();
		List<User> list = userDao.selectAllUser();
		System.out.println(list);
	}
}
