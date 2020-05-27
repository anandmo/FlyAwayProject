package com.flyaway.dao;

public interface LoginDao {
	
	public boolean verifyPasswordFromDB(String userid,String password);
	
}
