package ��������Ʈ;

import java.util.ArrayList;
import java.util.Scanner;

import Day06.Car;

public class ���� {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String[] parklist = new String[12];
		///////////////////car, ����, ������
		
		while(true) {
			System.out.println("******* �������� �ý��� *******");
			System.out.println("1.���� 2.���� 3. ����Ȯ��   ���� :  "); int ch = scanner.nextInt();
			
			if(ch==1) {
				System.out.println("������ȣ �Է� : "); int cnum = scanner.nextInt();
				
				
				for(int i = 0; i<=parklist.length; i++) {
					if(parklist[i] != null) {
						System.out.println("�˸�)�����Դϴ�.");
					} // if e
					else {

					} // else e
				}// for e
			} // if e
			else if(ch==2) {
				System.out.println("������ȣ �Է� : "); 	int cnum = scanner.nextInt();

				// ��ݰ��

				
			} // else if e
			else if(ch==3) {
				
			}
			else {
				System.err.println("�˸�))�� �� ���� ��ȣ�Դϴ�.");
			} // else e
			
		
		
		} // while e

	} // me
} // ce
