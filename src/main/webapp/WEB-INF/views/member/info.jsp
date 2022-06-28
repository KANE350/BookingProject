<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${path}/resources/js/info.js"></script>
</head>
<body>
	<div class="container">
		<%@ include file="../header.jsp"%>
		<h2>회원정보</h2>
		<form action="${path}/member/info" method="post" name="frmInfo">
			<table border="1">
				<tr>
					<th>이메일</th>
					<td><input type="text" name="member_id" readonly="readonly"
						value="${member.member_id}"></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="member_name"
						value="${member.member_name}"></td>
				</tr>
				<tr>
					<th>핸드폰번호</th>
					<td><input type="text" name="member_phone"
						value="${member.member_phone}"></td>
				</tr>
				<tr>
					<th>생일</th>
					<td><input type="date" name="member_birth"
						value="${member.member_birth}"></td>
				</tr>
				<tr>
					<th>등록일자</th>
					<td><fmt:formatDate value="${member.member_regidate}"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="button" onclick="modifyCheck(event)"
							class="btn btn-secondary btn-lg">저장</button>
						<button type="reset" class="btn btn-secondary btn-lg">취소</button> <a
						href="${path}/member/remove" id="aRemove" class="btn btn-danger btn-lg">회원탈퇴</a>
					</td>
				</tr>


			</table>
		</form>
		<!--부트스트랩-->
		<!-- Footer-->
		<footer class="py-5 bg-dark">
			<div class="container">
				<p class="m-0 text-center text-white">Copyright &copy; Your How
					about Geha</p>
			</div>
		</footer>
		<!-- Bootstrap core JS-->
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>



	</div>
</body>
</html>