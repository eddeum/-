<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

	<style type="text/css">
	
		#contents{
			margin: 200px 0px;
		}
		table{width: 400px; margin: 0 auto;}
		input{height: 25px; }
		button{padding: 22px 20px;}
		h3{text-align: center; padding-bottom: 20px;}

	</style>
</head>
<body>

	<%@include file="header.jsp" %> 	<!-- ��� -->	
	<%@include file="mainimage.jsp" %> 	<!-- ��� �̹��� -->
	<!-- ���� -->
		<div id="contents">
			<h3>�α���</h3>
			<form>
				<table id="t1">
					<tr> <td>���̵�</td> <td><input type="text"></td> <td rowspan="2"><button>�α���</button></td> </tr>
					<tr> <td>��й�ȣ</td> <td><input type="password"></td> </tr>
				</table>
			</form>
		</div>
	<%@include file="footer.jsp" %> 	<!-- Ǫ�� -->

</body>
</html>