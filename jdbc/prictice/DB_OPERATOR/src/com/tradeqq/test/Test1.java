package com.tradeqq.test;

import com.tradeqq.dao.UserDao;

public class Test1 {
	public static void main(String[] args){
		UserDao dao = new UserDaoImpl();
		boolean addUser = dao.addUser(new User(3, "xiaoqian", "123"));
		if(addUser){
			System.out.println(true);
		}
		User user = dao.selectUser(new User("周结论", "123456", 0));
		if(user != null){
			System.out.println("有数据");
		}else{
			System.out.println("没有数据");
		}
	}
}
