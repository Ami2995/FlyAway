<%@page import="com.java.dao.FlightsDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.java.bean.FlightsBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">Airlines</h2>
	<table border="2" style="width: 15%" align="center">

		<%
		getServletContext().getRequestDispatcher("/success.jsp").include(request, response);
		FlightsDAO dao = new FlightsDAO();
		List<FlightsBean> flight = (List<FlightsBean>) dao.showAirlines();
		%>
		<tr style="height: 35px; font-size: 20px">
			<th>Airlines Service</th>
		</tr>
		<%
		for (FlightsBean f : flight) {
		%>
		<tr style="height: 30px; font-size: 18px">
			<td ><%=f.getFlight_name()%></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>