<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<h1>Login to proceed...</h1>
<h3>Don't have account? <a href="registration.jsp">Sign up</a></h3><br>
<div class="container" align="center">
<h2>User Login</h2>
<form action="UserLogin" method="post">
Email <input type="text" name="email"><br><br>
Password<input type="password" name="password"><br><br>
<input type="submit" value="Login"> &nbsp &nbsp &nbsp
<input type="reset" value="reset"> &nbsp &nbsp &nbsp<br>
<h3>${msg}</h3> <br>
</form>
</div>
</body>
</html>