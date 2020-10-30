package com.cg.fms.ui;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.cg.fms.dto.Admin;
import com.cg.fms.exceptions.DataNotFoundException;
import com.cg.fms.service.AdminService;
import com.cg.fms.service.IAdminService;

public class AdminMain {
	
	static String adminName;
	static String adminPassword;

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
	
		IAdminService service= new AdminService(); // creating object for AdminService class of type IAdminService.
		while(true)
		{
			System.out.println("******************************Admin Services*******************************");
			System.out.println("Enter yor choice");
			System.out.println("1.To add a new admin");
			System.out.println("2.To Update a admin's password");
			System.out.println("3.To delete a admin");
			System.out.println("4.To get admin details based on admin name");
			System.out.println("5.To get all admin records");
			System.out.println("6.Exit");
			System.out.println("****************************************************************************");
			int choice=scanner.nextInt();
			
			switch(choice)
			{
			
			case 1: System.out.println("Enter admin name");
					adminName=scanner.next();
					System.out.println("enter the password(Your password must contain one upper case,one lower case and one digit)");
					adminPassword=scanner.next();
					Admin admin2=new Admin(adminName,adminPassword); 
					if(service.addAdmin(admin2)) // addadmain() method in service layer is invoked and addAdmin() method returns boolen value
					{
						System.out.println("Admin added succesfully");
						System.out.println("Your admin Id is :" + admin2.getAdminId());
						System.out.println("Kindly remember your Admin ID");
					}
					else
					{
						throw new DataNotFoundException("Admin not added, your password must contain one lower case, one upper case and one digit");
					}
					break;
			case 2: System.out.println("Enter id of the admin whose password should be updated");
					int id =scanner.nextInt();
					System.out.println("enter the new password");
					adminPassword=scanner.next();
					Admin updateRecord =new Admin(id,adminName,adminPassword);
					if(service.updateAdmin(updateRecord))  // calling updateAdmin() method in service layer.
					{
						System.out.println("Admin's password updated succesfully");
					}
					else
					{
						throw new DataNotFoundException(" admin's password not updated! your password must contain one lower case, one upper case and one digit"); 
					}
					break;
			case 3: System.out.println("Enter id of the admin whose record need to be deleted");
					int removeid =scanner.nextInt();
					 
					try {
						if(service.deleteAdmin(removeid))  // calling delete method in the service layer
						{
							System.out.println("Admin record removed successfully");
						}
					}
					catch(DataNotFoundException de)
					{
						System.out.println("Admin record not removed, Try again..");
					}
					break;
			case 4: 
					System.out.println("Enter admin name");
					adminName=scanner.next();
					Admin admin=new Admin(adminName);
					if(adminName==null)
					{
						throw new DataNotFoundException("enter valid admin name");  //throws a DataNotFoundException when admin name given by the user is null or if there is a mismatch in input datatype.
					}
					else 
					{
						System.out.println(service.getAdmin(admin)); // the getAdmin() method in service layer of admin module is invoked.
					}
					break;
			case 5:	 List<Admin> adminrecords =service.getAllAdmins();
					 Iterator<Admin> iterator=adminrecords.iterator();
					 while(iterator.hasNext())  // retriveing the elements in the list by using Iterator interface.
					 {
						Admin record=(Admin) iterator.next();
						System.out.println(record);
					 }
					 break;	
			case 6: System.out.println("-------------Thank you-------------");
					System.exit(0);
			}
		}
		
	}

}
