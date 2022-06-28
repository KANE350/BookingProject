//회원가입 js


function joinCheck(e){
	e.preventDefault(); //기본
	const username = document.getElementById('username');
	const email = document.getElementById('email');
	const passwd = document.getElementById('passwd');
	const passwdConfirm = document.getElementById('passwdConfirm');
	const phone = document.getElementById('phone');
	console.log(username.value);
	console.log(email.value);
	console.log(passwd.value);
	console.log(passwdConfirm.value);
	console.log(phone.value);
	if (!username.value){
		alert('이름을 입력해주세요');
		username.focus();
		return ;
	}
	if (!email.value){
		alert('이메일을 입력해주세요');
		email.focus();
		return ;
	}
	if (!passwd.value){
		alert('비밀번호를 입력해주세요');
		passwd.focus();
		return ;
	}
	if (!passwdConfirm.value){
		alert('비밀번호 확인을 입력해주세요');
		passwdConfirm.focus();
		return ;
	}
	if (!phone.value){
		alert('핸드폰 번호를 입력해주세요');
		phone.focus();
		return ;
	}
	if (passwd.value !== passwdConfirm.value){
		alert('비밀번호가 일치하지 않습니다');
		passwdConfirm.focus();
		return ;
	}
	
	document.getElementById('frmJoin').submit();
	
	
	
	
	
	
	
}	