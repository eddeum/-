package Day11;

import java.util.ArrayList;

public class BoardApp_Controller {
	
	public static ArrayList<Board> boardlist = new ArrayList<>();
	
	// 1. 목록 메소드
	
	// 2. 쓰기 메소드
	public static void write(String 제목, String 내용, String 작성자, String 비밀번호) {
		
		Board board = new Board(제목, 내용, 작성자, 비밀번호);
		
		boardlist.add(board);
		
		save();	//////////////////////////////////////////////////////////////////
		
	} // 쓰기 e
	
	// 3. 보기 메소드
	
	// 4. 수정 메소드
	
	// 5. 삭제 메소드
	
	// 6. 댓글쓰기 메소드

}
