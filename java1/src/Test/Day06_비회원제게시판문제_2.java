package Test;

import java.util.Scanner;

public class Day06_비회원제게시판문제_2 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Board[] boardlist = new Board[100];
		
		while(true) {
			System.out.println("-------------- 커뮤니티 --------------");
			System.out.println("번호\t작성자\t제목");
			
			int i = 0;
			for(Board temp : boardlist) {
				if(temp != null) {
					System.out.printf("%d\t%s\t%s", i, temp.writer, temp.title);
					break;
				} // if e
				i++;
			} // for e
			
			System.out.println("-------- 메뉴 --------");
			System.out.println("1.글쓰기 2.글보기");
			System.out.println("선택 : ");	int ch = scanner.nextInt();
			
			if(ch==1) {
				System.out.println("---------- 글쓰기 ----------");
				System.out.println("제목 : ");	String title = scanner.next();
				System.out.println("내용 : ");	String content = scanner.next();
				System.out.println("작성자 : ");	String writer = scanner.next();
				System.out.println("비밀번호 : ");	String password = scanner.next();
				
				Board board = new Board(title, content, writer, password);
				
				int j = 0;
				for(Board temp : boardlist) {
					if(temp == null) {
						boardlist[j] = board;
						break;
					} // if e
					j++;
				} // for e
			} // if e
			
			else if(ch==2) {
				System.out.println("게시물 번호 선택 : "); 	int bno = scanner.nextInt();
				System.out.println("---------- 글보기 ----------");
				System.out.printf("작성자 : %s  제목 : %s", boardlist[bno].writer, boardlist[bno].title);
				System.out.printf("내용 : %s", boardlist[bno].content);
				
				System.out.println("-------- 글보기 메뉴 --------");
				System.out.println("1.목록보기 2.삭제 3.수정");
				System.out.println("선택 : ");	int ch2 = scanner.nextInt();
				
				if(ch2==1) {}
				else if(ch2==2) {
					System.out.println("--------- 삭제 페이지 ---------");
					System.out.println("게시물의 비밀번호 : ");	String password = scanner.next();
				
					if(boardlist[bno].password.equals(password)) {
						System.out.println("게시물 삭제 성공");
						boardlist[bno] = null;
						
						for(int j = 0; j<boardlist.length; j++) {
							if(j == boardlist.length-1) {
								boardlist[boardlist.length-1] = null;	// i가 마지막인덱스 와 같으면 마지막인덱스에는 null 대입
							} // if e
							else {
								boardlist[j] = boardlist[j+1]; // 마지막 인덱스가 아니면 인덱스 위로 당기기 
							} // else e
						} // for e
					} // if e
					else {
						System.err.println("알림)비밀번호가 다릅니다 [삭제실패]");
					} // else e
				} // else if e
				
				else if(ch2==3)	{}
				else {
					System.err.println("알림)알 수 없는 번호입니다.");
				} // else e
			} // else if e
			else {
				System.err.println("알림)알 수 없는 번호입니다.");
			} // else e
		} // while e
		
	} // me
} // ce
