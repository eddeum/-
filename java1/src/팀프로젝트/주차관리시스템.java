package ��������Ʈ;

import java.util.Scanner;

public class ���������ý��� {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String[] parklo = {"[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]",
				"[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"};
		
		while(true) {
			
			for(int i = 0; i<parklo.length; i++) {
				System.out.print(parklo[i]);
				
				if(i%4==0) {
					System.out.println();
				} // if e
			} // for e
			
			while(true) {
				try {
					System.out.println("******** �������� �ý��� ********");
					System.out.println("1.���� 2.���� 3.����Ȯ��");
					System.out.println("���� : ");	int ch = scanner.nextInt();
					if(ch==1) {
						System.out.println("������ȣ �Է� : ");	int cnum = scanner.nextInt();
						System.out.println("������ �Է� : ");	String idate = scanner.next();
						System.out.println("�����ð� �Է� : ");	String itime = scanner.next();
						
						boolean result = Controller.carcheck(cnum); // ������ȣüũ
						boolean result2 = Controller.datecheck(idate); // ��¥üũ
						boolean result3 = Controller.timecheck(itime); // �ð�üũ
						
						if(result==false) {
							System.err.println("�˸�)������ȣ�� �߸��ԷµǾ����ϴ�.");
						} // if e
						else {
							if(result2==false) {
								System.err.println("�˸�)��¥�� �߸��ԷµǾ����ϴ�.");
							} // if e
							
						}// else e

						
						
					} // if e
					else if(ch==2) {}
					else if(ch==3) {}
					else {
						System.err.println("�˸�))�߸��� ��ȣ�Դϴ�.");
					} // else e
				}catch(Exception e) {
					System.err.println("�˸�))�����Դϴ�.(�����ڿ��� ����)");
				} // catch e
				
				
			} // while e
			
			
			
			
			
		} // while e
		
		
	} // me

} // ce
