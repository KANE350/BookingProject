<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./include/includeFile.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>테스트</title>
<link href="${path}/resources/css/reservstyles.css" rel="stylesheet" />
</head>
<script src="${path}/resources/js/jquery-3.6.0.js"></script>
<script
	src="${path}/resources/js/reservation/room_confirm_management.js"></script>

<body>
	<%@ include file="./header.jsp"%>
	<div id="show">
	<c:if test="${not empty confirm}">
		<form id="frmconfirm" method="post" action="">
			<table id="confirmtbl">
				<thead>
					<tr>
						<th>예약 번호</th>
						<th>객실 명</th>
						<th>아이디</th>
						<th>입실/퇴실</th>
						<th>입금확인</th>
					<tr>
				</thead>
				<c:forEach var="confirm" items="${confirm}">
					<tbody>
						<tr>
	

							<td>${confirm.RESERVATION_IDX}</td>
							<td>${confirm.ROOM_NAME}</td>
							<td>${confirm.MEMBER_ID}</td>
							<td>${confirm.RE_STARTDATE}<br>${confirm.RE_ENDDATE}</td>
							<td><button id="confrimbtn1" type="button"
									onclick="confrimbtn('${path}','${confirm.RESERVATION_IDX}')">확인</button></td>
						</tr>
					</tbody>

				</c:forEach>
			</table>
		</form>
		</c:if>
		<c:if test="${empty confirm}">
			<h3> 예정된 예약이없습니다.</h3>
		</c:if>
	</div>


</body>
</html>