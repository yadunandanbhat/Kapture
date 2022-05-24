<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>
</head>
<body>
	<h3>User login</h3>
	<form method="POST" action="servletDemo">
		Name: <input type="text" name="name"> <br>
		Email: <input type="email" name="email"> <br>
		Password: <input type="password" name="passwd"> <br>
		<input type="submit" value="Submit"/>
	</form>
</body>
</html>