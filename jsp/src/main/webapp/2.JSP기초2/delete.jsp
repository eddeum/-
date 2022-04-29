<%@page import="Dao.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    request.setCharacterEncoding("UTF-8");
        	
        	int mnum = Integer.parseInt(request.getParameter("mnum"));
        	Dao memberdao = new Dao();
        	boolean result = memberdao.delete(mnum);
        	if(result){
        		response.sendRedirect("main.jsp");
        		session.setAttribute("loginid", null);
        		System.out.println("회원탈퇴 성공");
        	}else{
        		response.sendRedirect("main.jsp");
        		System.out.println("회원탈퇴 실패");
        	}
    %>