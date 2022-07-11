<%@page import="dao.Dao"%>
<%@page import="dto.Member"%>
<%@page import="java.util.ArrayList"%>
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
	<% ArrayList<Member> list = Dao.getDao().getvoteresult(); %>
	<%@include file="header.jsp"%>

	<div>
		<h3 style="text-align: center;">후보자등수</h3>
		<table id="resulttable">
			<tr>
				<th>후보번호</th>
				<th>성명</th>
				<th>총투표건수</th>
			</tr>
			<%
				for(Member member : list){
			%>
			<tr>
				<td><%=member.getM_NO() %></td>
				<td><%=member.getM_NAME() %></td>
				<td><%=member.getV_TOTAL() %></td>
			</tr>
			<%	} %>
		</table>
	</div>

	<%@include file="footer.jsp"%>

</body>
</html>