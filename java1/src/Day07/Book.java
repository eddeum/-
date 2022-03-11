package Day07;

public class Book {

	// 1. 필드
	String ISBN;	// ISBN[도서번호 = 식별용]
	String bname;	// 도서명
	String bwriter;	// 작가
	boolean brental;// 도서대여여부
	String mid;		// 대여인ID
	
	// 2. 생성자
		// 1. 빈생성자 : 메소드호출용
	public Book() {}
		
		// 2. 풀생성자[모든필드를받는생성자] : 도서등록
	public Book(String iSBN, String bname, String bwriter, boolean brental, String mid) {
		ISBN = iSBN;
		this.bname = bname;
		this.bwriter = bwriter;
		this.brental = brental;
		this.mid = mid;
	}
	
	// 3. 메소드
		// 1. 도서검색
	void 도서검색() {
		System.out.println("---------- 도서검색 페이지 ----------");
//		System.out.println("도서명 검색 : "); String bname = Day07_5_BookApplication.scanner.next();
//		System.out.println("");
		
//		for(Book temp : Day07_5_BookApplication.booklist) {
//			if(temp != null && temp.bname.equals(bname)) {
//				System.out.printf("도서코드:%s\t도서명:%s\t작가:%s\t도서대여여부:%s\t대여인ID:%s \n"
//						,temp.ISBN, temp.bname, temp.bwriter, temp.brental, temp.mid);
//				return;
//			} // if e
//		} // for e
//		System.err.println("알림))동일한 책을 찾을 수 없습니다.");
	} // void e
	
		// 2. 도서목록
	void 도서목록() {
		System.out.println("---------- 도서목록 페이지 ----------");
		System.out.println("도서코드\t도서명\t작가\t대여가능여부");
		
		for(Book temp : Day07_5_BookApplication.booklist) {
			if(temp != null) { // 도서가 존재하면
				if(temp.brental)	// 도서대여가 가능하면
					System.out.println(temp.ISBN+"\t"+temp.bname+"\t"+temp.bwriter+"\t"+"대여가능");
				else // 해당도서의 도서대여여부가 false
					System.out.println(temp.ISBN+"\t"+temp.bname+"\t"+temp.bwriter+"\t"+"대여중");
			} // if e	
		} // for e
	} // void e
	
		// 3. 도서대여
	void 도서대여(String loginid) {
		System.out.println("---------- 도서대여 페이지 ----------");
		System.out.println("도서 ISBN : ");	String isbn = Day07_5_BookApplication.scanner.next();
		
		for(Book temp : Day07_5_BookApplication.booklist) {
			// * 임시객체 : 배열이름
				// 배열내 0번인덱스부터 마지막인덱스까지 하나씩 임시 객체 대입
				// temp 수정 X -> 배열의 i번째로 수정 O
			if(temp != null && temp.ISBN.equals(isbn)) {
				if(temp.brental) {
					System.out.println("알림))해당도서 대여합니다.");
					temp.brental = false; // 대여중으로 변경 ////////////////////////수정하기
					temp.mid = loginid;					////////////////////////수정하기
					return;
				} // if e
				else {
					System.out.println("알림))해당도서 대여중입니다.");
					return;
				}  // else e
			} // if e
		} // for e
		
	} // void e
	
		// 4. 도서반납
	void 도서반납(String loginid) {
		System.out.println("---------- 도서반납 페이지 ----------");
		도서대여목록(loginid);
		System.out.println("도서 ISBN : ");	String isbn = Day07_5_BookApplication.scanner.next();
		for(Book temp : Day07_5_BookApplication.booklist) {
			if(temp != null && temp.ISBN.equals(isbn)) { // 입력한 isbn이 있으면
				if(temp.mid.equals(loginid)) { // 대여인Id와 현재 로그인된id 동일하면
					if(temp.brental) { // 대여중이 아니면
						System.out.println("알림))현재 도서가 대여중이 아닙니다.");
					} // if e
					else { // 대여중이면
						System.out.println("알림))반납 완료!!!!");
						temp.brental = true;	////////////////////////수정하기
						temp.mid = null;		////////////////////////수정하기
						return;
					} // else e
				} // if e
				else {
					System.out.println("알림))회원님이 대여한 도서가 아닙니다.");
				} // else e
			} // if e
		} // for e
		
		
	} // void e
	
	// * 현재 로그인 한 회원이 대여중인 도서목록
	void 도서대여목록(String loginid) {
		System.out.println("---------- 도서목록 페이지 ----------");
		System.out.println("도서코드\t도서명\t작가\t도서대여여부");
		
		for(Book temp : Day07_5_BookApplication.booklist) {
			if(temp != null && temp.mid.equals(loginid)) {
				// * 도서가 존재하면서 대여id와 현재 로그인한id와 같으면
				System.out.println(temp.ISBN+"\t"+temp.bname+"\t"+temp.bwriter+"\t"+"대여중");
			} // if e	
		} // for e
	} // void e

	
	
		// 5. 도서등록
	void 도서등록() {
		System.out.println("---------- 도서등록 페이지 ----------");
		// 1. 입력받기
		System.out.println("ISBN : ");	String isbn = Day07_5_BookApplication.scanner.next();
		System.out.println("도서명 : ");	String bname = Day07_5_BookApplication.scanner.next();
		System.out.println("작가 : ");	String bwriter = Day07_5_BookApplication.scanner.next();
		
			// * 중복체크[isbn]
			for(Book temp : Day07_5_BookApplication.booklist) {
				if(temp != null && temp.ISBN.equals(isbn)) {
					System.err.println("알림))현재 사용중인 ISBN입니다.");
					return;	// 도서등록 메소드 종료(등록실패)
				} // if e
			} // for e
		
		// 2. 객체화[도서대여여부 = true, 대여회원id = null]
		Book book = new Book(isbn, bname, bwriter, true, null);
		
		// 3. 배열 대입[넣기]
		int i = 0;
		for(Book temp : Day07_5_BookApplication.booklist) {
			if(temp == null) {
				Day07_5_BookApplication.booklist[i]=book;
				System.out.println("알림))도서등록이 완료되었습니다.");
				return;
			} // if e
			i++;
		} // for e
		
	} // void e
		// 6. 도서삭제
	void 도서삭제() {
		System.out.println("---------- 도서삭제 페이지 ----------");
	} // void e
}
