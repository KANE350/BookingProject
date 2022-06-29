/**
 * 
 */
// 입금 확인 버튼 클릭
function confrimbtn(path,reserv_num){
	alert('확인되었습니다.');
	console.log('예약 번호 : '+reserv_num);
	

	document.getElementById('frmconfirm').method='post';
	document.getElementById('frmconfirm').action=path+'/room_management/room_confirm?reserv_num='+reserv_num;
	document.getElementById('frmconfirm').submit();
	
}

