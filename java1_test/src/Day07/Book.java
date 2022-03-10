package Day07;

public class Book {

	// 1. 필드
	String ISBN;
	String bname;
	String writer;
	boolean rental;
	String mid;
	
	// 2. 생성자
		// 1. 빈생성자
	public Book() {}
		// 2. 풀생성자

	public Book(String iSBN, String bname, String writer, boolean rental, String mid) {
		ISBN = iSBN;
		this.bname = bname;
		this.writer = writer;
		this.rental = rental;
		this.mid = mid;
	}
	
	// 3. 메소드
		// 1. 도서검색 메소드
	void 도서검색() {
		System.out.println("--------- 도서검색 페이지 ---------");
	} // void e
		
		// 2. 도서목록 메소드
	void 도서목록() {
		System.out.println("--------- 도서목록 페이지 ---------");
		System.out.println("도서코드\t도서명\t작가\t대여가능여부");
		
		for(Book temp : Day07_BookApplication.booklist) {
			if(temp != null) {
				if(temp.rental)
					System.out.println(temp.ISBN+"\t"+temp.bname+"\t"+temp.writer+"\t"+"대여가능");
				else
					System.out.println(temp.ISBN+"\t"+temp.bname+"\t"+temp.writer+"\t"+"대여중");
			} // if e
		} // for e
		
	} // void e
		
		// 3. 도서대여 메소드
	void 도서대여() {
		System.out.println("--------- 도서대여 페이지 ---------");
		System.out.println("도서 ISBN : ");	String isbn = Day07_BookApplication.scanner.next();
		
		for(Book temp : Day07_BookApplication.booklist) {
			if(temp != null && temp.ISBN.equals(isbn)) {
				if(temp.rental) {
					System.out.println("알림)해당도서를 대여합니다.");
					temp.rental = false;
					temp.mid = ////////////////////////
					return;
				} // if e
				else {
					System.out.println("알림)해당도서 대여중입니다.");
					return;
				} // else e
			} // if e
		} // for e

	} // void e
		
		// 4. 도서반납 메소드
	void 도서반납() {
		System.out.println("--------- 도서반납 페이지 ---------");
		도서대여목록(loginid); //////////////////????
		System.out.println("도서 ISBN : "); String isbn = Day07_BookApplication.scanner.next();
		
		for(Book temp : Day07_BookApplication.booklist) {
			if(temp != null && temp.ISBN.equals(isbn)) {
				if(temp.mid.equals(loginid)) { //////////////??????
					if(temp.rental) {
						System.out.println("알림)현재 도서가 대여중이 아닙니다.");
					} // if e
					else {
						System.out.println("알림)반납완료 !!");
						temp.rental = true;
						temp.mid = null;
						return;
					} // else e
				} // if e
				else {
					System.out.println("알림)회원님이 대여한 도서가 아닙니다.");
				} // else e
			} // if e
		} // for e

	} //void e
	
	// * 현재 로그인 한 회원이 대여중인 도서목록
	void 도서대여목록() {
		System.out.println("--------- 도서대여목록 페이지 ---------");
		System.out.println("도서코드\t도서명\t작가\t도서대여여부");
		
		for(Book temp : Day07_BookApplication.booklist) {
			if(temp != null && temp.mid.equals(loginid)) {
				System.out.println(temp.ISBN+"\t"+temp.bname+"\t"+temp.writer+"\t"+"대여중");
			} // if e
		} // for e
		
	} // void e
		
		// 5. 도서등록 메소드
	void 도서등록() {
		System.out.println("--------- 도서등록 페이지 ---------");
		System.out.println("ISBN : ");	String isbn = Day07_BookApplication.scanner.next();
		System.out.println("도서명 : ");	String bname = Day07_BookApplication.scanner.next();
		System.out.println("작가 : ");	String writer = Day07_BookApplication.scanner.next();
		
		// * ISBN 중복체크
		for(Book temp : Day07_BookApplication.booklist) {
			if(temp != null && temp.ISBN.equals(isbn)) {
				System.out.println("알림)현재 사용중인 ISBN입니다.");
				return;
			} // if e
		} // for e
		
		// * 객체화[도서대여여부 = true(대여가능), 대여회원id = null]
		Book book = new Book(isbn, bname, writer, true, null)
		
		int i = 0;
		for(Book temp : Day07_BookApplication.booklist) {
			if(temp == null) {
				Day07_BookApplication.booklist[i] = book;
				System.out.println("알림)도서등록이 완료되었습니다.");
				return;
			} // if e
			i++;
		} // for e
				
	} // void e
		
		// 6. 도서삭제 메소드
	void 도서삭제() {
		System.out.println("--------- 도서삭제 페이지 ---------");
	} // void e

	
	
	
}
