package com.cg.fms.dao;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;


import com.cg.fms.dto.User;
import com.cg.fms.exceptions.DataNotFoundException;
import com.cg.fms.utility.Connection;

public class LoginDao implements ILoginDao{

	EntityManagerFactory factory=Connection.getFactory();   //EntityManagerFactory, EntityManager, EntityTransaction all the three are interfaces present in javax.persistence package.
	EntityManager manager=factory.createEntityManager();
	EntityTransaction transaction=null;
	
	/*******************************************************************************************************
	 - Function Name	:	addUser
	 - Input Parameters	:	User user
	 - Return Type		:	User
	 - Author			:	Janani
	 - Creation Date	:	28/10/2020
	 - Description		:	Adding user record 
	 ********************************************************************************************************/
	
	public User addUser(User user) {
		
		transaction=manager.getTransaction();  //TrasactionEntity interface is required only for trasactional operations like persist, delete and update.
		
		transaction.begin();
		manager.persist(user);
		transaction.commit();
		
		return user;
	}
	/*******************************************************************************************************
	 - Function Name	:	removeUser
	 - Input Parameters	:	User user
	 - Return Type		:	User
	 - Author			:	Janani
	 - Creation Date	:	28/10/2020
	 - Description		:	removing user record 
	 ********************************************************************************************************/
	
	public User removeUser(User user) {
		
		transaction=manager.getTransaction();
		
		User userdata=manager.find(User.class, user.getUserId());
	
		transaction.begin();
		manager.remove(userdata);
		transaction.commit();

		return userdata;
	}
	/*******************************************************************************************************
	 - Function Name	:	login
	 - Input Parameters	:	User user
	 - Return Type		:	User
	 - Author			:	Janani
	 - Creation Date	:	28/10/2020
	 - Description		:	logging in into the exixting userrecord
	 ********************************************************************************************************/
	
	public User login(User user) throws DataNotFoundException  {
		int flag=0; //temporary local variable.
		User loginUser= manager.find(User.class, user.getUserId());
		try {
		if(loginUser!=null) 
		{
		
			String username=loginUser.getUserName();
			String pwd=loginUser.getPassword();
			if(username.equals(user.getUserName()) && pwd.equals(user.getPassword())) // validates whether the username and password entered by the user with the records in Database. 
			{

				System.out.println("Login successfull");
			}
			else
			{
				System.out.println("Trying to access invalid user");
			}
		}
		}
		catch(DataNotFoundException de)
		{
			throw new DataNotFoundException("please enter correct details");
		}
		return loginUser;
		/*if(flag==1) {
			
			System.out.println("Login successfull");
			return loginUser;
			}
		else
			System.out.println("Login failed");
			return null;*/
	}
	/*******************************************************************************************************
	 - Function Name	:	logout
	 - Input Parameters	:	User user
	 - Return Type		:	User
	 - Author			:	Janani
	 - Creation Date	:	28/10/2020
	 - Description		:	logging out from the exixting userrecord
	 ********************************************************************************************************/
	
	public User logout(User user) {
		
		return user;
	}

	

}
