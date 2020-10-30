package com.cg.fms.dao;

import com.cg.fms.dto.User;

public interface ILoginDao {			// All the methods in the interface are 'public abstract' by default.
	
	public User addUser(User user);
	public User removeUser(User user);
	public User login(User user);
	public User logout(User user);

}
