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
<title>admin_books</title>
<link rel="stylesheet" href="assets/tether/tether.min.css">
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="assets/bootstrap/css/bootstrap-grid.min.css">
<link rel="stylesheet"
	href="assets/bootstrap/css/bootstrap-reboot.min.css">
<link rel="stylesheet"
	href="assets/datatables/data-tables.bootstrap4.min.css">
<link rel="stylesheet" href="assets/dropdown/css/style.css">
<link rel="stylesheet" href="assets/animatecss/animate.min.css">
<link rel="stylesheet" href="assets/theme/css/style.css">
<link rel="stylesheet" href="assets/mobirise/css/mbr-additional.css"
	type="text/css">
</head>
<body>
	<section class="menu cid-qLBklWUHGk" id="menu1-r">



		<nav
			class="navbar navbar-expand beta-menu navbar-dropdown align-items-center navbar-fixed-top navbar-toggleable-sm">
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<div class="hamburger">
					<span></span> <span></span> <span></span> <span></span>
				</div>
			</button>
			<div class="menu-logo">
				<div class="navbar-brand">
					<span class="navbar-logo"> <a> <img
							src="assets/images/logocbs-345x345.png" alt="Mobirise" title=""
							style="height: 5.3rem;">
					</a>
					</span> <span class="navbar-caption-wrap"><a
						class="navbar-caption text-primary display-5">Library Web
							Project</a></span>
				</div>
			</div>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<div class="navbar-buttons mbr-section-btn">
				<a class="btn btn-sm btn-primary display-4"
						href="http://localhost:8080/login/MainServlet?action=main_page">Главная</a>
					<a class="btn btn-sm btn-primary display-4"
						href="http://localhost:8080/login/MainServlet?action=switch_cabinet">Личный кабинет</a>
					<a class="btn btn-sm btn-primary display-4"
						href="http://localhost:8080/login/MainServlet?action=logout">Выйти</a>
				</div>
			</div>
		</nav>
	</section>
	<section
		class="mbr-section form1 cid-qN84TDWaPu mbr-parallax-background"
		id="header1-i">
		<div class="container">
			<div class="row justify-content-center">
				<div class="title col-12 col-lg-8">
					<h3
						class="mbr-section-subtitle align-center mbr-light pb-3 mbr-fonts-style display-5">&nbsp;</h3>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row justify-content-center">
				<div class="media-container-column col-lg-8">
					<br>
					<div>${order}</div>
					<br>
					<form class="mbr-form" action="MainServlet" method="get">
					
						<div class="row row-sm-offset">
							<div class="col-md-4 multi-horizontal">
								<span class="input-group-btn"><input type="hidden"
									name="action" value="switch_search_author">
									<button type="submit"
										class="btn btn-primary btn-form display-4">Поиск по
										автору</button></span>
							</div>
						</div>
					</form>
					<form class="mbr-form" action="MainServlet" method="get">
					
						<div class="row row-sm-offset">
							<div class="col-md-4 multi-horizontal">
								<div class="form-group">
									<input type="text" class="form-control" name="title"
										placeholder="Введите название книги">
								</div>
							</div>
						</div>
						<span class="input-group-btn"><input type="hidden"
							name="action" value="find_book_search">
							<button type="submit" class="btn btn-primary btn-form display-4">Найти</button></span>
					</form>
				</div>
			</div>
		</div>
	</section>

	<section class="section-table cid-qN85IIjraZ" id="table1-v">



		<div class="container container-table">


			<div class="table-wrapper">


				<div class="container scroll">
					<form action="MainServlet" method="get">
					<input type="hidden" name="prevTitle" value="${prevTitle}">
						<table class="table isSearch">
							<thead>
								<tr class="table-heads ">
									<th class="head-item mbr-fonts-style display-7">Название</th>
									<th class="head-item mbr-fonts-style display-7">Автор</th>
									<th class="head-item mbr-fonts-style display-7">Дата
										публиции</th>
									<th class="head-item mbr-fonts-style display-7">Действия</th>
								</tr>
							</thead>

							<tbody>
								<c:forEach items="${list}" var="item">
									<tr>
										<td class="body-item mbr-fonts-style display-7">${item.getTitle()}</td>
										<td class="body-item mbr-fonts-style display-7">${item.getAuthor().getName()+=' '+=item.getAuthor().getSurName()}</td>
										<td class="body-item mbr-fonts-style display-7">${item.getPublishDate()}</td>
										<td class="body-item mbr-fonts-style display-7"><a
											href="http://localhost:8080/login/MainServlet?action=order_book&book_id=${item.getId()}&prevTitle=${prevTitle}&search=books">Заказать</a>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</form>
				</div>
			</div>
		</div>
	</section>


	<script src="assets/web/assets/jquery/jquery.min.js"></script>
	<script src="assets/popper/popper.min.js"></script>
	<script src="assets/tether/tether.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/datatables/jquery.data-tables.min.js"></script>
	<script src="assets/datatables/data-tables.bootstrap4.min.js"></script>
	<script src="assets/smoothscroll/smooth-scroll.js"></script>
	<script src="assets/dropdown/js/script.min.js"></script>
	<script src="assets/touchswipe/jquery.touch-swipe.min.js"></script>
	<script src="assets/viewportchecker/jquery.viewportchecker.js"></script>
	<script src="assets/parallax/jarallax.min.js"></script>
	<script src="assets/theme/js/script.js"></script>
	<script src="assets/formoid/formoid.min.js"></script>


	<input name="animation" type="hidden">
</body>
</html>