package com.flyaway.bo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyaway.dao.AdminDao;
import com.flyaway.daoimpl.AdminDaoImpl;
//import com.flyaway.model.FlightScheduleObject;

/**
 * Servlet implementation class AddFlightSchedule
 */
@WebServlet("/addflightschedule")
public class AddFlightSchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFlightSchedule() {
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

		String fromplace = request.getParameter("fromplace");
		String toplace = request.getParameter("toplace");
		String dateoftravel = request.getParameter("dateoftravel");
		String depaturetime = request.getParameter("depaturetime");
		AdminDao admindaoimpl = new AdminDaoImpl();
		admindaoimpl.addNewFlightSchedule(fromplace, toplace, dateoftravel, depaturetime);
		RequestDispatcher req = request.getRequestDispatcher("manageflightshedule.jsp");
		req.include(request, response);
		response.getWriter().write("<h2>Flight Schedule Added</h2>");
		
	}

}
