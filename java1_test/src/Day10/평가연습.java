package Day10;

import java.util.Scanner;

public class �򰡿��� {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Student[] studentlist = new Student[100];
		
		
		
		while(true) {
			
			System.out.println("-----------------------------------");
			System.out.println("         ��      ��      ǥ          ");
			System.out.println("-----------------------------------");
			System.out.printf("��ȣ �̸� ���� ���� ���� ���� ��� ���� \n");


			for(Student temp : studentlist) {
				if(temp != null) {
					System.out.printf("%d %s %d %d %d %d %.2f %d \n",
							temp.get��ȣ(), temp.get�̸�(), temp.get����(), temp.get����(), temp.get����(),
							temp.get����(), temp.get���(), temp.get����());
				} // if e

			} // for e
			
			
			System.out.println("-----------------------------------");
			System.out.println("�޴� : 1.�л����� ��� 2.�л����� ����");
			int ch = scanner.nextInt();
			
		if(ch==1) {
				
			System.out.println("��ȣ : ");	int ��ȣ = scanner.nextInt();	
			System.out.println("�̸� : ");	String �̸� = scanner.next();
			System.out.println("���� : ");	int ���� = scanner.nextInt();
			System.out.println("���� : ");	int ���� = scanner.nextInt();
			System.out.println("���� : ");	int ���� = scanner.nextInt();
			
			int ���� = ���� + ���� + ����;
			double ��� = ����/3;
			int ���� = 1;
			
			Student student = new Student();
			
			int i = 0;
			for(Student temp : studentlist) {
				if(temp == null) {
					studentlist[i] = student;
				} // if e
				i++;
			} // for e
//			
//			
//			for(int i = 0; i<=studentlist.length; i++) {
//				int ���� = 1;
//				for(int j = 0; j<studentlist.length; j++) {
//					if(studentlist[j] != null && studentlist[i].get����()<studentlist[j].get����()) {
//						studentlist[j].set����(����);
//					} // if e
//				} // for e
//			} // for e
				
		
			
//			for(int i = 1; i<studentlist.length; i++) {
//				if(studentlist[i] == null) {
//					studentlist[i] = student;
//					break;
//				} // if e
//				i++;
//			} // for e
			
			
				
				
			} // if e
			else if (ch==2) {
				
			} // else if e
			else {
				System.err.println("�˸�)�� �� ���� ��ȣ�Դϴ�.");
			} // else e
			
			
		} // while e
		
	} // me
} // ce
