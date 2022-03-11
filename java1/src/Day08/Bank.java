package Day08;

import Day07.Member;

public class Bank {
	
	// 1. 필드
	private int bnumber;
	private int bbalance;
	private String name;
	private String password;
	
	// 2. 생성자
		// 1. 빈생성자
	public Bank() {}
		// 2. 풀생성자
	public Bank(int bnumber, int bbalance, String name, String password) {
		this.bnumber = bnumber;
		this.bbalance = bbalance;
		this.name = name;
		this.password = password;
	}
	
	// 3. 메소드
	
	boolean 계좌생성(String loginname) { ///////////////////////////////////////////
		System.out.println("----------- 계좌생성 페이지 -----------");
		System.out.println("계좌번호 : ");	int bnumber = Day08_5.scanner.nextInt();
		
		// * 계좌번호 중복체크
		for(Bank temp : Day08_5.banklist) {
			if(temp != null && temp.bnumber == bnumber) {
				System.err.println("알림)현재 사용중인 계좌번호 입니다.");
				return false;
			} // if e
		} // for e
		
		System.out.println("통장 비밀번호 : ");	String password = Day08_5.scanner.next();
		
		Bank bank = new Bank(bnumber, bbalance, name, password);
		
		int i = 0;
		for(Bank temp : Day08_5.banklist) {
			if(temp == null) {
				Day08_5.banklist[i]= bank;
				bbalance = 0;
				temp.name = loginname;
				System.out.println("알림)계좌생성 완료");
				return true;
			} // if e
			i++;
		} // for e
		return false;
	} // boolean e
	
	void 입금() {
		System.out.println("----------- 입금 페이지 -----------");
		System.out.println("입금액 : ");	int 입금 = Day08_5.scanner.nextInt();
		System.out.println("알림)" + 입금 + "원 입금되었습니다.");
		bbalance += 입금;
		
	} // void e
	void 출금() {
		System.out.println("----------- 출금 페이지 -----------");
		System.out.println("출금액 : ");	int 출금 = Day08_5.scanner.nextInt();
		System.out.println("알림)" + 출금 + "원 출금되었습니다.");
		bbalance -= 출금;
		
		
	} // void e
	void 이체() {
		System.out.println("----------- 이체 페이지 -----------");
	} // void e
	void 대출() {
		System.out.println("----------- 대출 페이지 -----------");
	} // void e
	void 계좌목록() {
		System.out.println("----------- 계좌목록 페이지 -----------");
	} // void e
	

}
