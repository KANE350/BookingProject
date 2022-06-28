<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Heroic Features - Start Bootstrap Template</title>
<style>
#wrapper {
	width: 600px;
	margin: 0 auto;
}
</style>



<!-- Bootstrap icons-->
<link rel="icon" type="image/x-icon"
	href="${path}/resources/images/favicon.ico" />
<script type="text/javascript"
	src="${path}/resources/js/reservation/roominfo.js"></script>

</head>
<body>
	<%@ include file="../header.jsp"%>

	<div id="wrapper">
		<div class="bxslider">
			<div>
				<img src="${path}/resources/images/jeju2.jpg">
			</div>
			<div>
				<img src="${path}/resources/images/bed.jpg">
			</div>
			<div>
				<img src="${path}/resources/images/bathroom.jpg">
			</div>
			<div>
				<img src="${path}/resources/images/jeju1.jpg">
			</div>
			<div>
				<img src="${path}/resources/images/bbq.jpg">
			</div>
		</div>
	</div>

    <div style =' font-size : 20px ;' >
	<p class="fs-5 mb-4" style="text-align: center;">
	유채꽃 향기 가득한 제주, 그리고 저희 게하어때에 오신 여러분 환영합니다. 저희는 코로나 확산 방지를 위해 <br>
	위생소독을 1일 1회 실천하고 있으며, 연박 손님의 경우에는 매일 아침 문 앞에 새 수건을 놓아드립니다.<br>
	 바베큐가 필요한 분들께서는 장을 보신 후 입실 시 말씀하시면 불을 피워 드립니다.<br>
	  불편이 있으시면 언제든 직원에게 문의부탁드립니다.
	  <br> 입실 시간은 15:00분, 퇴실시간은 오전 11:00 입니다.
	</p>
	</div>
	
</body>
</html>