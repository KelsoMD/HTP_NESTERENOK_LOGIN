<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Orders</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<ul class="menu">
		<li><a href="http://localhost:8080/login/MainServlet?action=main_page">Главная</a></li>
		<li><a href="">Действия</a>
			<ul>
				<li><a href="http://localhost:8080/login/MainServlet?action=view_books">Список книг</a></li>
				<li><a href="http://localhost:8080/login/MainServlet?action=view_authors">Список авторов</a></li>
				<li><a href="http://localhost:8080/login/MainServlet?action=add_book">Добавить книгу</a></li>
				<li><a href="http://localhost:8080/login/MainServlet?action=add_author">Добавить автора</a></li>
				<li><a href="http://localhost:8080/login/MainServlet?action=view_new_orders">Необработанные заказы</a></li>
				<li><a href="http://localhost:8080/login/MainServlet?action=view_orders_return">Вернуть книги</a></li>
				<li><a href="http://localhost:8080/login/MainServlet?action=view_orders">История заказов</a></li>
			</ul></li>
		<li><a href="http://localhost:8080/login/MainServlet?action=logout">Выйти</a>
		</li>
	</ul>
	<br />
	<form method="get" action="MainServlet" class="sign-up">
		<h1 class="sign-up-title">История заказов</h1>
		<input type="hidden" name="action" value="view_new_orders"/> <input
			type="submit" value="Refresh" class="sign-up-button"> <br />
		<table>
			<thead>
			</thead>
			<tbody>
				<tr>
					<td>ID</td>
					<td>BOOK</td>
					<td>ABONENT</td>
					<td>ORDER DATE</td>
					<td>RETURN TO DATE</td>
					<td>OTDATED</td>
					<td>RETURNED</td>
					<td>APROOVED</td>
				</tr>
				<c:forEach items="${list}" var="item">
						<tr>
							<th>${item.getId()}</th>
							<th>${item.getBook().getTitle()}</th>
							<th>${item.getAbonent().getName()+=' '+=item.getAbonent().getSurname()}</th>
							<th>${item.getOrderDate()}</th>
							<th>${item.getReturnToDate()}</th>
							<th>${item.isOutdated()}</th>
							<th>${item.isReturned()}</th>
							<th>${item.isAprooved()}</th>
						</tr>
					</c:forEach>
			</tbody>
		</table>
		<br>
	</form>
</body>
</html>