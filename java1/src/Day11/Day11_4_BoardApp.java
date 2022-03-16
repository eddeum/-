package Day11;

import java.util.Scanner;

public class Day11_4_BoardApp {
	/*
	 * �Խ���/��� ���α׷�[����ó��, ����ó��, ����Ʈ]
	 * 	// �Խù� Ŭ����[M]
	 * 		// ��ȣ=�ε���, ����, ����, �н�����, �ۼ���, �ۼ���, ��ȸ��, ��۸���Ʈ
	 * 	// ��� Ŭ����[M]
	 * 		// ����, �н�����, �ۼ���, �ۼ���
	 * 	// ��Ʈ�ѷ� Ŭ����[C]
	 * 		// 1.��� 2.���� 3.���� 4.���� 5.���� 6.��۾���
	 * 		// 7.�Խù����� 8.�Խù��ҷ����� 9.������� 10.��ۺҷ�����
	 * 	// Day11_4_BoardApp[V]
	 * 		// �����[�Է¹޾� ��Ʈ�ѷ����� �Է¹��� �� ����]
	 */
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Controller.load(); // 2. ����[��� �Խù�[ �ҷ�����
		
		while(true) {
			try { // ���ܹ߻� : ����ڰ� �����Է½� ���ܹ߻�!!! -> catch�� �̵�
				
				// ��� �Խù� ���
				System.out.printf("%s\t%10s\t%5s\t%10s\t%2s\t \n", "��ȣ", "����", "�ۼ���", "�ۼ���", "��ȸ��");
				int i = 0;
				for(Board board : Controller.boardlist) {
					System.out.printf("%s\t%10s\t%5s\t%10s\t%2s\t \n", i, board.getTitle(), board.getWriter(), board.getDate(), board.getViewcount());
					i++;
				} // for e
				
				System.out.println("1.���� 2.����   ���� : "); 
				int ch = scanner.nextInt();
				if(ch==1) {
					System.out.println("*** �Խù� ��� ***");
						// nextLine() : �������� �Է°��� [����! : nextLine �տ� �Ϲ� next �ϳ��� ���]
						// �ذ��� : �Ϲ�next�� nextLine ���̿� �ǹ̾��� nextLine() �߰�
					scanner.nextLine();
					System.out.println("���� : ");				String ���� = scanner.nextLine(); // -> nextLine : ����
					System.out.println("���� : ");				String ���� = scanner.nextLine();
					System.out.println("�ۼ��� : ");				String �ۼ��� = scanner.next();
					System.out.println("��й�ȣ[����/������] : ");	String ��й�ȣ = scanner.next();
					
					Controller.write(����, ����, ��й�ȣ, �ۼ���);	// �μ�����
					
				} // if e
				
				else if(ch==2) {
					// �ش� �Խù� ��ȣ[�ε���]�� �Է¹޾� �Խù����� ��� ���
					System.out.println("�Խù� ��ȣ : "); 	int index = scanner.nextInt();
					
					Board temp = Controller.boardlist.get(index); // �ش� �ε����� ��ü�� �ӽ� ��ü[�ڵ� ���̱�]
					System.out.println("*** �Խù� ���� ***");
					System.out.println("���� : " + temp.getTitle());
					System.out.println("�ۼ��� : " + temp.getWriter() + "  �ۼ��� : " + temp.getDate() +  "  ��ȸ�� :" + temp.getViewcount());
					System.out.println("���� : " + temp.getContent());
					// ������[����]
					
					// �޴�
					System.out.println("1.�ڷΰ��� 2.���� 3.���� 4.��۾���  ���� : ");	int ch2 = scanner.nextInt();
					if(ch2==1) {}
					else if(ch2==2) {
						System.out.println("�� �Խù� �н����� : ");	String password = scanner.next();
						scanner.nextLine(); // �Ϲ�next �������� nextLine ����ϰԵǸ� �����߻�
						System.out.println("������ ���� : ");  		String title = scanner.nextLine();
						System.out.println("������ ���� : ");  		String content = scanner.nextLine();
						
						boolean result = Controller.update(index, password, title, content); // ������ �ε�����ȣ, �н�����, ����������, �����ҳ���
						
						if(result) System.out.println("�˸�)���� ����");
						else System.err.println("�˸�)���� ����(�н����尡 �ٸ��ϴ�.)");
						
					} // else if e
					else if(ch2==3) {
						System.out.println("�� �Խù� �н����� : ");	String password = scanner.next();
						boolean result = Controller.delete(index, password);
						if(result) System.out.println("�˸�)���� ����");
						else System.err.println("�˸�)���� ����(�н����尡 �ٸ��ϴ�.)");
						
//						Controller.delete(�ε�����ȣ, ��й�ȣ); // ������ �ε�����ȣ, �н����� => �μ�
					} // else if e
					else if(ch2==4) {
						Controller.replywrite(); // �ε�����ȣ, ��۳���, ����н�����, ����ۼ��� => �μ�
					} // else if e
					else {}
					
				} // else if e
				else {}
			}catch(Exception e) {
				System.err.println("�޽���]]����Ҽ� ���� ��ȣ�Դϴ�.[�ٽ��Է�]");
				scanner = new Scanner(System.in); // �ٽ� �޸��Ҵ�[���� ����� �����] -> �� �ٸ� ��� : Scanner�� while�� �ȿ� �ֱ�
			
			} // catch e
			
		} // while e
		
	} // me
	
} // ce
