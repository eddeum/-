package ��������Ʈ2_����;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class ȣ�ڿ��� {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		ArrayList<Room> roomlist = new ArrayList<>();
		
		roomlist.add(new Room("Ʈ����", "10,000��", false, "���缮", new java.util.Date()));
		
		while(true) {
			System.out.println("************** ȣ�� ���� ���α׷� **************");
			System.out.println("��¥�Է�(mmdd) :");	String ��¥ = scanner.next();
			
			boolean result = Controller.��¥üũ(��¥);
			if(result=true) {
				
				boolean[] ���డ�� = new boolean[5];
				for(Room temp : roomlist) {
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMdd"); // ��¥�� MM(��)dd(��)�� String ������ ��ü����
					if(simpleDateFormat.format(temp.getDate()).equals(��¥)) { // temp���� ��¥�� �Է¹��� ��¥�� �����ϰ�
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
				


				for(int i = 0; i<���డ��.length; i++) {
					if(���డ��[i]==true) {
						String ���డ�ɿ��� = "����Ұ�";
					} // if e
					else {
						String ���డ�ɿ��� = "���డ��";
					} // else e
				} // for e
				
				
				
				System.out.println("********* �� ���� ��Ȳǥ *********");
				System.out.println("��ȣ\t���̸�\t\t�ݾ�\t���࿩��");
				System.out.println("1"+".\t"+"Ʈ����\t\t"+"10,000��\t"+���డ��[0]);
				System.out.println("2"+".\t"+"�����\t\t"+"20,000��\t"+���డ��[1]);
				System.out.println("3"+".\t"+"�ٴٺ�Ʈ����\t"+"30,000��\t"+���డ��[2]);
				System.out.println("4"+".\t"+"�ٴٺ�����\t"+"40,000��\t"+���డ��[3]);
				System.out.println("5"+".\t"+"����Ʈ��\t\t"+"50,000��\t"+���డ��[4]);
				
//				int ch = scanner.nextInt();
//				
//				Controller.����(��¥,ch);
//				
//				if(ch==1) {}
//				else if(ch==2) {}
//				else if (ch==3) {}
//				else if(ch==4) {}
//				else if(ch==5) {}
//				else {
//					System.out.println("�˸�))�� ��ȣ�� �߸��Է��Ͽ����ϴ�.");
//				} // else e
//				
//			} // if e
//			else {
//				System.out.println("�˸�))��¥�� �߸��Է��Ͽ����ϴ�.");
			}
			
			
		} // while e
		
	} // me

} // ce
