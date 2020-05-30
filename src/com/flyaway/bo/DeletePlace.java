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

@WebServlet("/deleteplace")
public class DeletePlace extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeletePlace() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String place = request.getParameter("place");
		AdminDao admindaoimpl = new AdminDaoImpl();
		admindaoimpl.deletePlaceInDB(Integer.parseInt(place));
		RequestDispatcher reqdp = request.getRequestDispatcher("removeplace.jsp");
		reqdp.include(request, response);
		response.getWriter().write("<p><h2>Place deleted successfully</h2></p>");
	}

}
