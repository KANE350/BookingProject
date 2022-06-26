<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>
<%@include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>리뷰수정</h2>


	<form action="${path}/review/reviewModify" method="post" enctype="multipart/form-data">
		<table class="addtable table-dark table-hover" style="font-size: 12px , font-color: black">
			<tr>
				<th>번호</th>
				<td> <input type="text" name="board_idx" readonly="readonly" value="${rboard.board_idx}" > </td>
			</tr>
		
			<tr>
				<th>작성자</th>
				<td> <input type="text" name="board_id" value="${rboard.board_id}" > </td>
			</tr>
			<tr>
				<th>제목</th>
				<td> <input type="text" name="board_title" value="${rboard.board_title}" > </td>
			</tr>
			<tr>
				<th>내용</th>
				<td> <textarea name="board_content" rows="5" cols="25"  class="textarea" >${rboard.board_content}</textarea> </td>
			</tr>
			<tr>
				<th>파일 <br> <button onclick="fileAdd(event)" class="btn btn-dark border border-white">+</button> </th>
				<td> 
					<!-- 기존파일리스트 -->
					<c:forEach var="boardFile" items="${reviewFile}">
						 ${boardFile.rf_filename} <input type="checkbox" name="removeFiles" value="${boardFile.rf_idx}">삭제
					</c:forEach>
				
					<div id="divFiles">
						<input type="file" name="files"><br>
					</div>
				</td>
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