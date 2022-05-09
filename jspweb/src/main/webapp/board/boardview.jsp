<%@page import="dao.MemberDao"%>
<%@page import="dto.Board"%>
<%@page import="dao.BoardDao"%>
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
		<h3>게시판 상세</h3>
		<%
			int bnum = Integer.parseInt(request.getParameter("bnum") );
			String mid = (String)session.getAttribute("login"); 
			
			// 조회수 중복방지 세션이 존재하지 않으면
			if(session.getAttribute(mid+bnum) == null){
				// 조회수 증가
				BoardDao.getBoardDao().increview(bnum);
				// 조회수 중복방지[세션 생성]
				session.setAttribute(mid+bnum , true ); // 세션명 : 아이디 + 게시물번호 = true
				session.setMaxInactiveInterval(60*60*24); // 24시간
			} // if end	
			Board board = BoardDao.getBoardDao().getboard(bnum);			
			if(board.getMnum() == MemberDao.getmemberDao().getmnum(mid)){
		%>
		<a href="delete2?bnum=<%=board.getBnum()%>"> <button>삭제</button> </a>
		<a href="boardupdate.jsp?bnum=<%=board.getBnum()%>"> <button>수정</button> </a>
		<%} %>
		<a href="boardlist.jsp"> <button>목록</button> </a>
		<table>
			<tr> <td>번호</td> <td><%=board.getBnum() %></td> </tr>
			<tr> <td>작성자</td> <td><%=board.getMid() %></td> </tr>
			<tr> <td>작성일</td> <td><%=board.getBdate() %></td> </tr>
			<tr> <td>조회수</td> <td><%=board.getBview() %></td> </tr>
			<tr> <td>제목</td> <td><%=board.getBtitle() %></td> </tr>
			<tr> <td>내용</td> <td><%=board.getBcontent() %></td> </tr>
			<%
				if(board.getBfile() == null){
			%>
				<tr> <td>첨부파일</td> <td> - </td> </tr>
			<%
				}else{
			%>
					<tr> <td>첨부파일</td> <td> <a href="filedown?bfile=<%=board.getBfile()%>">
					<%=board.getBfile() %></a> </td> </tr> <!-- 다운로드 -->
			<% } %>

		</table>
	</div>	
		
	<%@include file="../footer.jsp" %>
</body>
</html>