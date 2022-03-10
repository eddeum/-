package Day03;

import java.util.Scanner;

public class Day03_8 {
	
	public static void main(String[] args) {
		
		// p.135 확인문제7
		// 공통 변수 [ 모든곳에서 사용할수 있는 변수 선언 ]
		boolean run = true; // 실행 여부 변수 / true=실행 false=종료
		int balance = 0; // 예금액[통장안에 있는 금액] 변수 
		Scanner scanner = new Scanner(System.in); // 입력객체 
		
		while( run ) { // while( true ) {  } : 무한루프
			System.out.println("------------------------");
			System.out.println("1.예금 2.출금 3.잔고 4.종료");
			System.out.println("------------------------");
			System.out.print("선택>"); 
		
			int 선택 = scanner.nextInt();
		
			if (선택==1) {
				System.out.print("예금액> ");	int 예금액 = scanner.nextInt();
				balance += 예금액;
			} // if e
			else if (선택==2)	{
				System.out.println("출금액>");	int 출금액 = scanner.nextInt();
				if(출금액>balance)	{System.out.println("알림) 잔액이 부족합니다.");}
				else	{balance -= 출금액;}
			} // else if e
			else if (선택==3)	{
				System.out.println("잔고>" + balance);
			} // else if e
			else if (선택==4)	{
				break;
			} // else if e
			else {
				System.out.println("알림) 알수 없는 번호입니다.");
			} // else e
		
		} // while e
		
	} // me

} // ce
