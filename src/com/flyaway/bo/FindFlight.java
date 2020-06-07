package com.flyaway.bo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyaway.dao.AdminDao;
import com.flyaway.daoimpl.AdminDaoImpl;
import com.flyaway.model.FlightScheduleObject;

@WebServlet("/findflight")
public class FindFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FindFlight() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
		if(request.getSession(false) != null) {
		
		String fromplace = request.getParameter("fromplace");
		String toplace = request.getParameter("toplace");
		String numberOfPassengers = request.getParameter("cop");
		if(numberOfPassengers.equals("")) {
		numberOfPassengers = "0";
		}
		Integer cop = Integer.parseInt(numberOfPassengers);
		System.out.println("Number of Passengers : "+numberOfPassengers);
		System.out.println("From : "+fromplace);
		System.out.println("To : "+toplace);
		
		if(fromplace.equals(toplace) || toplace.equals(fromplace) || fromplace.equals("-1") || toplace.equals("-1")){
			
			RequestDispatcher req = request.getRequestDispatcher("welcome.jsp");
			req.include(request, response);
			response.getWriter().write("<p>Invalid details selected. Please select source and destination location before proceeding </p>");
			
		} else {
		AdminDao admindaoimpl = new AdminDaoImpl();
		List<FlightScheduleObject> flightschedulelist = admindaoimpl.findFlightSchedule(fromplace, toplace);
	
		
		System.out.println("Schedule list size : "+flightschedulelist.size());
		System.out.println("Schedule list  : "+flightschedulelist);

		Iterator<FlightScheduleObject> flightscheduleiterator = flightschedulelist.iterator();
		FlightScheduleObject temp;
		List<FlightScheduleObject> flightlist = new ArrayList<>();
		while(flightscheduleiterator.hasNext()) {
			temp = flightscheduleiterator.next();
		if(temp.getFromplace().equals(fromplace) && temp.getToplace().equals(toplace)) {
			flightlist.add(temp);
		} 
	}
		
		System.out.println("Final list size : "+flightlist.size());
		System.out.println("Final list  : "+flightlist);
		
		if(flightlist.size() == 0 ) {
			RequestDispatcher req = request.getRequestDispatcher("welcome.jsp");
			req.include(request, response);
			response.getWriter().write("<p>No flight found for this route at the moment.</p>");
		} else {
		
		request.setAttribute("flightschedulelist", flightlist);
		request.setAttribute("copassenger", cop);
		RequestDispatcher req = request.getRequestDispatcher("selectflight.jsp");
		req.forward(request, response);
		}
		}
	} else {
		RequestDispatcher req = request.getRequestDispatcher("welcome.jsp");
		req.forward(request, response);
	}
		
	} 

}
