package Test;

import java.util.Scanner;

public class Day05_도서대여프로그램문제_1 {

	public static void main(String[] args) {
		
		String[][] memberlist = new String[100][2];
		String[][] booklist = new String[100][3];
		
		Scanner scanner = new Scanner(System.in);
		
		while(true){
			
			System.out.println("------- 도서 대여 프로그램 -------");
			System.out.println("1. 회원가입 2. 로그인");
			System.out.println("-----------------------------");
			System.out.println("선택 : ");	int 선택 = scanner.nextInt();
			
			if(선택==1) {
				System.out.println("------- 회원가입 페이지 ------ ");
				System.out.println("ID : ");		String id = scanner.next();
				System.out.println("Password : "); 	String pw = scanner.next();
				
				boolean idcheck = true;
				
				for(int i = 0; i<memberlist.length; i++) {
					if(memberlist[i][0] != null && memberlist[i][0].equals(id)) {
						System.err.println("알림))동일한 아이디가 존재합니다.");
						idcheck = false;
						break;
					} // if e
				} // for e
				
				if(idcheck) {
					for(int i = 0; i<memberlist.length; i++) {
						if(memberlist[i][0] == null) {
							memberlist[i][0] = id;	memberlist[i][1] = pw;
						} // if e
						System.out.println("회원가입이 완료되었습니다.");
						break;
					} // for e
				} // if e
			} // if e
			else if(선택==2) {
				
			} // else if e
			else System.err.println("알림))알 수 없는 번호입니다.");
		} // while e
		
	} // me
} // ce
