package Day05;

import java.util.Scanner;

public class Day05_회원제방문록문제_2 {

	public static void main(String[] args) {
		
		String[][] memberlist = new String[100][3];
		String[][] boardlist = new String[100][3];	
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("---------------------------");
			System.out.println("-------- 회원제 방문록 --------");
			System.out.println("---------------------------");
			System.out.println("1. 회원가입 2. 로그인 선택 : ");	int 선택 = scanner.nextInt();
			
			if(선택==1) {
				System.out.println("---------------------------");
				System.out.println("------- 회원가입 페이지 -------");
				System.out.println("ID : ");	String id = scanner.next();
				System.out.println("Password : ");	String pw = scanner.next();
				System.out.println("Name : ");	String name = scanner.next();
				
				boolean idcheck = true;
				for(int i = 0; i<memberlist.length; i++) {
					if(memberlist[i][0] != null && memberlist[i][0].equals(id)) {
						System.err.println("알림)동일한 아이디가 존재합니다.");
						idcheck = false;
						break;
					} // if e
				} // for e
				
				if(idcheck) {
					for(int i = 0; i<memberlist.length; i++) {
						if(memberlist[i][0] == null) {
							memberlist[i][0] = id; memberlist[i][1] = pw; memberlist[i][2] = name;
							System.out.println("알림)회원가입이 되었습니다.");
							break;
						} // if e
					} // for e
				} // if e
			} // if e
			else if(선택==2) {
				System.out.println("---------------------------");
				System.out.println("-------- 로그인 페이지 --------");
				System.out.println("ID :");			String id = scanner.next();
				System.out.println("Password :");	String pw = scanner.next();
				
				boolean logincheck = false;
				for(int i = 0; i<memberlist.length; i++) {
					if(memberlist[i][0] != null && memberlist[i][0].equals(id) 
							&& memberlist[i][1].equals(pw)) {
						System.out.println("알림)로그인 성공");
						logincheck = true;
						
						while(true) {
							System.out.println("---------------------------");
							System.out.println("----------- 방문록 ----------");
							System.out.printf("번호\t작성자\t제목\t내용 \n");
							
							for(int j = 0; j<boardlist.length; j++) {
								if(boardlist[j][0] != null) {
									System.out.printf("%d\t%s\t%s\t%s \n", j, boardlist[j][2], 
											boardlist[j][0], boardlist[j][1]);
								} // if e
							} // for e
							
							System.out.println("1. 방문록남기기 2. 로그아웃  선택 : ");	int 선택2 = scanner.nextInt();
							
							if(선택2==1) {
								System.out.println("----------------------------");
								System.out.println("제목 : ");	String 제목 = scanner.next();
								System.out.println("내용 : ");	String 내용 = scanner.next();
								
								for(int j = 0; j<boardlist.length; j++) {
									if(boardlist[j][0] == null) {
										boardlist[j][0] = 제목;	boardlist[j][1] = 내용 ;	
										boardlist[j][2] = id;
										
										System.out.println("알림)방문록이 작성되었습니다.");
										break;
									} // if e
								} // for e
							} // if e
							else if(선택2==2) {
								System.out.println("알림)로그아웃");
								break;
							} // else if e
							else System.err.println("알림)알 수 없는 번호입니다.");
						} // while e
						
					} // if e
				} // for e
				
				if(logincheck==false) System.err.println("알림)회원정보가 없거나 다릅니다.");
				
			} // else if e
			else System.err.println("알림)알 수 없는 번호입니다.");
			
			
		} // while e
		
	} // me
} // ce

// 22.03.07