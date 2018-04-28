package com.hitrader.dao;

import java.util.List;

import com.hitrader.model.User;

public interface UserDao {
	public boolean addUser(User user);

	public User selectUser(String name);
	
	public User selectUser(User user);
	
	public List<User> selectAllUser();
	
	public boolean insertUser(User user);
}



    