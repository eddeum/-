package Test2;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class �������α׷� {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			try {
				System.out.println("--------------------------- ���� ��Ȳ ǥ ---------------------------");
				System.out.println();
				System.out.print("\t\t\t"+DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm").format(LocalDateTime.now())+"\t\n");
				System.out.println();
				System.out.println("��¥\t\t������ȣ\t\t�����ð�\t\t�����ð�\t\t�ݾ�");
				// ��������Ʈ �ۼ�
					
					for(Parking temp : Controller.parkinglist) {
						if(temp != null) {
							if(temp.get�����ð�() != null) {
								System.out.printf(temp.get��¥()+"\t\t"+temp.get������ȣ()+"\t\t"+temp.get�����ð�()+"\t\t"+temp.get�����ð�()+"\t\t"+temp.get�ݾ�()+"\n");
							} // if e
							else {
								System.out.printf(temp.get��¥()+"\t"+temp.get������ȣ()+"\t\t"+temp.get�����ð�()+"\t\t"+"������"+"\t\t"+"������"+"\n");
							} // else e
						} // if e
					} // for e
						
				System.out.println();
				System.out.println("------------------------------------------------------------------");
				System.out.println("\t\t\t1. ����    2. ����");	int ch = scanner.nextInt();
				
				if(ch==1) {
					System.out.println("������ȣ �Է� : ");	String ������ȣ = scanner.next();
					int result = Controller.����(������ȣ);
					if(result==1) {System.out.println("��������~!");}
					else if(result==2) {System.err.println("�˸�))�ߺ��� ������ȣ�Դϴ�.");}
					else if (result==3) {System.err.println("�˸�))�����Դϴ�.");}
				}
				else if(ch==2) {
					System.out.println("������ȣ �Է� : ");	String ������ȣ = scanner.next();
					Controller.����(������ȣ);
				} // else if e
				else {
					System.err.println("�˸�))��ȣ�� �߸��Է��Ͽ����ϴ�.");
				} // else e
				
				
			}catch(Exception e) {
				System.err.println("�˸�)�����߻�(�����ڿ��Թ���)");
			} // catch e
		} // while e
		
		
		
		
		
		
		
		
		
	} // me

} // ce
