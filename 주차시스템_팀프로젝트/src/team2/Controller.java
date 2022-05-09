package team2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Controller  {
	
	// 차량 리스트 , 매출액배열
	public static ArrayList<Car> carlist = new ArrayList<>();
	public static int[] totalcharge = new int[12];
	
	// 모든 메소드는 static
	
	// 0. 차량번호체크 메소드
	public static boolean checkcnum(String carnum) {
		if(carnum.length()==4) {
			return true;
		}
		return false;
	}
	
	// 0 . 날짜체크 메소드
	public static boolean checkdate(String date) {
		Calendar calendar = Calendar.getInstance(); // 입력받은 월의 마지막일을 구하기 위해 객체 생성
		int month = Integer.parseInt(date) / 100; // 입력받은 월일4자리를 월, 일로 구분
		int day = Integer.parseInt(date) % 100;  // 입력받은 월일4자리를 월, 일로 구분
		calendar.set(2022, month-1, 1); // 마지막을 구하기위해 입력받은 월로 calendar 정의
		int eday = calendar.getActualMaximum(calendar.DAY_OF_MONTH); // 입력받은 월의 마지막일을 구함
		if(month>=1 && month<=12 && day>=1 && day<=eday) { // 입력받은월이 1~12월일, 입력받은일이 1~마지막일 경우
				return true;
			}
			return false ; // 날짜 오류
		}
	
	
	// 0. 시간체크 메소드
	public static boolean checktime(String time) {
		int hour = Integer.parseInt(time) / 100 ;
		int minute = Integer.parseInt(time) % 100 ;
		if(hour>-1 && hour<24 && minute>-1 && minute<60) {
			return true;
		} // if e
		return false; // 시간 오류
	}
	
	// 0. 출차시간 체크 메소드
	public static boolean checkouttimedate (String carnum, String outtime) {
		int i = 0 ; // 입력한 차번호의 인덱스 번호를 찾기위해 변수 선언
		for (Car temp : carlist) {
			if(temp.getCarnum().equals(carnum)) {
				break;
			}
			i++;
		}
		long diffTime = 0 ;
		try {
			Date in = new SimpleDateFormat("MMddhhmm").parse(carlist.get(i).getIntime());
			Date out = new SimpleDateFormat("MMddhhmm").parse(outtime);
			diffTime = (out.getTime() - in.getTime()) / 60000 ; // 출차시간-입차시간 을 분으로 계산
		}
		catch (Exception e) {
		}
		if (diffTime > 0 ) { // 출차시간이 0 보다 클시 ( 입차시간에 비해 출차시간이 늦은경우)
			return true;
		}
		else{ // 그 외 입력한 출차시간이 입차시간 이전인 경우
			return false;
		}
		
	}
	
	// 1. 입차 메소드
	public static boolean carin(String carnum, String intime) {
		for(int i = 0 ; i <=11 ; i++) { // 배열 인덱스위치를 얻기위해 i 변수 사용
			if(carlist.get(i).getCarnum().equals(" ")) { // 배열내 객체중 차량번호 "" 이면
				Car car = new Car(i, carnum, intime); // 매개변수로 객체 생성
				carlist.remove(i); // i번째 객체를 지우고 ( i, "" , "" )
				carlist.add(i,car); // 매개변수로 생성한 객체 삽입
				save();
				return true;
			}
		}
		return false;
	}

	// 2. 출차 메소드
	public static String carout(String carnum) {
		boolean check = false ; String intime = null ;
		for(int i = 0 ; i <=11 ; i++) { // 배열 인덱스위치를 얻기위해 i 변수 사용
			if(carlist.get(i).getCarnum().equals(carnum)) { // 배열내 객체중 차량번호가 매개변수로 받은 차량번호와 같으면
				intime = carlist.get(i).getIntime(); // 삭제전 intime 데이터를 받아서 저장해두고
				carlist.remove(i); // i번째 객체를 지우고 ( i, carnum , intime )
				Car car = new Car(i, " ", " "); // 차량번호 비어있는 객체 생성해서
				carlist.add(i,car); // i번 인덱스에 삽입
				check = true;
				break;
			}
		}
		save();
		if (check == false) {
			return null ; // 입차실패시 null 리턴
		}
		else {
			return intime ; // 출차 성공시 차량 입차시간 리턴
		}
	}
	
	// 3. 요금계산 메소드
	public static int pay(String carnum, String outtime, String intime) { // 입출차 시간받아서 시간차이 계산
		long diffMin = 0 ; int fee = 0 ;
		try {
			Date in = new SimpleDateFormat("MMddhhmm").parse(intime);
			Date out = new SimpleDateFormat("MMddhhmm").parse(outtime);
			diffMin = (out.getTime() - in.getTime()) / 60000 ; // 시간차이를 분으로 계산하여 long으로 반환
			int parkingtime = (int)diffMin ; // long자료형을 int로 형변환
			if(parkingtime<30) {
				fee = 0;
			}
			else if(parkingtime>=30 && parkingtime<1440) {
				if(parkingtime >= 500) {
					fee = 50000 ;
				}		
				else {
					fee = (parkingtime-30) * 100;
				}
			}
			else if(parkingtime==1440) {
				fee = (parkingtime/1440)*50000 ;	
			} // else if e
			else { // 주차시간이 24시간이 넘어갈 경우
				if(parkingtime%1440>=500) {
					fee = ((parkingtime/1440)*50000) + 50000 ;
				}
				else {
					fee = ((parkingtime/1440)*50000)+(((parkingtime%1440)-30)*100);
				}
			} // else e			
		}
		catch (Exception e) {
		}
		return fee; // 주차요금 반환
	}
	
	// 4. 매출계산 메소드
	public static void volume(String date, int charge) { // 출차월일, 주차요금 매개변수 받아서
		String month = date.substring(0,2); // 앞 두인덱스만 추출하여 (월)
		switch(month) { // 1~12월일경우 totalcharge배열에 증액
			case "01" : totalcharge[0] += charge ; break;
			case "02" : totalcharge[1] += charge ; break;
			case "03" : totalcharge[2] += charge ; break;
			case "04" : totalcharge[3] += charge ; break;
			case "05" : totalcharge[4] += charge ; break;
			case "06" : totalcharge[5] += charge ; break;
			case "07" : totalcharge[6] += charge ; break;
			case "08" : totalcharge[7] += charge ; break;
			case "09" : totalcharge[8] += charge ; break;
			case "10" : totalcharge[9] += charge ; break;
			case "11" : totalcharge[10] += charge ; break;
			case "12" : totalcharge[11] += charge ; break;
		} 
	}
		
	// 5. 차량리스트 저장메소드
	public static void save() {		
		try {
			FileOutputStream outputStream = new FileOutputStream("C:/java/주차장.txt"); // 파일출력객체
			for(Car temp : carlist) {
				String file = temp.getLocation()+","+temp.getCarnum()+","+temp.getIntime()+"\n"; 
				outputStream.write(file.getBytes()); // 내보내기
			}

		}
		catch (Exception e) {
		}	
	}
	public static void save2() {
		try {
			FileOutputStream outputStream2 = new FileOutputStream("C:/java/매출.txt");
			for(int temp : totalcharge) {
				String file2 = String.valueOf(temp)+"," ;
				outputStream2.write(file2.getBytes()); // 내보내기
			}
		}
		catch (Exception e) {
		}
		
			
	}
	// 6. 차량 리스트 불러오기메소드
	public static void load() { 

		try {
			FileInputStream inputStream = new FileInputStream("C:/java/주차장.txt"); // 파일입력객체
			byte[] bytes = new byte[1024]; // 바이트배열 선언
			inputStream.read(bytes); // 바이트 읽어와서 바이트배열에 저장
			String file = new String(bytes); // 바이트 -> 문자열
			String[] list = file.split("\n"); // 문자열자르기
			int i = 0 ;
			for(String temp : list) {
				if( i+1 == list.length) {
					break;
				}
				String[] field = temp.split(","); // 문자열 자르기
				Car car = new Car(Integer.parseInt(field[0]),field[1],field[2]); // 객체생성
				carlist.remove(i);
				carlist.add(i,car); // 리스트 저장
				i++;
			}
		}
		catch (Exception e) {
		}	
	}
	
	public static void load2() {
		try {
			FileInputStream inputStream2 = new FileInputStream("C:/java/매출.txt");	 
			byte[] bytes2 = new byte[1024]; // 바이트배열 선언
			inputStream2.read(bytes2); // 바이트 읽어와서 바이트배열에 저장
			String file2 = new String(bytes2); // 바이트 -> 문자열
			String[] list2 = file2.split(","); // 문자열자르기
			int i = 0 ;
			for(String temp : list2) {
				if( i+1 == list2.length) {
					break;
				}
				totalcharge[i] = Integer.parseInt(temp);
				i++;
			}
		}
		catch (Exception e) {
		}
	}
}
