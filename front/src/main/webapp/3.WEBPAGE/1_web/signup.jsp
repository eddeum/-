<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

	<style type="text/css">
	
		h3{text-align: center; padding-bottom: 20px;}
		li{list-style-type: none;} /*�۸Ӹ� ����*/
		#join{
			width: 600px;
			margin: 0 auto; /* ��� ����(��� ������ �Ϸ��� �ڽ��� ũ�Ⱑ �����ؾ��� width ������) */
			border-top: solid 2px #eeeeee;
			border-bottom: solid 2px #eeeeee;
			padding: 30px;
		}
		.cols{padding: 5px;}
		.cols li{display: inline-block;}
		.col1{width: 150px;}
		.col2 input, select{width: 200px; height: 30px;}
		.email input{height: 30px;}
		.hello{vertical-align: top;} /* �ؽ�Ʈ �������� */
	
	</style>
</head>
<body>
	<%@include file="header.jsp" %> 	<!-- ��� -->	
	<%@include file="mainimage.jsp" %> 	<!-- ��� �̹��� -->
	<!-- ���� -->
		<div>
		<h3>ȸ�� ���� ��</h3>
		<form> <!-- �� ��� -->
			<ul id="join"> <!-- ��ü -->
				<li> 										<!-- �� [tr����] -->
					<ul class="cols">
						<li class="col1">���̵�</li> 						<!-- ��[td����] -->
						<li class="col2"><input type="text"></li>		<!-- ��[td����] -->
					</ul>
				</li>
				<li>
					<ul class="cols"v>
						<li class="col1">��й�ȣ</li>
						<li class="col2"><input type="password"></li>
					</ul>
				</li>
				<li>
					<ul class="cols">
						<li class="col1">��й�ȣ Ȯ��</li>
						<li class="col2"><input type="password"></li>
					</ul>
				</li>
				<li>
					<ul class="cols">
						<li class="col1">�̸�</li>
						<li class="col2"><input type="text"></li>
					</ul>
				</li>
				<li>
					<ul class="cols">
						<li class="col1">�̸���</li>
						<li class="email"><input type="text"> @
								<select>
									<option>�����Է�</option>
									<option>naver.com</option>
									<option>nate.com</option>
								</select>
						</li>
					</ul>
				</li>
				<li>
					<ul class="cols">
						<li class="col1">�̸��� ����</li>
						<li><input type="radio" name="email" checked="checked"> �����
							<input type="radio" name="email"> ����
						</li>
					</ul>
				</li>
				<li>
					<ul class="cols">
						<li class="col1">���� ���</li>
						<li><input type="checkbox" name="it1"> ģ����õ
							<input type="checkbox" name="it1"> ���ͳݰ˻�
							<input type="checkbox" name="it1" checked="checked"> 
						</li>
					</ul>
				</li>
				<li>
					<ul class="cols">
						<li class="col1 hello">�λ縻</li>
						<li class="col2"><textarea rows="6" cols="40"></textarea></li>
					</ul>
				</li>
			</ul>
		</form>
		
		
		</div>
	<%@include file="footer.jsp" %> 	<!-- Ǫ�� -->
</body>
</html>