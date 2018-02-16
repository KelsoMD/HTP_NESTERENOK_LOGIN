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

	Loged Sucsessfully!
	
	<c:out value="${user_name}" />


	<c:forEach items="${list}" var="item">
		<p><c:out value="${item}" /></p>
	</c:forEach>



</body>
</html>