<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Heroic Features - Start Bootstrap Template</title>
<!-- Bootstrap icons-->
<link rel="icon" type="image/x-icon"
	href="${path}/resources/image/favicon.ico" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="${path}/resources/css/reservstyles.css" rel="stylesheet" />

<title>예약</title>
</head>
<script type="text/javascript"
	src="${path}/resources/js/reservation/updatereservation.js">
	
</script>
<body style="overflow: auto;">


	<!-- Responsive navbar-->
	<!-- <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand" href="#!">Start Bootstrap</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" href="#">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="#!">About</a></li>
					<li class="nav-item"><a class="nav-link" href="#!">Contact</a></li>
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Blog</a></li>
				</ul>
			</div>
		</div>
	</nav> -->

	<%@ include file="../header.jsp" %>

	<div class="d-inline-flex" id="wrapper">

		<!-- Sidebar-->
		<div class="border-end bg-white" id="sidebar-wrapper">
			<%@ include file="../sidebar.jsp"%>
		</div>

		<!-- 캘린더 -->
		<div id="calendar">
			<%@ include file="./calendar.jsp"%>
		</div>
		
		<div id="content">
			<form id="frm_reserv" action="${path}/reservation/updatereservation"
				method="post">
				<div>
					<span>입실</span> 
						<input type="date" class="startdate" name="re_startdate">&#9;
					<span>퇴실</span> 
						<input type="date" class="enddate" name="re_enddate">
				</div>

				<table class="roominfo">
					<thead>
						<tr>
							<td>선택</td>
							<td>이미지</td>
							<td>객실명</td>
							<!-- <td> 최대인원</td> -->

						</tr>
					</thead>
					<tbody>
						<c:forEach var="info" items="${roomNroomfile}">
							
							<tr>
								<td><input type="radio" name="room_idx" value="${info.ROOM_IDX}"></td>
								<td id="imgtd">
								<img src="${path}/savedir/${info.ROOMFILE_FILENAME}" width="150"
									height="50"></td>
								<td><span> ${info.ROOM_NAME}</span></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="buttom-button">

					<button class="reservButton" onclick="btnclick('${path}', event)">수정</button>
				</div>
			</form>
		</div>

	</div>
</body>
</html>