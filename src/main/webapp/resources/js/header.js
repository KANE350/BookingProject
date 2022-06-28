//헤더

//document가 준비되었을 때

	//로그아웃을 클릭했을 때
function aLogout(e, path) {
	e.preventDefault();//기본이벤트 제거
	if (confirm('로그아웃하시겠습니까?')) {
		location.href = path +'/logout';

	}
}
	

	const sessionMember_id = $('#sessionMember_id').text().trim();

	if (sessionMember_id == '') {//로그인 전
		document.getElementById("aLogin").style.display = '';
		document.getElementById("aLogout").style.display = 'none';
		document.getElementById("aJoin").style.display = '';
	} else {//로그인 후
		document.getElementById("aLogin").style.display = 'none';
		document.getElementById("aLogout").style.display = '';
		document.getElementById("aJoin").style.display = 'none';
	}




