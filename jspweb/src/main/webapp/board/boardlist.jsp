<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="dao.BoardDao"%>
<%@page import="dto.Board"%>
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


	<div class="container">
		<h3>자유게시판</h3>
		
		<%
			String mid = (String)session.getAttribute("login");
			if(mid != null){
		%>
		<a href="boardwrite.jsp">글쓰기</a>
		<%} %>
		
		<table class="table"> <!-- 테이블 : 부트스트랩 -->
			<tr>
				<th>번호</th> <th>제목</th> <th>작성자</th> <th>조회수</th> <th>작성일</th>
			</tr>
			<!-- for 문 -->
			<%
				ArrayList<Board> boardlist = BoardDao.getBoardDao().getboardlist();
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String today = sdf.format(date);
				for( Board board : boardlist ){
			%>
			<tr>
				<td> <%=board.getBnum() %> </td>
				<td> <%=board.getBtitle() %> </td>
				<td> <%=board.getMid() %> </td>
				<td> <%=board.getBview() %> </td>
				<%if(today==board.getBdate().split(" ")[0]){ %>
				<td> <%=board.getBdate().split(" ")[1]%> </td>
				<%}else{ %>
				<td> <%=board.getBdate() %> </td>
				<%} %>
			</tr>
			<%
				}
			%>
			
		</table>
	</div>
	
	<%@include file="../footer.jsp" %>

</body>
</html>