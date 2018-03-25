<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Books</title>
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
	
	
	<form method="get" action="MainServlet">
	<div>
			<label>Имя</label> <input type="text" name="name" value="${name}" disabled>
		</div>
		<div>
			<label>Отчество</label> <input type="text" name="lastname" value="${lastname}" disabled>
		</div>
		<div>
			<label>Фамилия</label> <input type="text" name="surname" value="${surname}" disabled>
		</div>
		<div>
			<label>Дата рождения</label> <input type="date" name="birth_date" value="${birthDate}" disabled>
		</div>
		<div>
			<label>Телефонный номер</label> <input type="text" name="number" value="${number}" disabled>
		</div>
		<div>
			<label>E-mail</label> <input type="text" name="e_mail" value="${e_mail}" disabled>
		</div>
		<div>
			<button type="submit" name="action" value="start_edit">Редактировать</button>
		</div>
		</form>
		
		<form>
		<h1>OUTDATED</h1>
		<table>
			<thead>
			</thead>
			<tbody>
				<tr>
					<td>ID</td>
					<td>BOOK</td>
					<td>ORDER DATE</td>
					<td>RETURN TO</td>
				</tr>
				<tr>
					<c:forEach items="${list1}" var="item">
						<tr>
							<th>${item.getId()}</th>
							<th>${item.getBook()}</th>
							<th>${item.getOrderDate()}</th>
							<th>${item.getReturnToDate()}</th>
						</tr>
					</c:forEach>
			</tbody>
		</table>
	</form>
	
	<form>
		<h1>ORDERS IN</h1>
		<table>
			<thead>
			</thead>
			<tbody>
				<tr>
					<td>ID</td>
					<td>BOOK</td>
					<td>ORDER DATE</td>
					<td>RETURN TO</td>
				</tr>
				<tr>
					<c:forEach items="${list2}" var="item">
						<tr>
							<th>${item.getId()}</th>
							<th>${item.getBook()}</th>
							<th>${item.getOrderDate()}</th>
							<th>${item.getReturnToDate()}</th>
						</tr>
					</c:forEach>
			</tbody>
		</table>
	</form>
	
	<form>
		<h1>HISTORY</h1>
		<table>
			<thead>
			</thead>
			<tbody>
				<tr>
					<td>ID</td>
					<td>BOOK</td>
					<td>ORDER DATE</td>
					<td>RETURN TO</td>
					<td>OUTDATED</td>
					<td>RETURNED</td>
				</tr>
				<tr>
					<c:forEach items="${list3}" var="item">
						<tr>
							<th>${item.getId()}</th>
							<th>${item.getBook()}</th>
							<th>${item.getOrderDate()}</th>
							<th>${item.getReturnToDate()}</th>
							<th>${item.isOutdated()}</th>
							<th>${item.isReturned()}</th>
						</tr>
					</c:forEach>
			</tbody>
		</table>
	</form>
	
</body>
</html>