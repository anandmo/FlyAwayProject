package com.flyaway.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "flightdb")
public class FlightObject {
	
	@Id
	private int flightId;
	
	private String flightName;
	private int flightCapacity;
	private double flightSpeed;
	private String flightProvider;
	
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public int getFlightCapacity() {
		return flightCapacity;
	}
	public void setFlightCapacity(int flightCapacity) {
		this.flightCapacity = flightCapacity;
	}
	public double getFlightSpeed() {
		return flightSpeed;
	}
	public void setFlightSpeed(double flightSpeed) {
		this.flightSpeed = flightSpeed;
	}
	public String getFlightProvider() {
		return flightProvider;
	}
	public void setFlightProvider(String flightProvider) {
		this.flightProvider = flightProvider;
	}
	public FlightObject(int flightId, String flightName, int flightCapacity, double flightSpeed,
			String flightProvider) {
		super();
		this.flightId = flightId;
		this.flightName = flightName;
		this.flightCapacity = flightCapacity;
		this.flightSpeed = flightSpeed;
		this.flightProvider = flightProvider;
	}
	
	
	
	public FlightObject() {
		super();
		
	}
	
	

}
