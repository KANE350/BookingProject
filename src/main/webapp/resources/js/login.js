$(function(){

	


	
	//로그인버튼을 클릭했을때
	$('#btnLogin').click(e=>{
		e.preventDefault();
		const email = $('#email')
		const passwd = $('#passwd')
		
		if (!email.val()) {
			alert('이메일을 입력해주세요!');
			email.focus();
			return ;
		}
		if (!passwd.val()) {
			alert('비밀번호를 입력해주세요!');
			passwd.focus();
			return ;
		}
		$('#frmLogin').submit();
	});
});








