
function passwordcheck(mid){
	// * 제이쿼리식
	let mpassword = $("#mpassword").val();
	// * 자바스크립트식
	//document.getElementById("mpassword").value;
	
	// 비동기 통신 = 제이쿼리 제공해주는 통신 메소드
		// [js(view)--->java(controller)]
	//$.ajax({속성명=속성값, 속성명2=속성값2})
	
	$.ajax({
		url : "../passwordcheck",						// 어디로
		data : {"mid" : mid, "mpassword" : mpassword},	// 보낼 데이터
		type : "POST",									// HTTP요청방식 정의[GET=기본값]
		success : function(result){ 					// 받을 데이터
			alert("결과값확인중"+result);
			if(result == 1){ 
				alert("같다");
				$("#checkmsg").html("정말 탈퇴하시겠습니까?");
				$("#mpassword").css("display", "none"); // 제이쿼리 css 적용[.css("속성명", "속성값")]
				$("#btndelete").css("display", "block");
				$("#btnconfirm").css("display", "none");
			}else{
				alert("다르다");
				$("#checkmsg").html("동일한 패스워드가 아닙니다.");
				$("#mpassword").val("");
			} // else e
		} // success end
	});
	
function mdelete(mid){
	$.ajax({
		url : "../delete",
		data : {"mid" : mid},
		success : function(result){
			if(result == 1){
				alert("회원탈퇴가 완료되었습니다.");
				// js에서 하이퍼링크[페이지연결]
				// <a href="경로">
				// location.href ="경로"
				location.href="/jspweb/logout";
			}else{
				location.href="/jspweb/error.jsp";
			} // else e
		}
	});
}


}