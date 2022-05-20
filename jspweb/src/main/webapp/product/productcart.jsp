<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="../css/productcart.css" rel="stylesheet">
</head>
<body>

<%@include file="../header.jsp" %>

<div class="container">
	<div class="processbox"> <!-- 진행상황 표시 -->
		<span>01 옵션선택</span> <span>></span>
		<span id="process_active">02 장바구니</span> <span>></span>
		<span>03 주문결제</span> <span>></span>
		<span>04 주문완료</span>
	</div>
	<table class="table my-5" id="carttable">
		<!-- js에서 데이터가 들어가는 위치 -->
	</table>
	<div class="col-sm-2">
		<button onclick="cancel(-1)" class="form-control">상품 전체삭제</button>
	</div>
	<div class="paybox"> <!-- 사용자정의 css만 사용되는 구역 -->
		<span>총 상품금액</span> <span id="sumprice">20,000원</span>
		<span>+</span>
		<span>배송비</span> <span id="deliverypay">3,000원</span>
		<span>=</span>
		<span>총 주문금액</span> <span id="totalpay">23,000원</span>
		<div class="pointbox">
			<span>주문시 적립예정 포인트</span> <span id="point">2,000</span>
		</div>	
	</div>
	<div class="row my-5"> <!-- 부트스트랩만 사용되는 구역 -->
		<div class="col-sm-3 offset-3">
			<a href="/jspweb.main.jsp"> <button class="form-control py-4">계속 쇼핑하기</button> </a>
		</div>
		<div class="col-sm-3">
			<a href="/jspweb/product/orderpay.jsp">
			<button style="background-color: blue; color: white;" class="form-control py-4">구매하기</button>
			</a>
		</div>
	</div>

</div>

<%@include file="../footer.jsp" %>

<script src="/jspweb/js/productcart.js" type="text/javascript"></script>

</body>
</html>