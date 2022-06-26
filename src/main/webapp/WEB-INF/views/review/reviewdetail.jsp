<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>
<%@ include file="../include/sessionCheck.jsp" %>
<%@include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<!-- 핸들바 탬플릿 cdn연결 -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.7/handlebars.min.js"></script>
<script type="text/javascript" src="${path}/resources/js/reviewDetail.js"></script>
<script type="text/javascript" src="${path}/resources/js/reviewReply.js"></script>
<!-- 댓글리스트 탬플릿 소스 -->

<script type="text/x-handlebars-template" id="template_source">
	{{#each . }}
	<div class='divReply' id='reply{{reply_idx}}' >
	 {{#levelSpace relevel}}	 <!--헬퍼작성:levelSpace(헬퍼의 이름)-->
	  {{/levelSpace}}
	  	<div>
			<span style="display:none;">{{reply_idx}}</span>
			<span style="display:none;" id="restep{{reply_idx}}">{{restep}}</span> 
			<span style="display:none;" id="relevel{{reply_idx}}">{{relevel}}</span> <br>

			작성자: <span> {{reply_id}}  </span>  <br>
			내용: <span> <pre id='content{{reply_idx}}'> {{reply_content}} </pre> </span><br>
			<button class="reReplyAddShow" value="{{reply_idx}}">댓글추가</button>
			<button class="reReplyModify" value="{{reply_idx}}">수정</button>
			<button class="reReplyRemove" value="{{reply_idx}}">삭제</button>
		</div>
	</div>
	<hr>
	{{/each}}
</script>




</head>
<body>
<div class="p-3 mb-2 bg-secondary text-white">
<div class="container">
	<h2>상세조회</h2>
	<%-- ${reviewBoard} --%>
	<%-- ${rflist} --%>
	<table border="1" class="table table-dark table-hover">
		<tr>
			<th>번호</th>
			<td id="board_idx">${reviewBoard.board_idx}</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${reviewBoard.board_id}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${reviewBoard.board_title}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${reviewBoard.board_content}</td>
		</tr>
		<tr>
			<th>사진</th>
			<td>
				<c:forEach var="boardfile" items="${rflist}">
					
					<img alt="" src="${path}/savedir/${boardfile.rf_filename}">
					
				</c:forEach>
			</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td id='readcnt'>${reviewBoard.board_views}</td>
		</tr>
		<tr>
			<th><i class="fas fa-thumbs-up" id="like"></i></th>
			<td id='likecnt'>${reviewBoard.board_likes}</td>
		</tr>
		
		<tr>
			<th>등록일자</th>
			<td> <fmt:formatDate value="${reviewBoard.board_regidate}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
		</tr>
		<tr>
			<th>수정일자</th>
			<td><fmt:formatDate value="${reviewBoard.board_modidate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		</tr>
		<tr>
			<td colspan="2">
			 	<button onclick="location.href='${path}/review/reviewModify?board_idx=${reviewBoard.board_idx}'" class="btn btn-dark" >수정</button>
			 	<button id="replyAddShow" class="btn btn-dark" >댓글</button>
			 	<button onclick="removeCheck('${path}',${reviewBoard.board_idx})" class="btn btn-dark" >삭제</button>
			 	<button onclick="location.href='${path}/review/reviewlist'" class="btn btn-dark" >리스트</button>
			</td>
		</tr>
	</table>
	
	<hr id="hr">
	
	<!-- 댓글추가 -->
	<div id='divReplyAdd'>
		<input type="text" value="0" id="restep"> <!-- 부모의 restep -->
		<input type="text" value="0" id="relevel"> <br> <!-- 부모의 relevel -->
		작성자: <input type="text" id="reply_id"> <br>
		내용: <textarea rows="3" cols="25" id="reply_content"></textarea>
		<button id="replyAdd" class="btn btn-dark border border-white" >저장</button>
		<button id="replyCancel" class="btn btn-dark border border-white" >취소</button>
	</div>
	
	<!-- 댓글수정 -->
	<div id='divReplyModify'>
		<input type="hidden" id="replyrnumModify"> <br>
		내용: <textarea rows="3" cols="25" id="replycontentModify"></textarea><br>
		<button id="replyModify" class="btn btn-dark border border-white" >저장</button>
		<button id="replyModifyCancel" class="btn btn-dark border border-white" >취소</button>
	</div>
	

		<!-- 댓글리스트 -->
		<div id="divReplyList"></div>
</div>
</div>
</body>
</html>