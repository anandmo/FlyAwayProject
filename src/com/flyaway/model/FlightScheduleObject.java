package com.flyaway.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "flightscheduledb")
public class FlightScheduleObject {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "flightid", updatable = false, nullable = false)
	int flightid;
	
	private String flightName;
	private String fromplace;
	private String toplace;
	private String dateoftravel;
	private String depaturetime;
	private double flightCostPerPerson;
	
	public double getFlightCostPerPerson() {
		return flightCostPerPerson;
	}
	public void setFlightCostPerPerson(double flightCostPerPerson) {
		this.flightCostPerPerson = flightCostPerPerson;
	}
	public int getFlightid() {
		return flightid;
	}
	public void setFlightid(int flightid) {
		this.flightid = flightid;
	}
	public String getFromplace() {
		return fromplace;
	}
	public void setFromplace(String fromplace) {
		this.fromplace = fromplace;
	}
	public String getToplace() {
		return toplace;
	}
	public void setToplace(String toplace) {
		this.toplace = toplace;
	}
	public String getDateoftravel() {
		return dateoftravel;
	}
	public void setDateoftravel(String dateoftravel) {
		this.dateoftravel = dateoftravel;
	}
	public String getDepaturetime() {
		return depaturetime;
	}
	public void setDepaturetime(String depaturetime) {
		this.depaturetime = depaturetime;
	}
	
	public FlightScheduleObject(String flightname, String fromplace, String toplace, String dateoftravel, String depaturetime , double flightCostPerPerson) {
		super();
		this.flightName = flightname;
		this.fromplace = fromplace;
		this.toplace = toplace;
		this.dateoftravel = dateoftravel;
		this.depaturetime = depaturetime;
		this.flightCostPerPerson = flightCostPerPerson;
	}
	
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public FlightScheduleObject() {
		super();
	}
	
	

}
