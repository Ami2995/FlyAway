<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign up</title>
</head>
<body>
<div class="container" align="center">
<h3 align="left">Back to <a href="bookflight.jsp">Login</a></h3><br>
<br>
<h4 align="left">${msg}</h4><br>
<h1>Registration Form</h1><br>
<form action="RegisterServlet" method="post">
Enter Name &nbsp <input type="text" name="fname" placeholder="Full name"><br><br>
Enter Email &nbsp <input type="text" name="email" ><br><br>
Mobile Number <input type="text" name="contact"><br><br>
Create Password <input type="password" name="password"><br><br>
<input type="submit" value="Sign up"> &nbsp &nbsp &nbsp
<input type="reset" value="Reset"> &nbsp &nbsp &nbsp
</form>
</div>
</body>
</html>