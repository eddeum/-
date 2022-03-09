package Day06;

import java.util.Scanner;

public class Day06_3_회원제프로그램 {

	public static void main(String[] args) {
		
		// 회원제 프로그램[클래스 버전]
			// 0. 회원 설계 => 회원 클래스 만들기
				// 1. 필드
					// 1. 아이디 2. 비밀번호 3. 이름 4. 전화번호
			// 1. 초기메뉴[1. 회원가입 2. 로그인 3. 아이디찾기 4. 비밀번호찾기]
				// 1. 회원가입 시 입력받아 저장
				// 2. 로그인 시 아이디와 비밀번호가 동일하면 로그인처리
				// 3. 아이디찾기는 이름과 전화번호가 동일하면 아이디를 출력
				// 4. 비밀번호찾기는 아이디와 전화번호가 동일하면 비밀번호를 출력
		
		// 위에 선언하는 이유 : main메소드를 모든곳에서 사용하기 위해서
		Scanner scanner = new Scanner(System.in);
		Member[] memberlist = new Member[100];	// Member 클래스로 만들어진 객체(id,pw,name,phone) 100개를 저장할 수 있는 배열 선언
		// 만약에 클래스가 없었을경우(아래와 같이 선언)
		// 	└ String[][] memberlist = new Member[100][4]; 
		
		while(true) {	// [종료조건 : X]
			
			System.out.println("-------- 회원제[클래스버전] ---------");
			System.out.println("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기");
			System.out.println("선택 : ");	int ch = scanner.nextInt();
			
			if(ch==1) { // 회원가입
				// 1. id, password, name, phone 입력받기 => 변수4개
				System.out.println("----------- 회원가입 페이지 -----------");
				System.out.println("아이디 : ");	String id = scanner.next();
				System.out.println("비밀번호 : ");	String password = scanner.next();
				System.out.println("이름 : ");	String name = scanner.next();
				System.out.println("연락처 : ");	String phone = scanner.next();
				// 2. 객체 생성
				Member member = new Member();
				// 3. 입력받은 변수4개를 객체 내 필드에 저장
				member.id = id;
				// 객체내 필드 = 입력받은값 대입
				member.password = password;
				member.name = name;
				member.phone = phone;
				
				// * 아이디 중복체크
					// 1. 배열 내 객체 중 입력한 아이디와 동일한 아이디 찾기
				boolean idcheck = false;
				for(Member temp : memberlist) {
					// * memberlist 배열 내 객체들을 하나씩 temp에 대입 반복
					if(temp != null && temp.id.equals(id)) {
						// 만약에 해당 객체 내 id가 입력받은 id와 같으면
						System.err.println("알림))사용중인 아이디입니다.");
						idcheck = true;
						break;
					} // if e
				} // for e
				if(idcheck==false) { // 아이디 중복이 없을 경우 저장
					// 4. 여러개 객체를 저장하는 배열에 저장
						// 위에 선언함 -> 여기에 선언하게 되면 {}내에서만 사용가능하기 때문
							// 1. 공백 인덱스 찾기[공백이 아니면 기존회원이 존재하기 때문]
					int i = 0; // 인덱스 위치 변수;
					for(Member temp : memberlist) {
						// * memberlist 배열 내 member 객체 하나씩 꺼내와 temp 저장 반복
						// 2. 공백 인덱스에 객체 저장
						if(temp == null) { // 만약에 해당 객체가 공백이면
							memberlist[i]= member;	// 해당 인덱스에 새로 만들어진 객체를 저장
							System.out.println("알림))회원가입 성공");
							break;	// for문 나가기[안나가면 모든 공백에 동일한 객체가 저장되기 때문]
						} // if e
						i++; // 인덱스 증가
					} // for e
				} // if e	
				
			} // if e(회원가입 끝)
			else if(ch==2) {
				
				// 1. 입력받기
				System.out.println("----------- 로그인 페이지 -----------");
				System.out.println("아이디 : ");	String loginid = scanner.next();
				System.out.println("비밀번호 : ");	String loginpassword = scanner.next();
				
				// 2. 기존 배열[memberlist] 내 입력받은 값 비교
				boolean logincheck = false; // true : 로그인성공 / false : 로그인실패으로 사용될 목적
				for(Member temp : memberlist) {
					// * memberlist 내 0번 인덱스부터 끝 인덱스까지 하나씩 temp에 대입[배열/리스트 내 모든 객체 호출]
					if(temp != null && temp.id.equals(loginid) && 
							temp.password.equals(loginpassword)) {
						// * 객체가 null 일때는 equals 불가[null 아닌 상태에서만 equals 사용]
						System.out.println("알림))로그인 성공");
						logincheck = true; // 로그인 성공했다는 표시 남기기
					} // if e
				} // for e
				
				// 3. 로그인 성공 유무
				if(logincheck == false) { // 로그인성공시에는 아래 코드 실행 불가
					System.err.println("알림))동일한 회원정보가 없습니다.");
				} // if e
			} // else if e(로그인 끝)
			else if(ch==3) { // 아이디 찾기
				// 1. 이름과 연락처를 입력받는다.
				System.out.println("-------- 아이디찾기 페이지 --------");
				System.out.println("이름 : ");	String name = scanner.next();
				System.out.println("연락처 : ");	String phone = scanner.next();
				// 2. 배열내 동일한 이름과 연락처가 있는지 확인한다.
				boolean findcheck = false;
				for(Member temp : memberlist) {	
					if(temp != null && temp.name.equals(name) &&
							temp.phone.equals(phone)) { // 3. 동일한 객체가 있으면 해당 아이디를 출력
						System.out.println("알림))아이디 찾기 성공");
						System.out.println("회원 ID : " + temp.id);
						findcheck = true;
						break;
					} // if e
				} // for e
				// 4. 없으면 없다고 출력
				if(findcheck == false) {
					System.err.println("알림))동일한 회원정보가 없습니다.[아이디 찾기 실패]");
				} // if e
				
			} // else if e
			else if(ch==4) { // 비밀번호 찾기
				System.out.println("아이디 : ");	String id = scanner.next();
				System.out.println("연락처 : ");	String phone = scanner.next();
				boolean findcheck2 = false;
				for(Member temp : memberlist) {
					if(temp != null && temp.id.equals(id)&&
							temp.phone.equals(phone)) {
						System.out.println("알림))비밀번호 찾기 성공");
						System.out.println("회원 비밀번호 : " + temp.password);
						findcheck2 = true;
						break;
					} // if e
				} // for e
				
				if(findcheck2==false) {
					System.err.println("알림))동일한 회원정보가 없습니다.[비밀번호 찾기 실패]");
				} // if e
				
			} // else if e
			
			else {System.err.println("알림))알 수 없는 번호입니다.");}
			
		} // while e
		
	} // me
} // ce
