package Day08;

public class Member {


	// 1.필드
	private String id;
	private String pw;
	private String name;
	private String phone;

	
	//2.생성자	
	public Member() {}//필드0개 빈 생성자[메소드호출용 사용예정]


	public Member(String id, String pw, String name, String phone) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
	}

	
	
	boolean 회원가입() {
		System.out.println("-----------------회원가입 페이지-----------------");
		System.out.println("아이디 : ");	String id =Day08_5.scanner.next();
		
		for(Member temp : Day08_5.member){
			if(temp!=null&&temp.id.equals(id)) {
				System.err.println("알림))사용 중인 아이디 입니다.");
				return false;
			}//if문 종료
		}//for문종료
		
		System.out.println("비밀번호 : ");	String pw =Day08_5.scanner.next();
		System.out.println("이름 : ");	String name=Day08_5.scanner.next();
		System.out.println("연락처 : ");	String phone=Day08_5.scanner.next();
		
		Member member = new Member(id,pw,name,phone);
		
		int i=0;
		for(Member temp:Day08_5.member) {
			if(temp==null) {
				Day08_5.member[i]=member;
				return true;
			}//if종료
			i++;
		}//for종료
		return false;
	}//bool end
	
	
	String 로그인() {
		System.out.println("-----------------로그인 페이지-----------------");
		System.out.println("아이디 : ");	String id=Day08_5.scanner.next();
		System.out.println("비밀번호 : ");	String pw=Day08_5.scanner.next();
		for(Member temp:Day08_5.member) {
			if(temp!=null&&temp.id.equals(id)&&
					temp.pw.equals(pw)) {
				return temp.name; //////////////////////////////////////
			}//if종료
		}//for문종료
		return null;//실패시 null반환
	}		
	void 아이디찾기() {
		System.out.println("-----------------아이디 찾기 페이지-----------------");
		System.out.println("이름 : ");	String name=Day08_5.scanner.next();
		System.out.println("연락처 : ");	String phone=Day08_5.scanner.next();
		for(Member temp:Day08_5.member) {
			if(temp!=null&&temp.name.equals(name)&&
					temp.phone.equals(phone)) {
				System.out.println("회원님의 아이디 : "+temp.id);
				return;
			}//if종료
			System.out.println("알림))일치하는 회원이 없습니다.");
		}//for문종료
		return;
	}
	void 비밀번호찾기() {
		System.out.println("-----------------비밀번호 찾기 페이지-----------------");
		System.out.println("아이디 : ");	String id=Day08_5.scanner.next();
		System.out.println("연락처 : ");	String phone=Day08_5.scanner.next();
		for(Member temp:Day08_5.member) {
			if(temp!=null&&temp.id.equals(id)&&
					temp.phone.equals(phone)) {
				System.out.println("회원님의 비밀번호 : "+temp.pw);
				return;//동일한 값을 찾았으면 해당 메소드 종료
			}
			System.out.println("알림))일치하는 회원이 없습니다.");
			return;
		}
		
	}
	
				
}//08_4 e
	

