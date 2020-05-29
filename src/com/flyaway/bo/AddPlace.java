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

/**
 * Servlet implementation class AddPlace
 */
@WebServlet("/addplace")
public class AddPlace extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPlace() {
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
		// TODO Auto-generated method stub
		// doGet(request, response);
		
		String pincode = request.getParameter("pincode");
		String cityname = request.getParameter("cityname");
		String statename = request.getParameter("statename");
		String airportname = request.getParameter("airportname");
		
//		if(pincode != null && pincode.matches("^[a-zA-Z]*$")){
//		
//			RequestDispatcher rs = request.getRequestDispatcher("addnewplace.jsp");
//			rs.include(request, response);
//			response.getWriter().write("<p>Pin code cannot contain alphabets</p>");
//			
//		} 
//		
		if(pincode.equals("") || cityname.equals("") || statename.equals("") || airportname.equals("")) {
			
			RequestDispatcher rs = request.getRequestDispatcher("addnewplace.jsp");
			rs.include(request, response);
			response.getWriter().write("<p>Fields cannot be left blank</p>");
			
		} else {
		int pin = Integer.parseInt(pincode);
		AdminDao admindao = new AdminDaoImpl();
		admindao.addPlaceInDB(pin, statename, cityname, airportname);
		RequestDispatcher rs = request.getRequestDispatcher("addnewplace.jsp");
		rs.include(request, response);
		response.getWriter().write("<p>Place Added</p>");
		}
		
	}

}
