package Test;

import java.util.Scanner;

public class Day03_p135Ȯ�ι���_1 { // cs
	
	public static void main(String[] args) { // ms
		
		boolean run = true;
		
		int balance = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		while(run) { // while s
			System.out.println("------------------------");
			System.out.println("1.���� 2.��� 3.�ܰ� 4.����");
			System.out.println("------------------------");
			System.out.print("����>"); 
			
			int ���� = scanner.nextInt();
			
			if(����==1) {
				System.out.print("���ݾ�>" );	int ���ݾ� = scanner.nextInt();
				balance += ���ݾ�;
				
			}
			else if(����==2) {
				
				while(true) {
					System.out.print("��ݾ�>"); int ��ݾ� = scanner.nextInt();

					if(��ݾ�>balance) {
						System.out.println("�˸�) �ܾ��� �����մϴ�.");
					} // if e
					else {
						balance -= ��ݾ�;
						break;
					}	// else e			
				} // while e
			} // else if e
			else if(����==3) {
				System.out.println("�ܰ�>" + balance);
			} // else if e
			else if(����==4) {
				break;
			}
			else {
				System.out.println("�˸�) �˼����� ��ȣ�Դϴ�.");
			} // else e
			
		} // while e
		
		
	} // me

} // ce

// 22.03.05