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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         
		String fromplace = request.getParameter("fromplace");
		String toplace = request.getParameter("toplace");
		String numberOfPassengers = request.getParameter("cop");
		AdminDao admindaoimpl = new AdminDaoImpl();
		List<FlightScheduleObject> flightschedulelist = admindaoimpl.findFlightSchedule(fromplace, toplace);
		Iterator<FlightScheduleObject> flightscheduleiterator = flightschedulelist.iterator();
		FlightScheduleObject temp;
		List<FlightScheduleObject> flightlist = new ArrayList<>();
		while(flightscheduleiterator.hasNext()) {
			temp = flightscheduleiterator.next();
		if(temp.getFromplace().equals(fromplace) && temp.getToplace().equals(toplace)) {
			flightlist.add(temp);
		} 
	}
		request.setAttribute("flightschedulelist", flightlist);
		request.setAttribute("copassenger", numberOfPassengers);
		RequestDispatcher req = request.getRequestDispatcher("selectflight.jsp");
		req.forward(request, response);
		
	}

}
