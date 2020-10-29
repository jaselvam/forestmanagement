package com.forestry.forestmanagement;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import com.cg.fms.dao.AdminDao;
import com.cg.fms.dao.IAdminDao;
import com.cg.fms.dto.Admin;



public class TestAdmin {
	static IAdminDao adao;
	@BeforeClass
	public static void initialise()
	{
		System.out.println("Inside before class");
		adao=new AdminDao();
	}
	@Test
	public void testAddAdmin()
	{
		//assertEquals
		Admin adminRecord1=new Admin("Shiva","Shiva85");
		Assertions.assertEquals(true, adao.addAdmin(adminRecord1)); // case-1 adminname and password satisfying all the conditions
		//assertNotEquals
	
		/*Admin adminRecord3=new Admin("Vishnu","");
		Assertions.assertNotEquals(true ,adao.addAdmin(adminRecord3));// case-2 adminpassword is null
		Admin adminRecord4=new Admin("Vishnu","vishnu85");
		Assertions.assertNotEquals(true ,adao.addAdmin(adminRecord4));// case-3 adminpassword is not satisfying the regex(no capital letters)
		Admin adminRecord5=new Admin("Vishnu","Vishnu");
		Assertions.assertNotEquals(true ,adao.addAdmin(adminRecord5));// case-4 adminpassword not satisfying the regular expression(no digits)
		Admin adminRecord6=new Admin("Vishnu","Vishnu@#");
		Assertions.assertNotEquals(true ,adao.addAdmin(adminRecord6));*/// case-5 admin password have special chars(not satisfying regular expression)
	}
	@Test
	public void testUpdateAdmin()
	{
			Admin adminRecord1=new Admin("jananiselvam","Selvam777");
			if(adao.addAdmin(adminRecord1))
			{
				adminRecord1.setAdminPassword("Selvam171");
				if(adao.updateAdmin(adminRecord1))
				{
					Assertions.assertEquals("Selvam171", adminRecord1.getAdminPassword());
					Assertions.assertNotEquals(" ",adminRecord1.getAdminPassword());
				}
			}
			
	}
	@Test
	public void testDeleteAdmin()
	{
		int adminId=48;
		if(adao.deleteAdmin(adminId))
				{
					Assertions.assertNotNull(adminId);
					Assertions.assertNotEquals(true, adao.deleteAdmin(adminId));
					
				}
		
	}
	@Test
	public void testGetAllAdmin()
	{
		List<Admin> list=new ArrayList<Admin>();
		Admin admin1=new Admin("Sanju","Sanjana456");
		Admin admin2=new Admin("pavitra","Pavitra74");
		if(adao.addAdmin(admin1) && adao.addAdmin(admin2))
		{
			list.add(admin1);
			list.add(admin2);
		}
		Assertions.assertNotNull(admin1);
		Assertions.assertNotNull(admin2);
		Assertions.assertNotEquals(list, adao.getAllAdmins());
	}

}
