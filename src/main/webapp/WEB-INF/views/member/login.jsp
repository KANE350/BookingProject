<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%-- <script type="text/javascript" src="${path}/resources/js/header.js"></script> --%>
</head>
<body>
		<%@ include file="../header.jsp"%>
		<h2>로그인</h2>
		<form id="frmLogin" action="${path}/login" method="post">
			<table>
				<tr>
					<th>이메일</th>
					<td><input type="email" name="email" id="email"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="passwd" id="passwd">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button class="btn btn-primary" id="btnLogin">로그인</button>
						<button type="reset">취소</button> <a href="${apiURL}"><img
							alt="" src="${path}/resources/images/naver.png" width="100"></a>
					</td>
				</tr>
			</table>
		</form>

	<!--부트스트랩-->
	<!-- Footer-->
	<footer class="py-5 bg-dark">
			<p class="m-0 text-center text-white">Copyright &copy; Your How
				about Geha</p>
	</footer>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>



</body>
</html>