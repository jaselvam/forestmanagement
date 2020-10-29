package com.cg.fms.utility;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connection {
	
	static EntityManagerFactory factory =null;
	public static EntityManagerFactory getFactory()   //EntityManagerFactory is an interface
	{
		if(factory==null)
		{
			factory=Persistence.createEntityManagerFactory("Forest_MS");
		}
		return factory;                            //An object of EntityManagerFactory is returned.
	}

}
