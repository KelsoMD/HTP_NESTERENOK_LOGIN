<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="generator" content="Mobirise v4.6.5, mobiriz.store">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<title>login</title>
<link rel="stylesheet" href="assets/tether/tether.min.css">
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="assets/bootstrap/css/bootstrap-grid.min.css">
<link rel="stylesheet"
	href="assets/bootstrap/css/bootstrap-reboot.min.css">
<link rel="stylesheet" href="assets/animatecss/animate.min.css">
<link rel="stylesheet" href="assets/theme/css/style.css">
<link rel="stylesheet" href="assets/mobirise/css/mbr-additional.css"
	type="text/css">



</head>
<body>
	<section
		class="mbr-section form1 cid-qMEynfnH4H mbr-parallax-background">



		<div class="mbr-overlay"
			style="opacity: 0.5; background-color: rgb(0, 0, 0);"></div>
		<div class="container">
			<div class="row justify-content-center">
				<div class="title col-12 col-lg-8">
					<h2
						class="mbr-section-title align-center pb-3 mbr-fonts-style display-2">Регистрация</h2>
					<h3
						class="mbr-section-subtitle align-center mbr-light pb-3 mbr-fonts-style display-5">${errorLogin}</h3>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row justify-content-center">
				<div class="media-container-column col-lg-8">
					<form class="mbr-form" action="MainServlet" method="post">
						<div class="row row-sm-offset">
							<div class="col-md-4 multi-horizontal">
								<div class="form-group">
									<label class="form-control-label mbr-fonts-style display-7">Ваш
										логин</label><input type="text" class="form-control" name="login"
										required><label
										class="form-control-label mbr-fonts-style display-7">${login_msg}</label>
								</div>
								<div class="form-group">
									<label class="form-control-label mbr-fonts-style display-7">Ваш
										пароль</label> <input type="password" class="form-control"
										name="password" required><label
										class="form-control-label mbr-fonts-style display-7">${pass_msg}</label>
								</div>
								<div class="form-group">
									<label class="form-control-label mbr-fonts-style display-7">Имя</label> <input type="text" class="form-control" name="name"
										required><label
										class="form-control-label mbr-fonts-style display-7">${name_msg}</label>
								</div>
								<div class="form-group">
									<label class="form-control-label mbr-fonts-style display-7">Отчество</label> <input type="text" class="form-control" name="lastname"
										required><label
										class="form-control-label mbr-fonts-style display-7">${lastname_msg}</label>
								</div>
								<div class="form-group">
									<label class="form-control-label mbr-fonts-style display-7">Фамилия</label> <input type="text" class="form-control" name="surname"
										required><label
										class="form-control-label mbr-fonts-style display-7">${surname_msg}</label>
								</div>
								<div class="form-group">
									<label class="form-control-label mbr-fonts-style display-7">Дата рождения</label> <input type="date" class="form-control" name="birth_date"
										required>
								</div>
								<div class="form-group">
									<label class="form-control-label mbr-fonts-style display-7">Номер телефона</label> <input type="text" class="form-control" placeholder="+3475(ХХ)ХХХ ХХ ХХ" name="number"
										required><label
										class="form-control-label mbr-fonts-style display-7">${number_msg}</label>
								</div>
								<div class="form-group">
									<label class="form-control-label mbr-fonts-style display-7">E-mail</label> <input type="text" class="form-control" name="e_mail"
										required><label
										class="form-control-label mbr-fonts-style display-7">${eMail_msg}</label>
								</div>
							</div>
						</div>


						<span class="input-group-btn"><input type="hidden"
							name="action" value="regandcard" />
							<button type="submit" class="btn btn-primary btn-form display-4">Зарегистрироваться</button>
						</span>
					</form>
				</div>
			</div>
		</div>
	</section>
	<script src="assets/web/assets/jquery/jquery.min.js"></script>
	<script src="assets/popper/popper.min.js"></script>
	<script src="assets/tether/tether.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/smoothscroll/smooth-scroll.js"></script>
	<script src="assets/parallax/jarallax.min.js"></script>
	<script src="assets/viewportchecker/jquery.viewportchecker.js"></script>
	<script src="assets/theme/js/script.js"></script>
	<script src="assets/formoid/formoid.min.js"></script>


	<input name="animation" type="hidden">
</body>
</html>