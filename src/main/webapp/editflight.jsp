<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Flight</title>
</head>
<body>
<h1 align="center">Enter Details</h1><br>
<div class="container" align="center" style="font-size:16px">
<form action="UpdateFlight">
S.N  <input type="number"  name="sno"  placeholder="Enter serial number"><br><br>
Flight Id <input  type="text" name="flight_id" placeholder="Enter flight id"><br><br>
Source  &nbsp &nbsp  <input type="text" name="source" placeholder="Enter city"><br><br>
Destination <input type="text" name="destination" placeholder="Enter city"><br><br>
Airlines &nbsp &nbsp<input type="text" name="flight_name" placeholder="Enter airlines name"><br><br>
Date <input type="date"  name="jdate" placeholder="Enter date"><br><br>
Departure <input type="time" name="dept_time" placeholder="Enter time"><br><br>
Arrival <input type="time" name="arr_time" placeholder="Enter time"><br><br>
Price <input type="number" name="price"  placeholder="Enter price"><br><br>
<input type="submit" value="Update"> ${msg}<br>
</form>
</div>
</body>
</html>