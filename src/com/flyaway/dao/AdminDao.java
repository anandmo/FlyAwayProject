package com.flyaway.dao;

import java.util.List;

import com.flyaway.model.*;
public interface AdminDao {
	
	public void addPlaceInDB(int pincode,String statename,String cityname,String airportname);
	public List<PlaceObject> fetchAllPlaceInDB();
	public void deletePlaceInDB(int pincode);
	public void addNewFlight(int flightId,String flightName,int flightCapacity,double flightSpeed,String flightProvider);
    public List<FlightObject> fetchAllFlightInDB();
	public void addNewFlightSchedule(String flightname,String fromplace,String toplace,String dateoftravel, String depaturetime, double flightCostPerPerson);
	public List<FlightScheduleObject> findFlightSchedule(String fromplace,String toplace);
	public String getPlaceName(String pincode);
	public String getFlightName(String flightid);
	
}
