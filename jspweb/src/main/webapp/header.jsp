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
	
	<div class="container col-md-12"><!-- 박스권 형성 -->
		<div class="py-3"> <!-- 로고/로그인 메뉴 -->
			<div class="row"><!-- 가로배치 -->
				<div class="col-md-2"> <!-- 로고 -->
					<a href="/jspweb/main.jsp">Home</a>
				</div>
				<div class="col-md-4 offset-6"> <!-- 로그인 메뉴 -->
					<ul class="nav loginmenu"><!-- 가로배치 -->
						<% if(loginid == null){ %>
						<li> <a href="/jspweb/member/login.jsp">로그인</a> </li>
						<li> <a href="/jspweb/member/signup.jsp">회원가입</a> </li>
						<%} %>
					
						<% if(loginid != null){ %>
						<span> <%=loginid %>님 </span>
						<li> <a href="/jspweb/logout">로그아웃</a> </li>
						<li> <a href="/jspweb/member/myshopping.jsp">나의쇼핑</a> </li>
						<%} %>
						<li> <a href="/jspweb/board/boardlist.jsp">자유게시판</a> </li>
					</ul>
				</div>
			</div>
		</div>
		<div class="py-3"> <!-- 메뉴 -->
				<ul class="nav mainmenu">
					<li> <a href="#">BIG SIZE!</a> </li>
					<li> <a href="#">MUSCLE-FIT</a> </li>
					<li> <a href="#">1+1 이벤트</a> </li>
					<li> <a href="#">아우터</a> </li>
					<li> <a href="#">상의</a> </li>
					<li> <a href="#">바지</a> </li>
					<li> <a href="#">슈즈</a> </li>
					<li> <a href="#">악세사리</a> </li>
					<li> <a href="#">BEST</a> </li>
					<li> <a href="#">트레이닝</a> </li>
					<li> <a href="#">모델처럼입자!</a> </li>
					<li> <a href="#">50% 할인</a> </li>
					<li> <input type="text"><button>검색</button> </li>
					<li> <a href="#"> <img src="#">장바구니 이미지</a> </li>
				</ul>
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