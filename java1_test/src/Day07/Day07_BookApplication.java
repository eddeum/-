package Day07;

import java.util.Scanner;

public class Day07_BookApplication {

	// BookApllication Ŭ���� : ����� �����ڵ�
	// Book Ŭ���� : ���� ���� �ڵ�
	// Member Ŭ���� : ȸ�� ���� �ڵ�
	
	// * ���� �뿩 console ���α׷�[Ŭ��������]
		// 1. Ŭ���� ����
			// 1. Book
				// �ʵ� : ISBN(�����ڵ�), ������, �۰�, �����뿩����, �뿩ȸ��
				// �޼ҵ� : 1.�����˻� 2.������� 3.�����뿩 4.�����ݳ� 5.������� 6.��������
			// 2. Member
				// �ʵ� : ��ȣ, ���̵�, ��й�ȣ, �̸�, ����ó
				// �޼ҵ� : 1.ȸ������ 2.�α��� 3.���̵�ã�� 4.��й�ȣã�� 5.�α׾ƿ�
		// 2. ȭ�� ����
			// 1. �ʱ�޴� [1.ȸ������ 2.�α��� 3.���̵�ã�� 4.��й�ȣã��]
			// 2. �Ϲ�ȸ���޴� [1.�����˻� 2.������� 3.�����뿩 4.�����ݳ� 5.�α׾ƿ�]
			// 3. �����ڸ޴� [1.������� 2.������� 3.�������� 4.����(����) 5.�α׾ƿ�]
	
	static Scanner scanner = new Scanner(System.in);
	static Member[] memberlist = new Member[100];
	static Book[] booklist = new Book[1000];
	
	public static void main(String[] args) {
		
		Day07_BookApplication application = new Day07_BookApplication();
		application.menu();
	} // me
	
	// 1. �ʱ� �޴� �޼ҵ�
	void menu() {
		while(true) {
			System.out.println("------------- ���� �뿩 ���α׷� -------------");
			System.out.println("1.ȸ������ 2.�α��� 3.���̵�ã�� 4.��й�ȣã�� : ");
			int ch = scanner.nextInt();
			
			Member member = new Member();
			
			if(ch==1) {
				boolean result = member.ȸ������();
				if(result) 	System.out.println("�˸�)ȸ������ ����");
				else		System.out.println("�˸�)ȸ������ ����");
			} // if e
			else if(ch==2) {
				String result = member.�α���();
				if(result == null) {
					System.out.println("�˸�)������ ȸ�������� �����ϴ�.");
				} // if e
				else if(result.equals("admin")) {
					System.out.println("�˸�)�ȳ��ϼ���" + result +"��");
					adminmenu();
				} // else if e
				else {
					System.out.println("�˸�)�ȳ��ϼ���" + result +"��");
					membermenu(); ///////��ȣ�ȿ� result???
				} // else e
			} // else if e
			else if(ch==3) {
				member.���̵�ã��();
			} // else if e
			else if(ch==4) {
				member.��й�ȣã��();
			} // else if e
			else {
				System.out.println("�˸�)�� �� ���� ��ȣ�Դϴ�.");
			} // else e
			
		} // while e
		
	} // void e
	// 2. �Ϲ�ȸ�� �޴� �޼ҵ�
	void membermenu() {}
	// 3. ������ȸ�� �޴� �޼ҵ�
	void adminmenu() {}
	
} // ce
