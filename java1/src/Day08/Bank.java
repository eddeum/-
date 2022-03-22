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
	
	boolean 계좌생성() { ///////////////////////////////////////////
		System.out.println("----------- 계좌생성 페이지 -----------");
		System.out.println("계좌번호 : ");	int bnumber = Day08_5.scanner.nextInt();
		
		// * 계좌번호 중복체크
		for(Bank temp : Day08_5.banklist) {
			if(temp != null && temp.bnumber == bnumber) {
				System.err.println("알림)현재 사용중인 계좌번호 입니다.");
				return false;
			} // if e
		} // for e
		
		System.out.println("예금주 : ");		String name = Day08_5.scanner.next();
		System.out.println("통장 비밀번호 : ");	String password = Day08_5.scanner.next();
		
		Bank bank = new Bank(bnumber, bbalance, name, password);
		
		int i = 0;
		for(Bank temp : Day08_5.banklist) {
			if(temp == null) {
				Day08_5.banklist[i]= bank;
				bank.bbalance = 0; 
				System.out.println("알림)계좌생성 완료");
				return true;
			} // if e
			i++;
		} // for e
		return false;
	} // boolean e
	
	void 입금(String loginid) {//////////////////////////////
		System.out.println("----------- 입금 페이지 -----------");
		System.out.println("입금액 : ");	int 입금 = Day08_5.scanner.nextInt();
		
		System.out.println("통장 비밀번호 : ");	String password = Day08_5.scanner.next();
		
		for(Bank temp : Day08_5.banklist) {
			if(temp != null && temp.password.equals(password)) {
				System.out.println("알림)" + 입금 + "원 입금되었습니다.");
				temp.bbalance += 입금;	
//				temp.id = loginid; ///////////////////////
				break;
			} // if e
			else {
				System.err.println("알림)통장 비밀번호가 다릅니다.[입금불가]");
				break;
			} // else e
		} // for e
		
		
	} // void e
	void 출금(String loginid) {
		System.out.println("----------- 출금 페이지 -----------");
		System.out.println("출금액 : ");	int 출금 = Day08_5.scanner.nextInt();
		
		System.out.println("통장 비밀번호 : "); String password = Day08_5.scanner.next();
		
		for(Bank temp : Day08_5.banklist) {
			if(temp != null && temp.password.equals(password)) {
				System.out.println("알림)" + 출금 + "원 출금되었습니다.");
				temp.bbalance -= 출금;
				break;
			} // if e
			else {
				System.err.println("알림)통장 비밀번호가 다릅니다.[출금불가]");
				break;
			} // else e
		} // for e
		
	} // void e
	
	void 이체(String loginid) {
		System.out.println("----------- 이체 페이지 -----------");
		System.out.println("이체 계좌번호 : "); int bnumber = Day08_5.scanner.nextInt();
		

		
		// 이체할 계좌번호 입력
		// 이체할 계좌번호 존재하는지 확인후
		// 이체액 입력
		// 내 통장 잔액이 이체액보다 많으면 이체진행 아니면 이체불가
		// 내 통장 비밀번호 입력 후 맞으면 이체 아니면 이체불가		
		// 이체 후 내 계좌 잔액변동 확인
		// 이체된 계좌번호 잔액변동 확인
		// 이체알림띄우기
		
		
		
	} // void e
	void 대출() {
		System.out.println("----------- 대출 페이지 -----------");
	} // void e
	void 계좌목록() {
		System.out.println("----------- 계좌목록 페이지 -----------");
		System.out.println("계좌번호\t예금주\t잔액");
		
		for(Bank temp : Day08_5.banklist) {
			if(temp != null) {
				System.out.println(temp.bnumber+"\t"+temp.name+"\t"+temp.bbalance);
			} // if e
		} // for e
	} // void e
	

}
