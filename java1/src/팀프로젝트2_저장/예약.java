package ��������Ʈ2_����;

import java.util.Calendar;
import java.util.Scanner;

import ddeum.Room;


public class ���� {

	public static Room[] roomlist = new Room[100];
	
///////////////////////// ��¥�Է¿���üũ(4�ڸ� �Է�) //////////////////////////////////
	public static boolean ��¥üũ(String ��¥) {
		Calendar calendar = Calendar.getInstance(); // �Է¹��� ���� ������ ���� ���ϱ� ����
		int month = Integer.parseInt(��¥) / 100; // �Է¹��� ��¥ 4�ڸ����Ŀ��� ���� 2�ڸ��� '��'�� ����
		int day = Integer.parseInt(��¥) % 100; // �Է¹��� ��¥ 4�ڸ����Ŀ��� ���� 2�ڸ��� '��'�� ����
		calendar.set(2022, month-1, 1); // �Է¹��� ���� ���������ڸ� ���ϱ� ���� �� 1�Ϸ� ����
		int eday = calendar.getActualMaximum(calendar.DAY_OF_MONTH); // �Է¹��� ���� ���������� ����
		if(month>=1 && month<=12 && day>=1 && day<=eday) {
			return true;
		} // if e
		return false;
	} // ��¥üũ e

/////////////////////////////////// ������ /////////////////////////////////////////		
	public static void ������() {
		for(Room temp : roomlist) {
			if(temp != null) {
				System.out.printf("%3s\t%10s\t%7s\n",temp.getDate(),temp.getRname(),temp.getName());
			} // if e
		} // for e
	
	} // ������ e
/////////////////////////////////// ���� /////////////////////////////////////////
	
//	public static void ����() {
		public static void main(String[] args) {
			
	
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			try {
				System.out.println("************** ȣ�� ���� ���α׷� **************");
				System.out.println("1.���� 2.������"); int ch = scanner.nextInt();
				if(ch==1) {
					System.out.println("��¥�Է�(mmdd) :");	String ��¥ = scanner.next();
				
					boolean result = ��¥üũ(��¥);
					
					if(result==true) {
						boolean[] ���డ�� = new boolean[5];
						for(Room temp : roomlist) {
							if(temp != null) {
						 // ��¥�� MM(��)dd(��)�� String ������ ��ü����
								if(temp.getDate().equals(��¥)) { // temp���� ��¥�� �Է¹��� ��¥�� �����ϰ�
									if(temp.getRname().equals("Ʈ����")) { // temp���� ���̸��� Ʈ����� �����ϸ�
										���డ��[0] = true;				// ���డ�� = true -> "����Ұ�"
									} // if e
									if(temp.getRname().equals("�����")) {
										���డ��[1] = true;
									} // if e
									if(temp.getRname().equals("�ٴٺ�Ʈ����")) {
										���డ��[2] = true;
									} // if e
									if(temp.getRname().equals("�ٴٺ�����")) {
										���డ��[3] = true;
									} // if e
									if(temp.getRname().equals("����Ʈ��")) {
										���డ��[4] = true;
									} // if e
								} // if e
							} // if e
						} // for e
					
						System.out.println("************** �� ���� ��Ȳǥ **************");
						System.out.println("��ȣ\t���̸�\t\t�ݾ�\t\t���࿩��");
						System.out.println("1"+".\t"+"Ʈ����\t\t"+"10,000��\t\t"+((���డ��[0])?"����Ұ�":"���డ��")); // ���ǿ�����[���ǽ�? �� : ����]
						System.out.println("2"+".\t"+"�����\t\t"+"20,000��\t\t"+((���డ��[1])?"����Ұ�":"���డ��"));
						System.out.println("3"+".\t"+"�ٴٺ�Ʈ����\t"+"30,000��\t\t"+((���డ��[2])?"����Ұ�":"���డ��"));
						System.out.println("4"+".\t"+"�ٴٺ�����\t"+"40,000��\t\t"+((���డ��[3])?"����Ұ�":"���డ��"));
						System.out.println("5"+".\t"+"����Ʈ��\t\t"+"50,000��\t\t"+((���డ��[4])?"����Ұ�":"���డ��"));
						
						System.out.println("�� ��ȣ ���� : ");	int ch2 = scanner.nextInt();
						System.out.println("������ �̸� : ");	String name = scanner.next();
						
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
						
						Room room1 = new Room("Ʈ����", "10,000��","����Ұ�", name, ��¥);
						Room room2 = new Room("�����", "20,000��","����Ұ�", name, ��¥);
						Room room3 = new Room("�ٴٺ�Ʈ����", "30,000��","����Ұ�", name, ��¥);
						Room room4 = new Room("�ٴٺ�����", "40,000��","����Ұ�", name, ��¥);
						Room room5 = new Room("����Ʈ��", "50,000��","����Ұ�", name, ��¥);
						
						for(int i = 0; i<roomlist.length; i++) {
							if(roomlist[i]==null) {
									if(ch2==1) {	
										if(���డ��[ch2-1]) {
											System.out.println("�˸�)�ش糯¥�� Ʈ���� ����Ұ��մϴ�.");
											break;
										} // if e
										else {
											roomlist[i]=room1;
											System.out.println("1���� Ʈ������ ����Ǿ����ϴ�.");
											break;
										} // else e
									} // if e
									else if(ch2==2) {
										if(���డ��[ch2-1]) {
											System.out.println("�˸�)�ش糯¥�� ����� ����Ұ��մϴ�.");
											break;
										} // if e
										else {
											roomlist[i]=room2;
											System.out.println("2���� ������� ����Ǿ����ϴ�.");
											break;
										} // else e
									} // else if e
									else if(ch2==3) {
										if(���డ��[ch2-1]) {
											System.out.println("�˸�)�ش糯¥�� �ٴٺ�Ʈ���� ����Ұ��մϴ�.");
											break;
										} // if e
										else {
											roomlist[i]=room3;
											System.out.println("3���� �ٴٺ�Ʈ������ ����Ǿ����ϴ�.");
											break;
										} // else e
									} // else if e
									else if(ch2==4) {
										if(���డ��[ch2-1]) {
											System.out.println("�˸�)�ش糯¥�� �ٴٺ����� ����Ұ��մϴ�.");
											break;
										} // if e
										else {
											roomlist[i]=room4;
											System.out.println("4���� �ٴٺ������� ����Ǿ����ϴ�.");
											break;
										} // else e
									} // else if e
									else if(ch2==5) {
										if(���డ��[ch2-1]) {
											System.out.println("�˸�)�ش糯¥�� ����Ʈ�� ����Ұ��մϴ�.");
											break;
										} // if e
										else {
											roomlist[i]=room5;
											System.out.println("5���� ����Ʈ���� ����Ǿ����ϴ�.");
											break;
										} // else e
									} // else if e
							} // if e		
						} // for e	

						
					} // if e
					else {
						System.out.println("�˸�))��¥�� �߸��Է��Ͽ����ϴ�.");
					} // else e

				} // if e
				else if(ch==2) {
					System.out.printf("%3s\t%10s\t%7s\n","��¥","���̸�","������");
					������();
				} // else if e
				
				
			}catch(Exception e) {
				System.out.println("�˸�))�����Դϴ�(�����ڿ��Թ���)");
			} // catch e

		} // while e

	} // ���� e
		
	
} // ce
