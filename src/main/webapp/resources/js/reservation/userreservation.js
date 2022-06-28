/**
 * 
 */

function btnclick(path,e){
	e.preventDefault();
	var idx = [];
	alert('취소버튼 클릭');

	$("input[name=box]:checked").each(function(){
		var chk = $(this).val();
		idx.push(chk);
	})
	
	if(idx.length == 0){
		alert('취소 데이터를 선택해주세요.');
		return ;
	}
	console.log(idx);
	document.getElementById('frm_reserv').method ='post';
	document.getElementById('frm_reserv').action=path+'/reservation/userreservation?idx='+idx;
	document.getElementById('frm_reserv').submit();
	

	
	
	
	
	/*	$.ajax({
			url:path+'/Reservation/userreservation',   //데이터를 주고받을 파일 주소
			type:'post',   //post 방식으로 전송
			contentType : 'application/json',
			dataType:'json',
		//	data:aa,   //위의 변수에 담긴 데이터를 전송해준다.
			data:JSON.stringify(idx),   //위의 변수에 담긴 데이터를 전송해준다.
			//dataType:'text',   //html 파일 형식으로 값을 담아온다.
			success : function(value){   //파일 주고받기가 성공했을 경우. data 변수 안에 값을 담아온다.
				alert(value);//현재 화면 위 id="message" 영역 안에 data안에 담긴 html 코드를 넣어준다. 
				console.log('성공');
			},
			error : console.error
		
		});*/
	
}