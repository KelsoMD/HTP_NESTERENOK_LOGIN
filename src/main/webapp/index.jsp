<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Start page</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<ul class="menu">
		<li><a href="http://localhost:8080/login/MainServlet?action=main_page">Главная</a></li>
		<li><a href="">Действия</a>
			<ul>
				<li><a href="http://localhost:8080/login/MainServlet?action=view_books">Список книг</a></li>
			</ul></li>
		<li><a href="http://localhost:8080/login/MainServlet?action=switch_login">Login</a></li>
			<li><a href="http://localhost:8080/login/registerandcard.jsp">Register</a></li>
	</ul>
	<br />
	
</body>
</html>