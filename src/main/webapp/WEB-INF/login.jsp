<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Login page</title>
<link rel="stylesheet" href="css/style2.css">
</head>
<body>
	<form method="post" action="MainServlet" class="login">
		<p>
			<label for="login">Email:</label> <input type="text" name="login"
				id="login" value="Enter your login">
		</p>
		<p>
			<label for="password">Password:</label> <input type="password"
				name="password" id="password" value="4815162342">
		</p>
		<p class="login-error">
			<c:out value="${errorLogin}" />
			<c:out value="${errorPassword}" />
		</p>
		<p class="login-submit">
		<input type="hidden" name="action"	value="check_login"/>
			<button type="submit" class="login-button">Login</button>
		</p>
	</form>
</body>
</html>
