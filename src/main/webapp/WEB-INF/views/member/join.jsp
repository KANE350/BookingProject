<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${path}/resources/js/memberJoin.js"></script>
</head>
<body>
	<div class="container">
		<%@ include file="../header.jsp"%>
		<h2>회원가입</h2>
		<form name="frmJoin" id="frmJoin" action="${path}/member/join"
			method="post">
			<table>
				<tr>
					<th>이름</th>
					<td><input type="text" name="member_name" id="username">
					</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="email" name="member_id" id="email">
						<input type="checkbox" id="chkEmail"> 
						<button type="button" onclick="emailCheck(event, '${path}')">중복체크</button>
					</td>
					
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="member_pw" id="passwd">
					</td>
				</tr>
				<tr>
					<th>비밀번호 확인</th>
					<td><input type="password" id="passwdConfirm"></td>
				</tr>

				<tr>
					<th>연락처</th>
					<td><input type="tel" name="member_phone" id="phone">
					</td>
				</tr>

				<tr>
					<th>생일</th>
					<td><input type="date" name="member_birth" id="date">
					</td>
				</tr>


				<tr>
					<td colspan="2" align="center">
						<button type="button" onclick="joinCheck(event)"
							class="btn btn-secondary btn-lg">가입</button>
						<button type="reset" class="btn btn-secondary btn-lg">취소</button>
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