<%@page import="dao.TeamDao"%>
<%@page import="team.Country"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="../header.jsp" %>

	<div class="container" my-5>
		<button onclick="gameconnect('<%=(String)session.getAttribute("login")%>')" class="btn">게임 접속</button>
		<div>
			<h3>현재 접속된 유저들</h3>
			<div id="connectlist"></div>
		</div>
		
		<table class="table my-5">
		<%
			ArrayList<Country> clist = TeamDao.getTeamDao().getcountry();
			int location = 1;
			for(int r = 1; r<=5; r++){
		%>
		<tr>
		<%
				for(int c = 1; c<=5; c++){
					if( (r == 2 || r == 3 || r ==4) && (c == 2 || c == 3 || c ==4) ){
						if(r == 2 && c == 2){
		%>
						<td width="20%" style="background-color: #eeeeee"><h3>순서</h3><h5 id="turndisplay" style="color: red;">플레이어1</h5></td>
		<%				}else if(r == 2 && c == 3){ %>
						<td width="20%" style="background-color: #eeeeee">주사위 결과 <br> <h1 id="dicedisplay"></h1></td>
		<%				}else if(r == 3 && c == 3){ %>
						<td width="20%" style="background-color: #eeeeee"> <button onclick="diceroll()">주사위버튼</button> </td>		
		<%				}else{ %>
						<td width="20%" style="background-color: #eeeeee"></td>		
		<%
						}
					}else{	
		%>
						<td width="20%" > <!-- 위치가 뭐지? -->
						<h1> </h1>
						<div id="gamelocation">말1, 말2, 말3</div>
						</td>
		<%			location++;} %>
		<%		} %>
		</tr>
		<%	} %>
		</table>
		<br>
		
		<div>
			<h3>현재 잔액 :</h3>
			<h3>현재 구매한 땅 :</h3>
		</div>
		
	</div>
<%@include file="../footer.jsp" %>
	
	<script src="/jspweb/team/marble.js" type="text/javascript"></script>

</body>
</html>