<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="signupcontroller.jsp" method="post">
		<!-- action = "이동경로(파일)" / method -->
		<input type="text" name="id" placeholder="아이디 입력">
		<input type="password" name="password" placeholder="비밀번호 입력">
		<input type="text" name="name" placeholder="이름 입력">
		<input type="submit" value="전송">
	</form>

</body>
</html>