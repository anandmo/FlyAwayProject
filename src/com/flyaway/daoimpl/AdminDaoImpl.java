package com.flyaway.daoimpl;

//import java.util.Iterator;
import java.util.List;

//import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.flyaway.dao.AdminDao;
import com.flyaway.dao.DBUtility;
//import com.flyaway.dao.DBUtility;
//import com.flyaway.model.LoginObject;
import com.flyaway.model.PlaceObject;

public class AdminDaoImpl implements AdminDao {

	@Override
	public void addPlaceInDB(int pincode, String statename, String cityname, String airportname) {
		
		PlaceObject place = new PlaceObject(pincode,statename,cityname,airportname);
		Session session = DBUtility.getDBSession(PlaceObject.class);
		Transaction tx = session.beginTransaction();
		session.save(place);
		tx.commit();
		session.close();
		
	}

	@Override
	public List<PlaceObject> fetchAllPlaceInDB() {
		
		Session session = DBUtility.getDBSession(PlaceObject.class);
		Transaction tx = session.beginTransaction();
    	List<PlaceObject> placelist = session.createQuery("FROM PlaceObject",PlaceObject.class).list();
		tx.commit();

//		Iterator<PlaceObject> iterator = placelist.iterator();
//		while(iterator.hasNext()) {
//			System.out.println(iterator.next());
//     	}
		
		session.close();
		return placelist;
	}

	@Override
	public void deletePlaceInDB(int pincode) {
		Session session = DBUtility.getDBSession(PlaceObject.class);
		PlaceObject tempplaceobject = session.load(PlaceObject.class, pincode);
		Transaction tx = session.beginTransaction();
		session.delete(tempplaceobject);
		tx.commit();
		session.close();
	}

}

