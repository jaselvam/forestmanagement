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
	EntityManagerFactory factory=null;   //EntityManagerFactory interface reference is created and declared as static in Connection class.
	EntityManager manager=null;
	EntityTransaction transaction=null;
	
	
	public Admin getAdmin(Admin admin) {
		factory=Connection.getFactory();
		manager=factory.createEntityManager();  
		
		/*Query query=manager.createQuery("select a from admin_records a where a.adminName=?1");
		query.setParameter(1,adminName);
		List<Admin> admin=query.getResultList();
		//Admin admin=(Admin) query.getSingleResult();
		return (Admin) admin;
		Admin list=manager.createQuery(" from admin_records where adminName=:adminName",Admin.class).setParameter("adminName", adminName).getSingleResult();
		return list;*/
		Admin admin1= manager.find(Admin.class, admin.getAdminId());
		if(admin1.getAdminName()==null)
		{
			throw new DataNotFoundException("admin not found");
		}
		return admin;
	}

	public boolean addAdmin(Admin admin) {
		factory=Connection.getFactory();
		manager=factory.createEntityManager();
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

	public boolean updateAdmin(Admin admin) {
		factory=Connection.getFactory();  
		manager=factory.createEntityManager();
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

	public boolean deleteAdmin(int adminId) {
		factory=Connection.getFactory();
		manager=factory.createEntityManager();
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

	public List<Admin> getAllAdmins() {
		factory=Connection.getFactory();
		manager=factory.createEntityManager();
		
		List<Admin> list=new ArrayList<Admin>();    //creation of ArrayList of type List.
		list=manager.createQuery("from Admin",Admin.class).getResultList();  //using Java persistence query language for retrieving all the admin records.
		return list;
	}
	

}
