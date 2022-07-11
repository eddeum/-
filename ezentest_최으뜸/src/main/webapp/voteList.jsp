<%@page import="dao.Dao"%>
<%@page import="dto.Vote"%>
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
	<% ArrayList<Vote> votelist = Dao.getDao().getvotelist(); %>
	<%@include file="header.jsp"%>

	<div>
		<h3 style="text-align: center;">투표검수조회</h3>
		<table id="votetable">
			<tr>
				<th>성명</th>
				<th>생년월일</th>
				<th>나이</th>
				<th>성별</th>
				<th>후보번호</th>
				<th>투표시간</th>
				<th>유권자확인</th>
			</tr>
			<%
				for(Vote vote : votelist){
					String birth = "19"+vote.getV_JUMIN().substring(0,2)+"년"+vote.getV_JUMIN().substring(3,5)+"월"+vote.getV_JUMIN().substring(5,7)+"일생";
					int year = Integer.parseInt("19"+vote.getV_JUMIN().substring(0,2) ) ;
					int age = 2022-year-2;
					String gender = "";
					if(vote.getV_JUMIN().substring(6,7).equals("1")){gender="남";}
					else{gender="여";}
					String time = vote.getV_TIME().substring(0, 2)+":"+vote.getV_TIME().substring(2, 4);
					String confirm = "";
					if(vote.getV_CONFIRM().equals("Y")){confirm="확인";}
					else{confirm="미확인";}
			%>
			<tr>
				<td><%=vote.getV_NAME() %></td>
				<td><%=birth %></td>
				<td>만 <%=age %>세
				</td>
				<td><%=gender %></td>
				<td><%=vote.getM_NO() %></td>
				<td><%=time %></td>
				<td><%=confirm %></td>
			</tr>
			<%	} %>
		</table>
	</div>

	<%@include file="footer.jsp"%>

</body>
</html>