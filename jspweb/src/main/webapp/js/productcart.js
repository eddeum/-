
// 변수선언
let jsonarray;			// JSON 형식의 변수를 선언
let sumprice = 0;		// 상품 총가격
let deliverypay = 0;	// 배송비
let totalpay = 0; 		// 총주문액
let poin = 0;			// 포인트

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
			tableview(); // 테이블 출력 메소드 호출
		} // success end
	}); // ajax end
	
} // 장바구니 데이터호출 출력

// 3. 테이블에 데이터를 넣어주는 메소드
function tableview(){
	// js : json 객체내 key값 이용한 value 추출
	// 객체명[key] -> value 호출
	// jsonarray[i][key] : 
	let tr = 
				'<tr>'+
		'			<th width="60%">상품정보</th>'+
		'			<th width="20%">수량</th>'+
		'			<th width="20%">가격</th>'+
		'		</tr>';
		
		sumprice = 0;		// 상품 총가격
		deliverypay = 0;	// 배송비
		totalpay = 0; 		// 총주문액
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
		'						<input readonly="readonly" id="" value="'+jsonarray[i]['samount']+'" type="text" class="form-control" style="background-color: white">'+
		'					</div>'+
		'					<div class="col-sm-2">'+
		'						<button onclick="amountincre('+i+')" class="amount_btn">▲</button>'+
		'						<button onclick="amountdecre('+i+')" class="amount_btn">▼</button>'+
		'					</div>'+
		'				</div>'+
		'			</td>'+
		'			<td class="align-middle"> <!-- 가격 -->'+
		'				<div class="row g-0">'+
		'					<div class="col-sm-8 pricebox">'+jsonarray[i]['totalprice'].toLocaleString()+'원</div>'+
		'					<div class="col-sm-4 deletebox"> <button onclick="cancel('+i+')">X</button> </div>'+
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
		
		// 총주문금액 = 총가격 + 배송비
		totalpay = sumprice + deliverypay;
		
		// 포인트
		point = parseInt(sumprice *0.01); // parseInt(데이터) : 정수형 변환
		
		// 출력
		$("#sumprice").html(sumprice.toLocaleString()+'원');
		$("#deliverypay").html(deliverypay.toLocaleString()+'원');
		$("#totalpay").html(totalpay.toLocaleString()+'원');
		$("#point").html(point.toLocaleString());
		
		$("#carttable").html(tr);
} // 테이블에 데이터를 넣어주는 메소드 end

// 4. json상태 업데이트 처리 메소드
function updatecart(){
	$.ajax({
		url : "updatecart",
		data : {"json" : JSON.stringify(jsonarray)},
		success : function(json){
			alert("업데이트처리");
			getcart();
		} // success end
	}); // ajax end
} // json상태 업데이트 

// 8. 장바구니 삭제 처리 메소드
function deletecart(i){
	$.ajax({
		url : "deletecart",
		data : {"cartnum" : jsonarray[i]['cartnum']},
		success : function(result){
			alert("삭제처리");
			getcart();
		} // success end
	}); // ajax end
	
} // 장바구니 삭제 end

// 5. 수량 증가 메소드
function amountincre(i){
	$.ajax({
		// 재고의 최대값 가져옥이
		url : "getamount",
		data : {"pnum" : jsonarray[i]['pnum'], "color" : jsonarray[i]['scolor'], "size" : jsonarray[i]['ssize']},
		success : function(maxamount){
			if(jsonarray[i]['samount'] >= maxamount){alert("재고가 부족합니다."); return;}
			// 총 금액 업데이트
			let price = (jsonarray[i]['totalprice'] / jsonarray[i]['samount']); // 제품 하나의 금액
			jsonarray[i]['samount']++;											// 수량증가
			jsonarray[i]['totalprice'] = price * jsonarray[i]['samount']; 		// 증가된 수량의 총금액의 업데이트
			updatecart();
		} // success;
	}); // ajax end
} // 수량증가  둥

// 6. 수량 감소 메소드
function amountdecre(i){
	if(jsonarray[i]['samount']==1){alert("최소 수량입니다."); return;}
	let price = (jsonarray[i]['totalprice'] / jsonarray[i]['samount']); // 제품 하나의 금액
	jsonarray[i]['samount']--;											// 수량감소
	jsonarray[i]['totalprice'] = price * jsonarray[i]['samount']; 		// 증가된 수량의 총금액의 업데이트
	updatecart();
} // 수량감소 end


// 7. json 배열내 특정 인덱스 삭제
function cancel(i){
	if(i == -1){ // 만약에 i가 -1이면 전체삭제
	alert(i);
		if(confirm('전체 삭제하시겠습니까?') ){
			alert("zzz");
			// confirm('내용') : 확인(true)/취소(false) 버튼 알림창
			for(let j = 0; j<jsonarray.length; j++){
				alert("메롱");
				deletecart(j);
			} // for end
		} // if end
		return;
	} // if end
	
	deletecart(i); // 삭제 DB 처리
} // json 배열내 특정 인덱스 삭제 end



