package ��������Ʈ2_����;

import java.util.Calendar;
import java.util.Scanner;

import ddeum.Room;


public class ����_����3 {

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
	public static void ������() { //////////////////////////////////////////////////////////////////////////////// ������ ���ڿ����� ����
		for(Room temp : roomlist) {
			if(temp != null) {
				System.out.printf("%3s\t%10s\t%7s\t%15s\n",temp.getDate(),temp.getRname(),temp.getName(),temp.get�߰��̿�()); ///////////////////////////////////////////////////////����(0329)
			} // if e
		} // for e
	
	} // ������ e
/////////////////////////////////// ���� /////////////////////////////////////////
	
//	public static void ����() {
		public static void main(String[] args) {
			
	
		Scanner scanner = new Scanner(System.in); /////////////////////////////////////////// Ȯ�ο�
		
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
						
						for(int i = 0; i<roomlist.length; i++) { ////////////////////////////////////////////////////////////////////////// �ߺ�ó�� ����
							if(roomlist[i]==null) {
									if(ch2==1) {	
										if(���డ��[ch2-1]) {
											System.out.println("�˸�)�ش糯¥�� Ʈ���� ����Ұ��մϴ�.");
											break;
										} // if e
										else {
											roomlist[i]=room1;
											System.out.println("1���� Ʈ������ ����Ǿ����ϴ�.");
											�߰��ü�(i);
											����(i);
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
											�߰��ü�(i);
											����(i);
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
											�߰��ü�(i);
											����(i);
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
											�߰��ü�(i);
											����(i);
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
											�߰��ü�(i);
											����(i);
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
					System.out.printf("%3s\t%10s\t%7s\t%15s\n","��¥","���̸�","������","�߰��̿�ü�");///////////////////////////////////////////////////////����(0329)
					������();
				} // else if e
				
				
			}catch(Exception e) {
				System.out.println("�˸�))�����Դϴ�(�����ڿ��Թ���)");
			} // catch e

		} // while e

	} // ���� e
		
	public static void �߰��ü�( int i) {
		
		Scanner scanner = new Scanner(System.in); /////////////////////////////////////////// Ȯ�ο�
		
		while(true) {
			System.out.println();
			System.out.print("�߰� �̿� �ü��� �������ּ���.(�� 1ȸ�� ������ �����մϴ�.)"
					+ "\n1.���ĺ���(30,000)\n2.������(20,000)\n3.�ｺ��(10,000)\n4.���� \n"); 
			System.out.println("�߰��̿� �ü� �� �������� : ");	int ch = scanner.nextInt();
			
				if(ch==1) { 
					System.out.println("���ĺ��並 �̿��մϴ�.");
					roomlist[i].get�߰��̿�().add("���ĺ���");
				} 
				else if (ch==2) { 
					System.out.println("�������� �̿��մϴ�.");
					roomlist[i].get�߰��̿�().add("������");
				}
				else if(ch==3) { 
					System.out.println("�ｺ���� �̿��մϴ�.");
					roomlist[i].get�߰��̿�().add("�ｺ��");
				} 
				else if(ch==4) {
					break;
				}
				System.out.println();
				System.out.println("** �߰��̿�ü� ������Ȳ **");
				System.out.println(roomlist[i].get�߰��̿�());
		} // while e
		
	} // �߰��ü� e
	
	public static void ����(int i) { ///////////////////////////////////////////////////////�߰�(0329)
		
		
		if(roomlist[i].getRname().equals("Ʈ����")) {
			int tprice = 10000;
			if(roomlist[i].get�߰��̿�().contains("���ĺ���")) {
				tprice += 30000;
			}
			if(roomlist[i].get�߰��̿�().contains("������")) {
				tprice += 20000;
			}
			if(roomlist[i].get�߰��̿�().contains("�ｺ��")) {
				tprice += 10000;
			}
			System.out.println("�����Ͻ� �� �ݾ��� "+tprice+"�� �Դϴ�.");
			System.out.println();
		} // if e
		
		else if(roomlist[i].getRname().equals("�����")) {
			int tprice = 20000;
			if(roomlist[i].get�߰��̿�().contains("���ĺ���")) {
				tprice += 30000;
			}
			if(roomlist[i].get�߰��̿�().contains("������")) {
				tprice += 20000;
			}
			if(roomlist[i].get�߰��̿�().contains("�ｺ��")) {
				tprice += 10000;
			}
			System.out.println("�����Ͻ� �� �ݾ��� "+tprice+"�� �Դϴ�.");
			System.out.println();
		} // else if e
		else if(roomlist[i].getRname().equals("�ٴٺ�Ʈ����")) {
			int tprice = 30000;
			if(roomlist[i].get�߰��̿�().contains("���ĺ���")) {
				tprice += 30000;
			}
			if(roomlist[i].get�߰��̿�().contains("������")) {
				tprice += 20000;
			}
			if(roomlist[i].get�߰��̿�().contains("�ｺ��")) {
				tprice += 10000;
			}
			System.out.println("�����Ͻ� �� �ݾ��� "+tprice+"�� �Դϴ�.");
			System.out.println();
		} // else if e
		else if(roomlist[i].getRname().equals("�ٴٺ�����")) {
			int tprice = 40000;
			if(roomlist[i].get�߰��̿�().contains("���ĺ���")) {
				tprice += 30000;
			}
			if(roomlist[i].get�߰��̿�().contains("������")) {
				tprice += 20000;
			}
			if(roomlist[i].get�߰��̿�().contains("�ｺ��")) {
				tprice += 10000;
			}
			System.out.println("�����Ͻ� �� �ݾ��� "+tprice+"�� �Դϴ�.");
			System.out.println();
		} // else if e
		else if(roomlist[i].getRname().equals("����Ʈ��")) {
			int tprice = 50000;
			if(roomlist[i].get�߰��̿�().contains("���ĺ���")) {
				tprice += 30000;
			}
			if(roomlist[i].get�߰��̿�().contains("������")) {
				tprice += 20000;
			}
			if(roomlist[i].get�߰��̿�().contains("�ｺ��")) {
				tprice += 10000;
			}
			System.out.println("�����Ͻ� �� �ݾ��� "+tprice+"�� �Դϴ�.");
			System.out.println();
		} // else if e
		
		
	} // ���� e

	
} // ce
