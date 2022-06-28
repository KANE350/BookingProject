/**
 * 
 */
$(function() {
	let date = new Date();
	// 년도 getFullYear()
	let year = date.getFullYear().toString(); 
	// 월 getMonth() (0~11로 1월이 0으로 표현되기 때문에 + 1을 해주어야 원하는 월을 구할 수 있다.)
	let month = date.getMonth() + 1
	month = month <10 ? '0'+month.toString() : month.toString();
	// 일 getDate()
	let day = date.getDate(); // 일
	day = day < 10 ? '0'+day.toString() : day.toString();
	const now= year+'-'+month+'-'+day;
	console.log('today'+now);
	
	
	
	

	$('.roominfo').hide();
	$('.reservButton').hide();

	$('.startdate').change(function() {
		const start = $('.startdate').val();
		if(start < now){
			alert('다시 선택해주세요.');
			location.reload();
			$('.startdate').focus();
			return ;
		}
		
		$('.enddate').change(function(){
			//오늘 날짜보다 커야하고 시작 날짜보다 커야함
			const end = $('.enddate').val();
			console.log('start : ' + start+'\n'+'end'+end+'\n'+now);
			if(end < start || end < now){
				alert('다시 선택해주세요.');
				location.reload();
				$('.enddate').focus();
				return ;	
			}
			
			$('.roominfo').show();
			$('.reservButton').show();
		});
		
	});

});



//윈도우가 로딩이 완료된 후

	

function btnclick(path, event){

	event.preventDefault();
	
	if($('.enddate').val() == ''){
		
		alert('퇴실날짜 입력해주세요');
		$('.enddate').focus();
		return ;
	}
	
	
	
	// 상단 선택버튼 클릭시 체크된 Row의 값을 가져온다.
 
		
		var rowData = new Array();
		var tdArr = new Array();
		var checkbox = $("input[name=room_idx]:checked");
		
		// 체크된 체크박스 값을 가져온다
		checkbox.each(function(i) {

			// checkbox.parent() : checkbox의 부모는 <td>이다.
			// checkbox.parent().parent() : <td>의 부모이므로 <tr>이다.
			var tr = checkbox.parent().parent().eq(i);
			var td = tr.children();
			
			// 체크된 row의 모든 값을 배열에 담는다.
			rowData.push(tr.text());
			//alert('tr : '+tr.text());
			// td.eq(0)은 체크박스 이므로  td.eq(1)의 값부터 가져온다.
		
		
			var roominfo = td.eq(2).text();
			//var person = td.eq(3).options[target.selectedIndex].value;
			var person = td.eq(3).text();
		
			
			
			
					
			

			
			tdArr.push(roominfo);

			
			console.log("roominfo : " + roominfo);

			document.getElementById('frm_reserv').method='post';

			document.getElementById('frm_reserv').action=path+'/reservation/reservation';
			document.getElementById('frm_reserv').submit();
			
		
		});
		
		

	
}


	
