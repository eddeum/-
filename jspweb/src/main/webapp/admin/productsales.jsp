<%@page import="dto.Orderdetail"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<style type="text/css">
		#chartdiv1, #chartdiv2{
			 width: 100%;
			 height: 500px;
		}
		#chartdiv3 {
			width: 100%;
			height: 500px;
			max-width: 100%
		}
	</style>
</head>
<body>
	<h3>매출 관리</h3>
	
	<div class="container">
		<div> <!-- 일 매출 막대차트 -->
			<div id="chartdiv1"></div>
		</div>
		<div class="row">
			<div class="col-sm-6"> <!-- 일 매출 테이블 -->
				
				<%
					ArrayList<Orderdetail> list = ProductDao.getproduDao().getorderdetail();
				
				%>
				
				<table class="table table-hover">
					<tr>
						<th>주문상세번호</th> <th>주문수량</th> <th>주문가격</th> <th>주문번호</th> <th>재고번호</th>
					</tr>
					<%
						for(Orderdetail orderdetail : list){
					%>
					<tr onclick="getchart(<%=orderdetail.getSnum()%>)">
						<td><%=orderdetail.getOrderdetailnum() %></td>
						<td><%=orderdetail.getSamount() %></td>
						<td><%=orderdetail.getTotalprice() %></td>
						<td><%=orderdetail.getOrdernum() %></td>
						<td><%=orderdetail.getSnum() %></td>
					</tr>
					<%	} %>
				</table>
			</div>
			<div class="col-sm-6"> <!-- 카테고리별 도넛차트 -->
				<div id="chartdiv2"></div>
			</div>
			<div> <!-- 제품별 판매추이 선차트  -->
				<div id="chartdiv3"></div>
			</div>
		</div>
	</div>
	
<script src="/jspweb/js/productsales.js" type="text/javascript"></script>

</body>
</html>