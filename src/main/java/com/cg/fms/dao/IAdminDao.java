package com.cg.fms.dao;

import java.util.List;

import com.cg.fms.dto.Admin;

public interface IAdminDao {     // All the methods in the interface are 'public abstract' by default.
	
	boolean addAdmin(Admin admin);
	boolean updateAdmin(Admin admin);
	boolean deleteAdmin(int adminId);
	List<Admin> getAllAdmins();
	public Admin getAdmin(Admin admin);
}
