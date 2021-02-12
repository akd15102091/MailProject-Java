package com.anproject ;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/OutboxServlet")
public class OutboxServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		request.getRequestDispatcher("header.html").include(request, response);
		HttpSession session = request.getSession() ;
		String uname = (String) (session.getAttribute("username")) ;
		String url = "jdbc:mysql://localhost:3306/khem";
		String un = "root" ;
		String pwd="Ashwini@1234" ;
		
		try {
			Class.forName("com.mysql.jdbc.Driver") ;
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		Connection con = null ;
		try {
			con = DriverManager.getConnection(url, un, pwd) ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(uname==null)
		{
			request.getRequestDispatcher("login.html").include(request, response);
		}
		else
		{
			String query = "select * from companyMessage where sender='"+uname+"'" ;
			Statement st = null ;
			try {
				 st = (Statement) con.createStatement() ;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ResultSet rs = null ;
			try {
				rs = ((java.sql.Statement) st).executeQuery(query) ;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			out.print("<body style='background-color:lightblue;'> ");
			out.println("<h1>OUTBOX</h1> <br>") ;
			out.println("Welcome "+uname);
			
			out.print("<table border='1' style='width:700px;'>");
			out.print("<tr style='background-color:grey;color:white'><td>ID</td><td>Receiver</td><td>Message</td><td>Date</td></tr>");
			try {
				while(rs.next()){
					out.print("<tr><td>"+rs.getInt("id")+"</td><td>"+rs.getString("receiver")+"</td><td>"+rs.getString("message")+"</td><td>"+rs.getString("dt")+"</td></tr>");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			out.print("</table>");
			out.print("</body>");
		}
	}

	}