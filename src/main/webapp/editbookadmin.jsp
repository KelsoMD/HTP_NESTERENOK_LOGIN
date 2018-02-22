<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit book</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
Admin
	<form method="get" action="MainServlet" class="sign-up">
		<h1 class="sign-up-title">Book info</h1>
		<c:out value="${bookid}"/>
		<input type="hidden" name="book_id" value="${bookid}"/>
		<input type="text" class="sign-up-input" name="title" value="${title}">
          <select id="authors" name="authors" >
          <option selected="${selectedAuthor.getId()}">${selectedAuthor}</option>
          <c:forEach var="author" items="${authors}">
            <option value="${author.getId()}">${author}</option>
          </c:forEach>
        </select>
        
        <input type="date" name="calendar" value="${publish_year}">
        <input type="hidden" name="action" value="save_book">
        <input type="submit" value="SAVE">
        </form>
</body>
</html>