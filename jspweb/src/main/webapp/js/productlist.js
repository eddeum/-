
// 선택한 제품번호
function pnummove(pnum){
	$("#modelinput").val(pnum);
}

// 제품 상태변경 비동기 처리구역
function activechange(active){
	let pnum = $("#modelinput").val();
	$.ajax({
		url : "activechange",
		data : {"pnum":pnum, "active" : active},
		success : function(result){
			if(result == 1){
				alert("상태변경 완료");
				// 특정태그 새로고침
				$("#modalclosebtn").click(); // 특정버튼 강제클릭 : 모달내 취소버튼 클릭 이벤트
				$("#mainbox").load("productlist.jsp");	// 해당 div에 해당페이지 로드
			}else{
				alert("상태변경 실패");
			} // else end
		} // success end
	}); // ajax end
}