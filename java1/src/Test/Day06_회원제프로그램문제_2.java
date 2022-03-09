package Test;

import java.util.Scanner;

public class Day06_회원제프로그램문제_2 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Member[] memberlist = new Member[100];
		
		while(true) {
			System.out.println("------------- 회원제 -------------");
			System.out.println("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기");
			System.out.println("선택 : ");	int ch = scanner.nextInt();
			
			if(ch==1) {
				System.out.println("------------ 회원가입 ------------");
				System.out.println("아이디 : ");		String id = scanner.next();
				System.out.println("비밀번호 : "); 	String password = scanner.next();
				System.out.println("이름 : "); 		String name = scanner.next();
				System.out.println("전화번호 : "); 	String phone = scanner.next();
				
				Member member = new Member();
				
				member.id = id;
				member.password = password;
				member.name = name;
				member.phone = phone;
				
				boolean idcheck = true;
				for(Member temp : memberlist) {
					if(temp != null && temp.id.equals(id)) {
						System.err.println("알림)이미 존재하는 아이디입니다.");
						idcheck = false;
						break;
					} // if e
				} // for e
				if(idcheck == true) {
					int i = 0;
					for(Member temp : memberlist) {
						if(temp == null) {
							memberlist[i] = member;
							System.out.println("회원가입 성공");
							break;
						} // if e
						i++;
					} // for e
				} // if e
			
			} // if e
			else if(ch==2) {
				System.out.println("---------- 로그인 ----------");
				System.out.println("아이디 : ");	String loginid = scanner.next();
				System.out.println("비밀번호 : ");	String loginpw = scanner.next();
				
				boolean logincheck = false;
				for(Member temp : memberlist) {
					if(temp != null && temp.id.equals(loginid) && temp.password.equals(loginpw)) {
						System.out.println("로그인 성공");
						logincheck = true;
						break;
					} // if e
				} // for e
				if(logincheck == false) {
					System.err.println("알림))동일한 회원정보가 없습니다.");
				} // if e
			} // else if e
			
			else if(ch==3) {
				System.out.println("---------- 아이디찾기 ----------");
				System.out.println("이름 : ");	String name = scanner.next();
				System.out.println("전화번호 : ");	String phone = scanner.next();
				
				boolean findid = false;
				for(Member temp : memberlist) {
					if(temp != null && temp.name.equals(name) && temp.phone.equals(phone)) {
						System.out.println("아이디 찾기 성공");
						System.out.println("회원님의 아이디 : " + temp.id);
						findid = true;
						break;
					} // if e
				} // for e
				if(findid == false) {
					System.err.println("알림))동일한 회원정보가 없습니다.[아이디찾기 실패]");
				} // if e
			} // else if e
			else if(ch==4) {
				
				System.out.println("---------- 비밀번호찾기 ----------");
				System.out.println("아이디 : ");	String id = scanner.next();
				System.out.println("전화번호 : ");	String phone = scanner.next();
				
				boolean findpw = false;
				for(Member temp : memberlist) {
					if(temp != null && temp.id.equals(id) && temp.phone.equals(phone)) {
						System.out.println("비밀번호 찾기 성공");
						System.out.println("회원님의 비밀번호 : " + temp.password);
						findpw = true;
						break;	
					} // if e
				} // for e
				if(findpw == false) {
					System.err.println("동일한 회원정보가 없습니다.[비밀번호찾기 실패]");
				} // if e
			} // else if e
			
			else {
				System.err.println("알림)알 수 없는 번호입니다.");
			} // else e
			
		} // while e
	} // me

} // ce
