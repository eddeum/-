package Test;

import java.util.Scanner;

public class Day06_��ȸ�����Խ��ǹ���_2 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Board[] boardlist = new Board[100];
		
		while(true) {
			System.out.println("-------------- Ŀ�´�Ƽ --------------");
			System.out.println("��ȣ\t�ۼ���\t����");
			
			int i = 0;
			for(Board temp : boardlist) {
				if(temp != null) {
					System.out.printf("%d\t%s\t%s", i, temp.writer, temp.title);
					break;
				} // if e
				i++;
			} // for e
			
			System.out.println("-------- �޴� --------");
			System.out.println("1.�۾��� 2.�ۺ���");
			System.out.println("���� : ");	int ch = scanner.nextInt();
			
			if(ch==1) {
				System.out.println("---------- �۾��� ----------");
				System.out.println("���� : ");	String title = scanner.next();
				System.out.println("���� : ");	String content = scanner.next();
				System.out.println("�ۼ��� : ");	String writer = scanner.next();
				System.out.println("��й�ȣ : ");	String password = scanner.next();
				
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
				System.out.println("�Խù� ��ȣ ���� : "); 	int bno = scanner.nextInt();
				System.out.println("---------- �ۺ��� ----------");
				System.out.printf("�ۼ��� : %s  ���� : %s", boardlist[bno].writer, boardlist[bno].title);
				System.out.printf("���� : %s", boardlist[bno].content);
				
				System.out.println("-------- �ۺ��� �޴� --------");
				System.out.println("1.��Ϻ��� 2.���� 3.����");
				System.out.println("���� : ");	int ch2 = scanner.nextInt();
				
				if(ch2==1) {}
				else if(ch2==2) {
					System.out.println("--------- ���� ������ ---------");
					System.out.println("�Խù��� ��й�ȣ : ");	String password = scanner.next();
				
					if(boardlist[bno].password.equals(password)) {
						System.out.println("�Խù� ���� ����");
						boardlist[bno] = null;
						
						for(int j = 0; j<boardlist.length; j++) {
							if(j == boardlist.length-1) {
								boardlist[boardlist.length-1] = null;	// i�� �������ε��� �� ������ �������ε������� null ����
							} // if e
							else {
								boardlist[j] = boardlist[j+1]; // ������ �ε����� �ƴϸ� �ε��� ���� ���� 
							} // else e
						} // for e
					} // if e
					else {
						System.err.println("�˸�)��й�ȣ�� �ٸ��ϴ� [��������]");
					} // else e
				} // else if e
				
				else if(ch2==3)	{}
				else {
					System.err.println("�˸�)�� �� ���� ��ȣ�Դϴ�.");
				} // else e
			} // else if e
			else {
				System.err.println("�˸�)�� �� ���� ��ȣ�Դϴ�.");
			} // else e
		} // while e
		
	} // me
} // ce
