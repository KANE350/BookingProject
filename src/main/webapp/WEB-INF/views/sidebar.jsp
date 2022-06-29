<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sidebar</title>
</head>
<body>
	<!-- Sidebar-->
	
		
			<div class="list-group list-group-flush">
				
				<a class="list-group-item list-group-item-action list-group-item-Light p-3"	href="${path}/reservation/info">기본정보</a> 
				<a class="list-group-item list-group-item-action list-group-item-light p-3" href="${path}/reservation/reservationinfo">객실안내</a> 
				<a class="list-group-item list-group-item-action list-group-item-light p-3"	href="${path}/reservation/reservation">실시간예약</a>
			
				 <c:if test="${!empty sessionScope.member_id}">
				<a class="list-group-item list-group-item-action list-group-item-light p-3"	href="${path}/reservation/userreservation">예약정보</a> 
				</c:if>
			</div>
			
			
	
</body>
</html>