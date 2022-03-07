package Day05;

import java.util.Scanner;

public class Day05_4_2 {
	
	public static void main(String[] args) {
		
		String[][] memberlist = new String[100][2];	// 100명기준
		String[][] booklist = new String[100][3];	// 100개기준
		
		Scanner scanner = new Scanner(System.in);
		// 초기메뉴
		while(true) {
			System.out.println("------- 도서 대여 프로그램 -------");
			System.out.println("1. 회원가입 2. 로그인");
			System.out.println("-----------------------------");
			System.out.println("선택 : ");	int 선택 = scanner.nextInt();
			// 회원가입
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
							System.out.println("회원가입이 완료되었습니다.");
							break;
						} // if e
					} // for e
				} // if e
			} // if e	
				
			// 로그인
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
	//////////////////////////////////////////////////////////////////////////				
					if(id.equals("admin")) {
						while(true) {
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
								
								if(bookcheck) {
									for(int j = 0; j<booklist.length; j++) {
										if(booklist[j][0] == null) {
											booklist[j][0] = 도서;
										} // if e
										System.out.println("알림)도서가 등록되었습니다.");
										break;
									} // for e
								} // if e
							} // if e
							else if(선택3==2) {
								System.out.println("--------- 도서 목록 ---------");
								System.out.println("번호\t도서명");
								System.out.println("--------------------------");
								for(int j =0; j<booklist.length; j++) {
									if(booklist[j][0] != null) {
										System.out.printf("%d\t%s\n" ,j , booklist[j][0]);
										
									} // if e
								} // for e
							}
							else if(선택3==3) {
								System.out.println("로그아웃 합니다.");
								break;
							}
							else System.err.println("알림)알 수 없는 번호입니다.");
						} // while e
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
									break;
								} // for e
							} // if e
							else if(선택==2) {}
							else if(선택==3) {}
							else if(선택==4) {}
							else if(선택==5) {}
							else {
								System.err.println("알림)알 수 없는 번호입니다.");
							} // else e
						} // while e
					} // else e
	//////////////////////////////////////////////////////////////				
					if(logincheck == false) System.err.println("알림)회원정보가 없거나 다릅니다.");
					break;
				} // for e	
					

			} // else if
			
			else System.out.println("알림))알수없는 번호입니다.");

		} // while e
		
	} // me
				
} // ce
