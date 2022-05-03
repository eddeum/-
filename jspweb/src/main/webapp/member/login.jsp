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
	<div class="container loginpage">
	<h3 style="padding-bottom: 20px;">로그인 페이지</h3>
		<form action="../login" method="post">
			아이디 : <input type="text" name="mid">
			비밀번호 : <input type="text" name="mpassword">
			<input type="submit" value="로그인">
			<!-- 만약에 로그인 실패시 -->
			<%
				String result = request.getParameter("result");
				if(result != null && request.equals("2") ){
			%>
				<span>동일한 회원정보가 없습니다.</span>
			<%		
				}
			%>
		</form>
	</div>
	<%@include file="../footer.jsp" %>

</body>
</html>