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
<div class="p-3 mb-2 bg-secondary text-black">
	<h2>리뷰 게시판</h2>
		<form action="${path}/review/reviewlist">
		
		<div class="">
		<select name="findkey">
			<option value="email" <c:out value="${page.findkey=='board_id'?'selected':''}"/>>유저ID</option>
			<option value="subject" <c:out value="${page.findkey=='board_title'?'selected':''}"/>>제목</option>
			<option value="content" <c:out value="${page.findkey=='board_content'?'selected':''}"/>>내용</option>
			<option value="subcon" <c:out value="${page.findkey=='subcon'?'selected':''}"/>>제목+내용</option>
		</select>
		</div>
		<input type="text" name="findvalue" value=${page.findvalue}>
		<button class="btn btn-dark">조회</button>
	</form>
	<section class="article-list">
	
	<table border="1" class="table table-dark table-hover">  
		
			<tr>
				
				<th>번호</th>
				<th>방이름</th>
				<th>유저ID</th>
				<th>제목</th>
				<th>조회수</th>
				<th>좋아요</th>
				<th>등록일자</th>
				<th>수정일자</th>
			</tr>
		
		
		
		
		<c:forEach var="board" items="${rvlist}">
			<tr>
				<td>${board.board_idx}</td>
				<td>${board.room_name}</td>
				<td>${board.board_id}</td>
				<td> <a href="${path}/review/reviewdetail?board_idx=${board.board_idx}"> ${board.board_title} </a></td>
				<td>${board.board_views}</td>
				<td>${board.board_likes}</td>
				<td> <fmt:formatDate value="${board.board_regidate}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
				<td><fmt:formatDate value="${board.board_modidate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			</tr>
		</c:forEach>
		
	</table>
	</section>
	
	<button  class="btn btn-dark border border-white" onclick="location.href='${path}/review/reviewAdd'">추가</button>
	
	<hr>
	


	<div class="divIndex" style="justify-content: center;">
	<c:if test="${page.startPage != 1}">
		<a href="${path}/review/reviewlist?curPage=${page.startPage-1}">이전</a>
	</c:if>
	
	<c:forEach var="i" begin="${page.startPage}" end="${page.endPage}">
		<a href="${path}/review/reviewlist?curPage=${i}" style="color: white; font-size: 2.0em; font-weight: bold; background: dark;"> &nbsp; ${i} &nbsp;</a>
	</c:forEach>
	
	<c:if test="${page.endPage<page.totPage}">
		<a href="${path}/review/reviewlist?curPage=${page.endPage+1}">다음</a>
	</c:if>
	</div>
</div>	
</body>
</html>