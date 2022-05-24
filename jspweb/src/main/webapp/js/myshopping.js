
let parentlist;

// 1. 무조건실행되는 메소드
$(function(){
	$.ajax({
		url : "/jspweb/product/getorder",
		success : function(result){
			parentlist = result;
			console.log(parentlist);
			view();
		}  // success end
	}); // ajax end
}); // 무조건실행되는 메소드

let viewcount = 2; // 처음 주문개수를 출력하는 변수

// 현재 브라우저내 스크롤 사용 이벤트 
$(window).scroll(function(){
	
	// 만약에 스크롤이 바닥에 닿았을때
	//	$(window).scroll : 브라우저(인터넷창) 스크롤
	//  $(window).scrollTop() : 스크롤막다의 상단 위치
	//	$(document).height() : 현재 보고 있는 문서 내 높이
	// 	$(winow).height() : 현재 보고 있는 화면 높이
		
	if($(window).scrollTop() >= $(document).height() - $(window).height() ){
		// 현재 스크롤의 상단위치 == 현재 보고 있는 문서내 높이 - 현재 보고 있는 화면높이
		viewcount++; // 스크롤이 바닥에 닿을때마다 출력하는 주문개수를 증가
		view();	// 새로고침
	} // if end
}); // 스크롤 end


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
'			<div class="orderdetailbox col-sm-10"> <!-- 주문상세 -->';
		for(let j = 0; j<parentlist[i].length; j++){
			let childlist = parentlist[i];	// 상위리스트에 하나씩 하위리스트 꺼내기
			html +=
				'<div class="row">'+
'					<div class="col-sm-2"> <!-- 이미지 -->'+
'						<img alt="" src="/jspweb/admin/productimg/'+childlist[j]['pimg']+'" width="100%">'+
'					</div>'+
'					<div class="col-sm-7 my-4"> <!-- 정보 -->'+
'						<div class="row">'+
'							<div class="pname">'+childlist[j]['pname']+'</div>'+
'							<div class="poption">'+childlist[j]['scolor']+'/'+childlist[j]['ssize']+'/'+childlist[j]['pimg']+' '</div>'+
'							<div class="orderbuttonbox"> <!-- 버튼 -->'+
'											<button onclick="">배송조회</button>'+
'											<button onclick="">취소신청</button>'+
'											<button onclick="">리뷰작성</button>'+
'							</div>'+
'						</div>'+
'					</div>'+
'					<div class="col-sm-3">'+
'						<span> 상품 준비중</span>'+
'					</div>'+
'				</div>'+
'			</div>';
					
		} // for end
			html+=
'					</div>'+
'				</div>';
	} // for end
	$("#orderbox").html(html);
	
} // view end