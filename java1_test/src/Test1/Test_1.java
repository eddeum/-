package Test1;

import java.util.Scanner;

import Day10.Student;

public class Test_1 {
	
	public static void main(String[] args) {
		
		Student[] studentlist = new Student[100];
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			try {
				System.out.println("-----------------------------------");
				System.out.println("         ��      ��      ǥ          ");
				System.out.println("-----------------------------------");
				System.out.printf("��ȣ\t�̸�\t����\t����\t����\t����\t���\t����\n");
				System.out.println("-----------------------------------");
				
				for(Student temp : studentlist) {
					if(temp != null) {
						System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d\n",
								temp.get��ȣ(), temp.get�̸�(), temp.get����(), temp.get����(), temp.get����(),
								temp.get����(), temp.get���(), temp.get����());
		
					} // if e

				} // for e
				
				System.out.println("-----------------------------------");
				System.out.println();
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
				
					Test1.Student student = new Test1.Student(��ȣ, �̸�, ����, ����, ����, ����, ���, ����);
				
					int i = 0;
					for(Student temp : studentlist) {
						if(temp == null) {
							studentlist[i] = student;
							break;
						} // if e
						i++;
					} // for e
					
				} // if e
				
				else if (ch==2) {
					
				} // else if e
				else {
					System.err.println("�˸�)�� �� ���� ��ȣ�Դϴ�.");
				} // else e
//				
				
				
			} // try e
			catch (Exception e) {}
			
		} // while e
		
	} // me

} // ce
