package ���α׷��־������_������;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;



public class ���������ý��� {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			try {
				System.out.println("------------------------- ���� ��Ȳ ǥ -------------------------");
				System.out.println();
				System.out.println("\t\t���� �ð� : " + DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm").format(LocalDateTime.now()));
				System.out.println();
				System.out.println("��¥\t\t������ȣ\t\t�����ð�\t\t�����ð�\t\t�ݾ�");
				
				for(Car temp : Controller.carlist) {
					if(temp != null) {
						if(temp.get�����ð�()==null) {
							System.out.printf(temp.get��¥()+"\t"+temp.get������ȣ()+"\t"+temp.get�����ð�()+"\t\t"+"������"+"\t\t"+"���� ��"+"\n");
						} // if e
						else {
							System.out.printf(temp.get��¥()+"\t"+temp.get������ȣ()+"\t"+temp.get�����ð�()+"\t\t"+temp.get�����ð�()+"\t\t"+temp.get�ݾ�()+"\n");
						} // else e
					} // if
				} // for e
				
				System.out.println();
				System.out.println("-------------------------------------------------------------");
				System.out.println("\t\t\t1. ����    2.����");	int ch = scanner.nextInt();
				
				if(ch==1) {
					System.out.println("������ȣ �Է� : ");	String ������ȣ = scanner.next();
					int result = Controller.����(������ȣ);
					if(result==1) {
						System.out.println("��������");
					} // if e
					else if(result==2) {
						System.err.println("�˸�))������ȣ�� �ߺ��Ǿ����ϴ�.");
					} // else if e
					else if(result==3) {
						System.err.println("�˸�)�����Դϴ�.");
					} // else if e
				} // if e
				
				else if(ch==2) {
					System.out.println("������ȣ �Է� : ");	String ������ȣ = scanner.next();
					int ��� = Controller.����(������ȣ);
					if(���==0) {
						System.out.println("�˸�))����� ����� �����ϴ�.");
					} // if e
					else {
						System.out.println(���+"�� �Դϴ�.");
					} // else e
				} // else if e
				
				else {
					System.err.println("�˸�))��ȣ�� �߸��Է��Ͽ����ϴ�.");
				} // else e
			
			}catch(Exception e) {
				System.err.println("�˸�))�����߻�(�����ڿ��Թ���)");
			} // catch e

		} // while e
	
	} // me

} // ce
