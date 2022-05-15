
// 주사위돌리기 버튼
function diceroll(){
	alert("주사위를 돌립니다.");
	const rand = Math.floor(Math.random() * 6)+1;
	$("#dicedisplay").html(rand);
} // 주사위돌리기 end

// 게임접속 버튼
function gameconnect(mid){
	if(mid == 'null'){
		alert("로그인 후 입장가능합니다.");
		return;
	} // if end
	alert(mid +"님 안녕하세요");
	$.ajax({
		url : "gameenter",
		data : {"mid" : mid},
		success : function(result){
			
		} // success end
	}); // ajax end
} // 게임접속 end

// * 특정 시간만큼 반복되는 함수
$(function() {
	timer = setInterval(function(){
		$.ajax({
			url : "enterlist",
			cache : false,
			success : function(result){
				$("#connectlist").html(result);
			} // success end
		}); // ajax end
	}, 1500);
});
