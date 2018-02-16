<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]> <html class="lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]> <html class="lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!-->
<html lang="en">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Sign Up Form</title>
<link rel="stylesheet" href="css/style.css">
<!--[if lt IE 9]><script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
</head>
<body>
	<form method="post" action="RegistrationServlet" class="sign-up">
		<h1 class="sign-up-title">Sign up in seconds</h1>
		<input type="text" class="sign-up-input"
			placeholder="What's your username?" autofocus name="login"> <input
			type="password" class="sign-up-input" placeholder="Choose a password"
			name="password"> <input type="submit" value="Sign me up!"
			class="sign-up-button">
			<br/>
			<p class="login-error">
		<c:out value="${errorLogin}"/>
		</p>
	</form>
	
</body>
</html>