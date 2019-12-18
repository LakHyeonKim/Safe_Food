<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<!-- head -->
<head>
<title>ProductInfoPage</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/navcss.css">
<link rel="stylesheet" href="css/search.css">
<link rel="stylesheet" href="css/footer.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<style>
.index-img {
	width: 150px;
	height: 150px;
}

.btn-img {
	width: 20px;
	height: 20px;
}

.jumbotron {
	background-image: url(img/border1.jpg);
	background-size: 100%;
	color: white;
	cursor: pointer;
}

.jumbotron hr {
	border-top: 1px solid rgba(255, 255, 255, 0.61);
}
</style>
<script>
	//	 $(function() {
	//displayHighLight(1);

	//		search("", "");
	/* $(document).on('click','.page-item',function(){
	$('#paginationUI').empty();
	$('#foodRowContent').empty();
	displayHighLight($(this).text());
	}); */

	//	});//onload  
	//자동 완성
	/* $(function() {
		$("#searchText").autocomplete({
			source : function(request, response) {
				$.ajax({
					type : 'post',
					url : "FoodServlet?command=auto",
					dataType : "json",
					//request.term = $("#autocomplete").val()
					data : {
						value : request.term
					},
					success : function(data) {
						//서버에서 json 데이터 response 후 목록에 뿌려주기 위함
						response($.map(data, function(item) {
							return {
								label : item.data,
								value : item.data
							}
						}));
					}
				});
			},
			//조회를 위한 최소글자수
			minLength : 1,
			select : function(event, ui) {
				// 만약 검색리스트에서 선택하였을때 선택한 데이터에 의한 이벤트발생
			}
		});
	}); */

	//제품 검색
	function search(searchField, searchText, searchAllegry) {
		var searchField = document.searchform.searchField.value;
		var searchText = document.searchform.searchText.value;
		
		var searchAllegry = document.getElementsByName('searchAllegry');
		var allergy = '';
		for(var i=0 ; i<searchAllegry.length ; i++) {
			if(searchAllegry[i].checked) {
				allergy += searchAllegry[i].value+",";
			}
		}

		console.log(searchText);
		console.log(allergy);
		$.ajax({
			type : 'post',
			url : 'findFood.do',
			data : {
				'searchField' : searchField,
				'searchText' : searchText,
				'allergy' : allergy,
			},
			success : function(result) {
				$('#productPool').html(result);
			}//success
		});//ajax

		return false;
	};//search

	/* function displayHighLight(curPageNumber) {
		$.ajax({
					type : 'get',

					url : 'FoodServlet',

					data : {
						'command' : 'search'
					},

					success : function(result) {
						$('#paginationUI').resize(0);
						len = $(result).find('food').length;

						var str = '<li class="page-item"><a id="previousBtn" class="page-link" href="#">Previous</a></li>';
						var i = 1;
						for (; i * 6 <= len; i++) {
							if (i == curPageNumber)
								str += '<li class="page-item active"><a class="page-link" href="#">'
										+ i + '</a></li>';
							else
								str += '<li class="page-item"><a class="page-link" href="#">'
										+ i + '</a></li>';
						}
						if ((i * 6) % len > 0)
							str += '<li class="page-item"><a class="page-link" href="#">'
									+ i + '</a></li>';

						str += '<li class="page-item"><a id="nextBtn" class="page-link" href="#">Next</a></li>';
						$('#paginationUI').prepend(str);

						strL = '<div class="row"><div class="col col-md-6">';
						strR = '</div><div class="col-md-6 col-md-auto">';
						$(result)
								.find('food')
								.each(
										function(index, item) {
											if (index < len
													&& (curPageNumber - 1) * 6 <= index
													&& index < (curPageNumber * 6) - 3) {

												var name = $(this).find('name')
														.text();
												var material = $(this).find(
														'material').text();
												var image = $(this).find(
														'image').text()
														.substring(4);
												strL += '<div class="row"><div class="col-4" style="cursor:pointer" onclick="location.href=\'DetailPage.jsp?name='
														+ name + '\'">';
												strL += '<img src="img/safefood_image/' + image + '" class="index-img"></div>';
												strL += '<div class="col-8 product-small"><h5><strong>'
														+ name
														+ '</strong></h5>';
												strL += '<p>' + material
														+ '</p><br>';
												strL += '<button type="button" class="btn btn-primary btn-sm"><img src="img/cart-white-30.png" class="cart-img btn-img">&nbsp;&nbsp;추가</button>';
												strL += '<button type="button" class="btn btn-primary btn-sm"><img src="img/icons8-heart-health-48.png" class="heart-img btn-img">&nbsp;&nbsp;찜하기</button>';
												strL += '</div></div><br><br>';
											} else if (index < len
													&& (curPageNumber * 6) - 3 <= index
													&& index < curPageNumber * 6) {

												var name = $(this).find('name')
														.text();
												var material = $(this).find(
														'material').text();
												var image = $(this).find(
														'image').text()
														.substring(4);
												strR += '<div class="row"><div class="col-4" style="cursor:pointer" onclick="location.href=\'DetailPage.jsp?name='
														+ name + '\'">';
												strR += '<img src="img/safefood_image/' + image + '" class="index-img"></div>';
												strR += '<div class="col-8 product-small"><h5><strong>'
														+ name
														+ '</strong></h5>';
												strR += '<p>' + material
														+ '</p><br>';
												strR += '<button type="button" class="btn btn-primary btn-sm"><img src="img/cart-white-30.png" class="cart-img btn-img">&nbsp;&nbsp;추가</button>';
												strR += '<button type="button" class="btn btn-primary btn-sm"><img src="img/icons8-heart-health-48.png" class="heart-img btn-img">&nbsp;&nbsp;찜하기</button>';
												strR += '</div></div><br><br>';
											}
										});
						strR += '</div></div>';
						$('#foodRowContent').append(strL + strR);
					}
				});//ajax

	};//displayHighLight */
	//});
</script>
</head>
<!-- head -->
<body>

	<jsp:include page="nav.jsp"></jsp:include>

	<!-- 검색창 부분 -->
	<div class="container search-bar">
		<form id="searchform" name="searchform" class="form-inline justify-content-center" method="post" onsubmit="return search()">
			<select name="searchField" class="custom-select" id="searchField">
				<option value="All" selected="selected">전체 검색</option>
				<option value="Name">제품 이름</option>
				<option value="Maker">제조사</option>
				<option value="Material">원재료</option>
			</select>&nbsp; 
			<input type="text" class="form-control" placeholder="Search" id="searchText" name="searchText" aria-label="Search">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

			<!-- searchAllegry -->
			<!-- 알레르기 선택 -->
			<div class="form-container ">
				<fieldset>
					<h3>알레르기 위험식품 검색</h3>
					<div class="row allegry-type">
						<div class="col-3 allegry-name">곡류</div>
						<div class="col">
							<input type="checkbox" name="searchAllegry" id="searchAllegry" value="메밀"> 메밀
							&nbsp;&nbsp;
							<input type="checkbox" name="searchAllegry" id="searchAllegry" value="밀가루"> 밀가루
						</div>
					</div>

					<div class="row allegry-type">
						<div class="col-3 allegry-name">두류</div>
						<div class="col ">
							<input type="checkbox" name="searchAllegry" id="searchAllegry" value="두유"> 두유
							&nbsp;&nbsp; 
							<input type="checkbox" name="searchAllegry" id="searchAllegry" value="두부">
							두부
						</div>
					</div>



					<div class="row allegry-type">
						<div class="col-3 allegry-name">과일</div>
						<div class="col ">
							<input type="checkbox" name="searchAllegry" id="searchAllegry" value="복숭아"> 복숭아&nbsp;&nbsp; 
							<input type="checkbox" name="searchAllegry" id="searchAllegry" value="귤"> 귤 &nbsp;&nbsp; 
							<input type="checkbox" name="searchAllegry" id="searchAllegry" value="오렌지"> 오렌지
						</div>
					</div>


					<div class="row allegry-type">
						<div class="col-3 allegry-name">야채</div>
						<div class="col ">
							<input type="checkbox" name="searchAllegry" id="searchAllegry" value="토마토"> 토마토
						</div>
					</div>

					<div class="row allegry-type">
						<div class="col-3 allegry-name">육류</div>
						<div class="col ">
							<input type="checkbox" name="searchAllegry" id="searchAllegry" value="돼지고기"> 돼지고기 &nbsp;&nbsp; 
							<input type="checkbox" name="searchAllegry" id="searchAllegry" value="소고기"> 소고기 &nbsp;&nbsp; 
							<input type="checkbox" name="searchAllegry" id="searchAllegry" value="닭고기"> 닭고기
						</div>

					</div>

					<div class="row allegry-type">
						<div class="col-3 allegry-name">난류</div>
						<div class="col ">
							<input type="checkbox" name="searchAllegry" id="searchAllegry" value="계란"> 계란
						</div>
					</div>

					<div class="row allegry-type">
						<div class="col-3 allegry-name">우유류</div>
						<div class="col ">
							<input type="checkbox" name="searchAllegry" id="searchAllegry" value="우유"> 우유
						</div>
					</div>

					<div class="row allegry-type">
						<div class="col-3 allegry-name">어류</div>
						<div class="col ">
							<input type="checkbox" name="searchAllegry" id="searchAllegry" value="등푸른생선"> 등푸른
							생선
						</div>

					</div>

					<div class="row allegry-type">
						<div class="col-3 allegry-name">갑각류</div>
						<div class="col ">
							<input type="checkbox" name="searchAllegry" id="searchAllegry" value="게"> 게&nbsp;&nbsp; 
							<input type="checkbox" name="searchAllegry" id="searchAllegry" value="조개"> 조개
						</div>

					</div>

					<div class="row allegry-type">
						<div class="col-3 allegry-name">패류</div>
						<div class="col ">
							<input type="checkbox" name="searchAllegry" id="searchAllegry" value="새우"> 새우
						</div>

					</div>
					<div class="row allegry-type">
						<div class="col-3 allegry-name">견과류</div>
						<div class="col ">
							<input type="checkbox" name="searchAllegry" id="searchAllegry" value="땅콩"> 땅콩
							&nbsp;&nbsp; <input type="checkbox" name="searchAllegry" id="searchAllegry" value="호두">
							호두
						</div>

					</div>
				</fieldset>
			</div>
			<br>
			<!-- 알레르기 선택 -->








		</form>
	</div>
	<br>


	<!-- 제품검색 -->
	<div id="productPool"></div>

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
						<li><a href="#!">Link 1</a></li>
						<li><a href="#!">Link 2</a></li>
						<li><a href="#!">Link 3</a></li>
						<li><a href="#!">Link 4</a></li>
					</ul>
				</div>
				<!-- Grid column -->
			</div>
			<!-- Grid row -->
		</div>
		<!-- Footer Links -->
		<!-- Copyright -->
		<div class="footer-copyright text-center py-3">
			© 2018 Copyright&nbsp; <span><b>S&nbsp;S&nbsp;A&nbsp;F&nbsp;Y</b></span>
		</div>
		<!-- Copyright -->
	</footer>
	<!-- Footer -->
</body>
</html>
