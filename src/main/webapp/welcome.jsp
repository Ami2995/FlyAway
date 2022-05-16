<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<h1 align="center"><u><b>'Welcome To FLY-AWAY'</b></u></h1>
<h3 align="center">'A Great Way To Fly'</h3><hr>
<h2 align="right"><a href="login.jsp">admin</a></h2>
<div class="container" align="center">
<h2>Search Flights</h2><br>
<form action="ShowFlight">
From <input type="text" name="source" placeholder="Enter city or airport">&nbsp; &nbsp; &nbsp;
To <input type="text" name="destination" placeholder="Enter city or airport">&nbsp; &nbsp; &nbsp;
Journey Date <input type="date" name="jdate">&nbsp; &nbsp; &nbsp;
Travelers <input type="number" name="passanger" min="1">&nbsp; &nbsp; &nbsp;
<input type="submit" value="Search"><br><br><br><br>
<h3 align="center">${msg}</h3>
</form>
</div>
</body>
</html>