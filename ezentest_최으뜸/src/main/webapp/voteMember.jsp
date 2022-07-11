<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- 사용자정의 css -->
<link href="/ezentest_최으뜸/css/main.css" rel="stylesheet">
</head>
<body>

	<%@include file="header.jsp"%>

	<div>
		<h3 style="text-align: center;">투표하기</h3>
		<form id="voteform" action="/ezentest_최으뜸/vote" method="post">
			주민번호 <input type="text" id="birth" name="birth" autofocus><br>
			성명 <input type="text" id="name" name="name"><br> 투표번호 <select
				name="voteno" id="voteno">
				<option></option>
				<option value="1">[1] 김후보</option>
				<option value="2">[2] 이후보</option>
				<option value="3">[3] 박후보</option>
				<option value="4">[4] 조후보</option>
				<option value="5">[5] 최후보</option>
			</select><br> 투표시간 <input type="text" id="votetime" name="votetime"><br>
			투표장소 <input type="text" id="votearea" name="votearea"><br>
			유권자확인 <input type="radio" name="confirm" value="Y">확인 <input
				type="radio" name="confirm" value="N">미확인 <br>
			<button onclick="vote()" type="button">투표하기</button>
			<button onclick="reset()" type="button">다시쓰기</button>

		</form>
	</div>

	<%@include file="footer.jsp"%>

	<script type="text/javascript" src="/ezentest_최으뜸/js/main.js"></script>

</body>
</html>