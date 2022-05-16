<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<h1 align="center">Administration Login</h1><hr><br>
<h4><a href="welcome.jsp">Book Flight</a></h4><br>
<div class="container" align="center">
<form action="AdminLoginServlet" method="post">
Enter UserName <input type="text" name="user_name"><br><br>
Enter Password <input type="password" name="password"><br><br>
<input type= "submit" value="Login">&nbsp &nbsp &nbsp
<input type= "reset" value="Reset">&nbsp &nbsp &nbsp
${msg}
</form>
</div>
</body>
</html>