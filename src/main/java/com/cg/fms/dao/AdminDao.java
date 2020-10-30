package com.cg.fms.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.cg.fms.dto.Admin;
import com.cg.fms.exceptions.DataNotFoundException;
import com.cg.fms.utility.Connection;

public class AdminDao implements IAdminDao{
	EntityManagerFactory factory=Connection.getFactory();   //EntityManagerFactory interface reference is created and declared as static in Connection class.
	EntityManager manager=factory.createEntityManager();
	EntityTransaction transaction=null;

	/*******************************************************************************************************
	 - Function Name	:	addAdmin
	 - Input Parameters	:	Admin admin
	 - Return Type		:	boolean
	 - Author			:	Janani
	 - Creation Date	:	28/10/2020
	 - Description		:	Adding admin
	 ********************************************************************************************************/
	
	public boolean addAdmin(Admin admin) {
		
		transaction=manager.getTransaction(); // EntityTransaction is required only for Transactional operations like persist,update,delete
		if(admin!=null) {
			transaction.begin();
			manager.persist(admin);
			transaction.commit();
			return true;
		}
		else
		{
			return false;
		}

	}
	/*******************************************************************************************************
	 - Function Name	:	updateAdmin
	 - Input Parameters	:	Admin admin
	 - Return Type		:	boolean
	 - Author			:	Janani
	 - Creation Date	:	28/10/2020
	 - Description		:	updating admin record
	 ********************************************************************************************************/
	
	public boolean updateAdmin(Admin admin) {

		transaction=manager.getTransaction(); // EntityTransaction interface is used to reflect the changes made on data base table 
		
		Admin adminRecord =manager.find(Admin.class, admin.adminId);  //finds the required admin record based on adminId.
		if(adminRecord!=null) {
			transaction.begin();
			adminRecord.setAdminPassword(admin.adminPassword);
			transaction.commit();
			return true;
		}
		else {
		return false;
		}
	}
	/*******************************************************************************************************
	 - Function Name	:	deleteAdmin
	 - Input Parameters	:	int adminId(Which need to be deleted)
	 - Return Type		:	boolean
	 - Author			:	Janani
	 - Creation Date	:	28/10/2020
	 - Description		:	Deleting Donor record
	 ********************************************************************************************************/
	
	public boolean deleteAdmin(int adminId) {

		transaction=manager.getTransaction();  
	
		
		Admin admin=manager.find(Admin.class, adminId);
		if(admin!=null) {
			transaction.begin();  
			manager.remove(admin);
			transaction.commit();
			return true;
		}
		else
		{
			return false;
		}
		//Delete by using JPQL
		/*Query query=manager.createQuery(" delete from admin_records where adminId=:adminId",Admin.class).setParameter("adminId", adminId);
		query.executeUpdate();*/
	}
	/*******************************************************************************************************
	 - Function Name	:	getAllAdmin
	 - Input Parameters	:	NIL
	 - Return Type		:	List<Admin>
	 - Author			:	Janani
	 - Creation Date	:	28/10/2020
	 - Description		:	retrieving all the Donors
	 ********************************************************************************************************/
	
	public List<Admin> getAllAdmins() {
		
		List<Admin> list=new ArrayList<Admin>();    //creation of ArrayList of type List.
		list=manager.createQuery("from Admin",Admin.class).getResultList();  //using Java persistence query language for retrieving all the admin records.
		return list;
	}
	/*******************************************************************************************************
	 - Function Name	:	getAdmin
	 - Input Parameters	:	Admin admin
	 - Return Type		:	Admin
	 - Author			:	Janani
	 - Creation Date	:	28/10/2020
	 - Description		:	retrieving the Donors based on his/her name
	 ********************************************************************************************************/
	
	public Admin getAdmin(Admin admin) {
		
		Admin admin1= manager.find(Admin.class, admin.getAdminId());
		return admin1;
		
	}

}
