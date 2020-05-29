package com.flyaway.main;

import com.flyaway.daoimpl.AdminDaoImpl;
//import com.flyaway.daoimpl.LoginDaoImpl;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AdminDaoImpl ld = new AdminDaoImpl();
		ld.fetchAllPlaceInDB();
		System.out.println("ID : "+ld);
		

	}

}
