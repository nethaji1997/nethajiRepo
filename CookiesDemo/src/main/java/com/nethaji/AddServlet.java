package com.nethaji;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class AddServlet extends HttpServlet 
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int i=Integer.parseInt(request.getParameter("num1"));
		int j=Integer.parseInt(request.getParameter("num2"));
		int k=i+j;
		Cookie cookie=new Cookie("k", k+"");
		response.addCookie(cookie);
		response.sendRedirect("sq");
	}

}
