package Day09;

import java.util.Scanner;

public class Day09_����������α׷�_1 {

	public static Bank[] accountlist = new Bank[100];
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("---------- ���� �ý��� ----------");
			System.out.println("1.���»��� 2.�Ա� 3. ��� 4.��ü 5.�����¸�� 6.����   ���� : ");
			int ch = scanner.nextInt();
			
			BankController bankcontroller = new BankController();
			
			if(ch==1) {
				System.out.println("*** ���µ�� ������ ***");
				System.out.println("��й�ȣ : ");	String password = scanner.next();
				System.out.println("������ : "); 	String owner = scanner.next();
				System.out.println("���༱�� < 1.KB 2.SH 3.HN > : "); int bno = scanner.nextInt();
				
				String ano = bankcontroller.���»���(password, owner, bno);
				
				if(ano != null) {
					System.out.println("++ ���� ���� ++");
					System.out.println("������ ���¹�ȣ : " + ano);
				} // if e
				else {
					System.err.println("�˸�)���µ�� ����");
				} // else e
				
			} // if e
			else if(ch==2) {
				System.out.println("*** �Ա� ������ ***");
				System.out.println("���¹�ȣ : "); 	String ano = scanner.next();
				System.out.println("�Աݾ� : ");		int deposit = scanner.nextInt();
				
				boolean result = bankcontroller.�Ա�(ano, deposit);
				
				if(result) {
					System.out.println("++ �Ա� ���� ++");
				} // if e
				else {
					System.err.println("�˸�)�Աݽ���[������ ���°� �����ϴ�]");
				} // else e
			} // else if e
			
			else if(ch==3) {
				System.out.println("*** ��� ������ ***");
				System.out.println("���¹�ȣ : ");	String ano = scanner.next();
				System.out.println("��й�ȣ : ");	String password = scanner.next();
				System.out.println("��ݾ� : "); 	int withdraw = scanner.nextInt();
				
				int result = bankcontroller.���(ano, password, withdraw);
				
				if(result == 1) {
					System.err.println("�˸�)�ܾ� ���� ");
				} // if e
				else if(result ==2) {
					System.out.println("++ ��� ���� ++");
				} // else if e
				else if(result ==3) {
					System.err.println("�˸�)�ùٸ� ������ �ƴմϴ�.");
				} // else if e
			} // else if e
			
			else if(ch==4) {
				System.out.println("*** ��ü ������ ***");
				System.out.println("���¹�ȣ : "); String ano = scanner.next();
				System.out.println("��й�ȣ : "); String password = scanner.next();
				System.out.println("��ü�ݾ� : "); int transfer = scanner.nextInt();
				System.out.println("��ü��������");	String transferano = scanner.next();
				
				int result = bankcontroller.��ü(ano, password, transfer, transferano);
				
				if(result==1) {
					System.err.println("�˸�)�ܾ� ����");
				} // if e
				else if(result==2) {
					System.out.println("++ ��ü ���� ++");
				} // else if e
				else if(result==3) {
					System.err.println("�˸�)��ü���� ���������� �����ϴ�.");
				} // else if e
				else if(result==4) {
					System.err.println("�˸�)������ ���������� �����ϴ�.");
				} // else if e
				
			} // else if e
			
			else if(ch==5) {
				System.out.println("*** �� ���¸�� ������ ***");
				
			} // else if e
			else if(ch==6) {
				System.out.println("*** ���� ������ ***");
				
			} // else if e
			else {
				System.err.println("�˸�)�� �� ���� ��ȣ�Դϴ�.");
			} // else e
			
		} // while e
		
	} // me
} // ce
