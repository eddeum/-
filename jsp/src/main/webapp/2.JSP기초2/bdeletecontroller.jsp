<%@page import="Dao.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		// 1. 전페이지로부터 게시물번호 요청
		int bno = Integer.parseInt(request.getParameter("bno") );
		// 2. dao 게시물삭제 메소드 호출
		Dao dao = new Dao();
		boolean result = dao.bdelete(bno);
		if(result){
			response.sendRedirect("main.jsp");
		}
	%>

</body>
</html>