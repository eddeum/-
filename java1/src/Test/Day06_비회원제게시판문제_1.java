package Test;

import java.util.Scanner;

public class Day06_비회원제게시판문제_1 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Board[] boardlist = new Board[100];
		
		while(true) {
			
			System.out.println("-------- 커뮤니티 ---------");
			System.out.printf("번호\t작성자\t제목 \n");
			
			int i  = 0;	// 1을 넣을경우 표현은 가능하지만 글보기에서 번호로 불러올때 해당글이 안불러와짐
			for(Board temp : boardlist) {
				if(temp != null) {
					System.out.printf("%d\t%s\t%s \n", i, temp.writer, temp.title );
				} // if e
				i++;
			} // for e
			
			System.out.println("1.글쓰기 2.글보기");
			System.out.println("선택 : ");	int ch = scanner.nextInt();
			
			if(ch==1) {
				System.out.println("-------- 글쓰기 ---------");
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
				
				System.out.println("글 번호 : "); int bno = scanner.nextInt();
				System.out.println("-------- 글보기 ---------");
				System.out.printf("작성자 : %s 제목 : %s \n", boardlist[bno].writer, boardlist[bno].title);
				System.out.printf("내용 : %s \n", boardlist[bno].content);
				System.out.println("-----------------------");
				System.out.println("1.목록보기 2.삭제 3.수정");	int ch2 = scanner.nextInt();
				
				if(ch2==1) {}
				else if(ch2==2) {
					System.out.println("게시물 비밀번호 : ");	String password = scanner.next();
					
					for(Board temp : boardlist) {
						if(temp != null && temp.password.equals(password)) {
							syso
							boardlist[bno] = null;
						} // if e
					} // for e
				} // else if e
				else if(ch2==3) {}
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
