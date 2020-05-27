package com.flyaway.main;

import com.flyaway.daoimpl.LoginDaoImpl;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LoginDaoImpl ld = new LoginDaoImpl();
		ld.verifyPasswordFromDB("admin", "admin@simplilearn");
		

	}

}
