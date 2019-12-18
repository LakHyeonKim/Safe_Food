<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<title>SafeFood - 마이페이지</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<script src="js/jquery-3.4.1.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="css/navcss.css">
	<link rel="stylesheet" href="css/footer.css">

	<style>
		#id,
		#password {
			padding-left: 3px;
		}

		/* form  css */
		.form-container {
			margin: 0 auto;
			width: 80%;
		}

		.allegry-name {
			text-align: center;
		}

		.allegry-type {
			margin-top: 4px;
			margin-bottom: 4px;
		}
		input[type=checkbox] {
    		 transform: scale(1.5); 
		}
		/* form  css end*/
		
		.jumbotron {
		background-image: url(img/border1.jpg);
		background-size: 100%;
		color: white;
		}

		.jumbotron hr {
			border-top: 1px solid rgba(255, 255, 255, 0.61);
		}
		
	</style>
	<script src="js/jquery-3.4.1.js"></script>
	<script>
		$(function () {
			var str = "${user.allergy}";
			var list = str.split(",");
			for(var v of list){
				$("input:checkbox[value="+v+"]").prop("checked",true);			
			}
		});
	</script>
</head>

<body>

	<jsp:include page="nav.jsp"></jsp:include>

	<div class="container">
		<form id="updateFrm" action="update.do" method="post">
			<!-- 아이디와 비밀번호 -->
			<div class="form-container ">
				<h3>마이 페이지</h3> <br>
				<div class="form-group">
					<label for="id">아이디:</label>
					<input type="text" class="form-control" id="id" name="id"  readonly="readonly" value="${user.id}" placeholder="${id}">
				</div>
				<div class="form-group">
					<label for="password">비밀번호:</label>
					<input type="text" class="form-control" id="password" name="password" value="${user.password}" required>
				</div>
				<div class="form-group">
					<label for="name">이름:</label>
					<input type="text" class="form-control" id="name"  name="name" value="${user.name}" required>
				</div>
				<div class="form-group">
					<label for="address">주소:</label>
					<input type="text" class="form-control" id="address" name="address" value="${user.address}" required>
				</div>

			</div>
			<!-- 아이디와 비밀번호, 이름, 주소 끝-->
			
			<br>

			<!-- 알레르기 선택 -->
			<div class="form-container ">
				<fieldset>
					<h3>알레르기</h3><br>
					<div class="row allegry-type">
						<div class="col-3 allegry-name">
							곡류
						</div>
						<div class="col-3">
							<input type="checkbox" name="allergy" value="메밀"> 메밀
							&nbsp;&nbsp;
							<input type="checkbox" name="allergy" value="밀가루"> 밀가루
						</div>
					</div>

					<div class="row allegry-type">
						<div class="col-3 allegry-name">두류
						</div>
						<div class="col ">
							<input type="checkbox" name="allergy" value="두유"> 두유
							&nbsp;&nbsp;
							<input type="checkbox" name="allergy" value="두부"> 두부
						</div>
					</div>



					<div class="row allegry-type">
						<div class="col-3 allegry-name">
							과일
						</div>
						<div class="col ">
							<input type="checkbox" name="allergy" value="복숭아"> 복숭아
							&nbsp;&nbsp;
							<input type="checkbox" name="allergy" value="귤"> 귤
							&nbsp;&nbsp;
							<input type="checkbox" name="allergy" value="오렌지"> 오렌지
						</div>
					</div>


					<div class="row allegry-type">
						<div class="col-3 allegry-name">
							야채
						</div>
						<div class="col ">
							<input type="checkbox" name="allergy" value="토마토"> 토마토
						</div>
					</div>

					<div class="row allegry-type">
						<div class="col-3 allegry-name">육류</div>
						<div class="col ">
							<input type="checkbox" name="allergy" value="돼지고기"> 돼지고기
							&nbsp;&nbsp;
							<input type="checkbox" name="allergy" value="소고기"> 소고기
							&nbsp;&nbsp;
							<input type="checkbox" name="allergy" value="닭고기"> 닭고기
						</div>

					</div>

					<div class="row allegry-type">
						<div class="col-3 allegry-name">난류</div>
						<div class="col ">
							<input type="checkbox" name="allergy" value="계란"> 계란
						</div>
					</div>

					<div class="row allegry-type">
						<div class="col-3 allegry-name">우유류</div>
						<div class="col ">
							<input type="checkbox" name="allergy" value="우유"> 우유
						</div>
					</div>

					<div class="row allegry-type">
						<div class="col-3 allegry-name">어류</div>
						<div class="col ">
							<input type="checkbox" name="allergy" value="등푸른생선"> 등푸른 생선
						</div>

					</div>

					<div class="row allegry-type">
						<div class="col-3 allegry-name">갑각류</div>
						<div class="col ">
							<input type="checkbox" name="allergy" value="게"> 게
							&nbsp;&nbsp;
							<input type="checkbox" name="allergy" value="조개"> 조개
						</div>

					</div>

					<div class="row allegry-type">
						<div class="col-3 allegry-name">패류</div>
						<div class="col ">
							<input type="checkbox" name="allergy" value="새우"> 새우
						</div>

					</div>
					<div class="row allegry-type">
						<div class="col-3 allegry-name">견과류</div>
						<div class="col ">
							<input type="checkbox" name="allergy" value="땅콩"> 땅콩
							&nbsp;&nbsp;
							<input type="checkbox" name="allergy" value="호두"> 호두
						</div>

					</div>
				</fieldset>
				
			</div><br>

			<!-- 알레르기 선택 끝-->
			<div class="form-container">
				<button type="submit" class="btn btn-primary" style="margin-top: 10px; width: 100%;">내 정보 수정하기</button>
				<a class="btn btn-primary" style="margin-top: 10px; width: 100%;" href="delete.do">회원 탈퇴하기</a>
			</div>
			
		</form>
	</div>

	<br>
	<br>
	<br>
	<!-- Footer -->
	<footer class="page-footer font-small blue pt-4">

		<!-- Footer Links -->
		<div class="container-fluid text-center text-md-left">

			<!-- Grid row -->
			<div class="row allegry-type">

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