package com.forestry.forestmanagement;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import com.cg.fms.dto.User;
import com.cg.fms.service.ILoginService;
import com.cg.fms.service.LoginService;

public class TestMethods {
	ILoginService service=new LoginService();
	
	@Test
	public void testAddUser()
	{
		User userRecord1=new User("lakshmi","Lakshmi123","admin");
		User user1=service.addUser(userRecord1);
		Assertions.assertEquals("lakshmi",user1.getUserName());
		Assertions.assertEquals("Lakshmi123",user1.getPassword());
		Assertions.assertEquals("admin",user1.getRole());
		
		//assertNotequals
		Assertions.assertNotEquals("",user1.getUserName());// username should not be null.
		Assertions.assertNotEquals("jon",user1.getUserName()); // username should have minimum of 4 characters.
		Assertions.assertNotEquals("lakshmi@45",user1.getPassword());//password should not have special characters
		Assertions.assertNotEquals("client",user1.getRole());// user role should be either customer or admin.
		//assertnotnull
		Assertions.assertNotNull(user1); // user record should not be null
		
	}
	@Test
	public void testLogin()
	{
		User userrecord=new User(16,"janani","karthika123");
		User user=service.login(userrecord);
		Assertions.assertEquals(16,user.getUserId());
		Assertions.assertEquals("janani",user.getUserName());
		Assertions.assertEquals("karthika123",user.getPassword());
		Assertions.assertEquals("admin",user.getRole());
		
		
	}
	@Test
	public void testLogout() {
		User userRecord=new User(22,"vishnu","hamsI123","admin");
		User user=service.logout(userRecord);
		Assertions.assertEquals(22,user.getUserId());
		Assertions.assertEquals("vishnu",user.getUserName());
		Assertions.assertEquals("hamsI123",user.getPassword());
		Assertions.assertEquals("admin",user.getRole());
	}
	@Test
	public void TestRemoveuser()
	{
		User userRecord=new User(37,"1akshmi","Lakshmi123","admin");
		User user=service.removeUser(userRecord);
		Assertions.assertEquals(37,user.getUserId());
		Assertions.assertEquals("lakshmi",user.getUserName());
		Assertions.assertEquals("Lakshmi123",user.getPassword());
		Assertions.assertEquals("admin",user.getRole());
		
	}
}
