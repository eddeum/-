<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

	<style type="text/css">
		h2{ text-align: center; margin-bottom: 50px;}
		form{
			width: 1150px;
			margin: 0 auto;
		}
		#search{
			width: 1150px;
			height: 60px;
			background-color: #f9f7f9;
			border-bottom: solid 2px #eeeeee;
		}
		#search_box{
			padding-top: 15px;
			text-align: center;	
		}
		input{
			width: 400px;
			height: 30px;
		}
		#btn{
			background-color: #555555;
			color: white;
			width: 100px;
			height: 30px;
		}
		table{
			width: 1150px;
			margin-top: 50px;
			width: 1000px;
			margin: 0 auto;
			text-align: center;
			line-height: 180%;

			border-collapse: collapse;
		}
		th, td{
			border-bottom: solid 1px #eeeeee;
			padding: 5px 0px;
		}
		.con{
			text-align: left;
			padding-left: 100px;
		}
	
	</style>
</head>
<body>

	<%@include file="header.jsp" %> 	<!-- 헤더 -->	
	<%@include file="mainimage.jsp" %> 	<!-- 헤더 이미지 -->
	<!-- 본문 -->
	<h2>공지사항</h2>
	<form>
		<div id="search">
			<div id="search_box">
				<input type="text" value="검색어를 입력해주세요.">
				<button id="btn">검색</button>
			</div>
		</div>
		<div>
			<table>
				<tr class="low"> <th>번호</th> <th>제목</th> <th>등록일</th> </tr>
				<tr> <td>3</td> <td class="con">[공지사항] 개인정보 처리방침 변경안내처리방침</td> <td>2017.07.13</td> </tr>
				<tr> <td>2</td> <td class="con">공지사항 안내입니다. 이용해주셔서 감사합니다.</td> <td>2017.06.15</td> </tr>
				<tr> <td>1</td> <td class="con">공지사항 안내입니다. 이용해주셔서 감사합니다.</td> <td>2017.06.15</td> </tr>
			</table>
		</div>
	</form>
	<%@include file="footer.jsp" %> 	<!-- 푸터 -->
</body>
</html>