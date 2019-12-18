<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.index-img{
	cursor:pointer;
	
}
</style>

</head>
<body>
<div class="container">

	<h2 align="center">상품</h2><br>
	<c:if test="${size>=1 }">
	<div class="row"><!-- 1 -->
		<!-- 왼쪽 상품들 -->
		<div class="col col-md-6">
		
			<c:forEach var="cnt" begin="0" end="${(size/2)-1 }">
				<div class="row"><!-- 2 -->
					<div class="col-4">
						<a href="detailPage.do?code=${foods[cnt].code}"><img src="${foods[cnt].img }" class="index-img"></a>
					</div>
					<div class="col-8 product-small">
						<h5><strong>${foods[cnt].name }</strong></h5>
						<p>${foods[cnt].material }</p><br>
						<button type="button" class="btn btn-primary btn-sm">
							<img src="img/cart-white-30.png" class="cart-img btn-img">&nbsp;&nbsp;추가
						</button>

						<button type="button" class="btn btn-primary btn-sm">
							<img src="img/icons8-heart-health-48.png" class="heart-img btn-img">&nbsp;&nbsp;찜하기
						</button>
					</div>
				</div><!-- 2 -->
				<br><br>
			</c:forEach>
		</div> <!-- 왼쪽 상품들  끝-->


		<!-- 오른쪽 상품들 -->
		<div class="col-md-6 col-md-auto">
		<c:if test="${not(size eq 1) }">
			<c:forEach var="cnt" begin="${(size/2) }" end="${size-1 }">
				<div class="row"><!-- 2 -->
					<div class="col-4">
						<a href="detailPage.do?code=${foods[cnt].code}">
							<img src="${foods[cnt].img }" class="index-img">
						</a>
					</div>
					<div class="col-8 product-small">
						<h5><strong>${foods[cnt].name }</strong></h5>
						<p>${foods[cnt].material }</p>
						<button type="button" class="btn btn-primary btn-sm">
							<img src="img/cart-white-30.png" class="cart-img btn-img">&nbsp;&nbsp;추가
						</button>

						<button type="button" class="btn btn-primary btn-sm">
							<img src="img/icons8-heart-health-48.png" class="heart-img btn-img">&nbsp;&nbsp;찜하기
						</button>
					</div>
				</div><!-- 2 -->
				<br><br>
			</c:forEach>
		</c:if>
			
		</div><!-- 오른쪽 상품들 끝-->
	</div><!-- 1 -->
	
	</c:if>
	<c:if test="${size==0 }">
		<h2 align="center">상품 정보가 없습니다.</h2>
	</c:if>
</div><!-- container -->
	<!-- 상품 내용 부분 끝 -->

	<!-- 페이지 넘기기! -->
	<!-- <div class="container">
		<ul class="pagination justify-content-center" style="margin:20px 0">
			<li class="page-item"><a class="page-link" href="#">Previous</a></li>
			<li class="page-item active"><a class="page-link" href="#">1</a></li>
			<li class="page-item"><a class="page-link" href="#">2</a></li>
			<li class="page-item"><a class="page-link" href="#">3</a></li>
			<li class="page-item"><a class="page-link" href="#">Next</a></li>
		</ul>
	</div>
 -->	<br><br>
	<!-- 페이지 넘기기 끝! -->
	
	
</body>
</html>
