
// 문서실행시 무조건 실행되는 함수
//window.onload = function(){	
//};

// 입력상자 유효성체크
let pass = [false, false, false, false, false, false];

// 투표하기 버튼 누르면
function vote(){

	let birth = document.getElementById("birth").value;			// 주민번호
	let name = document.getElementById("name").value;			// 성명
	let voteno = document.getElementById("voteno").value;		// 투표번호
	let votetime = document.getElementById("votetime").value;	// 투표시간
	let votearea = document.getElementById("votearea").value;	// 투표장소
	let confirm = document.querySelector("input[name='confirm']:checked");	// 유권자확인
	
	
	if(birth==""){
		alert("주민번호가 입력되지 않았습니다.");	pass[0] = false;
		document.getElementById("birth").focus(); // 마우스 커서???????
	}else{
		pass[0] = true;
	}
	if(name==""){
		alert("성명이 입력되지 않았습니다.");		pass[1] = false;
	}else{
		pass[1] = true;
	}
	if(voteno==""){
		alert("후보번호가 선택되지 않았습니다.");	pass[2] = false;
	}else{
		pass[2] = true;
	}
	if(votetime==""){
		alert("투표시간이 입력되지 않았습니다.");	pass[3] = false;
	}else{
		pass[3] = true;
	}
	if(votearea==""){
		alert("투표장소가 입력되지 않았습니다.");	pass[4] = false;
	}else{
		pass[4] = true;
	}
	if(confirm==null){
		alert("유권자확인이 선택되지 않았습니다.");	pass[5] = false;
	}else{
		pass[5] = true;
	}
	
	let check = true;
	for(let i = 0; i<pass.length; i++){
		if(pass[i] == false) check = false;
	}
	
	if(check){
		document.getElementById("voteform").submit();
	}else{
		alert("빈칸모두입력해야합니다.");
	} // else end
	
}


// 다시쓰기 버튼 누르면
function reset(){
	
	document.getElementById("birth").value("");
	document.getElementById("name").value("");			
	document.getElementById("voteno").value("");			
	document.getElementById("votetime").value("");	
	document.getElementById("votearea").value("");	
	document.getElementsByName("confirm").checked = false;
	
//	setTimeout(function(){document.getElementById("birth").focus();}, 0);
	document.getElementById("birth").focus(); // 마우스 커서???????
	

	
}
