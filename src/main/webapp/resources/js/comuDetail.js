
//게시물 상세조회

function removeCheck(path,cboard_idx){
	/*alert(board_idx);*/
	
	if(confirm("정말 삭제하시겠습니까?")) {
		location.href= path+"/comu/comuRemove?cboard_idx=" +cboard_idx;
		}
}



window.addEventListener('load',()=>{
	
	//컨택스트 패스
	const path = $('#contextpath').val();	


	//이벤트 달기 
	document.getElementById('like').addEventListener('click',()=>{
		//ajax방식 좋아요 update
		const board_idx = document.getElementById('board_idx').innerText;
		console.log(board_idx);
		
		fetch(`/third/comu/like/${cboard_idx}`, {
			method : 'put',
		})
		.then(res=>res.text())
		.then(text=>{
			console.log('리턴값:',text); //좋아요 likecnt
			document.getElementById('likecnt').innerText=text;
		})
		.catch(err=>console.log(err))
		
	
		
	}); 
	
	
});  