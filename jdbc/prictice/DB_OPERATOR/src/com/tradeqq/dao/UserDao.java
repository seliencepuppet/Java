package com.tradeqq.dao;

import com.tradeqq.entry.User;

public interface UserDao {
	public boolean addUser(User user);
	public User selectUser(String sname);
	public User selectUser(User user);
}
