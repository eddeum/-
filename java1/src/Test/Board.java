package Test;

public class Board {
	
	// 필드
	String title;
	String content;
	String writer;
	String password;
	
	// 생성자
		// 빈생성자
		Board(){}
		// 1개 필드 받는 생성자
		Board(String title){
			this.title = title;
		}
		// 2개 필드 받는 생성자
		Board(String title, String content){
			this.title = title;
			this.content = content;
		}
		// 3개 필드 받는 생성자
		Board(String title, String content, String writer){
			this.title = title;
			this.content = content;
			this.writer = writer;
		}
		// 4개 필드 받는 생성자
		Board(String title, String content, String writer, String password){
			this.title = title;
			this.content = content;
			this.writer = writer;
			this.password = password;
		}
	
	// 메소드

}
