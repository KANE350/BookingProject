<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>


<!-- 제이쿼리 연결 -->
<!-- 슬라이드 --> 
<!-- <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script> -->
<script src ="${path}/resources/js/jquery-3.6.0.js"></script>


<!-- 부트스트랩 연결 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<!-- Core theme JS-->
<script src="${path}/resources/js/scripts.js"></script>
<!-- css -->
<%-- <link href="${path}/resources/css/styles.css" rel="stylesheet" /> --%>
<link href="${path}/resources/css/reservstyles.css" rel="stylesheet" />

<script>
	//값이 있으면 true / 없으면 false
	if ('${msg}')
		alert('${msg}');

</script>