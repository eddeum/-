package Day11;

import java.awt.Container;
import java.util.Scanner;

public class Day11_BoardApp {
	/*
import java.util.ResourceBundle.Control;
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
		
		
		while(true) {
			try {
				// ��� �Խù� ���
				System.out.printf("%s\t%10s\t%5s\t%10s\t%2s \n", "��ȣ", "����", "�ۼ���", "�ۼ���", "��ȸ��");
				
				
				System.out.println("1.����  2.����   ���� : ");	int ch = scanner.nextInt();
				
				if(ch==1) {
					System.out.println("******* �Խù� ��� *******");
					System.out.println("���� : ");	String ���� = scanner.next();
					System.out.println("���� : ");	String ���� = scanner.next();
					System.out.println("�ۼ��� : ");	String �ۼ��� = scanner.next();
					System.out.println("��й�ȣ : ");	String ��й�ȣ = scanner.next();
					
					BoardApp_Controller.write(����, ����, �ۼ���, ��й�ȣ);
			
				} // if e
				else if (ch==2) {}
				else {
					System.err.println("�˸�))�� �� ���� ��ȣ�Դϴ�.");
				} // else e
				
				
				
				
				
			} // try e
			catch(Exception e) {
				System.err.println("�˸�))����Ҽ� ���� ��ȣ�Դϴ�.");
			} // catch e
		} // while e
	} // me

} // ce
