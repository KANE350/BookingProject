<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>
<%@include file="../header.jsp"%>    
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
	<h2>커뮤니티 글 수정</h2>


	<form action="${path}/comu/comuModify" method="post" enctype="multipart/form-data">
		<table class="addtable table-dark table-hover" style="font-size: 12px , font-color: black">
			<tr>
				<th>번호</th>
				<td> <input type="text" name="cboard_idx" readonly="readonly" value="${cboard.cboard_idx}" > </td>
			</tr>
		
			<tr>
				<th>작성자</th>
				<td> <input type="text" name="cboard_id" value="${cboard.cboard_id}" > </td>
			</tr>
			<tr>
				<th>제목</th>
				<td> <input type="text" name="cboard_title" value="${cboard.cboard_title}" > </td>
			</tr>
			<tr>
				<th>내용</th>
				<td> <textarea name="cboard_content" rows="5" cols="25"  class="textarea" >${cboard.cboard_content}</textarea> </td>
			</tr>
		
			<tr>
				<td colspan="2" align="center">
					<button class="btn btn-dark border border-white">수정</button>
					<button class="btn btn-dark border border-white">취소</button>
				</td>
			</tr>
		</table>
	
	</form>
</body>
</html>