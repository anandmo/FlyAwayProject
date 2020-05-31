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


@WebServlet("/addnewflight")
public class AddNewFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddNewFlight() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int flightId = Integer.parseInt(request.getParameter("flightid"));
		String flightName = request.getParameter("flightname");
		int flightCapacity = Integer.parseInt(request.getParameter("flightcapacity"));
		double flightSpeed = Double.parseDouble(request.getParameter("flightspeed"));
		String flightProvider = request.getParameter("flightprovider");
		
		AdminDao admindaoimpl = new AdminDaoImpl();
		admindaoimpl.addNewFlight(flightId, flightName, flightCapacity, flightSpeed, flightProvider);
		
		RequestDispatcher req = request.getRequestDispatcher("addflight.jsp");
		req.include(request, response);
		response.getWriter().write("<h2>Flight Added</h2>");
	}

}
