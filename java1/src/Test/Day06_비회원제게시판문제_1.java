package Test;

import java.util.Scanner;

public class Day06_��ȸ�����Խ��ǹ���_1 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Board[] boardlist = new Board[100];
		
		while(true) {
			
			System.out.println("-------- Ŀ�´�Ƽ ---------");
			System.out.printf("��ȣ\t�ۼ���\t���� \n");
			
			int i  = 0;	// 1�� ������� ǥ���� ���������� �ۺ��⿡�� ��ȣ�� �ҷ��ö� �ش���� �Ⱥҷ�����
			for(Board temp : boardlist) {
				if(temp != null) {
					System.out.printf("%d\t%s\t%s \n", i, temp.writer, temp.title );
				} // if e
				i++;
			} // for e
			
			System.out.println("1.�۾��� 2.�ۺ���");
			System.out.println("���� : ");	int ch = scanner.nextInt();
			
			if(ch==1) {
				System.out.println("-------- �۾��� ---------");
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
				
				System.out.println("�� ��ȣ : "); int bno = scanner.nextInt();
				System.out.println("-------- �ۺ��� ---------");
				System.out.printf("�ۼ��� : %s ���� : %s \n", boardlist[bno].writer, boardlist[bno].title);
				System.out.printf("���� : %s \n", boardlist[bno].content);
				System.out.println("-----------------------");
				System.out.println("1.��Ϻ��� 2.���� 3.����");	int ch2 = scanner.nextInt();
				
				if(ch2==1) {}
				else if(ch2==2) {
					System.out.println("�Խù� ��й�ȣ : ");	String password = scanner.next();
					
					for(Board temp : boardlist) {
						if(temp != null && temp.password.equals(password)) {
							syso
							boardlist[bno] = null;
						} // if e
					} // for e
				} // else if e
				else if(ch2==3) {}
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
