package 팀프로젝트2_저장;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import ddeum.Room;

public class Controller {
	
	public static ArrayList<Room> roomlist = new ArrayList<>();
	
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
		
		boolean[] 예약가능 = new boolean[5];
		for(Room temp : roomlist) { // roomlist에 있는 리스트를 temp에 대입하여
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMdd"); // 날짜를 MM(월)dd(일)의 String 형식의 객체생성
			if(simpleDateFormat.format(temp.getDate()).equals(날짜)) { // temp안의 날짜와 입력받은 날짜가 동일하고
				if(temp.getRname().equals("트윈룸")) { // temp안의 방이름이 트윈룸과 동일하면
					예약가능[0] = true;
				} // if e
				if(temp.getRname().equals("더블룸")) {
					예약가능[1] = true;
				} // if e
				if(temp.getRname().equals("바다뷰트윈룸")) {
					예약가능[2] = true;
				} // if e
				if(temp.getRname().equals("바다뷰더블룸")) {
					예약가능[3] = true;
				} // if e
				if(temp.getRname().equals("스위트룸")) {
					예약가능[4] = true;
				} // if e
				
			} // if e
			
		} // for e
		
		
	} // 예약 e
	

}
