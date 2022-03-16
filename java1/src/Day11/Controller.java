package Day11;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class Controller {

	// ��� �޼ҵ�� static
	// C(���)R(�б�)U(����)D(����)
	
	// 0. �Խù� ����Ʈ
	public static ArrayList<Board> boardlist = new ArrayList<>();
	
	
	// 2. ����޼ҵ�
	public static void write(String ����, String ����, String �ۼ���, String ��й�ȣ) {
		// 1. ��üȭ[������ 4�� -> 1�� ��ü]
		Board board = new Board(����, ����, �ۼ���, ��й�ȣ);
		// 2. ����Ʈ�� ����
		boardlist.add(board);
		// 3. ���Ͽ� ����
		save();
		
	} // ���� e

	// 4. �����޼ҵ�
	public static void update() {}
	// 5. �����޼ҵ�
	public static void delete() {
		
	} // ���� e
	// 6. ��۾���޼ҵ�
	public static void replywrite() {}
	// 7. �Խù�����/�����޼ҵ�
	public static void save() {
		// ����Ʈ�� ��� �Խù��� ���Ͽ� ����
		try {
			// 1. ������� Ŭ����
			FileOutputStream outputStream = new FileOutputStream("D:/java/�Խù�����.txt");
			// 2. ���Ͽ� �ۼ��� ����[����Ʈ �� ��ü 1���� = ���پ� = �Խù� 1����]
			for(Board board : boardlist) {
				String �ۼ����� = board.getTitle()+","+board.getContent()+","+
						board.getPassword()+","+board.getWriter()+","+
						board.getViewcount()+","+board.getDate()+"\n";
			// 3. ����[���ڿ�] -> ����Ʈ�� ��ȯ
			// 4. ��������[write()]				
				outputStream.write(�ۼ�����.getBytes());
			} // for e

		}// try e
		catch(Exception e) {
			System.err.println("�˸�]]�������� ����(�����ڿ��� ����)");
		} // catch e
	
	} // �Խù����� e
	
	// 8. �Խù��ҷ�����޼ҵ�[���α׷� ����]���� ---> ����Ʈ
	public static void load() {
		try {
			FileInputStream inputStream = new FileInputStream("D:/java/�Խù�����.txt");	// 1. �����Է�Ŭ����
			byte[] bytes = new byte[1000];			// 2. ����Ʈ�迭 ����
			inputStream.read(bytes);				// 3. ��� ����Ʈ �о�ͼ� ����Ʈ�� ����
			 String file = new String(bytes);		// 4. ����Ʈ -> ���ڿ� ��ȯ
			 String[] boards = file.split("\n");	// 5. ���ڿ� �ڸ���[���پ�(\n) -> 1����ü]
			 
			 int i = 0;
			 for( String temp : boards) { // �迭�� ���ڿ� �ϳ��� ������
				 if(i+1 == boards.length) break;	// ������ �ε���[��ü]���� -> ������ �Ʒ� ������ ���ַ���(\n �������� �ɰ��� ������ 1�� ������ : \n 3�� -> ���� 4��)
				 String[] field = temp.split(",");	// 6. ���ڿ� �ڸ���[����(,) -> �� �ʵ�
				 Board board = new Board(field[0], field[1], field[2],
						field[3], Integer.parseInt(field[4]), field[5], null);			// 7. ��üȭ
				 							// ��ȸ���� �������̹Ƿ� ����ȯ(Integer.parseInt(���ڿ�)
				 boardlist.add(board);					// 8. ����Ʈ ���	
				 i++; // �ε��� ����
			 } // for e
		} catch (Exception e) {
			System.out.println("�˸�]]���Ϸε� ����(�����ڿ��� ����)");
		} // catch e
		
	} // �Խù��ҷ����� e
	
	
	
} // ce
