
function chat(){
	let nickname = $("#nickname").val();
	let chatcontent = $("#chatcontent").val();
	$.ajax({
		url : "chatwrite",
		data : {"nickname":nickname, "chatcontent":chatcontent},
		success : function(result){
			if(result == 1){
				alert("채팅등록");
			
				$("#nickname").val("");
				$("#chatcontent").val("");
			}else{
				alert("채팅실패");
			} // else end
		}
		
	}); // ajax end
} // 채팅쓰기 end

//function test(){
//	let nickname = $("#nickname").val();
//	let chatcontent = $("#chatcontent").val();
//}
//setInterval(test, 3000);

