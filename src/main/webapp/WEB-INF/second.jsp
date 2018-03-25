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
	<form method="get" action="MainServlet" class="sign-up">
	<input type="hidden" name="action" value="switch_search_author" />
	<input type="submit" value="Search by Author" class="sign-up-button">
	</form>
	<br/>
	<form method="get" action="MainServlet" class="sign-up">
		<h1 class="sign-up-title">Поиск книги по названию</h1>
		<input type="text" class="sign-up-input"
			placeholder="Enter title or part" autofocus name="title">
			<input type="hidden" name="action" value="find_book_search" />
		<input type="submit" value="Find book" class="sign-up-button">
		<br/>
	</form>
	<form method="get" action="MainServlet" class="sign-up">
		<h1 class="sign-up-title">Список книг</h1>
		<input type="hidden" name="action" value="view_books" /> <input
			type="submit" value="Show all" class="sign-up-button"> <br />
			<c:out value="${order}"></c:out>
		<table>
			<thead>
			</thead>
			<tbody>
				<tr>
					<td>Название</td>
					<td>Год издания</td>
					<td>Автор</td>
					<td>Действия</td>
				</tr>
				<tr>

					<c:forEach items="${list}" var="item">
						<tr>
							<th>${item.getTitle()}</th>
							<th>${item.getPublishDate()}</th>
							<th>${item.getAuthor().getName()+=' '+=item.getAuthor().getSurName()}</th>
							<th><a
								href="http://localhost:8080/login/MainServlet?action=order_book&book_id=${item.getId()}"
								class="design">Order</a></th>
						</tr>
					</c:forEach>
			</tbody>
		</table>
	</form>
	
</body>
</html>