<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sucsess</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

<ul class="menu">
		<li><a href="http://localhost:8080/login/MainServlet?action=main_page">Главная</a></li>
		<li><a href="">Действия</a>
			<ul>
				<li><a href="http://localhost:8080/login/MainServlet?action=switch_cabinet">Личный кабинет</a></li>
			</ul></li>
		<li><a href="http://localhost:8080/login/MainServlet?action=logout">Выйти</a>
		</li>
	</ul>
	<br />
	<form method="post" action="MainServlet">
	<div>
			<label>Имя</label> <input type="text" name="name" value="${name}">
		</div>
		<div>
			<label>Отчество</label> <input type="text" name="lastname" value="${lastname}">
		</div>
		<div>
			<label>Фамилия</label> <input type="text" name="surname" value="${surname}">
		</div>
		<div>
			<label>Дата рождения</label> <input type="date" name="birth_date" value="${birthDate}">
		</div>
		<div>
			<label>Телефонный номер</label> <input type="text" name="number" value="${number}">
		</div>
		<div>
			<label>E-mail</label> <input type="text" name="e_mail" value="${e_mail}">
		</div>
		<div>
			<button type="submit" name="action" value="save_abonent">Сохранить</button>
		</div>
		</form>
</body>
</html>