/**
 * 
 */


$(document).ready(function() {
	let date = new Date();
	// 년도 getFullYear()
	let year = date.getFullYear().toString();
	// 월 getMonth() (0~11로 1월이 0으로 표현되기 때문에 + 1을 해주어야 원하는 월을 구할 수 있다.)
	let month = date.getMonth() + 1
	month = month < 10 ? '0' + month.toString() : month.toString();
	// 일 getDate()
	let day = date.getDate(); // 일
	day = day < 10 ? '0' + day.toString() : day.toString();
	const now = year + '-' + month + '-' + day;
	console.log('today' + now);
	
	$('.startdate').change(function() {
		var start = $('.startdate').val();
		if (start < now) {
			alert('다시 선택해주세요.');
			location.reload();
			$('.startdate').focus();
			return;
		}
		console.log('선택된 시작 날짜 '+start);


	$('.enddate').change(function() {
		// 오늘 날짜보다 커야하고 시작 날짜보다 커야함
		var end = $('.enddate').val();
		console.log('start : ' + start + '\n' + 'end' + end + '\n' + now);
		if (end < start || end < now) {
			alert('다시 선택해주세요.');
			location.reload();
			$('.enddate').focus();
			return;
		}
		console.log('선택된 퇴실 날짜 '+end);
	});
});
});
	
	function btnclick(path, e) {
		
		e.preventDefault();
		
		var start = $('.startdate').val();
		var end = $('.enddate').val();
		
		if(start=='' || end==''){
			alert('입실 퇴실 날짜를 선택해주세요.');
			return ;
		}
		console.log('시작날짜' + $('.startdate').val());
		console.log('종료날짜' + $('.enddate').val());
		console.log('방정보' + $('.roominfo').val());

	
	
		
		
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
			// alert('tr : '+tr.text());
			// td.eq(0)은 체크박스 이므로 td.eq(1)의 값부터 가져온다.

			var roominfo = td.eq(2).text();
			// var person = td.eq(3).options[target.selectedIndex].value;
			var person = td.eq(3).text();

			

			// 가져온 값을 배열에 담는다.

			tdArr.push(roominfo);
			// tdArr.push(person);

			console.log("roominfo : " + roominfo);

			document.getElementById('frm_reserv').method = 'post';
			//document.getElementById('frm_reserv').action = path+'/Reservation/updatereservation?roominfo=' + roominfo;
			document.getElementById('frm_reserv').action = path+'/reservation/updatereservation';
			document.getElementById('frm_reserv').submit();
		});
	}

