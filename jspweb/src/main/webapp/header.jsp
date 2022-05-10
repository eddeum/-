<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ezen 쇼핑몰</title>

	<!-- 부트스트랩 -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<!-- 사용자정의 css -->
	<link href="/jspweb/css/main.css" rel="stylesheet">
	<!-- 어썸폰트[아이콘] -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
</head>
<body>

	<!-- 헤더페이지[모든페이지에서 사용되기 때문에 = 최상위에서 절대경로]  -->
	
	<%
		String loginid = (String)session.getAttribute("login"); // 세션호출 (기본타입 = Object)
	
	%>
	
	<div class="container"><!-- 박스권 형성 -->
		<div class="py-4">
			<div class="row">
				<div class="col-md-4">
					<a href="/jspweb/main.jsp" class="header_logo">EZEN SHOP</a>
				</div>
				<div class="col-md-4 offset-4 d-flex justify-content-end">
					<ul class="nav loginmenu"><!-- 가로배치 -->
						<% if(loginid == null){ %>
						<li> <a href="/jspweb/member/login.jsp" class="header_topmenu">로그인</a> </li>
						<li> <a href="/jspweb/member/signup.jsp" class="header_topmenu">회원가입</a> </li>
						<%} %>
					
						<% if(loginid != null){ %>
						<span class="header_topmenu"> <%=loginid %>님 </span>
						<li> <a href="/jspweb/logout" class="header_topmenu">로그아웃</a> </li>
						<li> <a href="/jspweb/member/myshopping.jsp" class="header_topmenu">나의쇼핑</a> </li>
						<%} %>
						<li> <a href="/jspweb/board/boardlist.jsp" class="header_topmenu">자유게시판</a> </li>
					</ul>
				</div>
			</div> 
		</div> <!-- 상단메뉴 끝 -->
		
		<div class="navbar navbar-expand-md navbar-light bg-white"> <!-- 본 메뉴 -->
			<ul class="navbar-nav col-md-12 justify-content-between">
				<li class="nav-item"> <a href="#">BIG SIZE!</a> </li>
				<li class="nav-item"> <a href="#" style="color: #00D8FF;">MUSCLE-FIT</a> </li>
				<li class="nav-item"> <a href="#" style="color: #0100FF;">1+1 이벤트</a> </li>
				<li class="nav-item dropdown"> <!-- dropdown : 드랍다운 -->
					<a href="#">아우터</a>  <!--  data-bs-toggle="dropdown" : 해당 태그를 클릭했을때 드랍다운 -->
					<!-- 드롭다운 -->
					<div class="dropdown-menu"> <!-- dropdown-menu : 드랍다운 내용물 -->
						<a class="dropdown-item" href="#">패딩, 점퍼</a>
						<a class="dropdown-item" href="#">코트</a>
						<a class="dropdown-item" href="#">재킷</a>
						<a class="dropdown-item" href="#">가디건</a>
						<a class="dropdown-item" href="#">HAND MADE</a>
						<a class="dropdown-item" href="#">양털, 아노락, 후드집업</a>
					</div>
				</li>
				<li class="nav-item"> <a href="#">상의</a> </li>
				<li class="nav-item"> <a href="#">바지</a> </li>
				<li class="nav-item"> <a href="#">슈즈</a> </li>
				<li class="nav-item"> <a href="#">악세사리</a> </li>
				<li class="nav-item"> <a href="#">BEST</a> </li>
				<li class="nav-item"> <a href="#">트레이닝</a> </li>
				<li class="nav-item"> <a href="#" style="color: #FFBB00;">모델처럼입자!</a> </li>
				<li class="nav-item"> <a href="#" style="color: #FF0000;">50% 할인</a> </li>
				<li class="nav-item"> <input type="text" class="header_input" size="13"> </li>
				<li class="nav-item"> <a href="#"> <i class="fas fa-search"></i> </a> </li>
				<li class="nav-item"> <a href="#">장바구니<span class="shoppingbox">3</span> </a> </li>
			</ul>
		</div> <!-- 본 메뉴 끝 -->
		
	</div> <!-- 메뉴 끝 -->
	
	
	

	


	<!-- 사용자정의 js -->
	<script src="/jspwep/js/main.js" type="text/javascript"></script>
	<!-- 부트스트랩 js cdn -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<!-- jquery  최신 cdn -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
</body>
</html>