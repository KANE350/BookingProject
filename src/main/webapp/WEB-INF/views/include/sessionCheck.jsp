<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">

	//세션을 체크
	if(!'${sessionScope.member_id}'){
		alert('로그인 후 사용하세요');
		location.href='${path}/login';
	}	 

</script>