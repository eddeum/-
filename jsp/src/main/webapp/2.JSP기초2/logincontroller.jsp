<%@page import="Dao.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        
        Dao memberDao = new Dao();
      	boolean result = memberDao.login(id, password);
      	if(result){
      		response.sendRedirect("main.jsp"); // 클라이언트에게 페이지 응답[반환]
      		session.setAttribute("loginid", id);
      			// 서블릿 내장객체 : session
      				// 서버 내 메모리 생성 // 모든 페이지[파일]에서 접근 할 수 있는 메모리
      				// 브라우저 마다 메모리 별도 생성
      	}else{
      		response.sendRedirect("main.jsp");
      	}
    %>