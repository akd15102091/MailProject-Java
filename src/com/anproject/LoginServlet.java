package com.anproject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String username=request.getParameter("loginUsername");
		String password=request.getParameter("loginPassword");
		try {
			if(LoginDao.validate(username, password)){
				//out.print("you are successfully logged in!");
				request.getSession().setAttribute("username",username);
				request.getRequestDispatcher("InboxServlet").include(request, response);
				
			}else{
				request.getRequestDispatcher("header.html").include(request, response);
				request.getRequestDispatcher("login.html").include(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		out.close();
	}

}