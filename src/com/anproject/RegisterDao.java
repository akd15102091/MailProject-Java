package com.anproject;

import java.sql.* ;

public class RegisterDao 
{
	public static boolean save(String rname,String remail,String rpassword,String rgender,String rdob,String raddress,String rcity,String rstate,String rcountry,String rcontact) throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/khem";
		String un = "root" ;
		String pwd="Ashwini@1234" ;
		Class.forName("com.mysql.jdbc.Driver") ;
		Connection con = DriverManager.getConnection(url, un, pwd) ;
		if((rname!=null) && (remail!=null) && (rpassword!=null) && (rgender!=null) && (rdob!=null) && (raddress!=null) && (rcity!=null) && (rstate!=null) && (rcountry!=null) && (rcontact!=null))
		{

			String query = "select * from companyRegistration where email='"+remail+"'" ;
			Statement st = con.createStatement() ;
			ResultSet rs = st.executeQuery(query) ;
			if(rs.next())
			{
				return false ; 
			}
			
			else
			{
				String query2 = "insert into companyRegistration values(?,?,?,?,?,?,?,?,?,?)" ;
				PreparedStatement pst = con.prepareStatement(query2) ;
				pst.setString(1,rname) ;
				pst.setString(2,remail) ;
				pst.setString(3,rpassword) ;
				pst.setString(4,rgender) ;
				pst.setString(5,rdob) ;
				pst.setString(6,raddress) ;
				pst.setString(7,rcity) ;
				pst.setString(8,rstate) ;
				pst.setString(9,rcountry) ;
				pst.setString(10,rcontact) ;

				int cnt = pst.executeUpdate() ;

				pst.close();
				
			}

			st.close();
			con.close();
			return true ;

		}
		con.close();
		
		return false ;
	}
}
