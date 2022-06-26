//회원탈퇴 js

function removeCheck(e, path){
	e.preventDefault();
	if(!confirm('정말로 탈퇴하시겠습니까?'))return;
	
	location.href =`${path}/member/removeCheck`;	
}