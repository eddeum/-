<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<%@include file="1.��ġ.jsp" %>
	
	<div class="container"> <!-- �ڽ��� -->
		<div class="navbar navbar-expand-md navbar-light"> <!-- �׺���̼ǹ� -->
		
		<!-- �޴� ������ �۾����� ��� -->
		<button class="navbar-toggler" type="button"
			data-bs-toggle="collapse" data-bs-target="#navmenu"
			aria-controls="navbarcontents" aria-expanded="false" aria-label="toggle navi">
			<span class="navbar-toggler-icon"></span>
		</button>
		
			<div class="collapse navbar-collapse" id="navmenu"> <!-- collapse : ����� �۾�����(760px����) ȭ�鿡�� �޴��� ����� -->
			
				<a href="#" class="navbar-brand">�ΰ�</a> <!-- navbar-brand : �ΰ��鶧 ���� ����ϴ� Ŭ���� -->
			
				<ul class="navbar-nav"> <!-- �׺���̼� ��� -->
					<li class="nav-item"> <a href="#" class="nav-link">�޴�1</a> </li>	<!-- �׺���̼� ��� �� -->
					<li class="nav-item"> <a href="#" class="nav-link">�޴�2</a> </li>
					<li class="nav-item"> <a href="#" class="nav-link">�޴�3</a> </li>
					<li class="nav-item dropdown"> <!-- ��Ӵٿ� �޴� -->
						<!-- �ϴ� �ؽ�Ʈ�� Ŭ�������� �޴� ��ġ�� -->
							<!--
								nav-link ��ũ ������ : ��������, ����, ���� [���û�����]
								dropdown-toggle : �Ʒ�ȭ��ǥ [���û�����]
								class="nav-link : ���ڻ��� �ٲ�(�⺻:�Ķ���)
								data-bs-toggle="dropdown" : ��� ������ [�ʼ�����]
								class="dropdown-item" : ����� �������κ�����(�⺻:����)
							  -->
						<a href="#" class="nav-link" data-bs-toggle="dropdown" >
						��Ӵٿ�
						</a>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="#">��Ӵٿ� �޴�1</a>
							<a class="dropdown-item" href="#">��Ӵٿ� �޴�2</a>
							<a class="dropdown-item" href="#">��Ӵٿ� �޴�3</a>
						</div>
					</li>
				</ul> <!-- �׺���̼� ��� �� -->
				
				<form action="">
					<div class="row">
						<div class="col-md-5">
							<input type="text" class="form-control" placeholder="�˻���">
						</div>
						<div class="col-md-5">
							<button class="btn btn-info" type="submit">�˻�</button>
						</div>
					</div>
				</form>
			</div>	
		</div>
	</div>
	
	
	
</body>
</html>