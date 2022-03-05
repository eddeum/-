package Test;

import java.util.Scanner;

public class Day03_p135확인문제_1 { // cs
	
	public static void main(String[] args) { // ms
		
		boolean run = true;
		
		int balance = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		while(run) { // while s
			System.out.println("------------------------");
			System.out.println("1.예금 2.출금 3.잔고 4.종료");
			System.out.println("------------------------");
			System.out.print("선택>"); 
			
			int 선택 = scanner.nextInt();
			
			if(선택==1) {
				System.out.print("예금액>" );	int 예금액 = scanner.nextInt();
				balance += 예금액;
				
			}
			else if(선택==2) {
				
				while(true) {
					System.out.print("출금액>"); int 출금액 = scanner.nextInt();

					if(출금액>balance) {
						System.out.println("알림) 잔액이 부족합니다.");
					} // if e
					else {
						balance -= 출금액;
						break;
					}	// else e			
				} // while e
			} // else if e
			else if(선택==3) {
				System.out.println("잔고>" + balance);
			} // else if e
			else if(선택==4) {
				break;
			}
			else {
				System.out.println("알림) 알수없는 번호입니다.");
			} // else e
			
		} // while e
		
		
	} // me

} // ce

// 22.03.05