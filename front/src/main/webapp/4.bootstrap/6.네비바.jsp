<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<%@include file="1.설치.jsp" %>
	
	<div class="container"> <!-- 박스권 -->
		<div class="navbar navbar-expand-md navbar-light"> <!-- 네비게이션바 -->
		
		<!-- 메뉴 사이즈 작아지는 경우 -->
		<button class="navbar-toggler" type="button"
			data-bs-toggle="collapse" data-bs-target="#navmenu"
			aria-controls="navbarcontents" aria-expanded="false" aria-label="toggle navi">
			<span class="navbar-toggler-icon"></span>
		</button>
		
			<div class="collapse navbar-collapse" id="navmenu"> <!-- collapse : 사이즈가 작아지면(760px이하) 화면에서 메뉴가 사라짐 -->
			
				<a href="#" class="navbar-brand">로고</a> <!-- navbar-brand : 로고만들때 많이 사용하는 클래스 -->
			
				<ul class="navbar-nav"> <!-- 네비게이션 목록 -->
					<li class="nav-item"> <a href="#" class="nav-link">메뉴1</a> </li>	<!-- 네비게이션 목록 값 -->
					<li class="nav-item"> <a href="#" class="nav-link">메뉴2</a> </li>
					<li class="nav-item"> <a href="#" class="nav-link">메뉴3</a> </li>
					<li class="nav-item dropdown"> <!-- 드롭다운 메뉴 -->
						<!-- 하단 텍스트를 클릭했을때 메뉴 펼치기 -->
							<!--
								nav-link 링크 설정값 : 밑줄제거, 여백, 색상 [선택사항임]
								dropdown-toggle : 아래화살표 [선택사항임]
								class="nav-link : 글자색상 바뀜(기본:파란색)
								data-bs-toggle="dropdown" : 목록 펼쳐짐 [필수사항]
								class="dropdown-item" : 목록이 수직으로보여짐(기본:수평)
							  -->
						<a href="#" class="nav-link" data-bs-toggle="dropdown" >
						드롭다운
						</a>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="#">드롭다운 메뉴1</a>
							<a class="dropdown-item" href="#">드롭다운 메뉴2</a>
							<a class="dropdown-item" href="#">드롭다운 메뉴3</a>
						</div>
					</li>
				</ul> <!-- 네비게이션 목록 끝 -->
				
				<form action="">
					<div class="row">
						<div class="col-md-5">
							<input type="text" class="form-control" placeholder="검색어">
						</div>
						<div class="col-md-5">
							<button class="btn btn-info" type="submit">검색</button>
						</div>
					</div>
				</form>
			</div>	
		</div>
	</div>
	
	
	
</body>
</html>