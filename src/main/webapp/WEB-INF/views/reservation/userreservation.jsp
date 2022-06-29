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

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript"
	src="${path}/resources/js/reservation/userreservation.js">
	
</script>

<body>
	
	<%@ include file="../header.jsp" %>
	<!-- Sidebar-->
	<div class="d-inline-flex" id="wrapper">
		<div class="room_gall" id="sidebar-wrapper">
			<%@ include file="../sidebar.jsp"%>
		</div>


	




		<%-- ${rlist} --%>
		<div class="modi" align="center">
		<div>	
		<h3 align="center">내 예약정보 리스트</h3>
		</div>
			<c:if test="${not empty rlist}">
				<form id="frm_reserv" action = "${path}/reservation/usereservation" method="post">
					<table class="statustb">
						<thead>
							<tr>
								<th>선택</th>
								<th>예약번호</th>
								<th>예약상태</th>
								<th>체크인 / 아웃</th>
								<th>객실명</th>
	
							</tr>
						</thead>
						<tbody>
							<c:forEach var="list" items="${rlist}">
								<tr>
									<td>
										<input type="checkbox" id="box" name="box" value="${list.RESERVATION_IDX}">
									</td>
									<td>
										<a id="modify_reservation" href="${path}/reservation/updatereservation?idx=${list.RESERVATION_IDX}">${list.RESERVATION_IDX}</a>
									</td>
									<td>
									<!-- 예약완료 -->
										
											<c:if test="${list.RE_STATUS eq 'y'}">
												<button type="button" onclick="return false;" class="statusbtn">예약 확정</button>
											</c:if>
											<!-- 가예약 -->
											<c:if test="${list.RE_STATUS ne 'y'}">
												<h3 style="color: green;">관리자 확인중</h3>
											</c:if>
									
									</td>
									<td>
										${list.RE_STARTDATE}<br>${list.RE_ENDDATE}
									</td>
									<td>
										${list.ROOM_NAME}
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<br>
					<%-- <button class="btnclick" onclick="btnclick('${path}','<%=sessionv%>')">예약 취소</button> --%>
					<button class="btnclick" onclick="btnclick('${path}', event)">예약 취소</button>
				</form>
			</c:if>
			<c:if test="${empty rlist}">
				<div align="center" style="font-size: 12px">예약된 정보가 없습니다.</div>
			</c:if>
		</div>
	</div>
</body>
</html>