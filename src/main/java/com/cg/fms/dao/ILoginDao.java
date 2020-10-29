package com.cg.fms.dao;

import com.cg.fms.dto.User;

public interface ILoginDao {
	public User login(User user);
	public User logout(User user);
	public User addUser(User user);
	public User removeUser(User user);

}
