package com.cg.fms.dao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.cg.fms.dto.User;
import com.cg.fms.exceptions.DataNotFoundException;
import com.cg.fms.utility.Connection;

public class LoginDao implements ILoginDao{

	EntityManagerFactory factory=null;
	EntityManager manager=null;
	EntityTransaction transaction=null;
	
	public User login(User user) {
		int flag=0;
		factory=Connection.getFactory();
		manager=factory.createEntityManager();
		User loginUser= manager.find(User.class, user.getUserId());
		
		if(loginUser!=null) 
		{
		
			String username=loginUser.getUserName();
			String pwd=loginUser.getPassword();
			if(username.equals(user.getUserName()) && pwd.equals(user.getPassword()))
			{
				flag=1;
			}
		}
		else
		{
			throw new DataNotFoundException("please enter correct details");	
		}
		if(flag==1) {
			
			System.out.println("Login successfull");
			return loginUser;
			}
		else
			System.out.println("Login failed");
			return null;
	}

	public User logout(User user) {
		
		return user;
	}

	public User addUser(User user) {
		factory=Connection.getFactory();
		manager=factory.createEntityManager();
		transaction=manager.getTransaction();
		
		transaction.begin();
		manager.persist(user);
		transaction.commit();
		
		return user;
	}

	public User removeUser(User user) {
		factory=Connection.getFactory();
		manager=factory.createEntityManager();
		transaction=manager.getTransaction();
		
		User userdata=manager.find(User.class, user.getUserId());
	
		transaction.begin();
		manager.remove(userdata);
		transaction.commit();

		return userdata;
	}

}
