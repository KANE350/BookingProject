<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${path}/resources/js/login.js"></script>


</head>
<body>
	<header>

		<div>
			<!--컨텍스트 패스-->
			<input type="hidden" value="${path}" id="contextpath"> <span
				id="sessionMember_id" class="btn btn-ligh btn-lg"><a
				href="${path}/member/info">${sessionScope.member_id}</a></span> <a
				href="${path}/login" id="aLogin" class="btn btn-secondary btn-lg">로그인</a>
			<a onclick="aLogout(event, `${path}`)" id="aLogout"
				class="btn btn-secondary btn-lg">로그아웃</a> <a
				href="${path}/member/join" id="aJoin"
				class="btn btn-secondary btn-lg">회원가입</a>
			<c:if test="${sessionScope.member_level eq '9'}">
				<a href="${path}/room_management" class="btn btn-success btn-lg">객실
					관리</a>
				<a href="${path}/member_management" class="btn btn-success btn-lg">회원
					관리</a>
			</c:if>

		</div>
	</header>
	<hr>




	<!--부트스트랩 새로넣음-->
	<!-- Responsive navbar-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand btn-lg" href="${path}">홈</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
					<li class="nav-item btn-lg"><a class="nav-link active"
						aria-current="page" href="${path}/Reservation/">예약</a></li>
					<li class="nav-item btn-lg"><a class="nav-link"
						href="${path}/company">찾아오시는 길</a></li>
					<li class="nav-item btn-lg"><a class="nav-link"
						href="${path}/comu/comulist">커뮤니티</a></li>
					<li class="nav-item btn-lg"><a class="nav-link"
						href="${path}/review/reviewlist">리뷰</a></li>

				</ul>
			</div>
		</div>
	</nav>

<script type="text/javascript" src="${path}/resources/js/header.js"></script>



</body>
</html>