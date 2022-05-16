<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>제품 재고</h3>
	<br>
	<div class="row">
		카테고리목록
		<select id="categorybox" class="form-control" style="width: 200px;"> <!-- 제품목록이 출력되는 부분 -->
		</select>
		제품목록
		<select id="productbox" class="form-control" style="width: 200px;"> <!-- 제품명이 출력되는 부분 -->
		</select>
	</div>
	
	<form id="stockaddform" style="display: none;">
		색상 <input type="text" id="scolor">
		사이즈 <input type="text" id="ssize">
		수량 <input type="text" id="samount">
		<button type="button" onclick="stockadd()">재고 추가</button>
	</form>
	
	 재고목록
	 <table id="stocklistbox"> 
	 
	 </table>
	 
	<!-- 사용자정의 JS -->
	<script src="/jspweb/js/productstock.js" type="text/javascript"></script>
</body>
</html>