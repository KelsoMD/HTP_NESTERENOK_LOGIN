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
<link rel="stylesheet" href="css/style3.css">
<!--[if lt IE 9]><script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
</head>
<body>

	<form method="post" action="MainServlet">
		<h1 class="sign-up-title">Sign up in seconds</h1>
		<div>
			<label>Логин</label> <input type="text" name="login" value="${login}"><c:out value="${login_msg}"></c:out>
		</div>
		<div>
			<label>Пароль</label> <input type="password" name="password" value="${password}">
		</div>
		<div>
			<button type="submit" name="action" value="registration">Зарегистрироваться</button>
		</div>
	</form>

</body>
</html>
