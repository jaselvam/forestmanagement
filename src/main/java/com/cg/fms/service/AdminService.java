package com.cg.fms.service;


import java.util.List;

import com.cg.fms.dao.AdminDao;
import com.cg.fms.dao.IAdminDao;
import com.cg.fms.dto.Admin;

import com.cg.fms.utility.Validation;

public class AdminService implements IAdminService{

	IAdminDao adao=new AdminDao();//object for adminDao class is created of type IAdminDao interface.
	public Admin getAdmin(Admin admin) {
		
		return adao.getAdmin(admin);
	}

	public boolean addAdmin(Admin admin) {
		
		if(admin.getAdminPassword().matches(Validation.regex) && admin.getAdminName()!="")  //regex is a static variable declared in utility package.
		{
			return adao.addAdmin(admin); // addAdmin() method in the Dao layer is called and this method returns a boolean value.
		}
		else
		{
			return false;
		}
	}

	public boolean updateAdmin(Admin admin) {
		
		if(admin.getAdminPassword().matches(Validation.regex)) // regex is a static variable declared in utility package.
		{
			return adao.updateAdmin(admin);//calls updateAdmin() method in DAO layer of admin module and this method returns a boolean value.
		}
		else {
			return false;
		}
	}

	public boolean deleteAdmin(int adminId) {
		
		return adao.deleteAdmin(adminId);
	}

	public List<Admin> getAllAdmins() {
		
		return adao.getAllAdmins(); // This method returns the List of all the admin records.
	}
	

}
