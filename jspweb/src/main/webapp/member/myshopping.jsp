<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="/jspweb/css/myshopping.css" rel="stylesheet">
</head>
<body>

	<%@include file="../header.jsp" %>
	
	<div class="container"> <!-- 박스권 -->
		<div class="row"> <!-- 가로배치 -->
			<div class="col-md-3"> <!-- 사이드바 -->
				<%@include file="infosidebar.jsp" %>
			</div>
			<div class="col-md-9"> <!-- 본문 -->
				<h3>주문현황</h3>
				<div id="orderbox">
				
				
				<div class="orderbox"><!-- 아이디넣기 -->
						<div class="orderinfo">
							<span>주문번호</span> <span>3</span>
							<span>주문날짜</span> <span>2022-05-24</span>
							<a href="#"> <span>주문 상세보기 </span> </a>
						</div>
						<div class="orderdetailbox col-sm-10"> <!-- 주문상세 -->
							<div class="row">
								<div class="col-sm-2"> <!-- 이미지 -->
									<img alt="" src="/jspweb/img/new1.jpg" width="100%">
								</div>
								<div class="col-sm-7 my-4"> <!-- 정보 -->
									<div class="row">
										<div class="pname">아이스 린넨 크롭 와이드팬츠</div>
										<div class="poption">30 32 34 / 2개</div>
										<div class="orderbuttonbox"> <!-- 버튼 -->
											<button onclick="">배송조회</button>
											<button onclick="">취소신청</button>
											<button onclick="">리뷰작성</button>
										</div>
									</div>
								</div>
								<div class="col-sm-3">
									<span> 상품 준비중</span>
								</div>
							</div>
						</div>
					</div>
					
					
				</div>
			</div>
		</div>
	</div>
	
	<%@include file="../footer.jsp" %>

<script src="/jspweb/js/myshopping.js" type="text/javascript"></script>

</body>
</html>