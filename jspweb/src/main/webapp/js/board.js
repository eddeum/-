
// 문서 열렸을때 함수 무조건 실행
$(document).ready(function(){
	$('#summernote').summernote({
		placeholder: '내용 입력',
		tabsize: 2,
		minheight : 250, // 최소 높이
		maxheight : null, // 최대 높이
		lang : 'ko-KR'	// 메뉴 한글버전
	});
});


function filedelete(bnum){
	// HTML에서 JS로 변수 이동[통신]
		// 1. 메소드 인수로 이동
		// 2. 태그의 value 혹은 html 이동
	
	alert("파일만삭제");
	// 비동기통신 = 페이지 전환이 없는 상태 DB 통신
	// JQUERY 라이브러리 AJAX 사용
	$.ajax({
		url : "filedelete", /*서블릿통신*/
		data : {"bnum" : bnum}, /*통신 데이터 : {변수명 : 값, 변수명2 : 값} */
		success : function(result){
			if(result == "1"){
				alert("첨부파일삭제성공");
				location.reload(); // 현재 페이지를 새로고침
			}
			else{alert("첨부파일삭제실패[관리자에게문의]");}
		} // success end
	}); 
} // 첨부파일삭제 end

// 댓글작성 메소드
function replywrite(bnum){
	let rcontent = $("#rcontent").val();
	$.ajax({
		url: "replywrite",
		data: {"bnum":bnum, "rcontent":rcontent},
		success : function(result){
			if(result == 1){
				alert("댓글작성 되었습니다.");
				$("#rcontent").val(""); // 작성 input 공백으로 초기화
				$("#replytable").load(location.href+" #replytable"); // 특정 태그 새로고침
				// 해당 replytable 태그의 불러오기 = replytable
				//" #replytable" = "와 #사이에 띄어쓰기 필수
			}else{
				alert("댓글작성 실패했습니다.");
			} // else end
		} // success end
		
	}); // ajax end 
} // 댓글작성 end

// 대댓글창 메소드
function rereplyview(rnum, bnum, mid){
	// '문자열' + 변수 + '문자열'
	// JS 작성 공간에서는 HTML 작성 불가능 --> HTML 문자처리
	if(mid == null){
		alert("로그인후 작성 가능합니다."); return;
	} // if end
	
	$("#"+rnum).html(
		'<div class="row">'+
			'<div class="col-md-10">'+
				'<textarea id="rrcontent" class="form-control" rows="3"></textarea>'+
			'</div>'+
			'<div class="col-md-2">'+
				'<button class="form-control py-4 my-1" onclick="rereplywrite('+rnum+','+bnum+')">대댓글등록</button>'+
			'</div>'+
		'</div>'
	);
} // 대댓글창 end

// 대댓글작성 메소드
function rereplywrite(rnum, bnum){
	let rrcontent = $("#rrcontent").val();
	$.ajax({
		url : "rereplywrite",
		data : {"rnum": rnum, "bnum":bnum, "rrcontent":rrcontent},
		success : function(result){
			if(result == 1){
				alert("대댓글작성이 되었습니다.");
				$("#rrcontent").val(""); // 대댓글작성 input 공백으로 초기화
				$("#replytable").load(location.href+" #replytable"); // 특정 태그 새로고침
			}else{
				alert("대댓글작성 실패했습니다.");
			} // else end
		} // success end
	}); // ajax end
} // 대댓글작성 end

// 댓글삭제 메소드
function replydelete(rnum){
	$.ajax({
		url : "replydelete",
		data : {"rnum" : rnum},
		success : function(result){
			if(result == 1){
				alert("댓글이 삭제되었습니다.");
				$("#replytable").load(location.href+" #replytable");
			}else{
				alert("삭제 실패(관리자에게 문의)");
			} // else end
		} // success end
	}); // ajax end
} // 댓글삭제 end

// 댓글수정시 창 메소드
function reupdateview(rnum){
	$("#"+rnum).html(
		'<div class="row">'+
			'<div class="col-md-10">'+
				'<textarea id="rupcontent" class="form-control" rows="3"></textarea>'+
			'</div>'+
			'<div class="col-md-2">'+
				'<button class="form-control py-4 my-1" onclick="replyupdate('+rnum+')">댓글수정</button>'+
			'</div>'+
		'</div>'
	);	
} // 댓글수정시 창 end

// 댓글수정 메소드
function replyupdate(rnum){
	let rcontent = $("#rupcontent").val();
	$.ajax({
		url : "replyupdate",
		data : {"rnum" : rnum, "rcontent" : rcontent},
		success : function(result){
			if(result == 1){
				alert("댓글이 수정되었습니다.");
				$("#replytable").load(location.href+" #replytable");
			}else{
				alert("댓글수정 실패(관리자에게 문의)");
			} // else end
		} // success end
	}); // ajax end
} // 댓글수정 end
