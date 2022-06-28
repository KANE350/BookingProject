/*게시물 등록*/


function fileAdd(e) {
	e.preventDefault(); //기본이벤트제거
	//input엘리먼트 생성
	var input = document.createElement('input');
	input.type='file';
	input.name='files';
	//br엘리먼트 생성
	var br = document.createElement('br');
	//button엘리먼트 생성
	var removeButton  = document.createElement('button');
	var text = document.createTextNode('-');
	removeButton.type = 'button';
	removeButton.appendChild(text);
	console.log(removeButton);
	//divFiles에 추가하기
	var divFiles = document.getElementById('divFiles');
	var div = document.createElement('div');
	
	div.appendChild(input);
	div.appendChild(removeButton);
	div.appendChild(br);
	
	divFiles.appendChild(div);
	
	//이벤트달기1
	
	
	//이벤트달기2
	//삭제버튼 클릭시 부모div삭제
	removeButton.addEventListener('click', function(){
		this.parentNode.remove();
	});
	
	
}