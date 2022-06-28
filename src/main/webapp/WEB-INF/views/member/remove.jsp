<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${path}/resources/js/remove.js"></script>
<link rel="stylesheet" type="text/css" href="${path}/resources/css/remove.css">
</head>
<body>
	<%@ include file="../header.jsp"%>
     <img id="cen_img" src="${path}/resources/images/travel.jpg">
    <div style =' font-size : 20px ;' >
	<p style="text-align: center;">
		게하어때를 방문해주신 고객님. 감사드립니다. <br>아직 고객님을 위한 서비스들이 많이 준비되어 있습니다. 
		<br>그럼에도 불구하고 떠나시겠습니까? <br> <br>
		<button type="button" onclick="removeCheck(event, '${path}')"
			class="btn btn-danger btn-lg">탈퇴</button>
	</p>
	</div>

	<!--부트스트랩-->
	<!-- Footer-->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; Your How
				about Geha</p>
		</div>
	</footer>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>




</body>
</html>