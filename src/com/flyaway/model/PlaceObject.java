package com.flyaway.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "placetable")
public class PlaceObject {
	
	@Id
	private int pincode;
	
	private String statename;
	private String cityname;
	private String airportname;
	
	
	public PlaceObject(int pincode,String statename,String cityname,String airportname) {
		
		this.pincode = pincode;
		this.statename =  statename;
		this.cityname = cityname;
		this.airportname = airportname;
		
	}
	
	
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getStatename() {
		return statename;
	}
	public void setStatename(String statename) {
		this.statename = statename;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public String getAirportname() {
		return airportname;
	}
	public void setAirportname(String airportname) {
		this.airportname = airportname;
	}
	
	

}
