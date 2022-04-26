<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<!-- 부트스트랩 css CDN -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<!-- 사용자정의 css -->
	<link href="index.css" rel="stylesheet">
	<!-- 폰트어썸[아이콘] -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
</head>
<body>
	<!-- 훈스쇼핑몰 연습 -->
	
	<div class="col-md-10 offset-2 fixed-top pb-1 pt-5 px-5"> <!-- 상단고정 -->
		<div class="col-md-7 offset-5 d-flex justify-content-end"> <!-- 헤더 메뉴(오른쪽 배치) -->
			<ul class="nav"> <!-- 해당 리스트[ul, ol] 가로배치 -->
				<li class="tophead"> <a href="login.jsp">LOGON</a> </li>
				<li class="tophead"> <a href="#">JOIN</a> </li>
				<li class="tophead"> <a href="#">CART</a> </li>
				<li class="tophead"> <a href="#">MY PAGE</a> </li>
				<li class="tophead"> <a href="#">SNS</a> </li>
				<li class="tophead"> <a href="#">BOOKMARK</a> </li>
			</ul>
		</div>
	</div>
	
	<div class="row">
		<div class="col-md-2 sidemenu"> <!-- 사이드바 메뉴 -->
			<h3>HUNS</h3>
			<ul class="menu">
				<li>BEST</li>
				<li>NEW</li>
				<li>당일배송</li>
				<li>1+1/코디세트</li>
			</ul>
			<ul class="menu">
				<li>아우터</li>
				<li>상의</li>
				<li>셔츠</li>
				<li>니트/가디건</li>
				<li>팬츠</li>
				<li>트레이닝</li>
				<li>신발</li>
				<li>악세사리</li>
				<li>세일</li>
			</ul>
			<ul class="menu">	
				<li>NOTICE</li>
				<li>Q＆A</li>
				<li>REVIEW</li>
				<li>EVENT</li>
			</ul>
			
			<div id="search">
				<input type="text"> <i class="fas fa-search"></i>
			</div>
			
			<div id="notice">
				고객센터　***-****-****<br>
				카카오채널 @이젠<br><br>
				MON - FRI AM9 - PM4<br>
				(LUNCH TIME PM12:30 - PM13:30)<br>
				SAT, SUN, HOLIDAY CLOSE<br>
				업무시간외 문의는<br>
				Q＆A 게시판을 이용부탁드립니다.<br><br>
				우리은행 ****-***-******<br>
				예금주 : (주)이젠컴퍼니
			</div>
		</div>
		
		<div class="col-md-10 offset-2 content"> <!-- 본문 -->
			<div id="cs" class="col-md-11 offset-1 carousel slide" data-bs-ride="carousel" data-bs-interval="2000"> <!-- 캐러셀 -->
				<div class="carousel-indicators">
					<button data-bs-target="cs" data-bs-slide-to="0" class="active"></button>
					<button data-bs-target="cs" data-bs-slide-to="1"></button>
					<button data-bs-target="cs" data-bs-slide-to="2"></button>
				</div>
				<div class="carousel-inner">
					<div class="carousel-item active"> <img alt="" src="img/1.jpg"> </div>
					<div class="carousel-item"> <img alt="" src="img/2.jpg"> </div>
					<div class="carousel-item"> <img alt="" src="img/3.jpg"> </div>
				</div>
				<button class="carousel-control-prev" data-bs-target="#cs" data-bs-slide="prev">
					<span class="carousel-control-prev-icon"></span>
				</button>
				<button class="carousel-control-next" data-bs-target="#cs" data-bs-slide="next">
					<span class="carousel-control-next-icon"></span>
				</button>
			</div>
			
			<div class="col-md-11 offset-1 bestseller">
			<p id="b1">BEST SELLER</p>
			<p id="b2">#베스트셀러</p>
			</div>
			
			<div class="col-md-11 offset-1 product"> <!-- 제품목록 -->
			<%for(int i=0; i<5; i++){ %>
				<div class="row">
					<div class="col-md-4">
						<div>
							<div> <img alt="" src="img/item1.jpg" style="width: 400px;"> </div>
							<div>
								<p class="ptitle">[1+1+1]아이스 쿨링 반팔티</p>
								<div style="border: solid 1px #eeeeee;"></div>
								<p class="price">22,900원</p>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div>
							<div> <img alt="" src="img/item2.webp" style="width: 400px;"> </div>
							<div>
								<p class="ptitle">[1+1]플레인 와이드 밴딩팬츠</p>
								<div style="border: solid 1px #eeeeee;"></div>
								<p class="price">29,800원</p>
								<p class="size">2 color / 2 size</p>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div>
							<div> <img alt="" src="img/item3.webp" style="width: 400px;"> </div>
							<div>
								<p class="ptitle">[1+1]롱&숏 맞춤 레이어드 반팔티</p>
								<div style="border: solid 1px #eeeeee;"></div>
								<p class="price">23,900원</p>
								<p class="size">2 type / 3 color / 4 size</p>
							</div>
						</div>
					</div>

				</div>
				<%} %>
				<div class="col-md-11 offset-1 insta">
					<p id="i1">INSTAGRAM</p>
					<p id="i2">@ezen</p>
				</div>
			</div> <!-- 제품목록 end -->
			
			<div class="col-md-11 offset-1" style="border-top: solid 1px #eeeeee;"> <!-- footer -->
				<div class="nav footer">
					<div class="col-md-2 foot1">
						<ul>
							<li class="foottitle">S H O P    I N F O .</li>
							<li class="info"> <a href="#">ABOUT US</a> </li>
							<li class="info"> <a href="#">AGREEMENT</a> </li>
							<li class="info"> <a href="#">PRIVACY POLICY</a> </li>
							<li class="info"> <a href="#">SHOPPING GUIDE</a> </li>
						</ul>
					</div>
					<div class="col-md-3 foot1">
						<ul>
							<li class="foottitle">C U S T O M E R    C E N T E R .</li>	
							<li id="number">***-****-****</li>	
							<li id="kakao"> <a href="#">카카오채널 : @이젠</a></li>	
							<li class="info">MON - FRI AM9 - PM4<br>
							(LUNCH TIME PM12:30 - PM13:30)<br>
							SAT, SUN, HOLIDAY CLOSE
							</li>	
							<li id="info2">업무시간외 문의는<br>
							Q＆A 게시판을 이용부탁드립니다.<br><br>
							</li>	
							<li class="foottitle">B A N K    A C C O U N T .</li>
							<li class="info">우리은행 ****-***-******</li>
							<li class="info">예금주 : (주)이젠컴퍼니</li>				
						</ul>
					</div>
					<div class="col-md-4 foot1">
						<ul>
							<li class="foottitle">C O M P A N Y    I N F O .</li>
							<li class="info3">COMPANY : (주)이젠컴퍼니 CEO : 유이젠 TEL : ***-****-****</li>
							<li class="info3">BUSINESS NUMBER : ***-**-***** / 2021-경기하남-0552 [사업자정보확인]</li>
							<li class="info3">ADDRESS : 13024 경기도 하남시 하남대로 506 (하산곡동) 2층</li>
							<li class="info3">ADMIN : 김이젠 (ezen22@naver.com) HOSTING : (주)CAFE24</li>
							<li class="info3">온라인 전자상거래 안전 서비스 [서비스가입사실확인]</li>
							<li class="info4">반품주소 / CJ대한통운(****-****)</li>
							<li class="info3">CJ대한통운 반품주소 : 우편번호 05839) 서울시 송파구 충민로52 CJ대한통운 잠실유정대리점</li>
							<li class="info3">타택배이용 반품주소 : 우편번호 12729) 경기도 광주시 초월읍 산수로 625-12 A동 3층</li>
							<li class="info3">※타택배 이용시 로젠택배,롯데택배불가(반송될수 있습니다)※</li>
							<li class="info4">Copyright @ (주)이젠컴퍼니. All rights reserved. by uuniq.</li>
						</ul>
					</div>
				</div>
			</div> <!-- 푸터 end -->
		</div>
	</div>
	<!-- 부트스트랩 js cdn -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

</body>

</html>