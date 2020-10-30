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
	static int uid;
	public static void main(String args[])
	{
		Scanner scanner =new Scanner(System.in);
		
		ILoginService service=new LoginService();
		
		
		while(true)
		{
			System.out.println("_____________________________login services___________________________________");
			System.out.println("Select your choice");
			System.out.println("1. Add User");
			System.out.println("2. Login");
			System.out.println("3. Remove User");
			System.out.println("4. Logout");
			System.out.println("5. Exit");
			System.out.println("_______________________________________________________________________________");
			int ch=scanner.nextInt();
			switch(ch)
			{
				case 1: System.out.println("Enter the username (min length of 4)");  //adding user
						username=scanner.next();
						System.out.println("Enter the password(Your password must contain one upper case, one lower case, one digit)");
						pwd=scanner.next();
						System.out.println("Enter role (Admin or Customer)");
						role=scanner.next();
						User user=new User(username,pwd,role);
						System.out.println(service.addUser(user));
						System.out.println("Kindly remember yout user ID");
						break;
						
				
				case 2: try 
					{	
						System.out.println("Enter the username");     //logging in
						username=scanner.next();
						System.out.println("Enter the password");
						pwd=scanner.next();
						System.out.println("Enter the userId");
						uid=scanner.nextInt();
						User user1=new User(uid,username,pwd);
						System.out.println(service.login(user1));
					
					}
					catch(InvalidLoginException ie){
						throw new InvalidLoginException("Login failed");
					}
					break;
				case 3: System.out.println("Enter the id of user which you want to delete"); // removing user
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
				case 4:  User userdata=new User(uid,username,pwd,role); //logging out
				
						 System.out.println(service.logout(userdata)+"  logged out succesfully");
						 break;
				case 5: System.out.println("---------------Thank you------------------");
						System.exit(0);
			}
		}
	}

}
