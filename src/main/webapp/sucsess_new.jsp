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
<meta name="description"
	content="">
<title>index</title>
<link rel="stylesheet" href="assets/tether/tether.min.css">
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="assets/bootstrap/css/bootstrap-grid.min.css">
<link rel="stylesheet"
	href="assets/bootstrap/css/bootstrap-reboot.min.css">
<link rel="stylesheet" href="assets/socicon/css/styles.css">
<link rel="stylesheet" href="assets/animatecss/animate.min.css">
<link rel="stylesheet" href="assets/dropdown/css/style.css">
<link rel="stylesheet" href="assets/theme/css/style.css">
<link rel="stylesheet" href="assets/mobirise/css/mbr-additional.css"
	type="text/css">



</head>
<body>
	<section class="engine">
		<a>Современные шаблоны для
			сайта Скачать бесплатно У нас на сайте</a>
	</section>
	<section
		class="header1 cid-qLBnEAkCXA mbr-fullscreen mbr-parallax-background"
		id="header1-i">



		<div class="mbr-overlay"
			style="opacity: 0.5; background-color: rgb(0, 0, 0);"></div>
<form action="MainServlet" method="get">
		<div class="container">
			<div class="row justify-content-md-center">
				<div class="mbr-white col-md-10">

					<h3
						class="mbr-section-subtitle align-center mbr-light pb-3 mbr-fonts-style display-2">Операция выполнена успешно</h3>
				</div>
			</div>
			<c:choose>
         <c:when test = "${sessionScope.prevAction=='login_admin'}">
            <input type="hidden" name="action"	value="main_page"/>
			<button type="submit" class="btn btn-primary btn-form display-4">Продолжить</button>
         </c:when>
         <c:when test = "${sessionScope.prevAction=='create_author'}">
            <input type="hidden" name="action"	value="main_page"/>
			<button type="submit" class="btn btn-primary btn-form display-4">Продолжить</button>
         </c:when>
         <c:when test = "${sessionScope.prevAction=='create_book'}">
            <input type="hidden" name="action"	value="main_page"/>
			<button type="submit" class="btn btn-primary btn-form display-4">Продолжить</button>
         </c:when>
         <c:when test = "${sessionScope.prevAction=='create_user'}">
            <input type="hidden" name="action"	value="main_page"/>
			<button type="submit" class="btn btn-primary btn-form display-4">Продолжить</button>
         </c:when>
         <c:when test = "${sessionScope.prevAction=='create_user_and_card'}">
            <input type="hidden" name="action"	value="main_page"/>
			<button type="submit" class="btn btn-primary btn-form display-4">Продолжить</button>
         </c:when>
         <c:when test = "${sessionScope.prevAction=='update_abonent'}">
            <input type="hidden" name="action"	value="switch_cabinet"/>
			<button type="submit" class="btn btn-primary btn-form display-4">Продолжить</button>
         </c:when>
         <c:when test = "${sessionScope.prevAction=='update_author'}">
            <input type="hidden" name="action"	value="view_authors_select"/>
			<button type="submit" class="btn btn-primary btn-form display-4">Продолжить</button>
         </c:when>
         <c:when test = "${sessionScope.prevAction=='update_book'}">
            <input type="hidden" name="action"	value="view_books"/>
			<button type="submit" class="btn btn-primary btn-form display-4">Продолжить</button>
         </c:when>
          <c:when test = "${sessionScope.prevAction=='login_user'}">
            <input type="hidden" name="action"	value="main_page"/>
			<button type="submit" class="btn btn-primary btn-form display-4">Продолжить</button>
         </c:when>
         <c:otherwise>
            No comment sir...
         </c:otherwise>
      </c:choose>
		</div>
</form>
	</section>

	<section class="cid-qLBsHzZleS mbr-reveal" id="footer1-j">





		<div class="container">
			<div class="media-container-row content text-white">
				<div class="col-12 col-md-3">
					<div class="media-wrap">
						<a> <img
							src="assets/images/logocbs-2-345x345.png" alt="Mobirise" title="">
						</a>
					</div>
				</div>
				<div class="col-12 col-md-3 mbr-fonts-style display-7">
					<h5 class="pb-3">Разработал</h5>
					<p class="mbr-text">Нестерёнок Алексей Александрович</p>
				</div>
				<div class="col-12 col-md-3 mbr-fonts-style display-7">
					<h5 class="pb-3">Контакты</h5>
					<p class="mbr-text">
						E-mail: aleksejnesterenok@gmail.com &nbsp; &nbsp; &nbsp; &nbsp;
						&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<br>Телефон:
						+375 44 598 81 04 &nbsp; &nbsp; &nbsp; &nbsp;<br>
					</p>
				</div>
				<div class="col-12 col-md-3 mbr-fonts-style display-7">
					<h5 class="pb-3"></h5>
					<p class="mbr-text"></p>
				</div>
			</div>

		</div>
	</section>


	<script src="assets/web/assets/jquery/jquery.min.js"></script>
	<script src="assets/popper/popper.min.js"></script>
	<script src="assets/tether/tether.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/parallax/jarallax.min.js"></script>
	<script src="assets/smoothscroll/smooth-scroll.js"></script>
	<script src="assets/touchswipe/jquery.touch-swipe.min.js"></script>
	<script src="assets/viewportchecker/jquery.viewportchecker.js"></script>
	<script src="assets/dropdown/js/script.min.js"></script>
	<script src="assets/theme/js/script.js"></script>


	<input name="animation" type="hidden">
</body>
</html>