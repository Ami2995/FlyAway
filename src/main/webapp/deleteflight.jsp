<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Flight</title>
</head>
<body>
<h1 align="center">Enter Details</h1><br>
<div class="container" align="center" style="font-size:16px">
<form action="DeleteFlight">
S.N  <input type="number"  name="sno"  placeholder="Enter serial number"><br><br>
<input type="submit" value="Delete"> ${msg}<br>
</form>
</div>
</body>
</html>