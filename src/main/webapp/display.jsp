<%@page import="com.java.bean.FlightsBean"%>
<%@page import="java.util.List"%>
<%@page import="com.java.dao.FlightsDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<br>
	<br>
	<h3 align="center">${msg}</h3>
	<a href="success.jsp">Go Back</a>
	<br>
	<br>
	<a href="insertflight.jsp">Add Flights</a>&nbsp &nbsp &nbsp
	<h2 align="center">Flights</h2>
	<table border="2" style="width: 80%" align="center">

		<%
		FlightsDAO dao = new FlightsDAO();
		List<FlightsBean> flight = (List<FlightsBean>) dao.showFlights();
		%>
		<tr style="height: 40px; font-size: 18px">
			<th>S N</th>
			<th>Flight Id</th>
			<th>Source</th>
			<th>Destination</th>
			<th>Airlines</th>
			<th>Date</th>
			<th>Departure Time</th>
			<th>Arrival Time</th>
			<th>Price</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<%
		for (FlightsBean f : flight) {
		%>
		<tr style="height: 30px; font-size: 18px">
			<td><%=f.getSno()%></td>
			<td><%=f.getFlight_id()%></td>
			<td><%=f.getSource()%></td>
			<td><%=f.getDestination  ()%></td>
			<td><%=f.getFlight_name()%></td>
			<td><%=f.getJdate()%></td>
			<td><%=f.getDept_time()%></td>
			<td><%=f.getArr_time()%></td>
			<td><%=f.getPrice()%></td>
			<td><a href="editflight.jsp">Edit</a></td>
			<td><a href="deleteflight.jsp">Delete</a></td>

		</tr>
		<%
		}
		%>
	</table>
</body>
</html>