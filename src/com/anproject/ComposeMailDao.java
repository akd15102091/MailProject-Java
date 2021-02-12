package com.anproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ComposeMailDao 
{
	public static void saveMail(String fm,String t,String sub,String mess) throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/khem";
		String un = "root" ;
		String pwd="Ashwini@1234" ;
		Class.forName("com.mysql.jdbc.Driver") ;
		String query = "insert into companyMessage values(?,?,?,?,?,?,?)" ;
		Connection con = DriverManager.getConnection(url, un, pwd) ;
		
		PreparedStatement pst = con.prepareStatement(query) ;
		String query1 = "select * from companyMessage" ;
		Statement st = con.createStatement() ;
		ResultSet rs = st.executeQuery(query1) ;
		int cnt=0 ;
		while(rs.next())
		{
			int x = rs.getInt(6) ;
			cnt = x+1 ;
		}
		System.out.println(cnt);
		pst.setString(1, fm);
		pst.setString(2, t);
		pst.setString(3, sub);
		pst.setString(4, mess);
		pst.setDate(5, Formatter.getCurrentDate());
		pst.setInt(6, cnt);
		pst.setString(7, "yes");
		
		int y = pst.executeUpdate() ;
		

	}

}
