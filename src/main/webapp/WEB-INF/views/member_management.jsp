<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./include/includeFile.jsp" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@ include file="header.jsp" %>
	<h2>회원관리 창</h2>
		<%-- ${mlist} --%>
	
	<table>
		<thead>
			<tr>
				<td>아이디</td>
				<td>이름</td>
				<td>PHONE</td>
				<td>생일</td>
				<td>가입일자</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach  var="list" items="${mlist}">
				<tr>
					<td>${list.member_id}</td>
					<td>${list.member_name}</td>
					<td>${list.member_phone}</td>
					<td>${list.member_birth}</td>
					<td>${list.member_regidate}</td>
				</tr>
				
			</c:forEach>
		</tbody>
	
	</table>
</body>
</html>