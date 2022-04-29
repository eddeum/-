<%@page import="Dao.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
   			request.setCharacterEncoding("UTF-8");
    System.out.println("메롱");
    		String mid = request.getParameter("id");
        	Dao memberdao = new Dao();
        	System.out.println("메롱메롱");
        	boolean result = memberdao.delete(mid);
        	System.out.println("메롱메롱메롱");
        	if(result){
        		response.sendRedirect("main.jsp");
        		System.out.println("회원탈퇴 성공");
        	}else{
        		response.sendRedirect("main.jsp");
        		System.out.println("회원탈퇴 실패");
        	}
    %>