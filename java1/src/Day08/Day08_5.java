package Day08;

import java.util.Scanner;

public class Day08_5 {

	// ����� ��ũ ���α׷�[2�� ����]
		// �䱸����
		// ȸ�� �ֿ��� : 1.ȸ������ 2.�α��� 3.���̵�ã�� 4.��й�ȣã�� 5.�α׾ƿ�
		// ���� �ֿ��� : 1.���»��� 2.�Ա� 3.��� 4.��ü 5.���� 6.�� ���¸��
			// ȸ���� ���� ���� ���
			// ������(�����) ���� ��ǰ�� ����ϸ� ��ϵ� �����ǰ���� ȸ������ �����ؼ� ���� ���
		// ���� : ����, �����ǰ ���(������), ȸ�� 
	
		// ����Ŭ���� = ����Ŭ����
			// �ʵ� : 1.�����̸� 2.�ݾ� 3.���� 4.������[id] 5.��ȯ����
		// ����Ŭ����
			// �ʵ� : 1.���¹�ȣ(�ߺ�x) 2.���ݾ� 3.�̸�[id]
			// �ʵ� 
				// ȸ�� : ���̵�, ��й�ȣ, �̸�, ����ó
				// ���� : ���¹�ȣ(�Է¹���), �����ܾ�, ������(ȸ���̸�), ��й�ȣ
			// �޼ҵ�
	
	static Scanner scanner = new Scanner(System.in);
	static Bank[] banklist = new Bank[100];
	static Member[] member = new Member[100];
	
	public static void main(String[] args) {
		
		Day08_5 mbank = new Day08_5();
		mbank.menu();
		
	}  // me
	
	void menu() {
		while(true) {
			System.out.println("----------------- ����� ��ũ ���α׷� -----------------");
			System.out.println("1.ȸ������ 2.�α��� 3.���̵�ã�� 4.��й�ȣã��  ���� : ");
			int ch = scanner.nextInt();
			
			Member member = new Member();
			
			if(ch==1) {
				boolean result = member.ȸ������();
				if(result)System.out.println("�˸�))ȸ������ ����");
				else System.err.println("�˸�))ȸ������ ����");
			} // if e
			
			else if(ch==2) {
				String  result = member.�α���();
				if(result==null) {
					System.out.println("�˸�))������ ȸ�������� �����ϴ�.");
				} // if e
				else if(result.equals("admin")) {//2.������ �޴� �޼ҵ� ȣ��
					System.out.println("�˸�))�ȳ��ϼ���~"+result+"��");
					adminmenu();
				} // else if e
				else {//1. �Ϲ�ȸ�� �޴� �޼ҵ� ȣ��
					System.out.println("�˸�))�ȳ��ϼ���~"+result+"��");
					bankmenu();
				} // else e
			} // else if e
			else if(ch==3) {}
			else if(ch==4) {}
			else {
				System.err.println("�˸�))�� �� ���� ��ȣ�Դϴ�.");
			} // else e
			
		} // while e
	} // void e
	void bankmenu() {
		while(true) {
			System.out.println("------------------- ���� �޴� -------------------");
			System.out.println("1.���»��� 2.�Ա� 3.��� 4.��ü 5.���� 6.���¸�� 7.�α׾ƿ� ���� : ");
			int ch = scanner.nextInt();
		
			Bank bank = new Bank();
		
			if(ch==1) {bank.���»���();}
			else if(ch==2) {bank.�Ա�();}
			else if(ch==3) {bank.���();}
			else if(ch==4) {bank.��ü();}
			else if(ch==5) {}
			else if(ch==6) {bank.���¸��();}
			else if(ch==7) { return;}
			else { 
				System.err.println("�˸�)�� �� ���� ��ȣ�Դϴ�.");
			} // else e
		} // while e
		
	} // void e
	void adminmenu() {}
	
	
} // ce
