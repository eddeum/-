
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
}
