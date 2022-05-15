<%@page import="dao.ChatDao"%>
<%@page import="dto.Chat"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@include file="../header.jsp" %>
	<div class="container">
		<h3>비회원제 실시간 채팅 페이지</h3>
		<div id="chattable" style="width: 500px; height: 500px; border: solid 1px black; margin: 0 auto;">

		</div>
		<div style="width: 500px; margin: 0 auto;">
			<input id="nickname" type="text" placeholder="닉네임">
			<input id="chatcontent" type="text" placeholder="내용">
			<button type="button" onclick="chat()">입력</button>
		</div>
	</div>
	<%@include file="../footer.jsp" %>
	
	<script src="/jspweb/js/chat.js" type="text/javascript"></script>

</body>
</html>