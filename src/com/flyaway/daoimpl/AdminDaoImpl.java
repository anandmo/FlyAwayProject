package com.flyaway.daoimpl;

//import java.util.Iterator;
import java.util.List;

//import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.flyaway.dao.AdminDao;
import com.flyaway.dao.DBUtility;
import com.flyaway.model.FlightObject;
import com.flyaway.model.FlightScheduleObject;
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

	@Override
	public void addNewFlight(int flightId, String flightName, int flightCapacity, double flightSpeed,
			String flightProvider) {
	
		FlightObject flight = new FlightObject(flightId,flightName,flightCapacity,flightSpeed,flightProvider);
		Session session = DBUtility.getDBSession(FlightObject.class);
		Transaction tx = session.beginTransaction();
		session.save(flight);
		tx.commit();
		session.close();
		
		
	}

	@Override
	public List<FlightObject> fetchAllFlightInDB() {
		Session session = DBUtility.getDBSession(FlightObject.class);
		Transaction tx = session.beginTransaction();
    	List<FlightObject> flightlist = session.createQuery("FROM FlightObject",FlightObject.class).list();
		tx.commit();
		session.close();
		return flightlist;
	}

	@Override
	public void addNewFlightSchedule(String flightname,String fromplace, String toplace, String dateoftravel, String depaturetime, double flightCostPerPerson) {
		
		FlightScheduleObject flightscheduleobject = new FlightScheduleObject(flightname,fromplace,toplace,dateoftravel,depaturetime, flightCostPerPerson);
		Session session = DBUtility.getDBSession(FlightScheduleObject.class);
		Transaction tx = session.beginTransaction();
		session.save(flightscheduleobject);
		tx.commit();
		session.close();
		
	}

	@Override
	public List<FlightScheduleObject> findFlightSchedule(String fromplace, String toplace) {
		
		System.out.println("From Place : " + fromplace);
		System.out.println("To Place : " + toplace);
		Session session = DBUtility.getDBSession(FlightScheduleObject.class);
		Transaction tx = session.beginTransaction();
		List<FlightScheduleObject> flightschedulelist = session.createQuery("FROM FlightScheduleObject",FlightScheduleObject.class).list();
		tx.commit();
		session.close();
		return flightschedulelist;
	//	return null;
	}

	@Override
	public String getPlaceName(String pincode) {
		PlaceObject placeobject;
		Session session = DBUtility.getDBSession(PlaceObject.class);
		Transaction tx = session.beginTransaction();
		placeobject = session.get(PlaceObject.class, Integer.parseInt(pincode));
		tx.commit();
		return placeobject.getCityname();
	}

	@Override
	public String getFlightName(String flightid) {
	    FlightObject flightobject;
	    Session session = DBUtility.getDBSession(FlightObject.class);
	    Transaction tx = session.beginTransaction();
	    flightobject = session.get(FlightObject.class, Integer.parseInt(flightid));
		tx.commit();	
		return flightobject.getFlightName();

	}

	@Override
	public FlightObject getFlightObject(String flightid) {
		FlightObject flightobject;
	    Session session = DBUtility.getDBSession(FlightObject.class);
	    Transaction tx = session.beginTransaction();
	    flightobject = session.get(FlightObject.class, Integer.parseInt(flightid));
		tx.commit();	
		return flightobject;
	}

	@Override
	public FlightScheduleObject getFlightSheduleObject(String fsid) {
		FlightScheduleObject flightscheduleobject;
	    Session session = DBUtility.getDBSession(FlightScheduleObject.class);
	    Transaction tx = session.beginTransaction();
	    flightscheduleobject = session.get(FlightScheduleObject.class, Integer.parseInt(fsid));
		tx.commit();	
		return flightscheduleobject;
	}
	
	

}

