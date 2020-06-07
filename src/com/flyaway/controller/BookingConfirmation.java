package com.flyaway.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyaway.dao.AdminDao;
import com.flyaway.daoimpl.AdminDaoImpl;
import com.flyaway.model.FlightScheduleObject;

/**
 * Servlet implementation class BookingConfirmation
 */
@WebServlet("/bookingconfirmation")
public class BookingConfirmation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingConfirmation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String fdetail = request.getParameter("fdetail");
		
		String[] detail = fdetail.split("-");
		String flightscheduleid = detail[0];
		String cost = detail[1];
		String count = detail[2];
		
		AdminDao admindao = new AdminDaoImpl();
		FlightScheduleObject flightscheduleobject = admindao.getFlightSheduleObject(flightscheduleid);
		
		String flightname = flightscheduleobject.getFlightName();
		String dateoftravel = flightscheduleobject.getDateoftravel();
		String source = flightscheduleobject.getFromplace();
		String destination = flightscheduleobject.getToplace();
		String time = flightscheduleobject.getDepaturetime();

		//response.getWriter().write(name + "  " + "  " + email + "  " + phone + "  " + flightid + "  " + cost + "  "  + count );
		
		request.setAttribute("name", name);
		request.setAttribute("email", email);
		request.setAttribute("phone", phone);
		request.setAttribute("cost", cost);
		request.setAttribute("count", count);
		request.setAttribute("flightname", flightname);
		request.setAttribute("dateoftravel", dateoftravel);
		request.setAttribute("source", source);
		request.setAttribute("destination", destination);
		request.setAttribute("time", time);
		
		request.getRequestDispatcher("bookingconfirmationpage.jsp").forward(request, response);
		
		
		
	}

}
