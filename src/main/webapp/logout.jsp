<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout Page</title>
</head>
<body>
<% if(session.getAttribute("user")==null){
	request.setAttribute("msg", "* Login First *");
	response.sendRedirect("login.jsp");
	}else{
		request.setAttribute("msg", "* You logged out successfully *");
		getServletContext().getRequestDispatcher("/welcome.jsp").forward(request, response);
		session.invalidate();
	}%>
	
</body>
</html>