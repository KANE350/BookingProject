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
<script type="text/javascript" src="${path}/resources/js/reservation/reservation.js"> </script>
<body style="overflow: auto;">
	
	<%@ include file="../header.jsp" %>
	
	<div class="d-flex"  id="wrapper">
 	
	<!-- Sidebar-->
		<div class="border-end bg-white" id="sidebar-wrapper">
			<%@ include file="../sidebar.jsp"%>
		</div>

		<div id="calendar" style="width:600px;">
			<%@ include file="./calendar.jsp"%>
		</div>
		<div id="content">
			<div align="center">
				<form id="frm_reserv" action="${path}/reservation/reservation" method="post">
					
					<div class="dateselect">
						<span class="day">입실</span> <input type="date" class="startdate" name="re_startdate"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<span class="day">퇴실</span> <input type="date" class="enddate" name="re_enddate">
					</div>
				<%-- ${roomNroomfile} --%>
					<table class="roominfo">
						<thead>
							<tr>
								<td >선택</td>
								<td>이미지</td>
								<td >객실명</td>
								<!-- <td> 최대인원</td> -->
								
							</tr>
						</thead>
						<tbody>
							<c:forEach var="info" items="${roomNroomfile}">
								<tr>
									<td><input type="radio" name="room_idx" value="${info.room_idx}" ></td>
									<td id="imgtd">
										<img src="${path}/resources/images/${info.roomfile_filename}" width="150" height="50"></td>
									<td >${info.room_name}</td>
									
						
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="buttom-button">
					
					<button class="reservButton"  onclick="btnclick('${path}', event)">예약하기</button>
					</div>
				</form>
			</div>
		</div>
	</div>


</body>
<%@ include file="../footer.jsp"%>
</html>