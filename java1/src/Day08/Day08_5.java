package Day08;

import java.util.Scanner;

public class Day08_5 {

	// 모바일 뱅크 프로그램[2인 과제]
		// 요구사항
		// 회원 주요기능 : 1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기 5.로그아웃
		// 계좌 주요기능 : 1.계좌생성 2.입금 3.출금 4.이체 5.대출 6.계좌목록
		// 설계 : 통장, 대출상품 등록(관리자), 회원 
			// 필드 
				// 회원 : 아이디, 비밀번호, 이름, 연락처
				// 계좌 : 계좌번호(입력받음), 통장잔액, 예금주(회원이름), 비밀번호
			// 메소드
	
	static Scanner scanner = new Scanner(System.in);
	static Bank[] banklist = new Bank[100];
	static Member[] member = new Member[100];
	
	public static void main(String[] args) {
		
		Day08_5 mbank = new Day08_5();
		mbank.menu();
		
	}  // me
	
	void menu() {
		while(true) {
			System.out.println("----------------- 모바일 뱅크 프로그램 -----------------");
			System.out.println("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기  선택 : ");
			int ch = scanner.nextInt();
			
			Member member = new Member();
			
			if(ch==1) {
				boolean result = member.회원가입();
				if(result)System.out.println("알림))회원가입 성공");
				else System.err.println("알림))회원가입 실패");
			} // if e
			
			else if(ch==2) {
				String  result = member.로그인();
				if(result==null) {
					System.out.println("알림))동일한 회원정보가 없습니다.");
				} // if e
				else if(result.equals("admin")) {//2.관리자 메뉴 메소드 호출
					System.out.println("알림))안녕하세요~"+result+"님");
					adminmenu();
				} // else if e
				else {//1. 일반회원 메뉴 메소드 호출
					System.out.println("알림))안녕하세요~"+result+"님");
					bankmenu();
				} // else e
			} // else if e
			else if(ch==3) {}
			else if(ch==4) {}
			else {
				System.err.println("알림))알 수 없는 번호입니다.");
			} // else e
			
		} // while e
	} // void e
	void bankmenu() {
		while(true) {
			System.out.println("------------------- 은행 메뉴 -------------------");
			System.out.println("1.계좌생성 2.입금 3.출금 4.이체 5.대출 6.계좌목록  선택 : ");
			int ch = scanner.nextInt();
		
			Bank bank = new Bank();
		
			if(ch==1) {bank.계좌생성();}
			else if(ch==2) {}
			else if(ch==3) {}
			else if(ch==4) {}
			else if(ch==5) {}
			else if(ch==6) {}
			else {
				System.err.println("알림)알 수 없는 번호입니다.");
			} // else e
		} // while e
		
	} // void e
	void adminmenu() {}
	
	
} // ce
