package DDeum;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class View {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
		//	try {
			System.out.println(1650%1440);
			try {
				System.out.println("*********** ���� �ý��� ***********");
				
				int i = 0;
				for(Car temp : Controller.carlist) {
					if(temp.getLocation() != null) {
						System.out.println("[" + temp.getCnum()+"]");
					} // if e
					else {
						System.out.println("[  ]");
					} // else e
				} // for e
				

				
				System.out.println("1.���� 2.���� 3.����Ȯ��   ����> "); int ch = scanner.nextInt();
				
				if(ch==1) {
					System.out.println("�� ��ȣ : "); int cnum = scanner.nextInt();	
					System.out.println("�԰��� : ");	String date = scanner.next();
					System.out.println("�԰�ð� : "); String time = scanner.next();
					
					
					
					boolean result = Controller.datecheck(date);
					boolean result2 = Controller.timecheck(time);
					
					
					if(result == false) {
						System.err.println("�˸�))��¥�� �߸��Է��Ͽ����ϴ�.");
					} // if e
					else if(result2 == false) {
							System.out.println("�˸�))�ð��� �߸��Է��Ͽ����ϴ�.");
					} //  else e
					else {
					String intime = date+time;
					boolean result3 = Controller.carin(cnum, intime);
					if(result3)				{System.out.println("��������");}
					else					{System.err.println("�˸�))�����Դϴ�.");}						
					}			
					


					
				}  // if e
				else if(ch==2) {
					System.out.println("�� ��ȣ : ");	int cnum = scanner.nextInt();
					System.out.println("������ :");	String date = scanner.next();
					System.out.println("�����ð� : ");	String time = scanner.next();
					
					String outtime = date + time;
					
					int parkingtime = Controller.parktime(cnum, outtime);
					// ��ݰ��
					int ��� = Controller.pay(parkingtime);
					
					if(���==0) {
						System.out.println("�˸�)����� �����ϴ�.");
					} // if e
					else {
						System.out.println(���+"�� �Դϴ�.");
					} // else e
					
					Controller.sales(date, ���);
		
					
				} // else e
				else if(ch==3) {
					System.out.println("����Ȯ���� �ʿ��� ���� �Է����ּ���.");
					System.out.println("�� : "); 	int month = scanner.nextInt();
					if(1<=month && month<=12) {
						if(Controller.totalcharge[month-1]==0) {
							System.out.println(month+"�� ������ �����ϴ�.");
						} // if e
						else {
							System.out.println(month + "�� ������" + Controller.totalcharge[month-1] + "�� �Դϴ�.");
						} // else e
					} // if e
					else {
						System.out.println("�˸�))���� �߸��Է��Ͽ����ϴ�.");
					} // else e
				} // else if e
				else {
					System.err.println("�˸�)�˼� ���� ��ȣ�Դϴ�.");
				} // else e
				
				
				
			} catch(Exception e) {
				System.err.println("�����Դϴ�.(�����ڿ��� ����)");
			} // catech e
		} // while e
		
	} // me
} // ce

// ����1. ����/���� �޼ҵ忡�� ��üȭ�� add, remove ���°� ������������?
// ����2. ��ݰ�� �޼ҵ忡�� �����ð��� 1440���϶� 500���̻��� ����????
