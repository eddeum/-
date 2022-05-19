
$(function(){
	
	$.ajax({
		url : "getcart",
		success : function(jsonarray){
			for(let i = 0; i<jsonarray.length; i++){
//				alert(result[i]);
//				alert(Object.keys(result[i]) ); // Object.keys(json 객체) -> 객체 내 모든키 반환
//				alert(result[i]['ssize']);		// json객체[key] -> 객체내 key에 해당하는 value 호출
//				console.log(jsonarray[i]);

				// js : json 객체내 key값 이용한 value 추출
					// 객체명[key] -> value 호출
					//

				let tr = "";
				for( let i = 0; i<jsonarray.length; i++){
					tr +=
						'<tr>'+
							'<td width="5%"> <img width="100%" alt="" src="../admin/productimg/'+jsonarray[i]['pimg']+'"> </td>'+
							'<td> '+jsonarray[i]['pname']+'<br>'+jsonarray[i]['scolor']+'/'+jsonarray[i]['ssize']+ '</td>'+
							'<td> '+jsonarray[i]['totalprice']+' </td>'+
							'<td> <button>X</button>  </td>'+
						'</tr>'
				} // for end
				$("#carttable").html(tr);
			} // for end
		} // success end
	}); // ajax end
	
});