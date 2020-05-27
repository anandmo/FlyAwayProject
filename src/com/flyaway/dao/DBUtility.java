package com.flyaway.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class DBUtility {
	
	
	@SuppressWarnings("rawtypes")
	public static Session getDBSession(Class annotatedClass) {
		
        Configuration con = new Configuration().configure().addAnnotatedClass(annotatedClass);
		
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		
		SessionFactory sf = con.buildSessionFactory(reg);
		
		Session session = sf.openSession();
		
		return session;
		
	}

}
