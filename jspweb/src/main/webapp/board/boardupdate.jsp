<%@page import="dao.BoardDao"%>
<%@page import="dto.Board"%>
<%@page import="javax.swing.plaf.basic.BasicTextAreaUI"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<!-- 썸머노트 기본 부트스트랩버전 3버전 css cdn -->
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
	<!-- 썸머노트 css cdn -->
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
</head>
<body>

	<%@include file="../header.jsp" %>
	
	<%
		int bnum = Integer.parseInt(request.getParameter("bnum") );
		Board board = BoardDao.getBoardDao().getboard(bnum);
	%>

	<div class="container">
		<a href="boardlist.jsp"><button>글목록</button> </a>
		<h3>글수정</h3>
		<form action="../board/boardupdate?bnum=<%=board.getBnum() %>" method="post" enctype="multipart/form-data">
			<!-- form 전송 인코딩 타입 : 기본타입은 첨부파일 불가능 -->
			<!-- form 첨부파일 전송 인코딩 타입 : enctype = "multipart/form-data" -->
			제목 : <input type="text" name="btitle" value="<%=board.getBtitle()%>"> <br>
			내용 : <textarea name="bcontent" id="summernote"><%=board.getBcontent()%> </textarea> <br>
			<%if(board.getBfile() != null){ %>
			첨부파일 : <%=board.getBfile() %> <button type="button" onclick="filedelete(<%=board.getBnum()%>)">파일삭제</button>
			<%} %>
			<input type="file" name="bfile"> <br>
			<input type="submit" value="수정"> <input type="reset" value="취소">
		</form>
	</div>

	<%@include file="../footer.jsp" %>
	
	<!-- 썸머노트 기본 부트스트랩 3버전 js cdn -->
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<!-- 게시판API(썸머노트) js cdn -->
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
    <!--  썸머노트 한글 버전 cdn -->
    <script src=" https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.18/lang/summernote-ko-KR.min.js"></script>
	<!-- 사용자 정의 게시판관련 스크립트호출 -->
	<script src="/jspweb/js/board.js" type="text/javascript"></script>
	
</body>
</html>