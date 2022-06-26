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
	<h2>커뮤니티</h2>
	<form action="${path}/comu/comulist">
		<select name="findkey">
			<option value="email" <c:out value="${page.findkey=='cboard_id'?'selected':''}"/>>유저ID</option>
			<option value="subject" <c:out value="${page.findkey=='cboard_title'?'selected':''}"/>>제목</option>
			<option value="content" <c:out value="${page.findkey=='cboard_content'?'selected':''}"/>>내용</option>
			<option value="subcon" <c:out value="${page.findkey=='subcon'?'selected':''}"/>>제목+내용</option>
		</select>
		<input type="text" name="findvalue" value=${page.findvalue}>
		<button class="btn btn-dark border border-white">조회</button>
	</form>
	
	<table border="1" class="table table-dark table-hover">
		<tr>
			<th>번호</th>
			<th>유저ID</th>
			<th>제목</th>
			<th>조회수</th>
			<th>좋아요</th>
			<th>등록일자</th>
			<th>수정일자</th>
		</tr>
		<c:forEach var="cboard" items="${cmlist}">
			<tr>
				<td>${cboard.cboard_idx}</td>
				<td>${cboard.cboard_id}</td>
				<td> <a href="${path}/comu/comudetail?cboard_idx=${cboard.cboard_idx}"> ${cboard.cboard_title} </a></td>
				<td>${cboard.cboard_views}</td>
				<td>${cboard.cboard_likes}</td>
				<td> <fmt:formatDate value="${cboard.cboard_regidate}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
				<td><fmt:formatDate value="${cboard.cboard_modidate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			</tr>
		</c:forEach>
	
	</table>
	
	
	<button onclick="location.href='${path}/comu/comuAdd'" class="btn btn-dark border border-white">추가</button>
	
	<hr>
	


<div class="divIndex" style="justify-content: center;">
	<c:if test="${page.startPage != 1}">
		<a href="${path}/comu/comulist?curPage=${page.startPage-1}">이전</a>
	</c:if>
	
	<c:forEach var="i" begin="${page.startPage}" end="${page.endPage}">
		<a href="${path}/comu/comulist?curPage=${i}">${i}</a> 
	</c:forEach>
	
	<c:if test="${page.endPage<page.totPage}">
		<a href="${path}/comu/comulist?curPage=${page.endPage+1}">다음</a>
	</c:if>
</div>	
</div>	
</body>
</html>