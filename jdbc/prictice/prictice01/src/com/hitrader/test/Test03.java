package com.hitrader.test;

import java.util.ArrayList;
import java.util.List;

import com.hitrader.dao.UserDao;
import com.hitrader.daoimpl.UserDaoImpl;
import com.hitrader.model.User;

public class Test03 {
	public static void main(String[] args) {
		List<User> list = new ArrayList<>();
		UserDao userDao = new UserDaoImpl();
		list = userDao.selectAllUser();
		for (User user : list) {
			System.out.println(user);
		}
	}
}
