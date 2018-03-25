<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Login page</title>
<link rel="stylesheet" href="css/style2.css">
</head>
<body>
	<form method="get" action="MainServlet" class="login">
		<p class="login-error">
			<c:out value="Операция прошла успешно!" />
		</p>
		<p class="login-submit">
		<c:choose>
         <c:when test = "${sessionScope.prevAction=='login_admin'}">
            <input type="hidden" name="action"	value="main_page"/>
			<button type="submit" class="login-button">We made it</button>
         </c:when>
         <c:when test = "${sessionScope.prevAction=='create_author'}">
            <input type="hidden" name="action"	value="main_page"/>
			<button type="submit" class="login-button">We made it</button>
         </c:when>
         <c:when test = "${sessionScope.prevAction=='create_book'}">
            <input type="hidden" name="action"	value="main_page"/>
			<button type="submit" class="login-button">We made it</button>
         </c:when>
         <c:when test = "${sessionScope.prevAction=='create_user'}">
            <input type="hidden" name="action"	value="main_page"/>
			<button type="submit" class="login-button">We made it</button>
         </c:when>
         <c:when test = "${sessionScope.prevAction=='create_user_and_card'}">
            <input type="hidden" name="action"	value="main_page"/>
			<button type="submit" class="login-button">We made it</button>
         </c:when>
         <c:when test = "${sessionScope.prevAction=='update_abonent'}">
            <input type="hidden" name="action"	value="switch_cabinet"/>
			<button type="submit" class="login-button">We made it</button>
         </c:when>
         <c:when test = "${sessionScope.prevAction=='update_author'}">
            <input type="hidden" name="action"	value="view_authors_select"/>
			<button type="submit" class="login-button">We made it</button>
         </c:when>
         <c:when test = "${sessionScope.prevAction=='update_book'}">
            <input type="hidden" name="action"	value="view_books"/>
			<button type="submit" class="login-button">We made it</button>
         </c:when>
          <c:when test = "${sessionScope.prevAction=='login_user'}">
            <input type="hidden" name="action"	value="main_page"/>
			<button type="submit" class="login-button">We made it</button>
         </c:when>
      </c:choose>
		</p>
	</form>
</body>
</html>
