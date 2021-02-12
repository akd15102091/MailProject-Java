package com.anproject;

import java.sql.* ;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int x = Integer.parseInt(request.getParameter("id")) ;
		String url = "jdbc:mysql://localhost:3306/khem";
		String un = "root" ;
		String pwd="Ashwini@1234" ;
		try {
			Class.forName("com.mysql.jdbc.Driver") ;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = null ;
		try {
			con  = DriverManager.getConnection(url, un, pwd) ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String query = "update companyMessage set trash='"+"no' "+" where id='"+x+"' " ;
		PreparedStatement pst = null ;
		try {
			 pst = con.prepareStatement(query) ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			int c = pst.executeUpdate() ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("InboxServlet").include(request, response);
		
	}

	

}
