package com.cg.fms.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin_records") // creation of table in the name of admin_records. 
								//If we dont declare @Table annotaion table will be created same as the entity name.
public class Admin {
	
	@Id   
	@GeneratedValue
	public int adminId; //primary key
	public String adminName;
	public String adminPassword;
	
	public Admin()   //zero parametrized constructor
	{
		
	}
	
	public Admin(int adminId) {
		super();
		this.adminId = adminId;
	}
	
	public Admin(String adminName) {
		super();
		this.adminName = adminName;
	}

	public Admin(String adminName, String adminPassword) {
		super();
		this.adminName = adminName;
		this.adminPassword = adminPassword;
	}

	public Admin(int adminId, String adminName, String adminPassword) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminPassword = adminPassword;
	}
	//getters and setters
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminPassword=" + adminPassword + "]";
	}

}
