package com.anproject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 @WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet 
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter() ;
		response.setContentType("text/html"); 
		RequestDispatcher rd = request.getRequestDispatcher("header.html") ;
		rd.include(request, response); 
		
		// response.sendRedirect("header.html") ;
		
		String name=request.getParameter("name") ;
		String email=request.getParameter("email") ;
		String password=request.getParameter("password") ;
		String gender=request.getParameter("gender") ;
		String dob=request.getParameter("date") ;
		String address=request.getParameter("address") ;
		String city=request.getParameter("city") ;
		String state=request.getParameter("state") ;
		String country=request.getParameter("country") ;
		String contact=request.getParameter("contact") ;
		
		try {
			if(RegisterDao.save(name,email,password,gender,dob,address,city,state,country,contact))
			{
				RequestDispatcher rd1  = request.getRequestDispatcher("login.html") ;
				rd1.include(request, response);
			}
			else
			{
				RequestDispatcher rd2  = request.getRequestDispatcher("signup.html") ;
				rd2.include(request, response);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		out.close();
		
	}


}
