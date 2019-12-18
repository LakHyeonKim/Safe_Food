<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<header>
	<nav class="navbar navbar-expand-sm bg-light">
		<div class="navbar-collapse collapse">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="/safefood/ProductInfoPage.jsp">전체상품정보</a></li>
				<li class="nav-item"><a class="nav-link" href="/safefood/Vision.jsp">이미지 검색</a></li>
				<li class="nav-item"><a class="nav-link" href="/safefood/QnA.jsp">질문 게시판</a></li>
			</ul>
			<ul class="navbar ml-auto">
				<!-- 네비게이션 drop down 부분 -->
				<li class="nav-item dropdown" style="list-style-type: none;"><a class="nav-link" href="#" data-toggle="dropdown">
						<img id="img-person" src="img/person-64.png">
					</a>
					<div class="dropdown-menu dropdown-menu-right unlogin">
						<c:choose>
							<c:when test="${empty sessionScope.user}">
								<a class="dropdown-item" href="/safefood/login.html">login</a>
								<a class="dropdown-item" href="/safefood/SignUpPage.jsp">회원가입</a>
							</c:when>
							<c:otherwise>
								<!-- 로그인하면 보이는 부분 -->
								<a class="dropdown-item" href="logout.do">logout</a>
								<a class="dropdown-item" href="findById.do?id=${sessionScope.user.id}">마이페이지</a>
							</c:otherwise>
						</c:choose>

					</div>
				</li>
			</ul>
		</div>
	</nav>

</header>

	<!-- 그림 부분 -->
	<div class="jumbotron text-center" onclick="location.href='/safefood/index.jsp'">
		<h1>Safe Food</h1>
		<hr>
		<p>안전한 먹거리를 위해서 계속 생각합니다.</p>
	</div>