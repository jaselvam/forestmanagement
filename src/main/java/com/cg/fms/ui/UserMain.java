package com.cg.fms.ui;

import java.util.Scanner;


import com.cg.fms.dto.User;
import com.cg.fms.exceptions.InvalidLoginException;
import com.cg.fms.service.ILoginService;
import com.cg.fms.service.LoginService;

public class UserMain {
	static String username;
	static String pwd;
	static String role;
	public static void main(String args[])
	{
		Scanner scanner =new Scanner(System.in);
		
		ILoginService service=new LoginService();
		
		
		while(true)
		{
			System.out.println("------------------------------login services ---------------------------------");
			System.out.println("Select your choice");
			System.out.println("1. Login");
			System.out.println("2. Add User");
			System.out.println("3. Remove User");
			System.out.println("4. Logout");
			System.out.println("_______________________________________________________________________________");
			int ch=scanner.nextInt();
			switch(ch)
			{
				case 1: try 
						{	
							System.out.println("Enter the username");
							username=scanner.next();
							System.out.println("Enter the password");
							pwd=scanner.next();
							System.out.println("Enter the userId");
							int id=scanner.nextInt();
							User user=new User(id,username,pwd);
							System.out.println(service.login(user));
							
						}
						catch(InvalidLoginException ie){
							throw new InvalidLoginException("Login failed");
						}
						break;
				case 2: System.out.println("Enter the username");
						username=scanner.next();
						System.out.println("Enter the password");
						pwd=scanner.next();
						System.out.println("Enter role");
						role=scanner.next();
						User user=new User(username,pwd,role);
						System.out.println(service.addUser(user));
						break;
						
				case 3: System.out.println("Enter the id of user which you want to delete");
						int id= scanner.nextInt();
						try {
							
							 User userdata=new User(id);
							 User deleteduser= service.removeUser(userdata);
							 System.out.println(deleteduser);
							 System.out.println("The user got deleted");
						}
						catch(InvalidLoginException ie)
						{
							throw new InvalidLoginException("Not deleted try again..");
						}
						break;
						
				case 4:  User userdata=new User(username,pwd,role);
						 System.out.println(service.logout(userdata)+"  logged out succesfully");
						 break;
			}
		}
	}

}
