
function chat(){
	let nickname = $("#nickname").val();
	let chatcontent = $("#chatcontent").val();
	$.ajax({
		url : "chatwrite",
		data : {"nickname":nickname, "chatcontent":chatcontent},
		success : function(result){
			if(result == 1){
				alert("채팅등록");
				function test(){
					let nickname = $("#nickname").val();
					let chatcontent = $("#chatcontent").val();
					$("#chattable").html("[닉네임]"+nickname+"[내용]"+chatcontent);
				};
				$("#nickname").val("");
				$("#chatcontent").val("");
			}else{
				alert("채팅실패");
			} // else end
		}
		
	}); // ajax end
} // 채팅쓰기 end


setisetInterval(test, 3000);

//function test(){
//	let nickname = $("#nickname").val();
//	let chatcontent = $("#chatcontent").val();
//}
//setInterval(test, 3000);
