package Day07;

public class Member {
	
	// 1. 필드
	int mno;
	String id;
	String password;
	String name;
	String phone;
	
	// 2. 생성자
		// 1. 빈생성자 : 메소드호출용 객체생성시
	public Member() {}
		// 2. 풀생성자 : 회원가입용 객체생성시

	public Member(int mno, String id, String password, String name, String phone) {
		this.mno = mno;
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
	}
	
	// 3. 메소드
		// 1. 회원가입 메소드[인수x반환o]
	boolean 회원가입() {
		System.out.println("-------- 회원가입 페이지 -------- ");
		System.out.println("아이디 : "); String id = Day07_BookApplication.scanner.next();
		
		// * 아이디 중복체크
		for(Member temp : Day07_BookApplication.memberlist) {
			if(temp != null && temp.id.equals(id)) {
				System.err.println("알림)현재 사용중인 아이디입니다.");
				return false; // 함수종료 ->아이디 중복으로 false(가입실패)
			} // if e
		} // for e
		
		System.out.println("비밀번호 : ");	String password = Day07_BookApplication.scanner.next();
		System.out.println("이름 : "); 	String name = Day07_BookApplication.scanner.next();
		System.out.println("연락처 : "); 	String phone = Day07_BookApplication.scanner.next();
		
		// * 회원번호 자동부여
		int mno = 0;
		int i = 0;
		for(Member temp : Day07_BookApplication.memberlist) {
			if(temp==null) {
				if(i==0) { // 첫번째 회원일 경우
					mno = 1;
					break;
				} // if e
				else {
					mno = Day07_BookApplication.memberlist[i-1].mno+1;
					break;
				} //  else e
			} // if e
			i++;
		} // for e
		
		Member member = new Member(mno, id, password, name, phone);
		
		int j = 0;
		for(Member temp : Day07_BookApplication.memberlist) {
			if(temp == null) {
				Day07_BookApplication.memberlist[j] = member;
				System.out.println("알림)회원님의 회원번호 : "+ mno);
				return true;
			} // if e
			j++;
		} // for e
		
		return false;
	} // boolean e
	
	
		// 2. 로그인 메소드[인수x반환o]
			// 로그인 성공시 성공한 아이디 반환/실패시 null 반환
	String 로그인() {
		System.out.println("-------- 로그인 페이지 -------- ");
		System.out.println("아이디 : "); 		String id = Day07_BookApplication.scanner.next();
		System.out.println("비밀번호 : "); 	String password = Day07_BookApplication.scanner.next();
		
		for(Member temp : Day07_BookApplication.memberlist) {
			if(temp != null && temp.id.equals(id) && temp.password.equals(password)) {
				return temp.id;	//////////////////////////????
			} // if e
		} // for e
		
		return null; ///////////////////////////????
	} // String e
		// 3. 아이디찾기 메소드[인수x반환x] : 이름, 연락처
	void 아이디찾기 () {
		System.out.println("-------- 아이디찾기 페이지 -------- ");
		System.out.println("이름 : ");	String name = Day07_BookApplication.scanner.next();
		System.out.println("연락처 : ");	String phone = Day07_BookApplication.scanner.next();
		
		for(Member temp : Day07_BookApplication.memberlist) {
			if(temp != null && temp.name.equals(name) && temp.phone.equals(phone)) {
				System.out.println("알림)회원님의 아이디 : " + temp.id);
				return;
			} // if e
		} // for e
		System.err.println("알림)동일한 회원정보가 없습니다.[아이디찾기]");
	} // void e
		// 4. 비밀번호찾기 메소드[인수x반환x] : 아이디, 연락처
	void 비밀번호찾기 () {
		System.out.println("-------- 비밀번호찾기 페이지 -------- ");
		System.out.println("아이디 : ");	String id = Day07_BookApplication.scanner.next();
		System.out.println("연락처 : ");	String phone = Day07_BookApplication.scanner.next();
		
		for(Member temp : Day07_BookApplication.memberlist) {
			if(temp != null && temp.id.equals(id) && temp.phone.equals(phone)){
				System.out.println("알림)회원님의 비밀번호 : " + temp.password);
				return;
			} // if e
		} // for e
		System.err.println("알림)동일한 회원정보가 없습니다[비밀번호찾기 실패]");
	} // void e
	

} // ce
