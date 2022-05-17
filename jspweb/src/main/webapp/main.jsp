<%@page import="java.util.TreeSet"%>
<%@page import="java.util.Set"%>
<%@page import="dto.Stock"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="dto.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>

	<%@include file="header.jsp" %>
	
	<div class="container">
		<div id="mainslide" class="carousel slide" data-bs-ride="carousel" data-bs-interval="1000"> <!-- 캐러셀 -->
			<!-- 슬라이드 하단 위치 버튼 -->
			<div class="carousel-indicators">
				<button type="button" data-bs-target="#mainslide" data-bs-slide-to="0" class="active"></button>
				<button type="button" data-bs-target="#mainslide" data-bs-slide-to="1"></button>
				<button type="button" data-bs-target="#mainslide" data-bs-slide-to="2"></button>
			</div>
			<div class="carousel-inner"> <!-- 이미지 목록 -->
				<div class="carousel-item active"> <!-- 이미지 -->
					<img alt="" src="img/main1.jpg">
				</div>
				<div class="carousel-item"> <!-- 이미지 -->
					<img alt="" src="img/main2.jpg">
				</div>
				<div class="carousel-item"> <!-- 이미지 -->
					<img alt="" src="img/main3.jpg">
				</div>
			</div>
			<!-- 왼쪽 이동버튼 -->
			<button class="carousel-control-prev" type="button" data-bs-target="#mainslide" data-bs-slide="prev">
				<span class="carousel-control-prev-icon"></span>
			</button>
			<!-- 오른쪽 이동버튼 -->
			<button class="carousel-control-next" type="button" data-bs-target="#mainslide" data-bs-slide="next">
				<span class="carousel-control-next-icon"></span>
			</button>
		</div>
		<div class="row adbox"> <!-- 광고 / 이벤트 -->
			<div class="col-md-6">
				<img alt="" src="img/mainad1.gif">
			</div>
			<div class="col-md-6">
				<img alt="" src="img/mainad2.jpg">
			</div>
		</div>
		<div class="main_box"> <!-- 베스트 -->
			<h6 class="main_title">BEST</h6>
			<div class="row">
				<div class="col-md-3 best_box">
					<img alt="" src="img/best1.webp">
				</div>
					<div class="col-md-3 best_box">
					<img alt="" src="img/best1.webp">
				</div>
					<div class="col-md-3 best_box">
					<img alt="" src="img/best1.webp">
				</div>
					<div class="col-md-3 best_box">
					<img alt="" src="img/best1.webp">
				</div>
			</div>
		</div>
		<div  class="main_box"> <!-- 신상품 -->
			<h6 class="main_title">NEW ARRIVAL</h6>
			<div class="row">
			<%
				ArrayList<Product> list = ProductDao.getproduDao().getproductlist();
				for(Product p : list){
			%>
	
				<div class="col-md-4 best_box">
					<a href="product/productview.jsp?pnum=<%=p.getPnum() %>"> <!-- 제품이미지 클릭시 상세페이지로 이동 => 제품번호 -->
						<img alt="" src="admin/productimg/<%=p.getPimg()%>"> 
					</a>
					<div class="p_item">
						<div class="p_title"><%=p.getPname() %></div>
						<%
							// 해당 제품의 모든 재고 꺼내오기
							ArrayList<Stock> stocks = ProductDao.getproduDao().getstock(p.getPnum());
							// 해당 제품의 사이즈 목록 만들기[중복 제거 = set 컬렉션]
							Set<String> sizelist = new TreeSet<>();
							for(Stock s : stocks){ sizelist.add(s.getSsize() );}
						%>
						<div class="p_size">
						<% for(String temp : sizelist){ // 해당 사이즈 목록 표시 %>
							<%=temp + "  " %>
						<% } %>
						</div>
						<div class="row">
						<%
							// 천단위 쉼표 -> 형식 클래스[정수 -> 문자열]
							DecimalFormat df = new DecimalFormat("###,### 원");
						%>
						
						<%if(p.getPdiscount() == 0){ // 할인이 없으면 %>
							<div class="p_price"><%=df.format(p.getPprice() ) %></div>
						<%}else{ // 할인이 있으면 %>
							<% Float price = p.getPprice() - (p.getPprice() * p.getPdiscount()); %>
							<div class="p_discount"><%=df.format(p.getPprice() ) %></div>
							<div class="p_price"><%=df.format(price) %></div>
						<%	} %>
							<div class="p_review col-md-3 offset-9">리뷰 : 20</div>
						</div>
					</div>
				</div>
				
			<%	} %>	
		
			</div>
		</div>
		<div> <!-- 실시간 구매후기 -->
			
		</div>
	</div>
	
	<%@include file="footer.jsp" %>

</body>
</html>