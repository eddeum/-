package Day09;

import java.util.Scanner;

public class Day09_은행계좌프로그램_1 {

	public static Bank[] accountlist = new Bank[100];
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("---------- 계좌 시스템 ----------");
			System.out.println("1.계좌생성 2.입금 3. 출금 4.이체 5.내계좌목록 6.대출   선택 : ");
			int ch = scanner.nextInt();
			
			BankController bankcontroller = new BankController();
			
			if(ch==1) {
				System.out.println("*** 계좌등록 페이지 ***");
				System.out.println("비밀번호 : ");	String password = scanner.next();
				System.out.println("예금주 : "); 	String owner = scanner.next();
				System.out.println("은행선택 < 1.KB 2.SH 3.HN > : "); int bno = scanner.nextInt();
				
				String ano = bankcontroller.계좌생성(password, owner, bno);
				
				if(ano != null) {
					System.out.println("++ 계좌 생성 ++");
					System.out.println("고객님의 계좌번호 : " + ano);
				} // if e
				else {
					System.err.println("알림)계좌등록 실패");
				} // else e
				
			} // if e
			else if(ch==2) {
				System.out.println("*** 입금 페이지 ***");
				System.out.println("계좌번호 : "); 	String ano = scanner.next();
				System.out.println("입금액 : ");		int deposit = scanner.nextInt();
				
				boolean result = bankcontroller.입금(ano, deposit);
				
				if(result) {
					System.out.println("++ 입금 성공 ++");
				} // if e
				else {
					System.err.println("알림)입금실패[동일한 계좌가 없습니다]");
				} // else e
			} // else if e
			
			else if(ch==3) {
				System.out.println("*** 출금 페이지 ***");
				System.out.println("계좌번호 : ");	String ano = scanner.next();
				System.out.println("비밀번호 : ");	String password = scanner.next();
				System.out.println("출금액 : "); 	int withdraw = scanner.nextInt();
				
				int result = bankcontroller.출금(ano, password, withdraw);
				
				if(result == 1) {
					System.err.println("알림)잔액 부족 ");
				} // if e
				else if(result ==2) {
					System.out.println("++ 출금 성공 ++");
				} // else if e
				else if(result ==3) {
					System.err.println("알림)올바른 정보가 아닙니다.");
				} // else if e
			} // else if e
			
			else if(ch==4) {
				System.out.println("*** 이체 페이지 ***");
				System.out.println("계좌번호 : "); String ano = scanner.next();
				System.out.println("비밀번호 : "); String password = scanner.next();
				System.out.println("이체금액 : "); int transfer = scanner.nextInt();
				System.out.println("이체받을계좌");	String transferano = scanner.next();
				
				int result = bankcontroller.이체(ano, password, transfer, transferano);
				
				if(result==1) {
					System.err.println("알림)잔액 부족");
				} // if e
				else if(result==2) {
					System.out.println("++ 이체 성공 ++");
				} // else if e
				else if(result==3) {
					System.err.println("알림)이체받을 계좌정보가 없습니다.");
				} // else if e
				else if(result==4) {
					System.err.println("알림)보내는 계좌정보가 없습니다.");
				} // else if e
				
			} // else if e
			
			else if(ch==5) {
				System.out.println("*** 내 계좌목록 페이지 ***");
				
			} // else if e
			else if(ch==6) {
				System.out.println("*** 대출 페이지 ***");
				
			} // else if e
			else {
				System.err.println("알림)알 수 없는 번호입니다.");
			} // else e
			
		} // while e
		
	} // me
} // ce
