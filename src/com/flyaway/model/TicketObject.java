package com.flyaway.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ticketdb")
public class TicketObject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ticketid", updatable = false, nullable = false)
	private int ticketid;
	private int flightid;
	public int getFlightid() {
		return flightid;
	}
	public void setFlightid(int flightid) {
		this.flightid = flightid;
	}


	private String travellerName;
	private String travellerEmail;
	private double travellerPhoneNo;
	private int cotraveller;
	private float ticketCost;
	
	public int getTicketid() {
		return ticketid;
	}
	public void setTicketid(int ticketid) {
		this.ticketid = ticketid;
	}
	public String getTravellerName() {
		return travellerName;
	}
	public void setTravellerName(String travellerName) {
		this.travellerName = travellerName;
	}
	public String getTravellerEmail() {
		return travellerEmail;
	}
	public void setTravellerEmail(String travellerEmail) {
		this.travellerEmail = travellerEmail;
	}
	public double getTravellerPhoneNo() {
		return travellerPhoneNo;
	}
	public void setTravellerPhoneNo(double travellerPhoneNo) {
		this.travellerPhoneNo = travellerPhoneNo;
	}
	public int getCotraveller() {
		return cotraveller;
	}
	public void setCotraveller(int cotraveller) {
		this.cotraveller = cotraveller;
	}
	public float getTicketCost() {
		return ticketCost;
	}
	public void setTicketCost(float ticketCost) {
		this.ticketCost = ticketCost;
	}
	
	
	public TicketObject() {
		super();
	
	}
	
	
	public TicketObject(int flightid,String travellerName, String travellerEmail, double travellerPhoneNo, int cotraveller,
			float ticketCost) {
		super();
		
		this.flightid = flightid;
		this.travellerName = travellerName;
		this.travellerEmail = travellerEmail;
		this.travellerPhoneNo = travellerPhoneNo;
		this.cotraveller = cotraveller;
		this.ticketCost = ticketCost;
	}
	
	

}
