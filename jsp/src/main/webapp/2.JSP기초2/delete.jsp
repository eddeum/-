<%@page import="Dao.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
   			
    		int mnum = Integer.parseInt(request.getParameter("mnum"));
        	Dao memberdao = new Dao();
        	System.out.println("메롱메롱");
        	boolean result = memberdao.delete(mnum);
        	System.out.println("메롱메롱메롱");
        	if(result){
        		response.sendRedirect("main.jsp");
        		System.out.println("회원탈퇴 성공");
        	}else{
        		response.sendRedirect("main.jsp");
        		System.out.println("회원탈퇴 실패");
        	}
    %>