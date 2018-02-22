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

	Admin logged!
	<form method="get" action="MainServlet" class="sign-up">
		<h1 class="sign-up-title">Books list</h1>
		<input type="hidden" name="action" value="view_books" /> <input
			type="submit" value="View books" class="sign-up-button">
			<br/>
			<c:forEach items="${list}" var="item">
		<p>
			<c:out value="${item}" />
			<a href="http://localhost:8080/login/MainServlet?action=delete_book&book_id=${item.getId()}" class="design">delete</a>
			<a href="http://localhost:8080/login/MainServlet?action=edit_book&book_id=${item.getId()}" class="design">edit</a>
		</p>
	</c:forEach>
	</form>
	
	
	<form method="get" action="MainServlet" class="sign-up">
		<h1 class="sign-up-title">Add book panel</h1>
		
		<p class="login-error">
			<c:out value="${bookadded}" />
		</p>
		<p>
			<label for="title">Title:</label> <input type="text" name="title"
				id="title" value="Enter title">
		</p>
		<!-- <p>
			<label for="authorid">Author ID:</label> <input type="text"
				name="authorid" id="authorid" value="Enter Author ID">
		</p> -->
		
		
		<p><select id="authors" name="authors" >
          <c:forEach var="author" items="${authors}">
            <option value="${author.getId()}">${author}</option>
          </c:forEach>
        </select></p>
        <p>
        <br/>
        <br/>
		<br/>
        
		
		<input type="hidden" name="action" value="add_book" /> <input
			type="submit" value="Add Book" class="sign-up-button">
	</form>
	



</body>
</html>