<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

	<!-- ��Ʈ��Ʈ�� css CDN -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<!-- ��������� css -->
	<link href="index.css" rel="stylesheet">
	<!-- ��Ʈ���[������] -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
</head>
<body>

	<div class="col-md-10 offset-2 fixed-top pb-1 pt-5 px-5"> <!-- ��ܰ��� -->
		<div class="col-md-7 offset-5 d-flex justify-content-end"> <!-- ��� �޴�(������ ��ġ) -->
			<ul class="nav"> <!-- �ش� ����Ʈ[ul, ol] ���ι�ġ -->
				<li class="tophead"> <a href="login.jsp">LOGON</a> </li>
				<li class="tophead"> <a href="#">JOIN</a> </li>
				<li class="tophead"> <a href="#">CART</a> </li>
				<li class="tophead"> <a href="#">MY PAGE</a> </li>
				<li class="tophead"> <a href="#">SNS</a> </li>
				<li class="tophead"> <a href="#">BOOKMARK</a> </li>
			</ul>
		</div>
	</div>
	<div class="row">
		<div class="col-md-2 sidemenu"> <!-- ���̵�� �޴� -->
			<h3>HUNS</h3>
			<ul class="menu">
				<li>BEST</li>
				<li>NEW</li>
				<li>���Ϲ��</li>
				<li>1+1/�ڵ�Ʈ</li>
			</ul>
			<ul class="menu">
				<li>�ƿ���</li>
				<li>����</li>
				<li>����</li>
				<li>��Ʈ/�����</li>
				<li>����</li>
				<li>Ʈ���̴�</li>
				<li>�Ź�</li>
				<li>�Ǽ��縮</li>
				<li>����</li>
			</ul>
			<ul class="menu">	
				<li>NOTICE</li>
				<li>Q��A</li>
				<li>REVIEW</li>
				<li>EVENT</li>
			</ul>
			
			<div id="search">
				<input type="text"> <i class="fas fa-search"></i>
			</div>
			
			<div id="notice">
				�����͡�***-****-****<br>
				īī��ä�� @����<br><br>
				MON - FRI AM9 - PM4<br>
				(LUNCH TIME PM12:30 - PM13:30)<br>
				SAT, SUN, HOLIDAY CLOSE<br>
				�����ð��� ���Ǵ�<br>
				Q��A �Խ����� �̿��Ź�帳�ϴ�.<br><br>
				�츮���� ****-***-******<br>
				������ : (��)�������۴�
			</div>
		</div>
	


		<div class="col-md-10 offset-2">
		<div class="col-md-5 offset-4"> <!-- �α���â!!!!!!!!!! -->
			<h3>LOGIN</h3>
			<div><!-- ȸ���α��� -->
				<div class="nav"> <!-- id/pw �Է�â -->
					<div>
						<div>
							<input type="text" placeholder="���̵�">
						</div>
						<div>
							<input type="password" placeholder="��й�ȣ">
						</div>
					</div>
					<div>
						<button type="button" class="btn btn-dark" style="width: 100px; height: 60px; margin-left: 10px;">LOGIN</button>
					</div>
				</div>
				<div>
					<ul class="nav log">
						<li class="form-check"> <input type="checkbox" class="form-check-input"> ���̵����� </li>
						<li> ��������  |</li>
						<li> ���̵�ã��  |</li>
						<li> ��й�ȣã��</li>
					</ul>
				</div>
				<div></div>
				<div></div>
			</div>
			<div> <!-- ��ȸ�� -->
			</div>
		</div> <!-- �α���â end -->
	

		<div class="col-md-11 offset-1" style="border-top: solid 1px #eeeeee;"> <!-- footer -->
			<div class="nav footer">
				<div class="col-md-2 foot1">
					<ul>
						<li class="foottitle">S H O P    I N F O .</li>
						<li class="info"> <a href="#">ABOUT US</a> </li>
						<li class="info"> <a href="#">AGREEMENT</a> </li>
						<li class="info"> <a href="#">PRIVACY POLICY</a> </li>
						<li class="info"> <a href="#">SHOPPING GUIDE</a> </li>
					</ul>
				</div>
				<div class="col-md-3 foot1">
					<ul>
						<li class="foottitle">C U S T O M E R    C E N T E R .</li>	
						<li id="number">***-****-****</li>	
						<li id="kakao"> <a href="#">īī��ä�� : @����</a></li>	
						<li class="info">MON - FRI AM9 - PM4<br>
						(LUNCH TIME PM12:30 - PM13:30)<br>
						SAT, SUN, HOLIDAY CLOSE
						</li>	
						<li id="info2">�����ð��� ���Ǵ�<br>
						Q��A �Խ����� �̿��Ź�帳�ϴ�.<br><br>
						</li>	
						<li class="foottitle">B A N K    A C C O U N T .</li>
						<li class="info">�츮���� ****-***-******</li>
						<li class="info">������ : (��)�������۴�</li>				
					</ul>
				</div>
				<div class="col-md-4 foot1">
					<ul>
						<li class="foottitle">C O M P A N Y    I N F O .</li>
						<li class="info3">COMPANY : (��)�������۴� CEO : ������ TEL : ***-****-****</li>
						<li class="info3">BUSINESS NUMBER : ***-**-***** / 2021-����ϳ�-0552 [���������Ȯ��]</li>
						<li class="info3">ADDRESS : 13024 ��⵵ �ϳ��� �ϳ���� 506 (�ϻ�) 2��</li>
						<li class="info3">ADMIN : ������ (ezen22@naver.com) HOSTING : (��)CAFE24</li>
						<li class="info3">�¶��� ���ڻ�ŷ� ���� ���� [���񽺰��Ի��Ȯ��]</li>
						<li class="info4">��ǰ�ּ� / CJ�������(****-****)</li>
						<li class="info3">CJ������� ��ǰ�ּ� : �����ȣ 05839) ����� ���ı� ��η�52 CJ������� ��������븮��</li>							<li class="info3">Ÿ�ù��̿� ��ǰ�ּ� : �����ȣ 12729) ��⵵ ���ֽ� �ʿ��� ����� 625-12 A�� 3��</li>
						<li class="info3">��Ÿ�ù� �̿�� �����ù�,�Ե��ù�Ұ�(�ݼ۵ɼ� �ֽ��ϴ�)��</li>
						<li class="info4">Copyright @ (��)�������۴�. All rights reserved. by uuniq.</li>
					</ul>
				</div>
			</div>
		</div> <!-- Ǫ�� end -->
		</div>
	</div>


	<!-- ��Ʈ��Ʈ�� js cdn -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>