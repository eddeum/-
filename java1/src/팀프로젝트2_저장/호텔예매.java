package 팀프로젝트2_저장;

import java.util.ArrayList;
import java.util.Scanner;

public class 호텔예매 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
	
		
		while(true) {
			System.out.println("************** 호텔 예약 프로그램 **************");
			System.out.println("날짜입력(mmdd) :");	String 날짜 = scanner.next();
			
			boolean result = Controller.날짜체크(날짜);
			if(result=true) {
				Controller.예약(날짜);
				
				System.out.println("********* 방 예약 현황표 *********");
				System.out.println("번호\t방이름\t금액\t예약여부");
				System.out.print("1"+"."+"트윈룸"+"10,000원");
				System.out.print("2"+"."+"더블룸"+"20,000원");
				System.out.print("3"+"."+"바다뷰트윈룸"+"30,000원");
				System.out.print("4"+"."+"바다뷰더블룸"+"40,000원");
				System.out.print("5"+"."+"스위트룸"+"50,000원");
				
				int ch = scanner.nextInt();
				
				if(ch==1) {}
				else if(ch==2) {}
				else if (ch==3) {}
				else if(ch==4) {}
				else if(ch==5) {}
				else {
					System.out.println("알림))방 번호를 잘못입력하였습니다.");
				} // else e
				
			} // if e
			else {
				System.out.println("알림))날짜를 잘못입력하였습니다.");
			}
			
			
		} // while e
		
	} // me

} // ce
