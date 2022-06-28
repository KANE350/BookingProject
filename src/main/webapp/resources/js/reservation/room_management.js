/**
 * 
 */

window.addEventListener('load', ()=>{
	// 전체 리스트
	$('#selectAll').click(function(e){
		e.preventDefault();
		
		console.log('ajax');
		$.ajax({
			url : '/third/Allreserv',
			type : 'get',
			dataType : 'json', // 받을 데이터의 타입
			success : (data)=>{
				
				
				if(data.length == 0){
//					var h3 = document.createElement('h3');
//					var h3text = document.createTextNode('등록된 데이터가 없습니다.');
					
					console.log($('#output22'));
					
					$('#output22')[0].innerHTML ='<h3>등록된 데이터가 없습니다.</h3>';
					
					
				
				}else{
					const source = document.getElementById('template_source').innerHTML;
					// console.log(source);
					// 소스컴파일
					const template = Handlebars.compile(source);
					// 컴파일된 데이터를 div넣기
					document.getElementById('output22').innerHTML= template(data);
				}
			},
			error : console.error
			
		});

		
	});
	
	
	
	
});
