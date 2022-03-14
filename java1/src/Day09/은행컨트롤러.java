package Day09;

import java.util.Random;

public class 은행컨트롤러 { // 클래스
	
	// 해당 클래스는 은행 관련 컨트롤러
	// M : 모델 [데이터]
	// V : 뷰 [입출력]
	// C : 모델[M]과 뷰[V]의 연결 역할 
	
	// 뷰에서 요청하는 서비스[기능] 제공
		// 1. 계좌생성[C]
	public String 계좌생성(String 비밀번호, String 계좌주, int 은행번호) {
		// 1. 입력받은 값을 가져온다[인수]
		String 계좌번호 = null; // 선언만 [이유 : while 안에서 선언시 while 안에서 사용가능하기 때문]
		while(true) {
			// 계좌번호 자동생성
			Random random = new Random(); // 랜덤
			// 4자리 생성
			int 난수 = random.nextInt(10000); // 0~9999사이 값
			계좌번호 = String.format("%04d", 난수);
							// 문자형식 변경
								// %d : 정수
								// %4d : 정수 4자리[만일 자릿수 없으면 공백처리]
									// 15 -> 15
								// %04d : 정수 4자리[만일 자릿수 없으면 0처리]
									// 15 -> 0015
			// 중복체크
			boolean 계좌번호중복 = false;
			for(은행 temp2 : Day09_6_은행계좌프로그램.계좌리스트) {
				if(temp2 != null && temp2.get계좌번호().equals(계좌번호)) { // 기존 배열내 계좌번호와 동일하면
					계좌번호중복 = true;
				} // if e	
			} // for e
			if(계좌번호중복 == false)  break;
		} // while e
		
		// 2. 객체화[다수의 변수를 하나의 객체로 만들기]
			은행 temp = null; // 빈 객체 생성
			if(은행번호 == 1) 		{temp = new 국민은행(계좌번호, 비밀번호, 계좌주, 0);} 
			else if(은행번호==2) 	{temp = new 신한은행(계좌번호, 비밀번호, 계좌주, 0);} 
			else if (은행번호==3) 	{temp = new 하나은행(계좌번호, 비밀번호, 계좌주, 0);} 
		// 3. 배열에 저장[DB/파일]
			int i = 0;
			for(은행 temp2 : Day09_6_은행계좌프로그램.계좌리스트) {
				if(temp2 == null) {
					Day09_6_은행계좌프로그램.계좌리스트[i] = temp;
					return 계좌번호; // 계좌번호가 존재하면 성공했다는 의미
				} // if e
				i++;
			} // for e
		
		return null;
	} // String e
	
		// 2. 입금[U]
	public boolean 입금(String 계좌번호, int 입금액) {
		
		// 1. 동일한 계좌번호를 찾아서
		int i = 0;
		for(은행 temp : Day09_6_은행계좌프로그램.계좌리스트) {
			if(temp != null && temp.get계좌번호().equals(계좌번호)) {
				// 해당 계좌가 공백이 아니고 입력한[인수]와 같으면
				// 2. 동일한 계좌번호가 있으면 입금처리	
				Day09_6_은행계좌프로그램.계좌리스트[i].set예금액(temp.get예금액()+입금액);
									// Setter = 기존금액 + 새로운 입금액
				return true;
				
			} // if
			i++;
		} // for e
		// 3. 동일한 계좌번호가 없으면 입금실패
		return false;
	} // boolean e
	
		// 3. 출금[U]
	public int 출금(String 계좌번호, String 비밀번호, int 출금액) {	
		// 1. 동일한 계좌번호를 찾아서
		// 2. 동일한 계좌번호와 비밀번호가 일치확인
		int i = 0;
		for(은행 temp : Day09_6_은행계좌프로그램.계좌리스트) {
			if(temp != null && temp.get계좌번호().equals(계좌번호) && temp.get비밀번호().equals(비밀번호)) {
				if(temp.get예금액() < 출금액) {
					return 1; // 잔액부족 의미 반환
				} // if e
				else { 
					// 3. 비밀번호가 일치하면 출금처리
					Day09_6_은행계좌프로그램.계좌리스트[i].set예금액(temp.get예금액()-출금액);
					return 2; // 출금성공 의미 반환
				} // else e
			} // if e
			i++;
		} // for e
		return 3; // 동일한 정보가 아닐경우 실패 의미 반환
	
	} // boolean e
	
		// 4. 이체[U] 본인 계좌/비밀번호/이체액/받는사람 계좌
	public int 이체(String 계좌번호, String 비밀번호, int 이체액, String 이체계좌) {
		// 1. 동일한 계좌번호와 비밀번호 찾기
		// 2. 이체계좌를 찾기
		// 3. 본인계좌에서 이체금액을 빼기 
		// 	  이체계좌에서 이체금액을 더하기
		// 리턴 경우의 수 : 1.성공  2.실패[본인계좌 정보 틀림, 이체계좌 정보 틀림, 잔액부족 등]
		int i = 0; // 본인 인덱스 위치 변수
		for(은행 temp : Day09_6_은행계좌프로그램.계좌리스트) {
			if(temp != null && temp.get계좌번호().equals(계좌번호) && temp.get비밀번호().equals(비밀번호)) {
				
				int j = 0; // 받는사람 인덱스 위치 변수
				for(은행 temp2 : Day09_6_은행계좌프로그램.계좌리스트) {
					if(temp2 != null && temp2.get계좌번호().equals(이체계좌)) {
						
						if(temp.get예금액() < 이체액) {
							return 1; // 잔액부족
						} // if e
						else {
							Day09_6_은행계좌프로그램.계좌리스트[i].set예금액(temp.get예금액()-이체액);
							Day09_6_은행계좌프로그램.계좌리스트[j].set예금액(temp2.get예금액()+이체액);
							return 2;
						} // else e
					}// if e
					j++;
				} // for e
			
			} // if e
			i++;
		} // for e
		// 본인계좌 정보가 없을경우
		return 4;
	
	} // boolean e
		// 5. 내계좌목록[R]
	public 은행[] 계좌목록(String 계좌주) {
	// 입력받은 계좌주의 계좌목록을 만들어서 반환
						// 인수 : 외부로 들어오는 데이터
		// 동일한 계좌주의 계좌를 찾아서 배열에 담아 넘기기
		은행[] 내계좌목록 = new 은행[100];
		for(은행 temp : Day09_6_은행계좌프로그램.계좌리스트) {
			if(temp != null && temp.get계좌주().equals(계좌주)) {
				//해당 계좌내 계좌주와 인수의 계좌주와 동일하면
					// 내 계좌목록 배열내 빈공간을 찾아서 내계좌목록에 넣기
				int i = 0;
				for(은행 temp2 : 내계좌목록) {
					if(temp2 == null) {
						내계좌목록[i] = temp;
						break;
					} // if e
					i++;
				} // for e
			} // if e
		} // for e
		
		
		return 내계좌목록;
	}
		// 6. 대출[U]
	public boolean 대출() {return false;}

}
