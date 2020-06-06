package com.flyaway.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bookflight")
public class BookFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BookFlight() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		String flightdetail = request.getParameter("selectedticket");
		//response.getWriter().write(flightid); 
	    request.setAttribute("flightdetail", flightdetail);
		request.getRequestDispatcher("getdetail.jsp").forward(request, response);
		
	}

}
