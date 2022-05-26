<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body style="text-align: center; font-family: monospace;">
	<h3 style = "color: red; font-size: 24px;">User Registration</h3>
	<p style = "color: gray; font-size: 15px;">Welcome! Enter your details below and get registered!</p>
	<form action="registerServlet" method="post" style = "font-size: 18px;">
		Name:<br><input type=text name="name">
		<p></p>
		Email:<br><input type=email name="email"> <br>
		<p></p>
		Password:<br><input type=password name="pass"> <br>
		<p></p>
		<input type="submit" value="Register!"><br><br>
		<a href="login.jsp" style = "font-size: 16px;">Wanna go back to login page? Click here!</a>
	</form>
</body>
</html>