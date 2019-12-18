<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>SafeFood</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/navcss.css">
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
</style>
<script src="js/jquery-3.4.1.js"></script>
<script src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript" >
	 $(function(){
		 google.charts.load('visualization', '1',{'packages':['corechart'], 'callback':function(){
		 	 var data = google.visualization.arrayToDataTable([
	 			  ['provide', 'kal'],
	 			  ['탄수화물', Number($('#nutrition-carbohydrate').text()) ] ,
	 			  ['단백질', Number($('#nutrition-protein').text())  ],
	 			  ['지방', 	Number($('#nutrition-fat').text())  ] ,
	 			  ['당류', 	Number($('#nutrition-sugars').text())   ],
	 			  ['나트륨', Number($('#nutrition-salt').text())  ],
	 			  ['콜레스테롤',Number($('#nutrition-cholesterol').text()) ],
	 			  ['포화 지방산',Number($('#nutrition-sfa').text()) ],
	 			  ['트랜스지방',Number($('#nutrition-transfat').text()) ]]);
	 		 var options = {'title':'영양성분정보상세', 'width':550, 'height':400};
	 		 var chart = new google.visualization.PieChart(document.getElementById('piechart'));
			 chart.draw(data, options);
		 }});
	 }); 
	 //ready
</script>
</head>
<body>
	
	<jsp:include page="nav.jsp"></jsp:include>
	
	<h2 align="center"><strong>제품 정보</strong></h2><br>
	
	<div class="container" id="foodRowCotent">
	<div class="row">
		<div class="col-sm-4">
			<img src="img/${food.name}.jpg" class="img-thumbnail" alt="Cinque Terre" width="304" height="236">
		</div>
		<div class="col-sm-8 food-item-info">
			<div class="row">  <!-- 제품명, 제조사, 원재료, 알레르기 성분 -->
				<div class="col-2" >제품명</div>
				<div class="col-6" id="product-name">${food.name}</div>
			</div>
			<hr>		
			<div class="row">
				<div class="col-2">제조사</div>
				<div class="col-6" id="product-factory">${food.maker}</div>
			</div><hr>
			<div class="row">
				<div class="col-2">원재료</div>
				<div class="col-6" id="product-material">${food.material}</div>
			</div><hr>
			<div class="row">
				<div class="col-2">알레르기 &nbsp;&nbsp;&nbsp;성분</div>
				<div class="col-6" id="product-allergy">토마토,우유,땅콩</div>
			</div><hr>
			<div class="row">
				<div class="col-8">
					갯수&nbsp;&nbsp;<input type="number">
					&nbsp;<button type="button">넣기</button>
					&nbsp;&nbsp;<img id="image" src = "img/heart-gray-48.png" width="25" height="25">찜하기 <!-- 하트색 바뀌는 부분 코드 작성 -->
				</div>
			</div><br><br><br>
		</div>
		
		
		
		
		<div class="col-sm-6">
			<h5>영양 정보</h5>
			
			<!-- 파이차트 나오는 부분 -->
			<div id="piechart">
			
			</div>
			
		</div>
		<div class="col-6">
			<div class="row">
				<div class="col-4">일일 제공량</div>
				<div class="col-2" id="nutrition-daily">${food.supportpereat}</div>
			</div><hr>
			<div class="row">
				<div class="col-4">칼로리</div>
				<div class="col-2" id="nutrition-calories">${food.calory}</div>
			</div><hr>
			<div class="row">
				<div class="col-4">탄수화물</div>
				<div class="col-2" id="nutrition-carbohydrate">${food.carbo}</div>
			</div><hr>
			<div class="row">
				<div class="col-4">단백질</div>
				<div class="col-2" id="nutrition-protein">${food.protein}</div>
			</div><hr>
			<div class="row">
				<div class="col-4">지방</div>
				<div class="col-2" id="nutrition-fat">${food.fat}</div>
			</div><hr>
			<div class="row">
				<div class="col-4">당류</div>
				<div class="col-2" id="nutrition-sugars">${food.sugar}</div>
			</div><hr>
			<div class="row">
				<div class="col-4">나트륨</div>
				<div class="col-2" id="nutrition-salt">${food.natrium}</div>
			</div><hr>
			<div class="row">
				<div class="col-4">콜레스테롤</div>
				<div class="col-2" id="nutrition-cholesterol">${food.chole}</div>
			</div><hr>
			<div class="row">
				<div class="col-4">포화 지방산</div>
				<div class="col-2" id="nutrition-sfa">${food.fattyacid}</div>
			</div><hr>
			<div class="row">
				<div class="col-4">트렌스지방</div>
				<div class="col-2" id="nutrition-transfat">${food.transfat}</div>
			</div><hr>
		</div>
	</div><br>
	</div>
	
	
	
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
