
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

function getamount(pnum){
	// 제품번호, 색상, 사이즈 동일한 경우의 재고를 호출
	let scolor = $("#colorbox"+pnum).val();
	let ssize = $("#sizebox"+pnum).val();
	$.ajax({
		url : "getstock",
		data : {"field" : 'amount', "pnum" : pnum, "scolor" : scolor, "ssize" : ssize },
		success : function(result){
			if(result == ""){
				$("#amountbox"+pnum).html("재고없음");
				$("#datebox"+pnum).html("");
			}else{
				$("#amountbox"+pnum).html(result.split(",")[0]+"개");
				$("#datebox"+pnum).html(result.split(",")[1]);
			} // else end
		}// success end
	}); // ajax end
} //

// 선택한 제품의 재고 변경
function getstock(pnum){
	$.ajax({
		url : "getstock",
		data : {"pnum" : pnum},
		success : function(result){
			$("#stocklistbox").html(result);
		} // success end
	}); // ajax end
} // 재고변경 end

function showupdate(snum){
	$("#updatebox").css("display", "block"); // 재고수량 수정창 입력창 열기
	$("#snum").val(snum); // 수정할 재고번호
}

function stockupdate(){
	let snum = $("#snum").val(); 
	let samount = $("#samount").val();
	
	$.ajax({
		url : "stockupdate",
		data : {"snum" : snum, "samount" : samount},
		success : function(result){
			$("#modalclosebtn2").click(); // 모달닫기 버튼의 강제로 클릭이벤트 실행
			$("#mainbox").load('productlist.jsp'); // 페이지 재로드
		} // success end
	}); // ajax end
} 