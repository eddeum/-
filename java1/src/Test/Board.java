package Test;

public class Board {
	
	// �ʵ�
	String title;
	String content;
	String writer;
	String password;
	
	// ������
		// �������
		Board(){}
		// 1�� �ʵ� �޴� ������
		Board(String title){
			this.title = title;
		}
		// 2�� �ʵ� �޴� ������
		Board(String title, String content){
			this.title = title;
			this.content = content;
		}
		// 3�� �ʵ� �޴� ������
		Board(String title, String content, String writer){
			this.title = title;
			this.content = content;
			this.writer = writer;
		}
		// 4�� �ʵ� �޴� ������
		Board(String title, String content, String writer, String password){
			this.title = title;
			this.content = content;
			this.writer = writer;
			this.password = password;
		}
	
	// �޼ҵ�

}
