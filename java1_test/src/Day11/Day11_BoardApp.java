package Day11;

import java.awt.Container;
import java.util.Scanner;

public class Day11_BoardApp {
	/*
import java.util.ResourceBundle.Control;
	 * 게시판/댓글 프로그램[예외처리, 파일처리, 리스트]
	 * 	// 게시물 클래스[M]
	 * 		// 번호=인덱스, 제목, 내용, 패스워드, 작성자, 작성일, 조회수, 댓글리스트
	 * 	// 댓글 클래스[M]
	 * 		// 내용, 패스워드, 작성자, 작성일
	 * 	// 컨트롤러 클래스[C]
	 * 		// 1.목록 2.쓰기 3.보기 4.수정 5.삭제 6.댓글쓰기
	 * 		// 7.게시물저장 8.게시물불러오기 9.댓글저장 10.댓글불러오기
	 * 	// Day11_4_BoardApp[V]
	 * 		// 입출력[입력받아 컨트롤러에게 입력받은 값 전달]
	 */
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		
		while(true) {
			try {
				// 모든 게시물 출력
				System.out.printf("%s\t%10s\t%5s\t%10s\t%2s \n", "번호", "제목", "작성자", "작성일", "조회수");
				
				
				System.out.println("1.쓰기  2.보기   선택 : ");	int ch = scanner.nextInt();
				
				if(ch==1) {
					System.out.println("******* 게시물 등록 *******");
					System.out.println("제목 : ");	String 제목 = scanner.next();
					System.out.println("내용 : ");	String 내용 = scanner.next();
					System.out.println("작성자 : ");	String 작성자 = scanner.next();
					System.out.println("비밀번호 : ");	String 비밀번호 = scanner.next();
					
					BoardApp_Controller.write(제목, 내용, 작성자, 비밀번호);
			
				} // if e
				else if (ch==2) {}
				else {
					System.err.println("알림))알 수 없는 번호입니다.");
				} // else e
				
				
				
				
				
			} // try e
			catch(Exception e) {
				System.err.println("알림))사용할수 없는 번호입니다.");
			} // catch e
		} // while e
	} // me

} // ce
