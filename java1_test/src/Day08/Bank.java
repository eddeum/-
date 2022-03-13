package Day08;

public class Bank {
	
	// 1. 필드
	int ano;
	int balance;
	String owner;
	String bpassword;
	
	
	// 2. 생성자
		// 1. 빈생성자
	public Bank() {}
		// 2. 풀생성자
	public Bank(int ano, int balance, String owner, String bpassword) {
		this.ano = ano;
		this.balance = balance;
		this.owner = owner;
		this.bpassword = bpassword;
	}
		// 3. 3개 생성자
	public Bank(int ano, String owner, String bpassword) {
			this.ano = ano;
			this.owner = owner;
			this.bpassword = bpassword;
		}
	
	// 3. 메소드
		// 1. 계좌생성
	boolean 계좌생성() { 
		System.out.println("----------- 계좌생성 -----------");
		System.out.println("계좌번호 : "); int ano = Day08_모바일뱅크프로그램_1.scanner.nextInt();
		
		//* 계좌중복체크
		for(Bank temp : Day08_모바일뱅크프로그램_1.banklist) {
			if(temp != null && temp.ano == ano) {
				System.err.println("알림)중복된 계좌번호입니다.");
				return false;
			} // if e
		} // for e

		System.out.println("예금주 : ");		String owner = Day08_모바일뱅크프로그램_1.scanner.next();
		System.out.println("통장 비밀번호 : "); String bpassword = Day08_모바일뱅크프로그램_1.scanner.next();
		System.out.println("초기입금액 : ");	int money = Day08_모바일뱅크프로그램_1.scanner.nextInt();
		
		Bank bank = new Bank(ano,owner, bpassword);
		
		int i = 0;
		for(Bank temp : Day08_모바일뱅크프로그램_1.banklist) {
			if(temp == null) {
				Day08_모바일뱅크프로그램_1.banklist[i] = bank;
				Day08_모바일뱅크프로그램_1.banklist[i].balance = money;
				System.out.println("계좌생성 완료!");
				return true;
			} // if e
			i++;
		} // for e
		return false;
	} // boolean e
	
		// 2. 입금
	void 입금() {
		System.out.println("----------- 입금 -----------");
		System.out.println("계좌번호 : ");		int ano = Day08_모바일뱅크프로그램_1.scanner.nextInt();
		System.out.println("입금액 : ");		int 입금 = Day08_모바일뱅크프로그램_1.scanner.nextInt();
		System.out.println("통장 비밀번호 : ");	String bpassword = Day08_모바일뱅크프로그램_1.scanner.next();
		
		int i = 0;
		for(Bank temp : Day08_모바일뱅크프로그램_1.banklist) {
			if(temp != null && temp.ano == ano && temp.bpassword.equals(bpassword)) {
				System.out.println(입금+"원 입금되었습니다.");
				Day08_모바일뱅크프로그램_1.banklist[i].balance += 입금;
				return;
			} // if e
			i++;
		} // for e
		System.err.println("알림)동일한 정보가 없습니다[입금불가]");
	} // void e
	
		// 3. 출금
	void 출금() { //// 잔액확인하기
		System.out.println("----------- 출금 -----------");
		System.out.println("계좌번호 : "); 	int ano = Day08_모바일뱅크프로그램_1.scanner.nextInt();
		System.out.println("출금액 : "); 		int 출금 = Day08_모바일뱅크프로그램_1.scanner.nextInt();
		System.out.println("통장 비밀번호 : "); String bpassword = Day08_모바일뱅크프로그램_1.scanner.next();
		
		int i = 0;
		for(Bank temp : Day08_모바일뱅크프로그램_1.banklist) {
			if(temp != null && temp.ano == ano && temp.bpassword.equals(bpassword)) {
				System.out.println(출금+"원 출금되었습니다");
				Day08_모바일뱅크프로그램_1.banklist[i].balance -= 출금;
				return;
			} // if e
		} // for e	
		
	} // void e
		// 4. 이체
	void 이체 () {
		System.out.println("----------- 이체 -----------");
		System.out.println("이체계좌번호 : "); 	int ano = Day08_모바일뱅크프로그램_1.scanner.nextInt();
		System.out.println("이체액 : "); 		int 이체 = Day08_모바일뱅크프로그램_1.scanner.nextInt();
		System.out.println("통장 비밀번호 : "); String bpassword = Day08_모바일뱅크프로그램_1.scanner.next();
		
	
	} // void e
		// 5. 대출
	void 대출 () {}
		// 6. 내 계좌목록
	void 내계좌(String name) {
		System.out.println("----------- 내 계좌목록 -----------");
		System.out.println("순서\t계좌번호\t잔액");
		
		int i = 0;
		for(Bank temp : Day08_모바일뱅크프로그램_1.banklist) {
			if(temp != null && temp.owner.equals(name)) {
				System.out.println(i+"\t"+temp.ano+"\t"+temp.balance);
			} // if e
			i++;
		} // for e
	} // void e
	
	
	
	

} // ce
