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
			document.getElementById('creply_id').value='';
			document.getElementById('creply_content').value='';
			
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
		
		const cboard_idx = document.getElementById('cboard_idx').innerText;
		
		//ajax 서버 호출
		fetch(`/third/comureply/list/${cboard_idx}`)
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
			document.getElementById('cr_restep').value=0;
			document.getElementById('cr_relevel').value=0;
			
			
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
			const creply_idx = e.target.value;
			console.log(creply_idx);
			const cr_restep = document.getElementById(`cr_restep${creply_idx}`).innerText;
			//console.log(rnum);
			const cr_relevel = document.getElementById(`cr_relevel${creply_idx}`).innerText;
			//console.log(relevel);
			//부모의 step, relevel
			document.getElementById('cr_restep').value=cr_restep;
			document.getElementById('cr_relevel').value=cr_relevel;
			
			//댓글추가 div 이동
			const reply = document.getElementById(`reply${creply_idx}`);
			const divReplyAdd = document.getElementById('divReplyAdd');
			reply.after(divReplyAdd);
			
			//댓글추가 div 보이기
			divReplyAdd.style.display = '';
	
	}else if  (e.target.classList.contains('reReplyRemove')){
		const creply_idx = e.target.value;
		//ajax 서버 호출
			fetch(`/third/comureply/${creply_idx}`,{
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
			const creply_idx = e.target.value;
			
			
			//댓글수정 div 이동
			const reply = document.getElementById(`reply${creply_idx}`);
			
			const divReplyModify = document.getElementById('divReplyModify');
			reply.after(divReplyModify);
			
			//댓글 수정창 숨기기
			divReplyModify.style.display = '';
			
			//기존 rnum, content 읽기
			document.getElementById(`replyrnumModify`).value = creply_idx;
			const creply_content = document.getElementById(`creply_content${creply_idx}`).innerText;
			
			document.getElementById(`replycontentModify`).innerHTML = creply_content;
			
		}			
	});
	
	
	
	//추가댓글의 추가버튼 클릭시
	document.getElementById('replyAdd')
	.addEventListener('click',()=>{
		const cboard_idx = document.getElementById('cboard_idx').innerText;
		const creply_id = document.getElementById('creply_id').value;
		const creply_content = document.getElementById('creply_content').value;
		const cr_restep = document.getElementById('cr_restep').value; // 댓글의 순서
		const cr_relevel = document.getElementById('cr_relevel').value; // 댓글의 레벨
		
		console.log(cboard_idx);
		console.log(creply_id);
		console.log(creply_content);
		console.log(cr_restep);
		console.log(cr_relevel);
		
		//전송할 데이터
		const data ={
			cboard_idx,
			creply_id,
			creply_content,
			cr_restep,
			cr_relevel,
		};
		
		fetch('/third/comureply/' , {
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
			.catch (console.error)
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
		
		fetch('/third/comureply/',{
			method : 'put',
			headers : {
				'Content-Type' : 'application/json' //json문자열 전송
			},
			
			body: JSON.stringify(data),
			})
		.then(res=>res.text())
		.then(text=>{
			console.log(text);
			replyList();
		})
		.catch(console.err);
		
		});
		
	
		
		
		
	//댓글수정창에서 취소버튼을 클릭했을때
	document.getElementById('replyModifyCancel').addEventListener('click', ()=>{
		//댓글수정 창 숨기기
		document.getElementById('divReplyModify').style.display = 'none';	
	});	
		
			

			
			
});