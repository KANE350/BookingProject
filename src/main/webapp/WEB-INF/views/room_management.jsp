<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./include/includeFile.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>테스트</title>
<%-- <link href="${path}/resources/css/reservstyles.css" rel="stylesheet" /> --%>
</head>
<script src="${path}/resources/js/jquery-3.6.0.js"></script>
<script type="text/javascript"
	src="${path}/resources/js/reservation/room_management.js"></script>
<!-- 핸들마 탬플릿 cdn연결 -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.7/handlebars.min.js"></script>
<script type="text/x-handlebars-template" id="template_source">
	<h3>전체 예약 현황</h3>
	{{#each .}}
		
		<table id="roomtbl">
   			<thead> 
       		 	 <th>예약 번호</th> 
      			 <th>예약 상태</th> 
       			 <th>객실 명</th>
   				 <th>아이디</th>
   				 <th>입실 / 퇴실</th>
   				  
  			</thead> 
   			 <tbody> 
       			<tr> 
           			<td>{{RESERVATION_IDX}}</td> 
           			<td>{{RE_STATUS}}</td>
					<td>{{ROOM_NAME}}</td> 
            		<td>{{MEMBER_ID}}</td>
					<td>{{RE_STARTDATE}}<br>{{RE_ENDDATE}}</td>

        		</tr> 
   			 </tbody> 
		</table>
	{{/each}}
</script>
<script type="text/x-handlebars-template" id="template_source2">
	
	{{#each .}}
		
		<table id="roomtbl">
   			<thead> 

       		 	 <th>예약 번호</th> 
      			 <th>예약 상태</th> 
       			 <th>객실 명</th>
   				 <th>아이디</th>
   				 <th>입실 / 퇴실</th>
				 <th>입금확인</th>
   				  
  			</thead> 
   			 <tbody> 
       			<tr> 

           			<td>{{RESERVATION_IDX}}</td> 
           			<td>{{RE_STATUS}}</td>
					<td>{{ROOM_NAME}}</td> 
            		<td>{{MEMBER_ID}}</td>
					<td>{{RE_STARTDATE}}<br>{{RE_ENDDATE}}</td>
					<td><button class="confirmbtn" id="confirmbtn" onclick="btnclick()" value="{{RESERVATION_IDX}}">입금확인</button></td>
        		</tr> 
   			 </tbody> 
		</table>
	{{/each}}
</script>
<body>
	<%@ include file="./header.jsp"%>



	<div class="d-flex">
		<div class="border-end bg-white" id="sidebar-wrapper">
			<div class="list-group list-group-flush" style="width: 150px;">

				<button id="selectAll"
					class="list-group-item list-group-item-action list-group-item-Light p-3">전체예약목록</button>
				
				<a id="confirm"
					class="list-group-item list-group-item-action list-group-item-light p-3" href="${path}/room_management/room_confirm">처리
				</a>
			</div>
		</div>




		

			<div id="output22" >
				
				<table id="boardList" border="1"></table>
			</div>

			

	</div>
</body>
</html>