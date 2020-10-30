package com.cg.fms.service;

import java.util.List;

import com.cg.fms.dto.Admin;

public interface IAdminService {         // All the methods in the interface are public abstract by default.
	public Admin getAdmin(Admin admin);
	boolean addAdmin(Admin admin);
	boolean updateAdmin(Admin admin);
	boolean deleteAdmin(int adminId);
	List<Admin> getAllAdmins();

}
