package Day04;

import java.util.Scanner;

public class Day04_키오스크문제_1 { // cs
	
	public static void main(String[] args) { // ms
		
		Scanner scanner = new Scanner(System.in);
		
		int 콜라재고 = 10;	int 환타재고 = 10;	int 사이다재고 = 10;
		int 콜라구매수 = 0;	int 환타구매수 = 0;	int 사이다구매수 = 0;
		
		while(true) {
			System.out.println("------------------- 메뉴 -------------------");
			System.out.println("1. 콜라[300] 2. 환타[200] 3. 사이다[100] 4. 결제");
			System.out.println(">>> 선택 :");	int 선택 = scanner.nextInt();
			
			if(선택==1) {
				if(콜라구매수==0) {
					System.out.println("알림)재고가 부족합니다.");
				} // if e
				else {
				System.out.println("콜라를 담았습니다.");
				콜라구매수++;
				콜라재고--;
				} // else e
			} // if e
			else if(선택==2) {
				if(환타구매수==0) {
					System.out.println("알림)재고가 부족합니다.");
				} // if e
				else {
				System.out.println("환타를 담았습니다.");
				환타구매수++;
				환타재고--;
				} // else e
			} // else if e
			else if(선택==3) {
				if(사이다구매수==0) {
					System.out.println("알림)재고가 부족합니다.");
				} // if e
				else {
				System.out.println("사이다를 담았습니다.");
				사이다구매수++;
				사이다재고--;
				} // else e
			} // else if e
			else if(선택==4) {
				System.out.println("---------------- 결제 제품목록 ----------------");
				System.out.println("제품명\t수량\t금액");
				if(콜라구매수>=1) {System.out.println("콜라\t" + 콜라구매수 + "\t" + (콜라구매수*300));}
				if(환타구매수>=1) {System.out.println("환타\t" + 환타구매수 + "\t" + (환타구매수*200));}
				if(사이다구매수>=1) {System.out.println("사이다\t" + 사이다구매수 + "\t" + (사이다구매수*100));}
				int 총결제액 = (콜라구매수*300)+(환타구매수*200)+(사이다구매수*100);
				System.out.println("제품 총 결제액 : " + 총결제액 + "원");
				System.out.println("--------------------------------------------");
				System.out.println("1. 결제	2. 취소"); int 선택2 = scanner.nextInt();
				
				if(선택2==1) {
					while(true) {
						System.out.println("금액 : ");	int 금액 = scanner.nextInt();			
						if(금액<총결제액) {
							System.out.println("알림)금액이 부족합니다.");
						} // if e
						else {
							System.out.println("결제가 완료되었습니다.");
							System.out.println("잔돈은 " +(금액-총결제액)+ "원 입니다.");
							콜라구매수 = 0;	환타구매수 = 0;	사이다구매수 = 0;
							break;
						} // else e
					} // while e
				} // if e
				else if(선택2==2) {
					System.out.println("알림)구매목록 모두 지우기 ");
					콜라재고+=콜라구매수;	환타재고+=환타구매수;	사이다재고+=사이다구매수;
					콜라구매수 = 0;	환타구매수 = 0;	사이다구매수 = 0;
				}
				else {
					System.out.println("알림)알수없는 번호입니다.");
				} // else e
				
			} // else if e
			else {
				System.out.println("알림)알수없는 번호입니다.");
			} // else e
			
				
				
 		} // while e
		
	} //me

} // ce

// 22.03.05