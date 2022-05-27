
let parentlist;

// 1. 무조건실행되는 메소드
$(function(){
	getorder();
}); // 무조건실행되는 메소드

// 2. 주문 목록 가져오기
function getorder(){
	$.ajax({
		url : "/jspweb/product/getorder",
		success : function(result){
			parentlist = result;
			console.log(parentlist);
			view();
		}  // success end
	}); // ajax end
}

let viewcount =2; // 처음 주문개수를 출력하는 변수


// 3. 현재 브라우저내 스크롤 사용 이벤트 
$(window).scroll( function(){ 
	
	// 만약에 스크롤이 바닥에 닿았을때
	//	$(window).scroll : 브라우저(인터넷창) 스크롤
	//  $(window).scrollTop() : 스크롤막다의 상단 위치
	//	$(document).height() : 현재 보고 있는 문서 내 높이
	// 	$(window).height() : 현재 보고 있는 화면 높이
		
	if( $(window).scrollTop()+30 >= $(document).height() - $(window).height()  ){
		// 현재 스크롤의 상단위치 == 현재 보고 있는 문서내 높이 - 현재 보고 있는 화면높이
		viewcount++; // 스크롤이 바닥에 닿을때마다 출력하는 주문개수를 증가
		view();	// 새로고침
	} // if end
}); // 스크롤 end

// 4. view
function view(){
	
//	let html; // 초기값 안넣을떄[undefinde 문자가 들엉감]
	let html = "";
	for(let i = 0; i<parentlist.length; i++){
		if(i == viewcount) break; // 만약에 i가 화면에 표시할 수 있는
		html += 
			'<div class="orderinfo">'+
'				<span>주문번호</span> <span>'+parentlist[i][0]['ordernum']+'</span>'+
'				<span>주문날짜</span> <span>'+parentlist[i][0]['orderdate']+'</span>'+
'				<a href="#"> <span>주문 상세보기 </span> </a>'+
'			</div>'
'			<div class="col-sm-10 mb-5"> <!-- 주문상세 -->';
		for(let j = 0; j<parentlist[i].length; j++){
			let childlist = parentlist[i];	// 상위리스트에 하나씩 하위리스트 꺼내기
			
			// 상태 한글처리
			let active;
			if(childlist[j]['orderdetailactive'] == 0) active = "상품준비중";
			else if(childlist[j]['orderdetailactive'] == 1) active = "배송중";
			else if(childlist[j]['orderdetailactive'] == 2) active = "배송완료";
			else if(childlist[j]['orderdetailactive'] == 3) active = "구매확정";
			else if(childlist[j]['orderdetailactive'] == 4) active = "취소요청";
			else if(childlist[j]['orderdetailactive'] == 5) active = "취소완료";
			else{active = "재고확인중";}
			
			html +=
				'<div class="row orderdetailbox mx-3">'+
'					<div class="col-sm-2"> <!-- 이미지 -->'+
'						<img alt="" src="/jspweb/admin/productimg/'+childlist[j]['pimg']+'" width="100%">'+
'					</div>'+
'					<div class="col-sm-7 my-4"> <!-- 정보 -->'+
'						<div class="row">'+
'							<div class="pname">'+childlist[j]['pname']+'</div>'+
'							<div class="poption">'+childlist[j]['scolor']+'/'+childlist[j]['ssize']+' · '+childlist[j]["samount"]+'개</div>'+
'							<div class="orderbuttonbox"> <!-- 버튼 -->'+
'								<button onclick="">배송조회</button>'+
'								<button onclick="cancelbtn('+childlist[j]['orderdetailnum']+')" data-bs-toggle="modal" data-bs-target="#cancelmodal">취소신청</button>'+
'								<button onclick="">리뷰작성</button>'+
'							</div>'+
'						</div>'+
'					</div>'+
'					<div class="col-sm-3 py-5">'+
'						<div class="activetitle"> 주문상태 </div>'+
'						<div class="activecontent">'+active+'</div>'+
'					</div>'+
'				</div>';			
		} // for end
		html+=
'			</div>';
	} // for end
	$("#orderbox").html(html);
	
} // view end

let orderdetailnum = -1;	// 선택한 버튼의 모달에 넣을 주문상세번호 변수

function cancelbtn(num){orderdetailnum = num;}	// 선택한 버튼의 인수값을 변수에 대입 메소드

// 5. 취소 모달에서 취소를 처리하는 메소드
function cancel(){
	alert("취소할 상품번호 :" + orderdetailnum);
	
	$.ajax({
		url : "/jspweb/product/updateorderdetail",
		data : {"orderdetailnum" : orderdetailnum, "active": 4},
		success : function(result){
			if(result == "1"){
				alert("취소 요청 성공");
				$("#modalclose").click(); // 특정 버튼의 강제 클릭이벤트
				$("cancelconfirm").val(); // 사유 입력창 초기화
				getorder();	
			}else{
				alert("취소 요청 실패");	
			} // else end
		} // success end
	}); // ajax end
	

}