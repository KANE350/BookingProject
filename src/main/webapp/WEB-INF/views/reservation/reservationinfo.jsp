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
	href="${path}/resources/images/favicon.ico" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="${path}/resources/css/reservstyles.css" rel="stylesheet" />
<script type="text/javascript"
	src="${path}/resources/js/reservation/reservationinfo.js"></script>
</head>
<title>Insert title here</title>
</head>
<body>



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
	<!-- Sidebar-->
	<div class="d-flex" id="wrapper">
		<div class="border-end bg-white" id="sidebar-wrapper">
			<%@ include file="../sidebar.jsp"%>
		</div>


		<div id="content00">
			<div id="sh_content_title">
				<p>
					<b>객실안내</b><br>
				</p>
			</div>
			<%-- ${roomNroomfile} --%>
			<c:forEach var="list" items="${roomNroomfile}">
				<div class="room_list">
					<div class="room_gall">
						<div class="room_img">
								<a href="${path}/Reservation/roominfo?room_idx=${list.ROOM_IDX}">
								<img src="${path}/resources/images/${list.ROOMFILE_FILENAME}" alt=""
								style="width: 100%; max-width: 379px; vertical-align: middle"
								title="">
								</a>
						</div>

						<div class="room_info">
							<p class="room_tit">
									<a href="${path}/Reservation/roominfo?room_idx=${list.ROOM_IDX}">
									<span class="chg_font_color"><br>${list.ROOM_NAME}${list.ROOM_IDX}</span>
									</a>
							</p>
							<p class="room_caption"></p>
							<ul class="room_cont">
								<li><span class="r_cont_tit">스타일 </span> - 커플룸</li>
								<li><span class="r_cont_tit">인원(최대)</span>
									${list.ROOM_PERSONNEL}명</li>
							</ul>
							<a class="go_room_btn chg_bg_color"
								href="${path}/Reservation/roominfo?room_idx=${list.ROOM_IDX}"> 
								<span class="go_room_btn">ROOM 자세히보기</span>
							</a>
					
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>

	<!-- Footer -->
	<%@ include file="../footer.jsp"%>


</body>
</html>