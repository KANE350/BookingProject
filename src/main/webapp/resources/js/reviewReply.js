/*게시물 댓글*/

	


//윈도우가 로딩이 완료된 후
window.addEventListener('load',()=>{
	
	
	
	//핸들바에서 사용: 헬퍼만들기
	Handlebars.registerHelper('levelSpace',function(relevel){
		let result = '';
		for(var i=0;i<relevel;i++)
			result += '<div class ="divSpace"></div>';
		return result;
		
	});	
	
	//댓글창 초기화
	const replyInit = ()=>{
		
			//입력된 내용 지우기
			document.getElementById('reply_id').value='';
			document.getElementById('reply_content').value='';
			
			//댓글추가 div 이동
			const hr = document.getElementById(`hr`);
			const divReplyAdd = document.getElementById('divReplyAdd');
			hr.after(divReplyAdd);
			//댓글추가창 숨기기
			divReplyAdd.style.display = 'none'; 
			
			
			//댓글수정 div 이동
			
			const divReplyModify = document.getElementById('divReplyModify');
			hr.after(divReplyModify);
			
			//댓글 수정창 숨기기
			divReplyModify.style.display = 'none';
	};
	
	//댓글의 리스트
	const replyList = ()=>{
		
		replyInit(); // 댓글창 초기화
		
		const board_idx = document.getElementById('board_idx').innerText;
		
		//ajax 서버 호출
		fetch(`/third/reply/list/${board_idx}`)
		.then(res=>res.json())
		.then(data=>{
			console.log(data);
			
			/*탬플리 소스 가져오기*/
			const source = document.getElementById('template_source')
				.innerHTML;
			console.log(source);
			//소스 컴파일
			const template = Handlebars.compile(source);
			
			console.log(document.getElementById('divReplyList'));
			//컴파일 된 데이터를 div에 넣기
			document.getElementById('divReplyList')
			.innerHTML = template(data);
		})
		.catch(console.err);
	};
	
	replyList(); //댓글의 리스트 출력 함수 호출
	
	
	//게시물의 댓글 버튼을 클릭했을 때
	document.getElementById('replyAddShow').addEventListener('click',()=>{
		//부모의 restep,relevel
		document.getElementById('restep').value=0;
		document.getElementById('relevel').value=0;
		
		
		replyInit(); //초기화
		
		
		//댓글추가 div 보이기
		document.getElementById('divReplyAdd').style.display = '';
	});
	
	//댓글추가창에서 취소버튼을 클릭했을때
	document.getElementById('replyCancel').addEventListener('click',()=>{
		//댓글추가 창 숨기기
		document.getElementById('divReplyAdd').style.display = 'none';
	});
	
	//부모를 선택하고 자식엘리먼트에 이벤트 달기
	document.getElementById('divReplyList')
		.addEventListener('click',(e)=>{
		//댓글리스트의 댓글버튼을 클릭했을때
		
		if (e.target.classList.contains('reReplyAddShow')){
			//rnum,restep,relevel 가져오기
			const reply_idx = e.target.value;
			console.log(reply_idx);
			const restep = document.getElementById(`restep${reply_idx}`).innerText;
			//console.log(rnum);
			const relevel = document.getElementById(`relevel${reply_idx}`).innerText;
			//console.log(relevel);
			//부모의 step, relevel
			document.getElementById('restep').value=restep;
			document.getElementById('relevel').value=relevel;
			
			//댓글추가 div 이동
			const reply = document.getElementById(`reply${reply_idx}`);
			const divReplyAdd = document.getElementById('divReplyAdd');
			reply.after(divReplyAdd);
		
			//댓글추가 div 보이기
			divReplyAdd.style.display = '';
	
	}else if  (e.target.classList.contains('reReplyRemove')){
		const rnum = e.target.value;
		//ajax 서버 호출
			fetch(`/third/reply/${reply_idx}`,{
				method : 'delete' ,
			})
			.then(res=>res.text())
			.then(text=>{
				alert(text);
			})
			.catch(err=>console.log(err));
			replyList();
			
	}else if (e.target.classList.contains('reReplyModify')){
			//댓글리스트의 수정 버튼을 클릭했을때
			const reply_idx = e.target.value;
			
			
			//댓글수정 div 이동
			const reply = document.getElementById(`reply${reply_idx}`);
			
			const divReplyModify = document.getElementById('divReplyModify');
			reply.after(divReplyModify);
			
			//댓글 수정창 숨기기
			divReplyModify.style.display = '';
			
			//기존 rnum, content 읽기
			document.getElementById(`replyrnumModify`).value = reply_idx;
			const content = document.getElementById(`content${reply_idx}`).innerText;
			
			document.getElementById(`replycontentModify`).innerHTML = content;
			
		}			
	});
	
	
	
	//추가댓글의 추가버튼 클릭시
	document.getElementById('replyAdd').addEventListener('click',()=>{
		const board_idx = document.getElementById('board_idx').innerText;
		const reply_id = document.getElementById('reply_id').value;
		const reply_content = document.getElementById('reply_content').value;
		const restep = document.getElementById('restep').value; // 댓글의 순서
		const relevel = document.getElementById('relevel').value; // 댓글의 레벨
		
		console.log(board_idx);
		console.log(reply_id);
		console.log(reply_content);
		console.log(restep);
		console.log(relevel);
		
		//전송할 데이터
		const data ={
			board_idx,
			reply_id,
			reply_content,
			restep,
			relevel,
		};
		
		fetch('/third/reply/' , {
			method : 'post',
			headers : {
				'Content-Type' : 'application/json' //json문자열 전송
			},
			body : JSON.stringify(data),//object->json문자열로 변경
		})
		.then(res=>res.text())
		.then(text =>{
			console.log(text);
			replyList();
		})
		.catch (console.error);
			
	});
	
	//추가할 내용 읽어오기
		
		
	//댓글수정의 저장버튼을 클릭했을때
	document.getElementById('replyModify').addEventListener('click',()=>{
			//rnum, content
		const rnum = $('#replyrnumModify').val();
		const content = $('#replycontentModify').val();
		console.log(rnum);
		console.log(content);
		const data = {
			rnum,
			content,
			
		};
		
		$.ajax({
			url: '/third/reply/',
			type: 'put',
			contentType : 'application/json',
			data : JSON.stringify(data),
			success: (text)=>{
				cosole.log(text);
				replyList();
			},
			error : err => console.error
			
		});
		fetch('/third/reply/',{
			method : 'put',
			headers : {
				'Content-Type' : 'application/json' //json문자열 전송
			},
			body: JSON.stringify(data), //json문자열
			
		})
		.then(res=>res.text())
		.then(text=>{
			console.log(text);
			replyList();
		})
		.catch(err => console.err);
	});
		
		
		
	//댓글수정창에서 취소버튼을 클릭했을때
	document.getElementById('replyModifyCancel').addEventListener('click', ()=>{
		//댓글수정 창 숨기기
		document.getElementById('divReplyModify').style.display = 'none';	
	});	
		
			

			
			
});		
