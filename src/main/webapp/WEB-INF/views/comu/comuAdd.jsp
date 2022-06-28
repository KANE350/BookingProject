<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ include file="../include/includeFile.jsp" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<link href="${path}/resources/css/boardstyle.css" rel="stylesheet" />

</head>
<body>
	

<h2>커뮤니티</h2>
	<form action="${path}/comu/comuAdd" method="post" enctype="multipart/form-data">
		<table class="addtable table-dark table-hover">
			<tr>
				<th>아이디</th>
				<td> <input type="text" name=cboard_id class="inputarea"> </td>
			</tr>
			<tr>
				<th>제목</th>
				<td> <input type="text" name="cboard_title" class="inputarea"> </td>
			</tr>
			<tr>
				<th>내용</th>
				<td> <textarea name="cboard_content" rows="5" cols="25" class="textarea"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button class="btn btn-dark border border-white" >저장</button>
					<button type="reset" class="btn btn-dark border border-white">취소</button>
				</td>
			</tr>
		</table>
	
	</form>
</body>
</html>