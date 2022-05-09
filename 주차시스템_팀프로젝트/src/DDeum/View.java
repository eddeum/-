package DDeum;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class View {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
		//	try {
			System.out.println(1650%1440);
			try {
				System.out.println("*********** 주차 시스템 ***********");
				
				int i = 0;
				for(Car temp : Controller.carlist) {
					if(temp.getLocation() != null) {
						System.out.println("[" + temp.getCnum()+"]");
					} // if e
					else {
						System.out.println("[  ]");
					} // else e
				} // for e
				

				
				System.out.println("1.입차 2.출차 3.매출확인   선택> "); int ch = scanner.nextInt();
				
				if(ch==1) {
					System.out.println("차 번호 : "); int cnum = scanner.nextInt();	
					System.out.println("입고일 : ");	String date = scanner.next();
					System.out.println("입고시간 : "); String time = scanner.next();
					
					
					
					boolean result = Controller.datecheck(date);
					boolean result2 = Controller.timecheck(time);
					
					
					if(result == false) {
						System.err.println("알림))날짜를 잘못입력하였습니다.");
					} // if e
					else if(result2 == false) {
							System.out.println("알림))시간을 잘못입력하였습니다.");
					} //  else e
					else {
					String intime = date+time;
					boolean result3 = Controller.carin(cnum, intime);
					if(result3)				{System.out.println("입차가능");}
					else					{System.err.println("알림))만차입니다.");}						
					}			
					


					
				}  // if e
				else if(ch==2) {
					System.out.println("차 번호 : ");	int cnum = scanner.nextInt();
					System.out.println("출차일 :");	String date = scanner.next();
					System.out.println("출차시간 : ");	String time = scanner.next();
					
					String outtime = date + time;
					
					int parkingtime = Controller.parktime(cnum, outtime);
					// 요금계산
					int 요금 = Controller.pay(parkingtime);
					
					if(요금==0) {
						System.out.println("알림)요금이 없습니다.");
					} // if e
					else {
						System.out.println(요금+"원 입니다.");
					} // else e
					
					Controller.sales(date, 요금);
		
					
				} // else e
				else if(ch==3) {
					System.out.println("매출확인이 필요한 월을 입력해주세요.");
					System.out.println("월 : "); 	int month = scanner.nextInt();
					if(1<=month && month<=12) {
						if(Controller.totalcharge[month-1]==0) {
							System.out.println(month+"월 매출이 없습니다.");
						} // if e
						else {
							System.out.println(month + "월 매출은" + Controller.totalcharge[month-1] + "원 입니다.");
						} // else e
					} // if e
					else {
						System.out.println("알림))월을 잘못입력하였습니다.");
					} // else e
				} // else if e
				else {
					System.err.println("알림)알수 없는 번호입니다.");
				} // else e
				
				
				
			} catch(Exception e) {
				System.err.println("오류입니다.(관리자에게 문의)");
			} // catech e
		} // while e
		
	} // me
} // ce

// 질문1. 입차/출차 메소드에서 객체화후 add, remove 쓰는게 더낫지않은지?
// 질문2. 요금계산 메소드에서 주차시간이 1440분일때 500분이상은 무엇????
