package Day11;

import java.util.ArrayList;

public class BoardApp_Controller {
	
	public static ArrayList<Board> boardlist = new ArrayList<>();
	
	// 1. ��� �޼ҵ�
	
	// 2. ���� �޼ҵ�
	public static void write(String ����, String ����, String �ۼ���, String ��й�ȣ) {
		
		Board board = new Board(����, ����, �ۼ���, ��й�ȣ);
		
		boardlist.add(board);
		
		save();	//////////////////////////////////////////////////////////////////
		
	} // ���� e
	
	// 3. ���� �޼ҵ�
	
	// 4. ���� �޼ҵ�
	
	// 5. ���� �޼ҵ�
	
	// 6. ��۾��� �޼ҵ�

}
