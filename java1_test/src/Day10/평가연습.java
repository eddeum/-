package Day10;

import java.util.Scanner;

public class �򰡿��� {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String[][] ��������Ʈ = new String[100][8];
		
		while(true) {
			
			System.out.println("-----------------------------------");
			System.out.println("         ��      ��      ǥ          ");
			System.out.println("-----------------------------------");
			System.out.println("��ȣ  �̸�  ����  ����  ����  ����  ���  ����");
			System.out.printf();
			System.out.println("-----------------------------------");
			System.out.println("�޴� : 1.�л����� ��� 2.�л����� ����");
			int ch = scanner.nextInt();
			
		if(ch==1) {
				
			System.out.println("��ȣ : ");	int ��ȣ = scanner.nextInt();	
			System.out.println("�̸� : ");	String �̸� = scanner.next();
			System.out.println("���� : ");	int ���� = scanner.nextInt();
			System.out.println("���� : ");	int ���� = scanner.nextInt();
			System.out.println("���� : ");	int ���� = scanner.nextInt();
			
			int ���� = ���� + ���� + ����;
			double ��� = ����/3;
			
			for(int i =1; i<=5; i++) {
				if(��������Ʈ[i][0] == null) {
				��������Ʈ[i][0] = ��ȣ; ��������Ʈ[i][1] = �̸�; ��������Ʈ[i][2] = ����; ��������Ʈ[i][3] = ����;
				��������Ʈ[i][4] = ����; ��������Ʈ[i][5] = ����; ��������Ʈ[i][6] = ���; ��������Ʈ[i][7] = ����;
				} // if e
			} // for e
			
			
				
				
			} // if e
			else if (ch==2) {
				
			} // else if e
			else {
				System.err.println("�˸�)�� �� ���� ��ȣ�Դϴ�.");
			} // else e
			
			
		} // while e
		
	} // me
} // ce
