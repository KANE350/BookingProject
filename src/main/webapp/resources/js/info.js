//마이페이지 js

function modifyCheck(e){
	e.preventDefault();
	if(!confirm('수정 하시겠습니까?'))return;
	
	frmInfo.submit();	
}

