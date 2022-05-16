<%@page import="com.java.bean.FlightsBean"%>
<%@page import="java.util.List"%>
<%@page import="com.java.dao.FlightsDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
	<h2 align="center">Venue</h2>
	<table border="2" style="width: 25%" align="center">

		<%
		getServletContext().getRequestDispatcher("/success.jsp").include(request, response);
		FlightsDAO dao = new FlightsDAO();
		List<FlightsBean> flight = (List<FlightsBean>) dao.showPlaces();
		%>
		<tr style="height: 35px; font-size: 20px">
			<th>S.N</th>
			<th>Source</th>
			<th>Destination</th>
		</tr>
		<%
		for (FlightsBean f : flight) {
		%>
		<tr style="height: 30px; font-size: 18px">
			<td><%=f.getSno()%></td>
			<td><%=f.getSource()%></td>
			<td><%=f.getDestination()%></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>