<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>SafeFood</title>

	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<script src="js/jquery-3.4.1.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	
	<link rel="stylesheet" href="css/navcss.css">
	<link rel="stylesheet" href="css/search.css">
	<link rel="stylesheet" href="css/footer.css">

	<style>
		.jumbotron {
			background-image: url(img/border1.jpg);
			background-size: 100%;
			color: white;
			cursor:pointer;
		}

		.jumbotron hr {
			border-top: 1px solid rgba(255, 255, 255, 0.61);
		}

		.active-cyan {
			color: #4dd0e1;
		}

		.index-img {
	width: 150px;
	height: 150px;
}

.btn-img {
	width: 20px;
	height: 20px;
}
	</style>

</head>
<body>
	<jsp:include page="nav.jsp"></jsp:include>
	
	<c:import url="index_vision.html"></c:import>
	
	<!-- Footer -->
	<footer class="page-footer font-small blue pt-4">
		<!-- Footer Links -->
		<div class="container-fluid text-center text-md-left">
			<!-- Grid row -->
			<div class="row">
				<!-- Grid column -->
				<div class="col-md-6 mt-md-0 mt-3">
					<!-- Content -->
					<h5 class="text-uppercase">Safe Food</h5>
					<p>안전한 먹거리를 위해서 계속 생각합니다.</p>
				</div>
				<!-- Grid column -->
				<hr class="clearfix w-100 d-md-none pb-3">
				<!-- Grid column -->
				<div class="col-md-3 mb-md-0 mb-3 offset-md-3">
					<!-- Links -->
					<h5 class="text-uppercase">Links</h5>
					<ul class="list-unstyled">
						<li>
							<a href="#!">Link 1</a>
						</li>
						<li>
							<a href="#!">Link 2</a>
						</li>
						<li>
							<a href="#!">Link 3</a>
						</li>
						<li>
							<a href="#!">Link 4</a>
						</li>
					</ul>
				</div>
				<!-- Grid column -->
			</div>
			<!-- Grid row -->
		</div>
		<!-- Footer Links -->
		<!-- Copyright -->
		<div class="footer-copyright text-center py-3">© 2018 Copyright&nbsp;
			<span><b>S&nbsp;S&nbsp;A&nbsp;F&nbsp;Y</b></span>
		</div>
		<!-- Copyright -->
	</footer>
	<!-- Footer -->
</body>
</html>