<%@page import="dto.Member"%>
<%@page import="dao.Dao"%>
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

	<% ArrayList<Member> memberlist = Dao.getDao().getmember(); %>
	<%@include file="header.jsp"%>

	<div>
		<h3 style="text-align: center;">후보조회</h3>
		<table id="membertable">
			<tr>
				<th>후보번호</th>
				<th>성명</th>
				<th>소속정당</th>
				<th>학력</th>
				<th>주민번호</th>
				<th>지역구</th>
				<th>대표전화</th>
			</tr>

			<%for(Member member : memberlist){ 
				String school = "";
				if(member.getP_SCHOOL().equals("1")){member.setP_SCHOOL("고졸");}
				else if(member.getP_SCHOOL().equals("2")){member.setP_SCHOOL("학사");}
				else if(member.getP_SCHOOL().equals("3")){member.setP_SCHOOL("석사");}
				else{member.setP_SCHOOL("박사");;}
			%>

			<tr>
				<td><%=member.getM_NO() %></td>
				<td><%=member.getM_NAME() %></td>
				<td><%=member.getP_NAME() %></td>
				<td><%=member.getP_SCHOOL() %></td>
				<td><%=member.getM_JUMIN() %></td>
				<td><%=member.getM_CITY() %></td>
				<td><%=member.getP_TEL() %></td>
			</tr>

			<%} %>

		</table>
	</div>

	<%@include file="footer.jsp"%>


</body>
</html>