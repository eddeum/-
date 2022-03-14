package Day09;

import java.util.Random;

public class BankController {

	// 1. 계좌생성
	public String 계좌생성(String password, String owner, int bno) {
		
		String ano = null; //////////////////????
	
		while(true) {
			// 계좌번호 생성
			Random random = new Random();
			
			int 난수 = random.nextInt(10000); // 0~9999까지
			ano = String.format("%04d", 난수);
			// 계좌중복체크
			boolean anocheck = false;
			for(Bank temp : Day09_은행계좌프로그램_1.accountlist) {
				if(temp != null && temp.getAno().equals(ano)) {
					anocheck = true;
				} // if e
			} // for e
			if(anocheck == false) break;
		} // while e
		// 은행선택
		Bank temp = null;
		if(bno == 1) {temp = new KBBank(ano, password, owner, 0);}
		else if(bno == 2) {temp = new SinhanBank(ano, password, owner, 0);}
		else if(bno == 3) {temp = new HanaBank(ano, password, owner, 0);}
		// 배열에 저장
		int i = 0;
		for(Bank temp2 : Day09_은행계좌프로그램_1.accountlist) {
			if(temp2 == null) {
				Day09_은행계좌프로그램_1.accountlist[i] = temp;
				return ano;
			} // if e
			i++;
		} // for e
		return null;
	} // 계좌생성 e
	
	// 2. 입금
	public boolean 입금(String ano, int deposit) {
		
		int i = 0;
		for(Bank temp : Day09_은행계좌프로그램_1.accountlist) {
			if(temp != null && temp.getAno().equals(ano)) {
				Day09_은행계좌프로그램_1.accountlist[i].setBalance(temp.getBalance()+ deposit);
				return true;
			} // if e
			i++;
		} // for e
		return false;
	} // 입금 e
	
	// 3. 출금
	public int 출금(String ano, String password, int withdraw) {
		
		int i = 0;
		for(Bank temp : Day09_은행계좌프로그램_1.accountlist) {
			if(temp != null && temp.getAno().equals(ano) && temp.getPassword().equals(password)) {
				if(temp.getBalance() < withdraw) {
					return 1; // 잔액부족
				} // if e
				else {
					Day09_은행계좌프로그램_1.accountlist[i].setBalance(temp.getBalance()-withdraw);
					return 2; // 출금 성공
				} // else e
			} // if e	
			i++;
		} // for e
		return 3; // 동일한 정보 아닐경우
	} // 출금 e
	
	// 4. 이체
	public int 이체(String ano, String password, int transfer, String transferano) {
		
		int i = 0; // 본인 계좌
		for(Bank temp : Day09_은행계좌프로그램_1.accountlist) {
			if(temp != null && temp.getAno().equals(ano) && temp.getPassword().equals(password)) {
				
				int j = 0; // 이체 받을 계좌
				for(Bank temp2 : Day09_은행계좌프로그램_1.accountlist) {
					if(temp2 != null && temp2.getAno().equals(transferano)) {
						
						if(temp.getBalance()<transfer) {
							return 1; // 잔액부족
						} // if e
						else {
							Day09_은행계좌프로그램_1.accountlist[i].setBalance(temp.getBalance()-transfer);
							Day09_은행계좌프로그램_1.accountlist[j].setBalance(temp2.getBalance()+transfer);
							return 2; // 이체성공
						} // else e
					} // if e
					j++;
				} // for e
				return 3; // 이체받을 계좌 정보가 없을경우
			} // if e
			i++;
		} // for e
		return 4; // 본인계좌 정보가 없을경우
	} // 이체 e
	
	// 5. 내 계좌목록
	// 6. 대출
} // ce
