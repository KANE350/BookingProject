//회원가입 js

function goPopup(path){
	// 주소검색을 수행할 팝업 페이지를 호출합니다.
	// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
	var pop = window.open(path+"/member/jusoPopup","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
}
//주소팝업 호출후 실행할 함수
function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn,detBdNmList,bdNm,bdKdcd,siNm,sggNm,emdNm,liNm,rn,udrtYn,buldMnnm,buldSlno,mtYn,lnbrMnnm,lnbrSlno,emdNo){
	// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
	document.frmJoin.addrload.value = roadAddrPart1;
	document.frmJoin.addrdetail.value = addrDetail;
	document.frmJoin.zipcode.value = zipNo;

}



function joinCheck(e) {
	
	e.preventDefault(); //기본
	
	const email = document.getElementById('email');
	const passwd = document.getElementById('passwd');
	const passwdConfirm = document.getElementById('passwdConfirm');
	console.log(email.value);
	console.log(passwd.value);
	console.log(passwdConfirm.value);
	if (!email.value){
		alert('이메일을 입력해주세요!');
		email.focus();
		return ;
	}
	if (!passwd.value){
		alert('비밀번호를 입력해주세요!');
		passwd.focus();
		return ;
	}
	if (!passwdConfirm.value){
		alert('비밀번호 확인을 입력해주세요!');
		passwdConfirm.focus();
		return ;
	}
	if (passwd.value !== passwdConfirm.value){
		alert('비밀번호가 일치하지 않습니다!');
		passwdConfirm.focus();
		return ;
	}
	document.getElementById('frmJoin').submit();
	
}	
