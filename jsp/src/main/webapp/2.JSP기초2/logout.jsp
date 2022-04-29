<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%
		// session.invalidate(); // [방법 1]모든 세션 초기화 -> 문제점 : 세션을사용하는 모든기능이 초기화됨(예시:로그인, 장바구니 등)
		session.setAttribute("loginid", null);
		// 페이지 전환
		response.sendRedirect("main.jsp");
	%>