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
User Logged!
	<c:out value="${user_name}" />
	<c:forEach items="${list}" var="item">
		<p><c:out value="${item}" /></p>
	</c:forEach>
	
	<form method="get" action="MainServlet" class="sign-up">
		<h1 class="sign-up-title">Books list</h1>
		<input type="text" class="sign-up-input"
			placeholder="Enter book title" autofocus name="title">
			<input type="hidden" name="action" value="find_book" />
		<input type="submit" value="Find book" class="sign-up-button">
		<br/>
		<c:out value="${book}"/>
			
	</form>
	
	
</body>
</html>