<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>
<%@ include file="../include/sessionCheck.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 핸들바 탬플릿 cdn연결 -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.7/handlebars.min.js"></script>
<script type="text/javascript" src="${path}/resources/js/comuDetail.js"></script>
<script type="text/javascript" src="${path}/resources/js/comuReply.js"></script>
<!-- 댓글리스트 탬플릿 소스 -->

<script type="text/x-handlebars-template" id="template_source">
	{{#each . }}
	<div class='divReply' id='reply{{creply_idx}}' >
	 {{#levelSpace cr_relevel}}	 <!--헬퍼작성:levelSpace(헬퍼의 이름)-->
	  {{/levelSpace}}
	  	<div>
			<span style="display:none;">{{creply_idx}}</span>
			<span style="display:none;" id="cr_restep{{creply_idx}}">{{cr_restep}}</span> 
			<span style="display:none;" id="cr_relevel{{creply_idx}}">{{cr_relevel}}</span> <br>
			<div class='replyarea'>
			작성자: <span style-'color:black'> {{creply_id}}  </span>  <br>
			내용: <span> <pre id='content{{creply_idx}}'> {{creply_content}} </pre> </span><br>
			</div>
			<button class="reReplyAddShow" value="{{creply_idx}}">댓글추가</button>
			<button class="reReplyModify" value="{{creply_idx}}">수정</button>
			<button class="reReplyRemove" value="{{creply_idx}}">삭제</button>
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
	
	
	<table border="1" class="table table-dark table-hover">
		<tr>
			<th>번호</th>
			<td id="cboard_idx">${comuBoard.cboard_idx}</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${comuBoard.cboard_id}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${comuBoard.cboard_title}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${comuBoard.cboard_content}</td>
		</tr>
		
		<tr>
			<th>조회수</th>
			<td id='readcnt'>${comuBoard.cboard_views}</td>
		</tr>
		<tr>
			<th><i class="fas fa-thumbs-up" id="like"></i></th>
			<td id='likecnt'>${comuBoard.cboard_likes}</td>
		</tr>
		
		<tr>
			<th>등록일자</th>
			<td> <fmt:formatDate value="${comuBoard.cboard_regidate}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
		</tr>
		<tr>
			<th>수정일자</th>
			<td><fmt:formatDate value="${comuBoard.cboard_modidate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		</tr>
		<tr>
			<td colspan="2">
			 	<button onclick="location.href='${path}/comu/comuModify?cboard_idx=${comuBoard.cboard_idx}'" class="btn btn-dark border border-white" >수정</button>
			 	<button id="replyAddShow" class="btn btn-dark border border-white" >댓글</button>
			 	<button onclick="removeCheck('${path}',${comuBoard.cboard_idx})" class="btn btn-dark border border-white" >삭제</button>
			 	<button onclick="location.href='${path}/comu/comulist'" class="btn btn-dark border border-white" >리스트</button>
			</td>
		</tr>
	</table>
	
	<hr id="hr">
	
	<!-- 댓글추가 -->
	<div id='divReplyAdd'>
		<input type="text" value="0" id="cr_restep"> <!-- 부모의 restep -->
		<input type="text" value="0" id="cr_relevel"> <br> <!-- 부모의 relevel -->
		작성자: <input type="text" id="creply_id" class="replyarea"> <br>
		내용: <textarea rows="3" cols="25" id="creply_content" class="replyarea"></textarea>
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