package com.flyaway.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.flyaway.dao.AdminDao;
//import com.flyaway.dao.DBUtility;
//import com.flyaway.model.LoginObject;
import com.flyaway.model.PlaceObject;

public class AdminDaoImpl implements AdminDao {

	@Override
	public void addPlaceInDB(int pincode, String statename, String cityname, String airportname) {
		
		PlaceObject place = new PlaceObject(pincode,statename,cityname,airportname);
		//Session session = DBUtility.getDBSession(PlaceObject.class);
        Configuration con = new Configuration().configure().addAnnotatedClass(PlaceObject.class);
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(place);
		tx.commit();
		session.close();
		
	}

}

