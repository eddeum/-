<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ezen 쇼핑몰</title>
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">


	<!-- 사용자정의 css -->
	<link href="/jspweb/css/main.css" rel="stylesheet">
	
</head>
<body>

	<!-- 헤더페이지[모든페이지에서 사용되기 때문에 = 최상위에서 절대경로]  -->
	
	<%
		String loginid = (String)session.getAttribute("login"); // 세션호출 (기본타입 = Object)
	
	%>

	
	<div class="container col-md-10 offset-2 header">
		<div class="row">
			<!-- 공통 -->
			<div class="col-md-4">
				<a href="/jspweb/main.jsp">Home</a>
			</div>
				
			<!-- 로그인이 안된 상태 -->
			<div class="col-md-3 offset-5">
			<% if(loginid == null){ %>
				
				<a href="/jspweb/member/login.jsp">로그인</a>
				<a href="/jspweb/member/signup.jsp">회원가입</a>
	
			<%} %>
			</div>
			
			<!-- 만약에 로그인된 상태 -->
			<div class="col-md-3 offset-5">
			<% if(loginid != null){ %>
				<span> <%=loginid %>님 </span>
				<a href="logout">로그아웃</a>
				<a href="/jspweb/member/memberinfo.jsp">회원정보</a>
			<%} %>
			</div>
		</div>
	</div>


	<!-- 사용자정의 js -->
	<script src="/jspwep/js/main.js" type="text/javascript"></script>
	<!-- 부트스트랩 js cdn -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<!-- jquery  최신 cdn -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
</body>
</html>