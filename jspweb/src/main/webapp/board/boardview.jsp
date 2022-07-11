<%@page import="dto.Reply"%>
<%@page import="java.util.ArrayList"%>
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
		%>
		
		
		<h2 class="boardview_title"><%=board.getBtitle() %></h2>
		<table>
			<tr> 
				<td width="25%">번호 : <%=board.getBnum() %></td> 
		 		<td width="25%">작성자 : <%=board.getMid() %></td> 
			 	<td width="25%">작성일 : <%=board.getBdate() %></td> 
			 	<td width="25%">조회수 : <%=board.getBview() %></td> 
			 </tr>
			 <tr>
			 	<td colspan="4"> 
			 		<div class="boardview_content">
			 			<%=board.getBcontent()%>
			 		</div>
			 	</td>
			</tr>
			<%
				if(board.getBfile() == null){
			%>
				<tr> <td colspan="4">첨부파일 : - </td> </tr>
			<%
				}else{
			%>
					<tr> <td colspan="4">첨부파일 : <a href="filedown?bfile=<%=board.getBfile()%>">
					<%=board.getBfile() %></a> </td> </tr> <!-- 다운로드 -->
			<% } %>

		</table>
<!-- --------------------------------------- 버튼 구역 --------------------------------------- -->		
		<div class="row">
		<% 
			if(board.getMnum() == MemberDao.getmemberDao().getmnum(mid)){
		%>
			<div class="col-md-2">
				<a href="delete2?bnum=<%=board.getBnum()%>"> <button class="form-control">삭제</button> </a>
			</div>
			<div class="col-md-2">
				<a href="boardupdate.jsp?bnum=<%=board.getBnum()%>"> <button class="form-control">수정</button> </a>
			</div>
		<%} %>
			<div class="col-md-2">
				<a href="boardlist.jsp"> <button class="form-control">목록</button> </a>
			</div>
		</div>
		
<!-- --------------------------------------- 댓글쓰기 구역 --------------------------------------- -->		
		<h4 class="boardview_title">댓글</h4>
		
		<%if(mid != null){ // 로그인이 되어있으면 %>
		
		<div class="row"> <!-- row : 가로배치 -->
			<div class="col-md-10">
				<textarea id="rcontent" class="form-control" rows="3"></textarea>
			</div>
			<div class="col-md-2">
				<button class="form-control py-4 my-1" onclick="replywrite(<%=bnum%>)">등록</button>
			</div>
		</div>
		<%}else{%>
		<h5 class="text-center">*로그인후 댓글쓰기가 가능합니다.</h5>
		<%}%>
	
<!-- --------------------------------------- 댓글출력 구역 --------------------------------------- -->		
		<table id="replytable" class="table"> <!-- 댓글 작성 성공시 해당 태그 새로고침 -->
		<%
			ArrayList<Reply> replylist = BoardDao.getBoardDao().replylist(bnum);
			for(Reply reply : replylist){
		%>
			<tr>
				<td class="replywriter" width="10%"> 
					<%=reply.getMid() %><br> 
					<span class="replyday"> <%=reply.getRdate() %> </span>
				</td>
				<td width="80%" colspan="2">
					<%=reply.getRcontent() %><br>
					<%if(mid != null && mid.equals(reply.getMid()) ){ // 본인이 작성한 댓글이면 %>
					<button class="btn replybtn" onclick="reupdateview(<%=reply.getRnum()%>)">수정</button>
					<button class="btn replybtn" onclick="replydelete(<%=reply.getRnum()%>)">삭제</button>
					<%} %>
					<button class="btn replybtn" onclick="rereplyview(<%=reply.getRnum()%>, <%=reply.getBnum()%>, '<%=mid%>')">댓글</button>
																												<!-- js메소드에 인수 넣을때 문자열일 경우 작은따옴표 쓰기 '' -->
				</td>
				<td></td>
			</tr>
<!-- --------------------------------------- 대댓글 구역 --------------------------------------- -->	
			<tr> <!-- 대댓글 입력창 -->
				<td></td>
				<td colspan="2" id=<%=reply.getRnum()%>></td>
				<!-- 해당 태그의 id값을 변수로 설정 = 댓글번호(댓글 한개당 1개씩) -->
			</tr>
			<!-- 대댓글 출력창 -->
			<%
				ArrayList<Reply> rereplylist = BoardDao.getBoardDao().rereplylist(bnum, reply.getRnum() );
				for(Reply rereply : rereplylist){
			%>
			<tr>
				<td></td>
				<td width="10%" class="replywriter"> 
					<%=rereply.getMid() %><br> 
					<span class="replyday"> <%=rereply.getRdate() %> </span>
				</td>
				<td width="80%">
					<%=rereply.getRcontent() %><br>
					<%if(mid != null && mid.equals(rereply.getMid()) ){ %>
					<button class="btn replybtn" onclick="reupdateview(<%=rereply.getRnum()%>)">수정</button>
					<button class="btn replybtn" onclick="replydelete(<%=rereply.getRnum()%>)">삭제</button>
					<%} %>
				</td>
			</tr>
		<%
				} // for end
			} // for end
		%>
		</table>
		
	</div>	
		
	<%@include file="../footer.jsp" %>
	
	<script src="/jspweb/js/board.js" type="text/javascript"></script>
</body>
</html>