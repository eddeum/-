package Day08;

import java.util.Scanner;

public class Day08_����Ϲ�ũ���α׷�_1 {
	
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
	static Member[] memberlist = new Member[100];
	static Bank[] banklist = new Bank[100];

	public static void main(String[] args) {
		
		Day08_����Ϲ�ũ���α׷�_1 mobilebank = new Day08_����Ϲ�ũ���α׷�_1();
		mobilebank.menu();
	} // me
	
	// 1. �ʱ�޴� �޼ҵ�
	void menu() {
		while(true) {
			System.out.println("-------- ����� ��ũ ���α׷� --------");
			System.out.println("1.ȸ������ 2.�α��� 3.���̵�ã�� 4.��й�ȣã��");
			System.out.println("���� : ");	int ch = scanner.nextInt();
			
			Member member = new Member();
			
			if(ch==1) {
				boolean result = member.ȸ������();
				if(result)	System.out.println("�˸�)ȸ������ ����");
				else 		System.err.println("�˸�)ȸ������ ����");
			} //if e
			else if(ch==2) {
				String result = member.�α���();
				
				if(result == null) {
					System.err.println("�˸�)������ ȸ�������� �����ϴ�[�α��� ����]");
				} //if e
				else if(result.equals("admin")) {
					System.out.println("�˸�)�ȳ��ϼ���" + result +"��");
					adminmenu();
				} // else if e
				else {
					System.out.println("�ȳ��ϼ���" + result + "��");
					bankmenu(result);
				} // else e
				
			} // else if e
			else if(ch==3) {
				member.���̵�ã��();
			} // else if e
			else if(ch==4) {
				member.��й�ȣã��();
			} // else if e
			else {
				System.err.println("�˸�)�� �� ���� ��ȣ�Դϴ�.");
			} // else e
		} // while e
	} // void e
	
	// 2. ����޴� �޼ҵ�
	void bankmenu(String loginid) {
		while(true) {
			System.out.println("-------- ȸ�� ����Ϲ�ũ �޴� --------");
			System.out.println("1.���»��� 2.�Ա� 3.��� 4.��ü 5.���� 6.�� ���¸�� 7.�α׾ƿ�");
			System.out.println("���� : ");	int ch = scanner.nextInt();
			
			Bank bank = new Bank();
			
			if(ch==1) {
				bank.���»���();
			} // if e
			else if(ch==2) {
				bank.�Ա�();
			} // else if e
			else if(ch==3) {
				bank.���();
			} // else if e
			else if(ch==4) {}
			else if(ch==5) {}
			else if(ch==6) {}
			else if(ch==7) {
				return;
			} // else if e
			else {
				System.err.println("�˸�)�� �� ���� ��ȣ�Դϴ�.");
			} // else e
			
		} // while e
	} // void e
	// 3. ����޴� �޼ҵ�
	void adminmenu() {}
	
} // ce
