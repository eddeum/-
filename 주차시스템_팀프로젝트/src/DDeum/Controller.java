package DDeum;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Controller {
	
	public static ArrayList<Car> carlist = new ArrayList<>();
	public static int[] totalcharge = new int[12];
	
	// 0. 날짜 메소드
	public static boolean datecheck(String date) {
		int month = Integer.parseInt(date) / 100;
		int day = Integer.parseInt(date) % 100;
		if(month>=1 && month<=12 && day>=1 && day<=31 ) {
			return true;
		} // if e
		return false; // 날짜 오류
	} // 날짜체크 e
	
	// 0. 시간 체크 메소드
	public static boolean timecheck(String time) {
		int hour = Integer.parseInt(time) / 100 ;
		int minute = Integer.parseInt(time) % 100 ;
		if(hour>-1 && hour<24 && minute>-1 && minute<60) {
			return true;
		} // if e
		return false; // 시간 오류

	} // 시간체크 e
	
	// 1. 입차메소드
	public static boolean carin(int cnum, String intime) {
		

		for(int i = 0; i<12; i++){
			if(carlist.get(i).getLocation().equals(null)){
//				carlist.get(i).setCnum(cnum);
//				carlist.get(i).getIntime(); ////////////////////////////////////
				save();
				return true;
			} // if e
		} // for e
		return false;
	} // 입차 e
	
	// 2. 출차메소드
	public static void carout() {
		
	} // 출차 e
	
	// 3. 입/출차 저장 메소드
	public static void save() {
		try {
			// 1. 파일출력 클래스
			FileOutputStream outputStream = new FileOutputStream("위치");
			// 2. 파일에 작성할 내용[리스트 내 객체 1개씩 = 한줄씩 = 게시물 1개씩]
			for(Car car : carlist) {
				String 저장내용 =  car.getLocation() + "," + car.getCnum() + "," + car.getIntime() +"\n";
			// 3. 내용[문자열] -> 바이트열 변환
			// 4. 내보내기[write()]	
				outputStream.write(저장내용.getBytes());		
			
			} // for e
		}catch(Exception e) {
			System.err.println("알림))파일저장 실패");
		} // catch e
		
	} // 저장 e
	
	// 4. 입/출차 불러오기 메소드
	public static void load() {
		try {
			// 1. 파일입력클래스
			FileInputStream InputStream = new FileInputStream("위치");
			// 2. 바이트배열 선언
			byte[] bytes = new byte[1000];
			// 3. 모든 바이트 읽어와서 바이트에 저장
			InputStream.read(bytes);
			// 4. 바이트 -> 문자열 변환
			String file = new String(bytes);
			// 5. 문자열 자르기[한줄씩(\n) -> 1개객체]
			String[] board = file.split("\n");
			
			int i = 0;
			for(String temp : board) {
				if(i+1 == board.length) break;
				// 6. 문자열 자르기[한줄(,) -> 각 필드]
				String[] field = temp.split(",");				
			} // for e	
			
			// 6. 문자열 자르기[한줄(,) -> 각 필드]
			// 7. 객체화
			// 8. 리스트 담기	
		}catch(Exception e) {} // catch e
		
	} // 불러오기 e
	
	// 5. 주차시간계산 메소드
	public static int parktime(int cnum, String outtime) {
		try {
			long parktime = 0;
			int i = 0;
			for(Car temp : carlist) {
				if(temp.getCnum() == cnum) {
					String in = temp.getIntime();
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMddhhmm");
					Date indate = simpleDateFormat.parse(in);
					Date outdate = simpleDateFormat.parse(outtime);
					
					parktime = (outdate.getTime() - indate.getTime()) / 60000;
					int parktime2 =(int)parktime;
					return parktime2 ;
				} // if e
			}i++;
		}catch(Exception e)	{}
		return 0;
	} // 주차시간계산e

	// 6. 요금계산 메소드
	public static int pay(int parkingtime) {
		try {
			int fee = 0;
			if(parkingtime<30) {
				fee = 0;
			}
			else if(parkingtime>=30 && parkingtime<1440) {
				fee = parkingtime * 100;
			}
			else if(parkingtime==1440) {
				fee = (parkingtime/1440)*50000;
			} // else if e
			else { // 주차시간이 24시간이 넘어갈 경우
				fee = ((parkingtime/1440)*50000)+((parkingtime%1440)*100);
			} // else e
			return fee;
		}catch(Exception e) {}
		return 0; /////////////////////////////
	} // 요금계산 e
	
	// 7. 매출확인 메소드
	public static void sales(String date, int 요금) {
		int month = Integer.parseInt(date)/100;
		switch(month) {
		case 1 : totalcharge[0] += 요금; break;
		case 2 : totalcharge[1] += 요금; break;
		case 3 : totalcharge[2] += 요금; break;
		case 4 : totalcharge[3] += 요금; break;
		case 5 : totalcharge[4] += 요금; break;
		case 6 : totalcharge[5] += 요금; break;
		case 7 : totalcharge[6] += 요금; break;
		case 8 : totalcharge[7] += 요금; break;
		case 9 : totalcharge[8] += 요금; break;
		case 10 : totalcharge[9] += 요금; break;
		case 11 : totalcharge[10] += 요금; break;
		case 12 : totalcharge[11] += 요금; break;
		} // switch e
	} // 매출확인 e

}
