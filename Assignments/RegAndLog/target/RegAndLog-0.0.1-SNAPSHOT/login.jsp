<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body style="text-align: center; font-family: monospace;">
	<h3 style = "color: red; font-size: 24px;">User Login</h3>
	<p style = "color: gray; font-size: 15px;">Enter your email and password below and click login.</p> 
	<form action="loginServlet" method="post" style = "font-size: 18px;">
		Email:<br><input type=email name="email">
		<p></p>
		Password:<br><input type=password name="pass">
		<p></p>
		<input type="submit" value="Login"><br><br>
		<a href="register.jsp" style = "font-size: 16px;">Not a user? Click here to register!</a>
	</form>
</body>
</html>