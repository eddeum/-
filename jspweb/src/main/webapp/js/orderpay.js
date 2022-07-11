
let jsonarray; // json 형식의 변수선언

let sumprice = 0;		// 상품 총가격
let deliverypay = 0;	// 배송비
let totalpay = 0; 		// 총주문액
let point = 0;			// 포인트

let member; // 회원정보 json 객체
let mpoint = 0; // 회원이 사용하는 포인트

let pay_method;

// 1. 자바스크립트 열리면 무조건 실행되는 메소드
$(function(){ 
	
	// 회원정보 출력
	$.ajax({
		url : "/jspweb/member/getmember",
		success : function(json){
		member = json;
		getcart();  // 제품 출력 메소드 = getcart에서 member 객체 사용하므로 member객체 호출후 메소드 실행
		} // success end
	}); // ajax end
	
	// 받는사람 정보가 기존 회원과 동일 버튼을 눌렀을때 []$(document).ready(function(){})]
	$("#checkbox").change(function(){ // 체크박스가 변경 되었을때 이벤트
		
		// 만약에 체크박스가 체크가 되어있으면
		if( $("#checkbox").is(":checked") ){
			$("#ordername").val(member['mname']);
			$("#orderphone").val(member['mphone']);
			$("#sample4_postcode").val(member['maddress'].split('_')[0]);
			$("#sample4_roadAddress").val(member['maddress'].split('_')[1]);
			$("#sample4_jibunAddress").val(member['maddress'].split('_')[2]);
			$("#sample4_detailAddress").val(member['maddress'].split('_')[3]);
		}else{
			$("#ordername").val("");
			$("#orderphone").val("");
			$("#sample4_postcode").val("");
			$("#sample4_roadAddress").val("");
			$("#sample4_jibunAddress").val("");
			$("#sample4_detailAddress").val("");
		} // else end

	}); // change end
	
});

// 2. 장바구니 데이터호출 메소드
function getcart(){
		$.ajax({
		url : "getcart",
		success : function(json){
			jsonarray = json; // 응답받은 데이터를 전역변수에 넣기
			cartview();
		} // success end
	}); // ajax end
	
} // 장바구니 데이터호출 출력

// 3. js내 존재하는 json 객체를 table에 데이터 출력
function cartview(){
	sumprice = 0;		// 상품 총가격
	deliverypay = 0;	// 배송비
	totalpay = 0; 		// 총주문액
	
	let tr = 
		'<tr>'+
		'			<th width="60%">상품정보</th>'+
		'			<th width="20%">수량</th>'+
		'			<th width="20%">가격</th>'+
		'		</tr>'

		for( let i = 0; i<jsonarray.length; i++){
			
			sumprice += jsonarray[i]['totalprice']; // 누적합계
			
			tr +=
				'<tr>'+
		'			<td> <!-- 상품정보 열 -->'+
		'				<div class="row">'+
		'					<div class="col-sm-2">'+
		'						<img alt="" src="/jspweb/admin/productimg/'+jsonarray[i]['pimg']+'" width="70%">'+
		'					</div>'+
		'					<div class="col-sm-10">'+
		'						<div class="pnamebox">'+jsonarray[i]['pname']+'</div>'+
		'						<div class="optionbox">'+jsonarray[i]['scolor']+' / '+jsonarray[i]['ssize']+'</div>'+
		'					</div>'+
		'				</div>'+
		'			</td>'+
		'			<td class="align-middle"> <!-- 수량 --> <!-- align-middle(B) : 수직 가운데 배치 -->'+
		'				<div class="row g-0"> <!-- g-0(B) : 그리드간 여백 제거 -->'+
		'					<div class="col-sm-5 offset-3">'+
								jsonarray[i]['samount'] +
		'					개 </div>'+
		'				</div>'+
		'			</td>'+
		'			<td class="align-middle"> <!-- 가격 -->'+
		'				<div class="row g-0">'+
		'					<div class="col-sm-8 pricebox">'+jsonarray[i]['totalprice'].toLocaleString()+'원</div>'+
		'				</div>'+
		'			</td>'+
		'		</tr>';
		} // for end
		// 만약에 총가격이 7만원이상이면 배송비 무료
		if(sumprice >= 70000){deliverypay = 0;}
		else{deliverypay = 2500;}
		
		// 만약에 장바구니에 상품이 없으면
		if(jsonarray.length == 0){
			tr += '<td style="text-align: center" colspan="3">상품이 없습니다.</td>';
			deliverypay =0;
		} // if end
		
		// 총주문금액 = 총가격 + 배송비 - 사용포인트
		totalpay = sumprice + deliverypay - mpoint;
		
		// 포인트
		point = parseInt(sumprice *0.01); // parseInt(데이터) : 정수형 변환
		
		// 출력
		$("#carttable").html(tr);			// 테이블 상품 출력
		$("#mpoint").html(member["mpoint"]);// 사용가능한포인트 출력
		$("#pointbox").html(mpoint);		// 사용할포인트 출력
		$("#totalpay").html(totalpay);		// 총 주문금앵 출력
		$("#sumprice").html(sumprice);		// 총 상품금액 출력
		$("#deliverypay").html(deliverypay);// 배송비 출력
} // cartview end

// 4. 결제수단 선택 메소드 
function paymethod(method){
	$("#paymethod").html(method); // html에 출력
	pay_method = method; // 변수에 넣기
} // 결제수단 end


// 5. 아임포트 실행 메소드 /* 아임포트 API = 결제API
function payment(){
	
	if(pay_method == null){ // 만약에 결제수단을 선택 안했으면
		alert("결제수단을 선택해주세요.");
		return;
	}
	
	var IMP = window.IMP; 		// 생략가능
    IMP.init("imp11431422"); 	// 가맹점 식별코드[아임포트 관리자콘솔 -> 시스템설정 메뉴]
    
      IMP.request_pay({ // param
          pg: "html5_inicis",					// pg사 -> 결제대행 회사
          pay_method: pay_method,					// 결제방식
          merchant_uid: "ORD20180131-0000011",	// 주문번호[별도]
          name: "EZEN SHOP",					// 홈페이지 이름[결제 이름]
          amount: totalpay,						// 총 주문금액
          buyer_email: member['memail'],		// 주문하는사람 이메일
          buyer_name: member['mname'],					// 주문하는사람 이름
          buyer_tel: member['mphone'],			// 주문하는사람 전화번호
          buyer_addr: member['maddress'],		// 주문하는사람 주소
          buyer_postcode: member['maddress'].split("_")[0],				// 주문하는사람 주소
      }, function (rsp) { // callback			// 실행여부 판단
          if (rsp.success) { // 결제 성공 시 로직,
           
          }else{ // 결제 실패 시 로직,
           	saveorder(); // 테스트용
          } // else end
      });
} // 결제하기 end

// 6. 주문 처리 메소드 
function saveorder(){
	// 주문정보 호출
	let ordername = $("#ordername").val();
	let orderphone = $("#orderphone").val();
	let orderaddress = 
			$("#sample4_postcode").val("") +"_"+
			$("#sample4_roadAddress").val("") +"_"+
			$("#sample4_jibunAddress").val("") +"_"+
			$("#sample4_detailAddress").val("");
	let ordertotalpay = totalpay;
	let orderrequest = $("#orderrequest").val();
	
	let orderjson = {
		ordername : ordername ,
		orderphone : orderphone , 
		orderaddress : orderaddress ,
		ordertotalpay : ordertotalpay , 
		orderrequest : orderrequest
	}
	
	$.ajax({
		url : "saveorder",
		data : {"orderjson" : JSON.stringify(orderjson)},
		success : function(result){
			alert(result);
			if(result == "true"){
				location.href = "/jspweb/product/ordersuccess.jsp";
			}else{
				alert("오류 발생[관리자에게 문의]");
			}
		} // success end
	}); // ajax end
} // 주문처리 end

//  7.포인트 사용 메소드 
function pointbtn(){
	
	// 만약에 포인트가 5000이상이면
	mpoint = $("#pointinput").val();
	if(mpoint == 0){
		mpoint = 0;
	}else if(mpoint < 5000){
		alert('최소 5000부터 사용가능합니다.');
		mpoint = 0;
		$("#pointinput").val(0);
		return;
	}else if(mpoint>member['mpoint']){
		alert('포인트가 부족합니다.');
		mpoint = 0;
		$("#pointinput").val(0);
		return;
	}
	cartview(); // 새로고침
} // 포인트사용 end

