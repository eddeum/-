
// 
function categorybtn(){
	$("#categoryinput").html(
		'<div class="row">'+
			'<div class="col-md-5">'+
				'<input class="form-control" type="text" id="cname">'+
			'</div>'+
			'<div class="col-md-5">'+
				'<button class="form-control" onclick="categoryadd()" type="button">등록</button>'+
			'</div>'+
		'</div>'
	)
} // 카테고리추가버튼 end

// 카테고리 등록 눌렀을때 함수
function categoryadd(){
	let cname = $("#cname").val();
	$.ajax({
		url : "categoryadd",
		data : {"cname" : cname},
		success : function(result){
			if(result == 1){
				alert("카테고리추가");
				$("#categoryinput").html("");
			}else{
				alert("카테고리실패");
			} // else end
		} // success end
	}); // ajax end
} // 카테고리추가 end

// 카테고리
$(function category(){ // $( 함수(){ 실행코드 }); : js 열람시 실행되는 함수 
	getcategory();
});

// 카테고리 호출
function getcategory(){
	$.ajax({
		url : "getcategory",
		success : function(result){
			$("#categorybox").html(result);
			
		} // success en
	}); // ajax end
}; // 카테고리호출 end

// 제품등록 form전송
function productadd(){
	alert("졸려");	
	var form = $("#addform")[0];
	var formData = new FormData(form);
	// 폼태그 id 호출[사용자가 작성하지 않는 폼이 존재하기 때문에 0으로 호출]
	// js에서 지원하는 FormData 클래스를 이용한 form태그 객체화
	// ajax 기본적으로 문자열 전송한다. 인코딩 URL 타입 : application/x-www-form-urlencoded
	alert("피곤해유");
	$.ajax({
		url : "productadd",
		type : 'POST',
		data : formData,
		contentType : false, // 전송시 문자열 타입 X
		// contentType 전송시 내용물 타입 : URL
		// 첨부파일 String 인코딩 X
		// contentType : true -> URL 인코딩 타입 문자열 O(기본타입)
		// contentType : false -> URL 인코딩 타입 문자열 X
		processData : false, // 전송시 문자열 전송X
		// html에서 enctype="multipart/form-data 사용
		// ajax에서 contentType : false, processData : false 사용
		success : function(result){
			if(result == 1){
				alert("등록이 되었습니다.");
				form.reset();
			}else{
				alert("등록실패[관리자에게 문의]");
			} // else end
			
		} // success end
	}); // ajax end
} // 제품등록 form전송 end


// 첨부파일이 변경되면 특정태그에 첨부파일 이미지 표시하기
$("#pimg").change(function(e){
	// 클라이언트가 업로드시 업로드파일의 경로알기
	let reader = new FileReader();	// 파일 경로를 읽어오는 클래스
	reader.readAsDataURL(e.target.files[0]); // readAsDataURL(파일) : 해당파일의 경로찾음
	reader.onload = function(e){ // 찾은 파일의 경로 실행
		$("#preview").attr("src", e.target.result);
	}
	
	alert(e);					// change된 객체
	alert(e.target);			// 객체.target() -> html 태그
	alert(e.target.files[0]); 	// 객체내 파일
	alert($("#pimg").val() );	// 사용시 -> 경로를 알수 없다.
}); // 이미지표시 emd

// $(함수(){실행코드}); : js 열람시 무조건 실행되는 함수