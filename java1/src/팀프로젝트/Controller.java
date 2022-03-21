package 팀프로젝트;

import java.util.Calendar;

public class Controller {
	
	// 차량번호체크 메소드
	public static boolean carcheck(int cnum) {
		String cnum2 = String.valueOf(cnum);
		if(cnum2.length() == 4) {
			return true;
		} // if e
		return false;
	} // 차량번호 e
	
	// 날짜체크 메소드
	public static boolean datecheck(String idate) {
		int month = Integer.parseInt(idate)/100;
		int day = Integer.parseInt(idate)%100;
		Calendar calendar = Calendar.getInstance();
		calendar.set(2022, month-1, 1);
		int eday = calendar.getActualMaximum(calendar.DAY_OF_MONTH);
		if(1<=month && month<=12 && 1<=day && day<=eday) {
			return true;
		}
		return false;
	
	} // 날짜체크 e
	
	// 시간체크 메소드
	public static boolean timecheck(String itime) {
		int hour = Integer.parseInt(itime)/100;
		int minute = Integer.parseInt(itime)%100;
		if(-1<hour && hour<24 && -1<minute && minute<60) {
			return true;
		} // if e
		return false;
	} // 시간체크 e

	// 입차 메소드
	public static void carin(int cnum, String idate, String itime) {
		
	}
	// 출차 메소드
	public static void carout() {}
	// 주차시간&요금계산 메소드
	public static void pay() {}
	// 매출확인 메소드
	public static void sales() {}

}
