
// 스크립트가 실행될때 입력창에 커서두기
$("#incontent").focus();

// js 웹소켓 변수 선언
let websocket = null;

start();	// 웹 소켓실행

// 엔터 입력했을때 이벤트
function enterkey(mid){
	if(window.event.keyCode == 13){
		if(mid == 'null'){alert("로그인후 채팅입장이 가능합니다."); return;}
		send(mid); // 메시지 전송
	} // if end
} // enter입력 end

// 전송버튼 클릭시 이벤트
function sendbtn(mid){
	if(mid == 'null'){alert("로그인후 채팅입장이 가능합니다."); return;}
	send(mid); // 메시지 전송
} // 전송버튼 end

// 채팅 소켓 실행 메소드
function start(){
	// js에서 사용되는 웹소켓 클래스(ws:IP번호 : HTTP-PORT번호/프로젝트명/서버소켓이름)
	let mid = $("#mid").val(); 
	websocket = new WebSocket("ws://192.168.17.10:8080/jspweb/chatting/"+mid);
	websocket.onopen = function(e){onOpen(e);}
	websocket.onmessage = function(e){onmessage(e)}
	websocket.onclose = function(e){onclose(e)}
	websocket.onerror = function(e){onerror(e)}
} // 채팅소켓실행 end

function onclose(e){alert("채팅방을 나갑니다.") +e;}
function onerror(e){alert("서버소켓 오류입니다." +e);}

function onOpen(e){
	alert("서버소켓으로 들어왔습니다." + e);
	console.log(e);

}
function onmessage(e){
	// 문자열 -> json
//	alert("메소드 실행정보 : "+e);
//	alert("메시지 정보[문자열] : "+e.data);
//	alert("메시지 정보[json] : "+e.data);
	// e : 메소드 이벤트 실행정보가 담겨있는 객체
		// e.data : 메시지 내용이 담겨있는 필드
	let msg = JSON.parse(e.data);
	
	if(msg['type'] != "1"){ // 메시지 이면
		let html = "";
		for(let i = 0; i<msg.length; i++){
			html +=
				'<div class="row p-2"> <!-- 접속자 정보 표시 구역 = js -->'+
	'				<div class="col-sm-4"> <!-- 프로필 이미지 표시 구역 -->'+
	'					<img alt="" src="/jspweb/img/프로필.jpg" class="rounded-circle" width="100%">'+
	'				</div>'+
	'				<div class="col-sm-8"> <!-- 접속자 이름, 기능 -->'+
	'					<div class="member_name">'+msg[i]["mid"]+'</div>'+
	'					<div class="btnbox">'+
	'						<span>귓말</span>'+
	'						<span>친추</span>'+
	'					</div>'+
	'				</div>'+
	'			</div>';
		} // for end
		$("#enterlist").html(html);
		
	}else{ // 접속자 명단

		let from = msg["from"]; // json 키를 통한 value 호출
		let content = msg["content"];
		let img = msg["img"];
		let date = msg["date"];
	//	alert(from+content+img+date);
	
		let html = $("#contentbox").html(); // 기존 html 가져오기
		
		if(from == $("#mid").val() ){ // 현재 로그인된 아이디와 보낸사람이 같으면
	
			html +=
				'<div class="secontent my-3"> <!-- 보낼때 메시지 구역 -->'+
		'			<span class="date">'+date+'</span>'+
		'			<span class="content">'+content+'</span>'+
		'		</div>';
		}else{ // 다른 사람이 보냈을때
			html +=
			  '<div class="row g-0 my-3"> <!--g-0 : 부트스트랩 - div간 여백제거  --> <!-- 받을때 구역 -->'+
	'				<div class="col-sm-1 mx-2">'+
	'					<img alt="" src="/jspweb/img/'+img+';" class="rounded-circle" width="100%">'+
	'				</div>'+
	'				<div class="col-sm-9">'+
	'					<div class="recontent"> <!-- 받을때 메시지 구역 -->'+
	'						<div class="member_name">'+from+'</div>'+
	'						<span class="content">'+content+'</span>'+
	'						<span class="date">'+date+'</span>'+
	'					</div>'+
	'				</div>'+
	'			</div>';
		} // else end
	
		$("#contentbox").html(html);
		// 스크롤 하단으로 내리기
		$("#contentbox").scrollTop($("#contentbox")[0].scrollHeight);
			// $("#contentbox").scrollTop : 현재 스크롤의 상단 위치
			// $("#contentbox")[0].scrollHeight : 현재 스크롤의 전체 길이
	} // else end
	

}
function send(mid){
	
	let content = $("#incontent").val();
	
	// json 형식응로 통신
	let msg = { // js 객체화
		type : "1", 	// 문자전송, 접속자명
		from : mid,		// 보내는사람 명
		content : content, 	// 채팅내용
		img : "프로필.jpg",	// 프로필
		date : new Date().toLocaleTimeString()	// 채팅 보낸시간
	}
	// json 통신할때 json모양의 문자열 변환
		// JSON -> 문자열 : JSON.stringify
		// 문자열 -> JSON : JSON.parse
		
	websocket.send(JSON.stringify(msg)); // json -> 문자열 형식
	$("#incontent").val(""); // 전송후 입력창 공백
	$("#incontent").focus(); // 전송후 입력창에 커서두기 
}