package ��������Ʈ2_����;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class ȣ�ڿ��� {
	
	public static ArrayList<Room> roomlist = new ArrayList<>();
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		
		roomlist.add(new Room("�����", "20,000��", true, "���缮", "0326"));
		
		while(true) {
			try {
				System.out.println("************** ȣ�� ���� ���α׷� **************");
				System.out.println("��¥�Է�(mmdd) :");	String ��¥ = scanner.next();
				
				boolean result = Controller.��¥üũ(��¥);
				if(result==true) {
					
					boolean[] ���డ�� = new boolean[5];
					for(Room temp : roomlist) {
					 // ��¥�� MM(��)dd(��)�� String ������ ��ü����
						if(temp.getDate().equals(��¥)) { // temp���� ��¥�� �Է¹��� ��¥�� �����ϰ�
							if(temp.getRname().equals("Ʈ����")) { // temp���� ���̸��� Ʈ����� �����ϸ�
								���డ��[0] = true;
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
					} // for e
					
					
		
					System.out.println("********* �� ���� ��Ȳǥ *********");
					System.out.println("��ȣ\t���̸�\t\t�ݾ�\t���࿩��");
					System.out.println("1"+".\t"+"Ʈ����\t\t"+"10,000��\t"+((���డ��[0])?"����Ұ�":"���డ��"));
					System.out.println("2"+".\t"+"�����\t\t"+"20,000��\t"+((���డ��[1])?"����Ұ�":"���డ��"));
					System.out.println("3"+".\t"+"�ٴٺ�Ʈ����\t"+"30,000��\t"+((���డ��[2])?"����Ұ�":"���డ��"));
					System.out.println("4"+".\t"+"�ٴٺ�����\t"+"40,000��\t"+((���డ��[3])?"����Ұ�":"���డ��"));
					System.out.println("5"+".\t"+"����Ʈ��\t\t"+"50,000��\t"+((���డ��[4])?"����Ұ�":"���డ��"));
					
					System.out.println("�� ��ȣ ���� : ");	int ch = scanner.nextInt();
					System.out.println("������ �̸� : ");	String name = scanner.next();
					
					boolean result2 = Controller.����(��¥, name, ch);
					
					
						
					if(ch==1) {
						
						System.out.println("1���� Ʈ������ ����Ǿ����ϴ�.");
						
					} // if e
					else if(ch==2) {
						
						System.out.println("2���� ������� ����Ǿ����ϴ�.");
					}
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
				
			}catch(Exception e) {
				System.out.println("�˸�))�����Դϴ�(�����ڿ��Թ���)");
			}
		} // while e
		
	} // me

} // ce
