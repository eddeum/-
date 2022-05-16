
// 특정 select에 DB 데이터 넣기

$(function getcategory(){
	$.ajax({
		url : "getcategory",
		data : {"type" : "option"},
		success : function(result){
			$("#categorybox").html(result);
		} // success end
	}); // ajax end
}); // 카테고리출력 end

// 카테고리 select값이 변경 될때마다
$("#categorybox").change(function(){
	let cnum = $("#categorybox").val();
	$.ajax({
		url : "getproduct",
		data : {"type" : "option", "cnum" : cnum},
		success : function(result){
			if(result == ""){
				alert("해당 카테고리의 제품이 없습니다.");
				$("#productbox").html(" ");
				document.getElementById('stockaddform').attr('display', 'none');
				// 속성값 변경 : js -> attr / jquery -> css
			}else{
				$("#productbox").html(result);
				$("#stockaddform").css('display', 'block');
				getstock();
			} // else end
		} // success end
	}); // ajax end
}); // change end

// 제품 재고 추가
function stockadd(){
	let pnum = $("#productbox").val();
	let scolor = $("#scolor").val();
	let ssize = $("#ssize").val();
	let samount = $("#samount").val();
	
	$.ajax({
		url : "stockadd",
		data : {"pnum" : pnum, "scolor" : scolor, "ssize": ssize, "samount" : samount},
		success : function(result){
			if(result == 1){
				alert("재고등록 성공");
				$("#mainbox").load('productstock.jsp');
			}else{
				alert("재고등록 실패");
			}// else end
		} // success end
	}); // ajax end
}// 재고추가 end

// 제품명 목록 select 값이 변경 될때마다
$("#productbox").change(function(){
	getstock();
});

// 재고 목록 가져오기
function getstock(){
	let pnum = $("#productbox").val();
	$.ajax({
		url : "getstock",
		data : {"pnum": pnum},
		success : function(result){
			$("#stocklistbox").html(result);
		} // success end
	}); // ajax end
} // 재고목록 가져오기 end
	