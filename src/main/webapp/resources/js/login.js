//로그인 버튼을 클릭했을 때
function loginCheck(e) {
	e.preventDefault();
	const email = document.getElementById('email');
	const passwd = document.getElementById('passwd');
	console.log(email);
	console.log(passwd);
	
	if(!email.value){
		email.focus();
		alert('이메일을 입력해 주세요')
		return;
	}
	if(!passwd.value){
		passwd.focus();
		alert('비밀번호를 입력해 주세요')
		return;
	}
		
	document.getElementById('frmLogin').submit();
}