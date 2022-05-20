
let jsonarray; // json 형식의 변수선언
let totalpay=0; // 총금액

// 1. 자바스크립트 열리면 무조건 실행되는 메소드
$(function(){ 
	getcart();
});

// 2. 장바구니 데이터호출 메소드
function getcart(){
		$.ajax({
		url : "getcart",
		success : function(json){
			jsonarray = json; // 응답받은 데이터를 전역변수에 넣기
			for(let i = 0; i<jsonarray.length; i++){
				totalpay += jsonarray[i]['totalprice'];
			} // for end
			alert(totalpay); // 테스트용
		} // success end
	}); // ajax end
	
} // 장바구니 데이터호출 출력


// 아임포트 API = 결제API
function payment(){
	var IMP = window.IMP; 		// 생략가능
    IMP.init("imp11431422"); 	// 가맹점 식별코드[아임포트 관리자콘솔 -> 시스템설정 메뉴]
    
      IMP.request_pay({ // param
          pg: "html5_inicis",					// pg사 -> 결제대행 회사
          pay_method: "card",					// 결제방식
          merchant_uid: "ORD20180131-0000011",	// 주문번호[별도]
          name: "EZEN SHOP",					// 홈페이지 이름[결제 이름]
          amount: totalpay,						// 총 주문금액
          buyer_email: "gildong@gmail.com",		// 주문하는사람 이메일
          buyer_name: "홍길동",					// 주문하는사람 이름
          buyer_tel: "010-4242-4242",			// 주문하는사람 전화번호
          buyer_addr: "서울특별시 강남구 신사동",		// 주문하는사람 주소
          buyer_postcode: "01181"				// 주문하는사람 주소
      }, function (rsp) { // callback			// 실행여부 판단
          if (rsp.success) { // 결제 성공 시 로직,
           
          }else{ // 결제 실패 시 로직,
           	saveorder(); // 테스트용
          } // else end
      });
} // 결제하기 end


function saveorder(){
	alert("DB처리 시작");
	$.ajax({
		url : "saveorder",
		success : function(result){
			alert("DB처리 성공");
		} // success end
	}); // ajax end
}