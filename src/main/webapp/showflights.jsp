<%@page import="java.util.List"%>
<%@page import="com.java.bean.FlightsBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
	<%
	List<FlightsBean> flights = (List<FlightsBean>) session.getAttribute("flights");
	if (flights == null) {
		request.setAttribute("msg", "--: No Flights Available :--");
		getServletContext().getRequestDispatcher("/welcome.jsp").forward(request, response);
	%>

	<%
	} else {
	%>
	<h2 align="center">Available Flights</h2>
	<table border="2" style="width: 80%" align="center">
		<tr style="height: 40px; font-size: 18px">
			<th>Flight Id</th>
			<th>Source</th>
			<th>Destination</th>
			<th>Airlines</th>
			<th>Date</th>
			<th>Departure Time</th>
			<th>Arrival Time</th>
			<th>Price</th>
			<th>Book Flight</th>
		</tr>
		<%
		for (FlightsBean f : flights) {
		%>
		<tr style="height: 30px; font-size: 18px">
			<td><%=f.getFlight_id()%></td>
			<td><%=f.getSource()%></td>
			<td><%=f.getDestination()%></td>
			<td><%=f.getFlight_name()%></td>
			<td><%=f.getJdate()%></td>
			<td><%=f.getDept_time()%></td>
			<td><%=f.getArr_time()%></td>
			<td><%=f.getPrice()%></td>
			<td><h3>
					<a href="bookflight.jsp">Book</a>
				</h3></td>
		</tr>
		<%
		}
		%>
	</table>
	<%
	}
	%>
</body>
</html>