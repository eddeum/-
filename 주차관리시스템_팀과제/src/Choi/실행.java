package Choi;

import java.util.ArrayList;
import java.util.Scanner;


public class ���� {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("���� ��ȣ : "); String ����=scanner.next();
		System.out.println("���� ��¥(ex 0320) : "); String ������¥=scanner.next();
		System.out.println("���� ��¥(ex 1515) : "); String �����ð�=scanner.next();
		
		
		boolean result= �޼ҵ�.����( ����,������¥,�����ð�);
		if(result==true) {System.out.println("��������");}
		else if(result==false) {System.out.println("��������");}
		
				
		
		
	}//m e
}
