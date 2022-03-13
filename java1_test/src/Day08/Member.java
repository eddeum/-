package Day08;

public class Member {
	
	// 1. 필드
	String id;
	String password;
	String name;
	String phone;
	
	// 2. 생성자
		// 1. 빈생성자
	public Member() {}
		// 2. 풀생성자
	public Member(String id, String password, String name, String phone) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
	}
	
	// 3. 메소드
		// 1. 회원가입 메소드
	boolean 회원가입() { // 인수x반환o(가입성공true)
		System.out.println("--------- 회원가입 페이지 ---------");
		System.out.println("아이디 : ");	String id = Day08_모바일뱅크프로그램_1.scanner.next();
		
		// * 아이디 중복체크
		for(Member temp : Day08_모바일뱅크프로그램_1.memberlist) {
			if(temp != null && temp.id.equals(id)) {
				System.err.println("알림)동일한 아이디가 존재합니다.");
				return false;
			} // if e
		} // for e
		
		System.out.println("비밀번호 : ");		String password = Day08_모바일뱅크프로그램_1.scanner.next();
		System.out.println("이름 : ");		String name = Day08_모바일뱅크프로그램_1.scanner.next();
		System.out.println("연락처 : ");		String phone = Day08_모바일뱅크프로그램_1.scanner.next();
		
		Member member = new Member();
		
		int i = 0;
		for(Member temp : Day08_모바일뱅크프로그램_1.memberlist) {
			if(temp == null) {
				Day08_모바일뱅크프로그램_1.memberlist[i] = member;
				return true;
			} // if e
			i++;
		} // for e
		return false;
	} // boolean e
	
		// 2. 로그인 메소드
	String 로그인() { // 인수x반환o(로그인성공시 아이디 반환)
		System.out.println("--------- 로그인 페이지 ---------");
		System.out.println("아이디 : ");	String id = Day08_모바일뱅크프로그램_1.scanner.next();
		System.out.println("비밀번호 : ");	String password = Day08_모바일뱅크프로그램_1.scanner.next();
		
		for(Member temp : Day08_모바일뱅크프로그램_1.memberlist) {
			if(temp != null && temp.id.equals(id) && temp.password.equals(password)) {
				return temp.id; ////////////////////////////
			} // if e
		} // for e	
		return null;
	} // String e
	
		// 3. 아이디찾기 메소드
	void 아이디찾기() { // 인수x반환x (이름,연락처 입력)
		System.out.println("--------- 아이디찾기 페이지 ---------");
		System.out.println("이름 : "); 	String name = Day08_모바일뱅크프로그램_1.scanner.next();
		System.out.println("연락처 : "); 	String phone = Day08_모바일뱅크프로그램_1.scanner.next();
		
		for(Member temp : Day08_모바일뱅크프로그램_1.memberlist) {
			if(temp != null && temp.name.equals(name) && temp.name.equals(phone)) {
				System.out.println("아이디 찾기 성공!");
				System.out.println("회원님의 아이디 : " + temp.id);
				return;
			} // if e
		} // for e
		System.err.println("알림)동일한 회원정보가 없습니다.[아이디찾기 실패]");
	} // void e
	
		// 4. 비밀번호찾기 메소드
	void 비밀번호찾기() { // 인수x반환x (아이디, 연락처 입력)
		System.out.println("--------- 비밀번호찾기 페이지 ---------");
		System.out.println("아이디 : ");	String id = Day08_모바일뱅크프로그램_1.scanner.next();
		System.out.println("연락처 : ");	String phone = Day08_모바일뱅크프로그램_1.scanner.next();
		
		for(Member temp : Day08_모바일뱅크프로그램_1.memberlist) {
			if(temp != null && temp.id.equals(id) && temp.phone.equals(phone)) {
				System.out.println("비밀번호 찾기 성공!");
				System.out.println("회원님의 비밀번호 : " + temp.password);
				return;
			} // if e
		} // for e
		System.err.println("알림)동일한 회원정보가 없습니다.[비밀번호찾기 실패]");
	} // void e
	

} // ce
