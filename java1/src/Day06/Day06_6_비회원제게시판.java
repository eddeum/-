package Day06;

import java.util.Scanner;

public class Day06_6_비회원제게시판 {

	// 비회원제 게시판[클래스 버전]
	
		// 0. 게시물 설계 => 클래스 선언
			// 필드 : 제목, 내용, 작성자, 비밀번호
			// 생성자 : 사용유무 선택
		// 1. 첫 화면[모든 게시물(번호,작성자,제목) 출력]
		// 2. 메뉴[1.글쓰기 2.글보기]
			// 1. 글쓰기 [제목, 내용, 작성자, 비밀번호 => 4개변수 => 객체생성]
			// 2. 글보기 [해당 글 번호를 입력받아 해당 글 상세페이지(번호,작성자,제목,내용) 표시]
				// 글 번호는 배열에 저장되는 순서[인덱스]
				// 글보기 메뉴
		// 3. 글보기 메뉴[1.목록보기 2.삭제 3.수정]
			// 1. 삭제시 : 작성자와 비밀번호 입력받아 동일하면 삭제
			// 2. 수정시 : 작성자와 비밀번호 입력받아 동일하면 제목과 내용만 수정
	
	public static void main(String[] args) {
		
		// 준비[모든 중괄호{} 안에서 사용되는 변수 선언]
		Scanner scanner = new Scanner(System.in);	// 1. 입력객체
		Board[] boardlist = new Board[100];			// * Board 객체를 100개 저장할 수 있는 1차원 배열 선언
		
		// 프로그램 실행
		while(true) { // 프로그램 실행 무한루프[종료조건 X]
			
			System.out.println("--------- 커뮤니티 ---------");
			//////////////////////////////// 모든 게시물 조회 ////////////////////////////////
			System.out.printf("번호\t작성자\t제목 \n");
				// 배열내 모든 객체(게시물) 출력 반복문
				int index = 0; // 인덱스 변수[반복순서 체크 = 배열내 객체 수 체크]
				for(Board board : boardlist) {
					if(board != null) {
						// 만약에 해당 board 객체가 내용물이 있으면 출력
						System.out.printf("%d\t%s\t%s \n", index, board.writer, board.title);
							// 형식문자 : %s 문자,  %d 숫자
									// %숫자s : 숫자만큼 자리차지[만약에 해당 데이터가
					} // if e	
					index++; // 인덱스 증가	
				} // for e
			////////////////////////////////////////////////////////////////////////////
			System.out.println("1.글쓰기 2.글보기");
			int ch = scanner.nextInt();
			///////////////////////////////// 글쓰기 /////////////////////////////////////
			if(ch==1) { // 1. 글쓰기
				// 1. 4개 변수를 입력받는다
				System.out.println("--------------- 글쓰기 페이지 ---------------");
				System.out.println("title : ");		String title = scanner.next();
				System.out.println("content : ");	String content = scanner.next();
				System.out.println("writer : ");	String writer = scanner.next();
				System.out.println("password : ");	String password = scanner.next();
				// 2. 4개 변수를 객체화[객체를 만들어서 4개변수를 객체내 필드에 저장]
				Board board = new Board(title, content, writer, password);
							// 4개 필드를 갖는 생성자 사용
				// 3. 배열내 빈공간을 찾아서 빈공간에 객체 대입
				int i = 0;
				for(Board temp : boardlist) {
					if(temp == null) { // 빈공간 찾았으면
						boardlist[i] =board; // 해당 인덱스에 새로운 객체 저장
						break; // 한번 저장했으면 반복문 종료
					} // if e
					i++;
				} // for e
			} // if e
			////////////////////////////////////////////////////////////////////////////
			else if(ch==2) { // 2. 글보기
				 System.out.println("게시물 번호(인덱스)  선택 : ");	 int bno = scanner.nextInt();
				 System.out.println("--------------- 글보기 페이지 ---------------");
				 System.out.printf("작성자 : %s  제목 : %s \n",
						 boardlist[bno].writer, boardlist[bno].title );
				 System.out.printf("내용 : %s \n", boardlist[bno].content);
				 System.out.println("-----------------------------------------");
				 System.out.println("1. 목록보기 2.삭제 3.수정  선택 : ");
				 
				 int ch2 = scanner.nextInt();
				 if(ch2==1) {}
				 else if(ch2==2) {
					 System.out.println("현 게시물 비밀번호 : ");		String password = scanner.next();
					 if(boardlist[bno].password.equals(password)) {
						 System.out.println("알림))삭제 성공");
						 boardlist[bno] = null;
						 for(int i = bno; i<boardlist.length; i++) { // 배열길이 = 100  인덱스 : 0~99
							 if(i==boardlist.length-1) boardlist[boardlist.length-1] = null;
							// i가 마지막인덱스 와 같으면 마지막인덱스에는 null 대입
							 else boardlist[i] = boardlist[i+1];
							// 마지막 인덱스가 아니면 인덱스 당기기 
								// *  	만약에 2번 인덱스 삭제시 
								// 		2인덱스 = 3인덱스 
								//	  	3인덱스 = 4인덱스 
								//		4인덱스 = 5인덱스 
								//      ~~~~~~~~~~~
								//		98인덱스 = 99인덱스 [ 0번~99번 -> 100개 인덱스 ]
								//		99인덱스 = null [ 99번 인덱스 : 마지막인덱스 ] 
						 } // for e
					 } // if e
					 else {
						 System.err.println("알림))비밀번호가 다릅니다 [ 삭제실패 ]");
					 } // else e
				 } // else if e
				 else if(ch2==3) {
					 System.out.println("현 게시물 비밀번호 : ");		String password = scanner.next();
					 if(boardlist[bno].password.equals(password)) {
						 System.out.println("수정할 제목 : ");	boardlist[bno].title = scanner.next();
						 System.out.println("수정할 내용 : ");	boardlist[bno].content = scanner.next();
						 System.out.println(" 알림)) 내용이 수정되었습니다.");
					 } // if e
					 else {
						 System.err.println(" 알림))비밀번호가 다릅니다 [ 수정실패 ]");
					 } // else e
				 } // else if e
				 else {
					 System.err.println("알림)) 알수없는 번호입니다.");
				 } // else e
			} // else if e
			else {
				System.err.println("알림))알수없는 번호입니다.");
			} // else e
			
		} // while e
		
	} // me
} // ce
