package com.cg.fms.service;


import com.cg.fms.dto.User;

public interface ILoginService {
	
	public User login(User user);
	public User addUser(User user);
	public User removeUser(User user);
	public User logout(User user);
}
