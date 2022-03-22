package Day05;

import java.util.Scanner;

public class Day05_4_도서대여2인과제 { // cs
	
	public static void main(String[] args) { // ce
		
		String[][] memberlist = new String[100][2];	// 100명기준
		String[][] booklist = new String[100][3];	// 100개기준
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("------- 도서 대여 프로그램 -------");
			System.out.println("1. 회원가입 2. 로그인");
			System.out.println("-----------------------------");
			System.out.println("선택 : ");	int 선택 = scanner.nextInt();
			
			if(선택==1) {
				System.out.println("--------- 회원가입 ---------");
				System.out.println("ID : ");		String id = scanner.next();
				System.out.println("Password : ");	String pw = scanner.next();
				
				boolean idcheck = true;
				for(int i =0; i<memberlist.length; i++) {
					if(memberlist[i][0] != null && memberlist[i][0].equals(id)) {
						System.err.println("알림)동일한 아이디가 존재합니다.");
						idcheck = false;
						break;
					} // if e
				} // for e
				if(idcheck) {
					for(int i = 0; i<memberlist.length; i++) {
						if(memberlist[i][0]==null) {
							memberlist[0][0]=id; memberlist [0][1] = pw;
						} // if e
						System.out.println("회원가입이 완료되었습니다.");
						break;
					} // for e
				} // if e
			} // if e
			else if(선택==2) {
				System.out.println("------- 로그인 페이지 -------");
				System.out.println("ID : ");		String id = scanner.next();
				System.out.println("Password : ");	String pw = scanner.next();
				
				
				boolean logincheck = false;
				for(int i = 0; i<memberlist.length; i++) {
					if(memberlist[i][0] != null && memberlist[i][0].equals(id) && memberlist[i][1].equals(pw)){
						System.out.println("로그인 성공");
						logincheck = true;
					} // if e
				} // for e	
						
				if(id.equals("admin")) {
					System.out.println("---------- 관리자 메뉴 ----------");
					System.out.println("1. 도서등록 2. 도서목록 3. 로그아웃");	int 선택3 = scanner.nextInt();
					if(선택3==1) {
						System.out.println("도서명 : ");	String 도서 = scanner.next();
									
						boolean bookcheck = true;
						for(int j = 0; j<booklist.length; j++) {
							if(booklist[j][0] != null && booklist[j][0].equals(도서)) {
								System.err.println("알림)동일한 책이 존재합니다.");
								bookcheck = false;
								break;
										
							} // if e
						} // for e
					} // if e
				} // if e
				else {
					while(true) {
						System.out.println("---------------- 도서프로그램 메뉴 ----------------");
						System.out.println("1. 도서검색 2. 도서목록 3. 도서대여 4. 도서반납 5. 로그아웃");
						System.out.println("----------------------------------------------");
						System.out.println("선택 : ");	int 선택2 = scanner.nextInt();
						
						if(선택2==1) {
							System.out.println("도서명 검색 : "); String 도서명 = scanner.next();
							
							boolean bookcheck = false;
							for(int j = 0; j<booklist.length; j++) {
								if(booklist[j][0] != null && booklist[j][0].equals(도서명)) {
									System.out.println("도서명 : " + 도서명 );
									bookcheck = true;
								} // if e
								if(bookcheck==false)	System.err.println("알림)해당 도서 찾을 수 없습니다.");
							} // for e
						}
						else if(선택==2) {}
						else if(선택==3) {}
						else if(선택==4) {}
						else if(선택==5) {}
						else {
							System.err.println("알림)알 수 없는 번호입니다.");
						} // else e
					} // while e
				} // else e
				
				if(logincheck == false) System.err.println("알림)회원정보가 없거나 다릅니다.");
		
			} // else if e
			
			else {
				System.err.println("알림)알수없는 번호입니다.");
			} // else e
			
					
		} // while e

		
	} // me
	
} // ce
