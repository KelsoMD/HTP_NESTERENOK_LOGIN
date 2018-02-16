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

<p class="about">Hello user!</p>

	<form action="LoginServlet" method="get" class="about">
		<input type="hidden" name="action" value="login" />
		<input type="submit" value="Login" />
	</form>
	<form action="RegistrationServlet" method="get" class="about">
		<input type="hidden" name="action" value="registration" />
		<input type="submit" value="registration" />
	</form>
	
	
	
	
</body>
</html>