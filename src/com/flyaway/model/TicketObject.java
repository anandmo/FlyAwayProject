package com.flyaway.model;

public class TicketObject {
	
	private int ticketid;
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
	
	
	public TicketObject(String travellerName, String travellerEmail, double travellerPhoneNo, int cotraveller,
			float ticketCost) {
		super();
		this.travellerName = travellerName;
		this.travellerEmail = travellerEmail;
		this.travellerPhoneNo = travellerPhoneNo;
		this.cotraveller = cotraveller;
		this.ticketCost = ticketCost;
	}
	
	

}
