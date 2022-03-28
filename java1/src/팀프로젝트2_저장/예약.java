package 팀프로젝트2_저장;

import java.util.Calendar;
import java.util.Scanner;

import ddeum.Room;


public class 예약 {

	public static Room[] roomlist = new Room[100];
	
///////////////////////// 날짜입력오류체크(4자리 입력) //////////////////////////////////
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

/////////////////////////////////// 예약목록 /////////////////////////////////////////		
	public static void 예약목록() {
		for(Room temp : roomlist) {
			if(temp != null) {
				System.out.printf("%3s\t%10s\t%7s\n",temp.getDate(),temp.getRname(),temp.getName());
			} // if e
		} // for e
	
	} // 예약목록 e
/////////////////////////////////// 예약 /////////////////////////////////////////
	
//	public static void 예약() {
		public static void main(String[] args) {
			
	
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			try {
				System.out.println("************** 호텔 예약 프로그램 **************");
				System.out.println("1.예약 2.예약목록"); int ch = scanner.nextInt();
				if(ch==1) {
					System.out.println("날짜입력(mmdd) :");	String 날짜 = scanner.next();
				
					boolean result = 날짜체크(날짜);
					
					if(result==true) {
						boolean[] 예약가능 = new boolean[5];
						for(Room temp : roomlist) {
							if(temp != null) {
						 // 날짜를 MM(월)dd(일)의 String 형식의 객체생성
								if(temp.getDate().equals(날짜)) { // temp안의 날짜와 입력받은 날짜가 동일하고
									if(temp.getRname().equals("트윈룸")) { // temp안의 방이름이 트윈룸과 동일하면
										예약가능[0] = true;				// 예약가능 = true -> "예약불가"
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
							} // if e
						} // for e
					
						System.out.println("************** 방 예약 현황표 **************");
						System.out.println("번호\t방이름\t\t금액\t\t예약여부");
						System.out.println("1"+".\t"+"트윈룸\t\t"+"10,000원\t\t"+((예약가능[0])?"예약불가":"예약가능")); // 조건연산자[조건식? 참 : 거짓]
						System.out.println("2"+".\t"+"더블룸\t\t"+"20,000원\t\t"+((예약가능[1])?"예약불가":"예약가능"));
						System.out.println("3"+".\t"+"바다뷰트윈룸\t"+"30,000원\t\t"+((예약가능[2])?"예약불가":"예약가능"));
						System.out.println("4"+".\t"+"바다뷰더블룸\t"+"40,000원\t\t"+((예약가능[3])?"예약불가":"예약가능"));
						System.out.println("5"+".\t"+"스위트룸\t\t"+"50,000원\t\t"+((예약가능[4])?"예약불가":"예약가능"));
						
						System.out.println("방 번호 선택 : ");	int ch2 = scanner.nextInt();
						System.out.println("예약자 이름 : ");	String name = scanner.next();
						
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
						
						Room room1 = new Room("트윈룸", "10,000원","예약불가", name, 날짜);
						Room room2 = new Room("더블룸", "20,000원","예약불가", name, 날짜);
						Room room3 = new Room("바다뷰트윈룸", "30,000원","예약불가", name, 날짜);
						Room room4 = new Room("바다뷰더블룸", "40,000원","예약불가", name, 날짜);
						Room room5 = new Room("스위트룸", "50,000원","예약불가", name, 날짜);
						
						for(int i = 0; i<roomlist.length; i++) {
							if(roomlist[i]==null) {
									if(ch2==1) {	
										if(예약가능[ch2-1]) {
											System.out.println("알림)해당날짜에 트윈룸 예약불가합니다.");
											break;
										} // if e
										else {
											roomlist[i]=room1;
											System.out.println("1번방 트윈룸이 예약되었습니다.");
											break;
										} // else e
									} // if e
									else if(ch2==2) {
										if(예약가능[ch2-1]) {
											System.out.println("알림)해당날짜에 더블룸 예약불가합니다.");
											break;
										} // if e
										else {
											roomlist[i]=room2;
											System.out.println("2번방 더블룸이 예약되었습니다.");
											break;
										} // else e
									} // else if e
									else if(ch2==3) {
										if(예약가능[ch2-1]) {
											System.out.println("알림)해당날짜에 바다뷰트윈룸 예약불가합니다.");
											break;
										} // if e
										else {
											roomlist[i]=room3;
											System.out.println("3번방 바다뷰트윈룸이 예약되었습니다.");
											break;
										} // else e
									} // else if e
									else if(ch2==4) {
										if(예약가능[ch2-1]) {
											System.out.println("알림)해당날짜에 바다뷰더블룸 예약불가합니다.");
											break;
										} // if e
										else {
											roomlist[i]=room4;
											System.out.println("4번방 바다뷰더블룸이 예약되었습니다.");
											break;
										} // else e
									} // else if e
									else if(ch2==5) {
										if(예약가능[ch2-1]) {
											System.out.println("알림)해당날짜에 스위트룸 예약불가합니다.");
											break;
										} // if e
										else {
											roomlist[i]=room5;
											System.out.println("5번방 스위트룸이 예약되었습니다.");
											break;
										} // else e
									} // else if e
							} // if e		
						} // for e	

						
					} // if e
					else {
						System.out.println("알림))날짜를 잘못입력하였습니다.");
					} // else e

				} // if e
				else if(ch==2) {
					System.out.printf("%3s\t%10s\t%7s\n","날짜","방이름","예약자");
					예약목록();
				} // else if e
				
				
			}catch(Exception e) {
				System.out.println("알림))오류입니다(관리자에게문의)");
			} // catch e

		} // while e

	} // 예약 e
		
	
} // ce
