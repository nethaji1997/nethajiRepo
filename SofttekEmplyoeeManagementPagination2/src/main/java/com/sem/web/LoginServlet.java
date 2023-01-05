package com.sem.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sem.dao.EmployeeDAO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String uname = request.getParameter("uname");
		String password = request.getParameter("pass");
		EmployeeDAO dao = new EmployeeDAO();
		if (dao.check(uname, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("username", uname);
			try {
				EmployeeServlet emp = new EmployeeServlet();
				emp.listEmployee(request, response);
			} catch (SQLException | IOException | ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/listemployee.jsp");

//			rd.forward(request, response);
			response.sendRedirect("listemployee.jsp");

		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
			rd.forward(request, response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		doPost(request, response);
	}

}
