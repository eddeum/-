package Day06;

import java.util.Scanner;

public class Day06_6 {

	// ��ȸ���� �Խ���[Ŭ���� ����]
	
		// 0. �Խù� ���� => Ŭ���� ����
			// �ʵ� : ����, ����, �ۼ���, ��й�ȣ
			// ������ : ������� ����
		// 1. ù ȭ��[��� �Խù�(��ȣ,�ۼ���,����) ���]
		// 2. �޴�[1.�۾��� 2.�ۺ���]
			// 1. �۾��� [����, ����, �ۼ���, ��й�ȣ => 4������ => ��ü����]
			// 2. �ۺ��� [�ش� �� ��ȣ�� �Է¹޾� �ش� �� ��������(��ȣ,�ۼ���,����,����) ǥ��]
				// �� ��ȣ�� �迭�� ����Ǵ� ����[�ε���]
				// �ۺ��� �޴�
		// 3. �ۺ��� �޴�[1.��Ϻ��� 2.���� 3.����]
			// 1. ������ : �ۼ��ڿ� ��й�ȣ �Է¹޾� �����ϸ� ����
			// 2. ������ : �ۼ��ڿ� ��й�ȣ �Է¹޾� �����ϸ� ����� ���븸 ����
	
	public static void main(String[] args) {
		
		// �غ�[��� �߰�ȣ{} �ȿ��� ���Ǵ� ���� ����]
		Scanner scanner = new Scanner(System.in);	// 1. �Է°�ü
		Board[] boardlist = new Board[100];			// * Board ��ü�� 100�� ������ �� �ִ� 1���� �迭 ����
		
		// ���α׷� ����
		while(true) { // ���α׷� ���� ���ѷ���[�������� X]
			
			System.out.println("--------- Ŀ�´�Ƽ ---------");
			//////////////////////////////// ��� �Խù� ��ȸ ////////////////////////////////
			System.out.printf("��ȣ\t�ۼ���\t���� \n");
				// �迭�� ��� ��ü(�Խù�) ��� �ݺ���
				int index = 0; // �ε��� ����[�ݺ����� üũ = �迭�� ��ü �� üũ]
				for(Board board : boardlist) {
					if(board != null) {
						// ���࿡ �ش� board ��ü�� ���빰�� ������ ���
						System.out.printf("%d\t%s\t%s \n", index, board.writer, board.title);
							// ���Ĺ��� : %s ����,  %d ����
									// %����s : ���ڸ�ŭ �ڸ�����[���࿡ �ش� �����Ͱ�
					} // if e	
					index++; // �ε��� ����	
				} // for e
			////////////////////////////////////////////////////////////////////////////
			System.out.println("1.�۾��� 2.�ۺ���");
			int ch = scanner.nextInt();
			///////////////////////////////// �۾��� /////////////////////////////////////
			if(ch==1) { // 1. �۾���
				// 1. 4�� ������ �Է¹޴´�
				System.out.println("--------------- �۾��� ������ ---------------");
				System.out.println("title : ");		String title = scanner.next();
				System.out.println("content : ");	String content = scanner.next();
				System.out.println("writer : ");	String writer = scanner.next();
				System.out.println("password : ");	String password = scanner.next();
				// 2. 4�� ������ ��üȭ[��ü�� ���� 4�������� ��ü�� �ʵ忡 ����]
				Board board = new Board(title, content, writer, password);
							// 4�� �ʵ带 ���� ������ ���
				// 3. �迭�� ������� ã�Ƽ� ������� ��ü ����
				int i = 0;
				for(Board temp : boardlist) {
					if(temp == null) { // ����� ã������
						boardlist[i] =board; // �ش� �ε����� ���ο� ��ü ����
						break; // �ѹ� ���������� �ݺ��� ����
					} // if e
					i++;
				} // for e
			} // if e
			////////////////////////////////////////////////////////////////////////////
			else if(ch==2) { // 2. �ۺ���
				 
			} // else if e
			else {
				System.err.println("�˸�))�˼����� ��ȣ�Դϴ�.");
			} // else e
			
		} // while e
		
	} // me
} // ce
