<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="lightblue">
	<%

		if(session.getAttribute("username")==null)
		{
			response.sendRedirect("login.html") ;
		}
	%>
	
	<h1>Compose Mail</h1>
	<form action="ComposeMailServlet" method="post">
		From :&nbsp; &nbsp; <input type="email" name="from"><br><br>
		To :&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<input type="email" name="to"><br><br>
		Subject : <input type="text" name="subject"><br><br>
		Message:<br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<textarea rows="5" cols="20" name="message"></textarea> <br><br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Send Mail"> 
	</form>
</body>
</html>