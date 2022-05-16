<%@page import="java.util.List"%>
<%@page import="com.java.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Home</title>
</head>
<body>
<h3 align="right"><a href="logout.jsp">Logout</a></h3>
	 <h1 align="center">
 Welcome<br>
 <% if(session.getAttribute("user")!=null){
		String uname = session.getAttribute("user").toString();
		out.println(uname);
		} %>
 </h1><br>
 <h2>Flight Booked Successfully</h2>
</body>
</html>