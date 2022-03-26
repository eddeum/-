package 팀프로젝트2_저장;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Controller {
	
	
	
	public static boolean 날짜체크(String 날짜) {
		Calendar calendar = Calendar.getInstance(); // 입력받은 월의 마지막 일을 구하기 위함
		int month = Integer.parseInt(날짜) / 100; // 입력받은 날짜 4자리형식에서 앞의 2자리를 '월'로 구분
		int day = Integer.parseInt(날짜) % 100; // 입력받은 날짜 4자리형식에서 뒤의 2자리를 '일'로 구분
		calendar.set(2022, month-1, 1); // 입력받은 월의 마지막일자를 구하기 위해 월 1일로 정의
		int eday = calendar.getActualMaximum(calendar.DAY_OF_MONTH); // 입력받은 월의 마지막일을 구함
		if(month>=1 && month<=12 && day>=1 && day<=eday) {
			return true;
		} // if e
		return false;
	} // 날짜체크 e
	public static void 예약(String 날짜) {
		

			
		} // for e
		
		
	} // 예약 e
	

}
