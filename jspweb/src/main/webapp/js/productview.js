
// 컬러 select 목록이 변경 되었을때
$("#color_select").change(function(){
	let color = $("#color_select").val(); // 색상
	if(color == ""){return;}
	let pnum = $("#pnum").val(); // 제품번호
	
	$.ajax({ // 통신시 사용되는 데이터 타입 -> 문자열 / 첨부파일 / json
		url : "getstocksize",
		data : {"pnum" : pnum, "color" : color},
		success : function(result){
			let list = result.replace("{", "");
			let itemlist = list.split(", "); // 공백없애주기
			let html = "";
			html += "<option value=''>-[필수]옵션 선택-</option>";
			for(let item of itemlist){
				let color = item.split("=")[0];
				let amount = item.split("=")[1];
				html += "<option value='"+color+"'>"+color+" - "+amount+"</option>";
			} // for end
			
			$("#size_select").html(html);	// id.html() : 새로운데이터(기존꺼 사라짐)
//			$("#size_select").appen("<option>asdasd</option>");	// id.append() : 데이터추가
		} // success end
	}); // ajax end
	
}); // 컬러선택 변경 end

	// js 배열
		// let 배열명 = [ ]
		// 추가 : push -> 배열내 마지막인덱스 뒤에 추가
		// 제거 : pop -> 배열내 마지막인덱스에 삭제
		// 특정인덱스 삭제 : splice(인덱스, 개수) -> 특정인덱스부터 개수만큼 삭제
			// 배열내 중간인덱스 삭제시 빈공간 인덱스 당기기 -> java 리스트 클래스와 동일
				// 예) 3번 인덱스 삭제시 : 4번 인덱스가 3번인덱스로 당겨짐
	// js 객체 선언 -> object = { }
		// let 객체명 = {필드명1 : 값, 필드명2 : 값, 필드명3 : 값}
		// 호출[.연산자]
			// 객체명.필드명
			
let selectlist = [ ]; // js 배열

// 사이즈 select 목록이 변경 되었을때 선택값을 객체화해서 배열에 저장
$("#size_select").change(function(){
	let pname = $("#pname").html();
	let color = $("#color_select").val();
		if( color == ""){ return; } // 색상이 선택이 없으면
	let size = $("#size_select").val();
		if( size == ""){ return; }	// 사이즈 선택이 없으면
	let amount = $("#amount").val();
		if($("#amount").val() == null) amount = 1; // input이 생성되기 전이면 기본값 1
	let pprice = $("#pprice").val(); 
	let overcheck = color+size; // 식별용
	
	// js 객체 선언
	let product = {
		pname : pname, 
		color : color, 
		size : size, 
		amount : amount, 
		pprice : pprice, 
		totalprice : pprice *amount,
		point : (pprice *amount)*0.01,
		overcheck : overcheck
	}
	
	for(let i = 0; i<selectlist.length; i++){ // 만약에 배열에 이미있는 옵션이면 중지
		if(selectlist[i].overcheck == overcheck){alert("이미 선택한 옵션입니다."); return;}
		// 배열내 i번째 객체의 필드[중복체크]호출
	} // for end
	selectlist.push(product); // 배열에 객체를 추가
	optionprint();
}); // 사이즈선택 변경 end

// 천단위 구분쉼표 -> 정규표현식
/*
	\d{3} : 정수 3자리 패턴
	(\d{3})+ : 앞 표현식 반복 대응
	(\d{3})+(?!\d) : 표현식 뒤에 정수가 없는경우[정수 끝 찾기]
	\B( ?= (\d{3})+(?!\d)) : 문자가 없으면 
	
	/^ : 정규표현식 시작
	패턴 : (앞 = 문자존재), (뒤 = 문자열 3글자)
			(\d{3}) = 정수3자리
	\d : 정수 [0-9]{3} <------> (\d{3})
	{ } : 길이
	+ : 앞 표현식 반복되는 부분 대응(천단위, 백단위 등)
	x(?!y) : x 뒤에 y가 없는경우(false)	: (?!\d) : 앞에 패턴이 없는 경우(뒤에 숫자가 없는 경우)
	x(?=y) : x 뒤에 y가 있는경우(true) 	: (	?= (\d{3})+(?!\d))
	\B : 문자 경계선 (문자제외)			: \B( ?= (\d{3})+(?!\d))
	g : 전역검색[모든 곳 검색]
	i : 대소문자 구분없는 검색
	
 */
 // 데이터.toString().replace( '정규표현식' , ',' );
 // 데이터.toLocaleString(undefind, {maximumFractionDigits : 0})
 														// 0 : 소수점 표시단위


function optionprint(){
	let html = '<tr> <th width="60%">상품명</th><th width="25%">상품수</th><th width="15%">가격</th> </tr>';
	for(let i = 0; i<selectlist.length; i++){
		
		// 총금액, 포인트 금액 최신화
		selectlist[i].totalprice = selectlist[i].pprice * selectlist[i].amount;
		selectlist[i].point = selectlist[i].totalprice * 0.01;
		
		
		html +=
			'<tr>'+
		 		'<td> <span>'+selectlist[i].pname+'</span> <br> <span class="pointbox">- '+selectlist[i].color+'/'+selectlist[i].size+'</span></td>'+
		 		'<td>'+
		 			'<div class="row g-0"> <!-- g-0 : div간 여백제거 -->'+
		 				'<div class="col-md-7">'+
		 					// 수량입력상자 -> readonly : 읽기전용
		 					'<input readonly id="amount'+i+'" value='+selectlist[i].amount+' type="text" class="form-control fc amount_input">'+
		 				'</div>'+
		 				'<div class="col-md-4">'+
		 					// 구매수량 증가/감소 버튼 -> 클릭이벤트 : i번째 인덱스 전달
		 				 	'<button onclick="amountincre('+i+')" class="amount_btn">▲</button>'+
		 				 	'<button onclick="amountdecre('+i+')" class="amount_btn">▼</button>'+
		 				'</div>'+
		 				'<div class="col-md-1">'+
		 					'<button onclick="optioncancel('+i+')" class="cancel_btn">x</button>'+
		 									// x 버튼을 눌렀을때 이벤트 -> i값 인수 전달 => i : 배열내 객체 인덱스
		 				'</div>'+
		 			'</div>'+
		 		'</td>'+
		 		'<td>'+
		 			'<span class="pricebox">'+(selectlist[i].amount*selectlist[i].pprice).toLocaleString()+'원'+'</span> <br>'+
		 		 	'<span class="pointbox">(적'+selectlist[i].point.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',')+'원'+')</span>'+
		 		 '</td>'+
			'</tr>'
	} // for end
	$("#select_table").html(html);
	// 객체내 총합계
	let total_price = 0;
	let total_amount = 0;
	for(let i = 0; i<selectlist.length; i++){
		total_price += selectlist[i].totalprice;
		total_amount += selectlist[i].amount;
	} // for end
	$("#total_price").html(total_price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',')+'원'+ '(' + total_amount + '개)');
} // 선택옵션출력 end

// 선택한옵션 삭제 
function optioncancel(i){
	selectlist.splice(i, 1); // i번째 인덱스부터 1개의 인덱스 삭제 
	optionprint(); 
} // 선택한옵션 삭제 end

// 해당 인덱스의 상품수 증가 함수
function amountincre(i){
	// 만약에 재고보다 상품수 더 크면 함수 종료
	let pnum = $("#pnum").val();
	$.ajax({
		url : "getamount",
		data : {"pnum" : pnum, "color" : selectlist[i].color, "size" : selectlist[i].size},
		success : function(maxamout){
			if(selectlist[i].amount>=maxamout){alert("재고가 부족합니다."); return;}
			selectlist[i].amount ++; // 선택한 객체들이 모여있는 배열
				// 해당 인덱스의 객체내 수량 1 증가
			optionprint(); // 변경 후 옵션목록 새로고침
		} // success end
	}); // ajax end

} // 상품수증가 end

// 해당 인덱스의 상품수 감소 함수
function amountdecre(i){
	// 만약에 수량이 1보다 작으면 함수 종료
	if(selectlist[i].amount == 1){alert("최소수량 입니다."); return;}
	selectlist[i].amount --;
				// 해당 인덱스의 객체내 수량 1 감소
	optionprint(); // 변경 후 옵션목록 새로고침
} // 상품수감소 end

// 관심등록 버튼을 눌렀을때 함수 -> mnum, pnum
function saveplike(mid){
	if(mid == null){alert("로그인후 등록 가능합니다."); return;}
	let pnum = $("#pnum").val();
	
	$.ajax({
		url : "saveplike",
		data : {"mid" : mid, "pnum" : pnum},
		success : function(result){
			if(result == 1){
				alert("관심등록 했습니다.");
			}else if(result == 2){
				alert("관심등록 취소했습니다.");
			}else if(result == 3){
				alert("오류발생[관리자에게문의]")
			} // else if end
			// 특정 태그 새로고침
			$("#btnbox").load(location.href+" #btnbox");
		} // success end
	}); // ajax end
} // 관심등록 end

// 장바구니 담기
function savecart(mnum){
	// 로그인이 안되어 있으면
	if(mnum == 0){alert("로그인 후 장바구니 사용가능합니다."); return;}
	// 선택한 옵션의 개수 -> 만약에 선택한 옵션이 없으면
	if(selectlist.length == 0){alert("최소 1개 이상 옵션 선택해주세요."); return;}

	// 서블릿에게 배열 보내기(서로 다른언어들끼리 데이터 타입 통일성)
		// ajax <------- json --------> 서블릿
			// js : json 라이브러리 내장 / java : json 내장 X
				// JSON.stringify : 배열이나 객체를 JSON 형식으로 변환 메소드
				// key : value -> entry
				// 여러개 entry -> JSONobject  		: { 키1 : 값1, 키2: 값2 ~~}
				// 여러개 JSONobject -> JSONarray		: [{ 키1 : 값1, 키2: 값2 ~~}, { 키1 : 값1, 키2: 값2 ~~}]
				// 키 : value(JSONarray)
	$.ajax({
		url : "savecart",
		data : {"json" : JSON.stringify(selectlist), "pnum" : $("#pnum").val()},
		success : function(result){
			if(result == -1){
				alert("장바구니에 등록했습니다.");
			}else{
				alert("오류발생[관리자에게문의] : "+(result+1)+"옵션");
			} // else end
		} // success end
	}); // ajax end
	
} // 장바구니 담기 end
