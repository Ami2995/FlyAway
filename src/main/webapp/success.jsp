
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home</title>
</head>
<body>
<h3 align="right"><a href="resetpassword.jsp">Change Password</a></h3>
<h3 align="right"><a href="logout.jsp">Logout</a></h3>
<% if(session.getAttribute("user")==null){
	request.setAttribute("msg", "* Login First *");
	response.sendRedirect("login.jsp");
	}%>
 <h1 align="center">
 Welcome
 <% if(session.getAttribute("user")!=null){
		String uname = session.getAttribute("user").toString();
		out.println(uname);
		} %>
 </h1>	
 <h3 align="center">${msg}</h3><br>
<a href="place.jsp">Display Venue</a> &nbsp &nbsp &nbsp
<a href="airlines.jsp">Display Airlines</a>&nbsp &nbsp &nbsp
<a href="display.jsp">Display Flights</a>&nbsp &nbsp &nbsp
<br><br><br>
</body>
</html>