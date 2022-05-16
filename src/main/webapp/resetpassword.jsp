<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password</title>
</head>
<body>
<h1>Change Your Password</h1>
<form action="ChangePasswordServlet" method="post">
Old Password <input type="password" name="oldpass" placeholder="Enter old password"><br><br>
New Password <input type="password" name="newpass" placeholder="Enter new password"><br><br>
Confirm Password <input type="password" name="renewpass" placeholder="Confirm new password"><br><br>
<input type="submit" value="Save">&nbsp &nbsp &nbsp
<input type="reset" value="Reset">&nbsp &nbsp &nbsp
${msg}
</form>
</body>
</html>