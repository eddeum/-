package Day13;

import java.util.Calendar;
import java.util.Scanner;

public class Day13_3_�޷� {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("���� : ");	int year = scanner.nextInt();
		System.out.print("�� : ");	int month = scanner.nextInt();
		
		�޷�(year, month);
		
	} // me
	
	// 1. �޷¸޼ҵ�
	public static void �޷�(int year, int month) {
		while(true) { // ���ѷ���[�������� : 4��]
			// 1. Ķ���� Ŭ���� �� ���� ��¥/�ð� ��ü ȣ��
			Calendar calendar = Calendar.getInstance();

			// 2. ����, ��, ��
			//		int year = calendar.get(Calendar.YEAR);
			//		int month = calendar.get(Calendar.MONTH)+1; // +1 �ϴ����� : 0=1�� / 11=12��
			int day = calendar.get(Calendar.DAY_OF_MONTH);

			// * �ش� ���� 1���� ����ã��
			// 1. ����� ���� Ķ���� ����
			calendar.set(year, month-1, 1); // ��) 2022�� 3�� 1��
			//			System.out.println("����ڰ� ��¥����� : " + calendar.toString());
			// 2. 3�� 1���� ����
			int sweek = calendar.get(Calendar.DAY_OF_WEEK);
			//			System.out.println("���ϱ��ϱ�: " + sweek);
			// 3. 3���� ������ ��
			int eday = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
			//			System.out.println("�ش糯¥�� ������ �ϼ� : " + eday);

			//  3. ���
			System.out.println("******** " + year + "��" + month + "�� ********" );
			System.out.println("��\t��\tȭ\t��\t��\t��\t��");

			// * ���� �� 1���� ��ġ �տ� ���� ä���
			for(int i = 1; i<sweek; i++) {
				// 3�� 1�� = ȭ -> 3
				System.out.print("\t");
			}
			// 1�Ϻ��� ��������¥ ���
			for(int i = 1; i<=eday; i++) {
				// i = �ϼ� ���
				System.out.print(i + "\t");
				// ����ϸ��� �ٹٲ�ó��[�����=7] ������ 7�������
				if(sweek%7 == 0) {System.out.println();} 
				sweek++; // �Ϸ羿 ���� ����
			} // for e

			// ��ư[1.��(������) 2.��(������) 3.�ٽð˻�]
			try { // ���࿡ try {} �ȿ��� ����[����]�� �߻��ϸ� catch�� �̵�(���α׷� �ٿ�x)
				Scanner scanner = new Scanner(System.in);

				System.out.print("\n\n*** [1.��(������) 2.��(������) 3.�ٽð˻� 4.����] *** "); int ch = scanner.nextInt();

				if(ch==1) {
					month -= 1;
					// ���࿡ ���� 0�� �Ǹ� ����1����, �� 12�� ����
					if(month==0) {month =12; year -= 1;}
				} // if e
				else if (ch==2) {
					month += 1;
					// ���࿡ ���� 13���� �Ǹ� ����1����, �� �ٽ� 1�� ����
					if(month == 13) {month = 1; year += 1;}
				} // else if e
				else if(ch==3) {
					System.out.print("���� : ");	year = scanner.nextInt();
					System.out.print("�� : ");	month = scanner.nextInt();
				} // else if e
				else if(ch==4) {
					System.out.println("�˸�))�޷� ���α׷� ����");
					break; // �޼ҵ� ����
				} // else if e
				else {
					System.out.println("�˸�))�� �� ���� ��ȣ�Դϴ�.");
				} // else e
			} catch(Exception e) { // ���࿡ try{}���� ����[����] �߻��ϸ� �ش��ڵ尡 ����
				System.out.println("���))�������� �Է��� ���ּ���(�����ڿ��Թ���)");
			} // catch e

		} // while e
	
	} // �޷� e
	
	
	
	
} // ce
