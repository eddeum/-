package Day03;

import java.util.Scanner;

public class Day03_8 {
	
	public static void main(String[] args) {
		
		// p.135 Ȯ�ι���7
		// ���� ���� [ �������� ����Ҽ� �ִ� ���� ���� ]
		boolean run = true; // ���� ���� ���� / true=���� false=����
		int balance = 0; // ���ݾ�[����ȿ� �ִ� �ݾ�] ���� 
		Scanner scanner = new Scanner(System.in); // �Է°�ü 
		
		while( run ) { // while( true ) {  } : ���ѷ���
			System.out.println("------------------------");
			System.out.println("1.���� 2.��� 3.�ܰ� 4.����");
			System.out.println("------------------------");
			System.out.print("����>"); 
		
			int ���� = scanner.nextInt();
		
			if (����==1) {
				System.out.print("���ݾ�> ");	int ���ݾ� = scanner.nextInt();
				balance += ���ݾ�;
			} // if e
			else if (����==2)	{
				System.out.println("��ݾ�>");	int ��ݾ� = scanner.nextInt();
				if(��ݾ�>balance)	{System.out.println("�˸�) �ܾ��� �����մϴ�.");}
				else	{balance -= ��ݾ�;}
			} // else if e
			else if (����==3)	{
				System.out.println("�ܰ�>" + balance);
			} // else if e
			else if (����==4)	{
				break;
			} // else if e
			else {
				System.out.println("�˸�) �˼� ���� ��ȣ�Դϴ�.");
			} // else e
		
		} // while e
		
	} // me

} // ce
