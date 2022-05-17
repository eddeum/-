
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
			let itemlist = list.split(",");
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
	// js 객체 선언 -> object = { }
		// let 객체명 = {필드명1 : 값, 필드명2 : 값, 필드명3 : 값}
		// 호출[.연산자]
			// 객체명.필드명
			
let 선택한목록 = [ ]; // js 배열

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
	let 중복체크 = color+size; // 식별용
	
	// js 객체 선언
	let product = {pname : pname, color : color, size : size, amount : amount, pprice : pprice, 중복체크 : 중복체크}
	
	
	
	for(let i = 0; i<선택한목록.length; i++){ // 만약에 배열에 이미있는 옵션이면 중지
		if(선택한목록[i].중복체크 == 중복체크){alert("이미 선택한 옵션입니다."); return;}
		// 배열내 i번째 객체의 필드[중복체크]호출
	} // for end
	선택한목록.push(product); // 배열에 객체를 추가
	선택옵션출력();
}); // 사이즈선택 변경 end

function 선택옵션출력(){
	let html = '<th width="60%">상품명</th><th width="25%">상품수</th><th width="15%">가격</th>';
	for(let i = 0; i<선택한목록.length; i++){
		html +=
			'<tr>'+
		 		'<td> <span>'+선택한목록[i].pname+'</span> <br> <span class="pointbox">- '+선택한목록[i].color+'/'+선택한목록[i].size+'</span></td>'+
		 		'<td>'+
		 			'<div class="row g-0"> <!-- g-0 : div간 여백제거 -->'+
		 				'<div class="col-md-7">'+
		 					'<input id="amount" value="1" type="text" class="form-control fc amount_input">'+
		 				'</div>'+
		 				'<div class="col-md-4">'+
		 				 	'<button class="amount_btn">▲</button>'+
		 				 	'<button class="amount_btn">▼</button>'+
		 				'</div>'+
		 				'<div class="col-md-1">'+
		 					'<button onclick="optioncancel('+i+')" class="cancel_btn">x</button>'+
		 									// x 버튼을 눌렀을때 이벤트 -> i값 인수 전달 => i : 배열내 객체 인덱스
		 				'</div>'+
		 			'</div>'+
		 		'</td>'+
		 		'<td>'+
		 			'<span class="pricebox">'+(선택한목록[i].amount*선택한목록[i].pprice).toLocaleString()+'원'+'</span> <br>'+
		 		 	'<span class="pointbox">(적'+(선택한목록[i].amount*선택한목록[i].pprice)*0.01+'원'+')</span>'+
		 		 '</td>'+
			'</tr>'
	} // for end
	$("#select_table").html(html);
} // 선택옵션출력 end

// 선택한옵션 삭제 
function optioncancel(i){
	alert(i);
	선택한목록.splice(i, 1); // i번째 인덱스부터 1개의 인덱스 삭제 
	선택한옵션출력(); 
} // 선택한옵션 삭제 end