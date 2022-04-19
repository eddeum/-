<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

	<style type="text/css">
	
		#contents{
			margin: 200px 0px;
		}
		table{width: 400px; margin: 0 auto;}
		input{height: 25px; }
		button{padding: 22px 20px;}
		h3{text-align: center; padding-bottom: 20px;}

	</style>
</head>
<body>

	<%@include file="header.jsp" %> 	<!-- 헤더 -->	
	<%@include file="mainimage.jsp" %> 	<!-- 헤더 이미지 -->
	<!-- 본문 -->
		<div id="contents">
			<h3>로그인</h3>
			<form>
				<table id="t1">
					<tr> <td>아이디</td> <td><input type="text"></td> <td rowspan="2"><button>로그인</button></td> </tr>
					<tr> <td>비밀번호</td> <td><input type="password"></td> </tr>
				</table>
			</form>
		</div>
	<%@include file="footer.jsp" %> 	<!-- 푸터 -->

</body>
</html>