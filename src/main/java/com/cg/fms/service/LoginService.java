package com.cg.fms.service;

import com.cg.fms.dao.ILoginDao;
import com.cg.fms.dao.LoginDao;
import com.cg.fms.dto.User;
import com.cg.fms.exceptions.InvalidLoginException;
import com.cg.fms.utility.Validation;


public class LoginService implements ILoginService{
	ILoginDao ldao=new LoginDao(); // Object creation of LoginDao class of type ILoginDao interface(Dynamic polymorphism).
											

	public User addUser(User user) {    //validation takes place according to the regex stated in Validation class.
		if(user.getPassword().matches(Validation.regex) && user.getUserName().length()>=4 && (user.getRole().equalsIgnoreCase("admin")||user.getRole().equalsIgnoreCase("Customer")))
		{
			return ldao.addUser(user);
		}
		else
		{
			throw new InvalidLoginException("choose credentials as per the given criteria");
		}
		
	}
	public User removeUser(User user) {
		
		return ldao.removeUser(user);
	}
	public User login(User user) {
		
		return ldao.login(user);
	}

	public User logout(User user) {
		
		return ldao.logout(user);
	}


}
