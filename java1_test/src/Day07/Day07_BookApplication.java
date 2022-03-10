package Day07;

import java.util.Scanner;

public class Day07_BookApplication {

	// BookApllication 클래스 : 입출력 관련코드
	// Book 클래스 : 도서 관련 코드
	// Member 클래스 : 회원 관련 코드
	
	// * 도서 대여 console 프로그램[클래스버전]
		// 1. 클래스 설계
			// 1. Book
				// 필드 : ISBN(도서코드), 도서명, 작가, 도서대여여부, 대여회원
				// 메소드 : 1.도서검색 2.도서목록 3.도서대여 4.도서반납 5.도서등록 6.도서삭제
			// 2. Member
				// 필드 : 번호, 아이디, 비밀번호, 이름, 연락처
				// 메소드 : 1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기 5.로그아웃
		// 2. 화면 설계
			// 1. 초기메뉴 [1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기]
			// 2. 일반회원메뉴 [1.도서검색 2.도서목록 3.도서대여 4.도서반납 5.로그아웃]
			// 3. 관리자메뉴 [1.도서등록 2.도서목록 3.도서삭제 4.순위(도전) 5.로그아웃]
	
	static Scanner scanner = new Scanner(System.in);
	static Member[] memberlist = new Member[100];
	static Book[] booklist = new Book[1000];
	
	public static void main(String[] args) {
		
		Day07_BookApplication application = new Day07_BookApplication();
		application.menu();
	} // me
	
	// 1. 초기 메뉴 메소드
	void menu() {
		while(true) {
			System.out.println("------------- 도서 대여 프로그램 -------------");
			System.out.println("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기 : ");
			int ch = scanner.nextInt();
			
			Member member = new Member();
			
			if(ch==1) {
				boolean result = member.회원가입();
				if(result) 	System.out.println("알림)회원가입 성공");
				else		System.out.println("알림)회원가입 실패");
			} // if e
			else if(ch==2) {
				String result = member.로그인();
				if(result == null) {
					System.out.println("알림)동일한 회원정보가 없습니다.");
				} // if e
				else if(result.equals("admin")) {
					System.out.println("알림)안녕하세요" + result +"님");
					adminmenu();
				} // else if e
				else {
					System.out.println("알림)안녕하세요" + result +"님");
					membermenu(); ///////괄호안에 result???
				} // else e
			} // else if e
			else if(ch==3) {
				member.아이디찾기();
			} // else if e
			else if(ch==4) {
				member.비밀번호찾기();
			} // else if e
			else {
				System.out.println("알림)알 수 없는 번호입니다.");
			} // else e
			
		} // while e
		
	} // void e
	// 2. 일반회원 메뉴 메소드
	void membermenu() {}
	// 3. 관리자회원 메뉴 메소드
	void adminmenu() {}
	
} // ce
