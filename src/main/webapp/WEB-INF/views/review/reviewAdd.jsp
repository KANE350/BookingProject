<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>리뷰 작성</h2>
	<form action="${path}/review/reviewAdd" method="post" enctype="multipart/form-data">
	
<table class="addtable table-dark table-hover">
			<tr>
				<th>방이름</th>
				<td> <select class="form-select" aria-label="Default select example" name="room_name">
  						<option selected>선택</option>
					  	<option value="one">One</option>
					  	<option value="two">Two</option>
					  	<option value="three">Three</option>
					 </select> 
				</td>
			</tr>
		
			<tr>
				<th>아이디</th>
				<td> <input type="text" name="board_id" class="inputarea"> </td>
			</tr>
			<tr>
				<th>제목</th>
				<td> <input type="text" name="board_title" class="inputarea"> </td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="board_content" rows="10" cols="50" class="textarea"></textarea></td>
			</tr>
			<tr>
				<th>파일 <br> <button onclick="fileAdd(event)" class="btn btn-dark border border-white">+</button> </th>
				<td> 
					<div id="divFiles">
						<input type="file" name="files"><br>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button class="btn btn-dark border border-white" >저장</button>
					<button class="btn btn-dark border border-white"  type="reset">취소</button>
				</td>
			</tr>
		</table>
	</form>
	
</body>
</html>