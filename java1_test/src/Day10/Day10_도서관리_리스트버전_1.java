package Day10;

import java.util.ArrayList;
import java.util.Scanner;

public class Day10_도서관리_리스트버전_1 {

	public static void main(String[] args) {
		
		ArrayList<Book> booklist = new ArrayList<>();
		
		Scanner scanner = new Scanner(System.in);
		
		while(true){
			System.out.println("1.등록 2.목록 3.삭제 4.수정");
			System.out.println("선택 : ");	int ch = scanner.nextInt();
			
			if(ch==1) {
				System.out.println("도서명 : "); 	String 도서명 = scanner.next();
				System.out.println("저자 : "); 	String 저자 = scanner.next();
				
				Book book = new Book(도서명, 저자);
				
				booklist.add(book);
				
			} // if e
			
			else if(ch==2) {
				System.out.println("도서명\t저자");
				for(Book book : booklist) {
					System.out.println(book.get도서명()+"\t"+book.get저자());
				} // for e
			} // else if e
			
			else if(ch==3) {
				System.out.println("삭제할 도서명 : ");	String 도서명 = scanner.next();
				for(Book book : booklist) {
					if(book.get도서명().equals(도서명)) {
						booklist.remove(book);
						break;
					} // if e
				} // for e
			} // else if e
			
			else if(ch==4) {
				System.out.println("수정할 도서명 : ");	String 도서명 = scanner.next();
				
				for(Book book : booklist) {
					if(book.get도서명().equals(도서명)) {
						System.out.println("수정할 저자이름 : ");	String 저자 = scanner.next();
						book.set저자(저자);
					} // if e
				} // for e
			} // else if e
		
			else {
				System.err.println("알림)알 수 없는 번호입니다.");
			} // else e
		} // while e
		
		
	} // me
} // ce
