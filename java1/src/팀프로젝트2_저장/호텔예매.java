package ��������Ʈ2_����;

import java.util.ArrayList;
import java.util.Scanner;

public class ȣ�ڿ��� {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
	
		
		while(true) {
			System.out.println("************** ȣ�� ���� ���α׷� **************");
			System.out.println("��¥�Է�(mmdd) :");	String ��¥ = scanner.next();
			
			boolean result = Controller.��¥üũ(��¥);
			if(result=true) {
				Controller.����(��¥);
				
				System.out.println("********* �� ���� ��Ȳǥ *********");
				System.out.println("��ȣ\t���̸�\t�ݾ�\t���࿩��");
				System.out.print("1"+"."+"Ʈ����"+"10,000��");
				System.out.print("2"+"."+"�����"+"20,000��");
				System.out.print("3"+"."+"�ٴٺ�Ʈ����"+"30,000��");
				System.out.print("4"+"."+"�ٴٺ�����"+"40,000��");
				System.out.print("5"+"."+"����Ʈ��"+"50,000��");
				
				int ch = scanner.nextInt();
				
				if(ch==1) {}
				else if(ch==2) {}
				else if (ch==3) {}
				else if(ch==4) {}
				else if(ch==5) {}
				else {
					System.out.println("�˸�))�� ��ȣ�� �߸��Է��Ͽ����ϴ�.");
				} // else e
				
			} // if e
			else {
				System.out.println("�˸�))��¥�� �߸��Է��Ͽ����ϴ�.");
			}
			
			
		} // while e
		
	} // me

} // ce
