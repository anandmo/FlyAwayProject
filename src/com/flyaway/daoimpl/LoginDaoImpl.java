package com.flyaway.daoimpl;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.flyaway.dao.DBUtility;
import com.flyaway.dao.LoginDao;
import com.flyaway.model.LoginObject;

public class LoginDaoImpl implements LoginDao {

	@Override
	public boolean verifyPasswordFromDB(String userid, String password) {
		
		LoginObject lo = new LoginObject();
		//lo.setUserid("admin");
		//lo.setPassword("admin@simplilearn");
		
		Configuration con = new Configuration().configure().addAnnotatedClass(LoginObject.class);
		
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		
		SessionFactory sf = con.buildSessionFactory(reg);
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		//session.save(lo);
		
		lo = (LoginObject) session.get(LoginObject.class, userid);
		
		tx.commit();
		session.close();
		
		if(lo != null) {
			
		     if(lo.getPassword().equals(password)) {
		    	 System.out.println("Userid found");
		    	 return true;
		     } else {
		 		  	 System.out.println("Userid not found");
		     }
			
		} else {
			System.out.println("Userid not found");
		}
		
		return false;
	}

	@Override
	public void modifyPassword(String username, String password) {
		
		Session s = DBUtility.getDBSession(LoginObject.class);
		
		Transaction tx = s.beginTransaction();
		s.createQuery("update LoginObject set password=:npassword where userid=:username").setParameter("npassword", password).setParameter("username", username).executeUpdate();
		tx.commit();
		s.close();
	}

}
