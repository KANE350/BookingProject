<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./include/includeFile.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${path}/resources/js/header.js"></script>
</head>
<body>
<div class="container">
	<%@ include file="header.jsp" %>
	<h2>로그인</h2>
	<form id="frmLogin" action="${path}/login" method="post">
		<table>
			<tr>
				<th>이메일</th>
				<td><input type="email" name="member_id" id="email"> </td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="member_pw" id="passwd"> </td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button class="btn btn-primary" id="btnLogin">로그인</button>
					<button class="btn btn-primary" type="reset" >취소</button>
					<a href="${apiURL}"><img alt="" src="${path}/resources/images/naver.png" width="100"></a> 					
				 </td>
			</tr>
		</table>
	</form>
</div>	
</body>
</html>