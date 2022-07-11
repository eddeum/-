<%@page import="java.util.ArrayList"%>
<%@page import="dao.MemberDao"%>
<%@page import="dao.BoardDao"%>
<%@page import="dto.Board"%>
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
	
	<div class="container">
	<h3>내가 쓴글</h3>
	<table class="table">
		<tr>
			<th>번호</th> <th>제목</th> <th>내용</th> <th>조회수</th> <th>작성일</th>
		</tr>
	<%
		String mid = (String)session.getAttribute("login");
		mnum = MemberDao.getmemberDao().getmnum(mid);
		ArrayList<Board> myboardlist = BoardDao.getBoardDao().getmyboard(mnum);
		for(Board board : myboardlist){
	%>
		<tr>
			<th><%=board.getBnum() %> </th>
			<th><%=board.getBtitle() %> </th>
			<th><%=board.getBcontent() %> </th>
			<th><%=board.getBview() %> </th>
			<th><%=board.getBdate() %> </th>
		</tr>
	<%
		}
	%>
	</table>
	</div>

	<%@include file="../footer.jsp" %>
	
</body>
</html>