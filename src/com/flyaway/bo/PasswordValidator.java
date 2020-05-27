package com.flyaway.bo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyaway.daoimpl.LoginDaoImpl;

/**
 * Servlet implementation class PasswordValidator
 */
@WebServlet("/validate")
public class PasswordValidator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PasswordValidator() {
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
		//doGet(request, response);
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		
		if(userid.equals("") || password.equals("") ) {

			RequestDispatcher rs = request.getRequestDispatcher("adminLogin.jsp");
			rs.include(request, response);
			response.getWriter().write("<p>Userid or Password cannot be left blank</p>");
			
			
		} else if (userid.length() <= 3 || password.length() <= 4) {
			
			RequestDispatcher rs = request.getRequestDispatcher("adminLogin.jsp");
			rs.include(request, response);
			response.getWriter().write("<p>Userid or Password invalid</p>");
			
			
		} else {
			
			System.out.println("Checking user credentials in DB");
			LoginDaoImpl logindao = new LoginDaoImpl();
			
			if(logindao.verifyPasswordFromDB(userid, password)) {
				RequestDispatcher rs = request.getRequestDispatcher("adminpage.jsp");
				rs.forward(request, response);
			} else {
				
				RequestDispatcher rs = request.getRequestDispatcher("adminLogin.jsp");
				rs.include(request, response);
				response.getWriter().write("<p>Userid or Password invalid</p>");
				
			}
			
		}
	}

}
