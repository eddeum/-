package ���α׷��־��Ȱ��;

import java.util.Scanner;

public class ���α׷��־��Ȱ��_������ {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Student[] studentlist = new Student[100];
		
		while(true) {
			try {
				System.out.println("-----------------------------------------------------------");
				System.out.println("\t\t��\t��\tǥ\t\t");
				System.out.println("-----------------------------------------------------------");
				System.out.printf("��ȣ\t�̸�\t����\t����\t����\t����\t���\t���� \n");

				for(Student student : studentlist) {
					if(student != null) {
						System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\t%.1f \n",
								student.get��ȣ(), student.get�̸�(), student.get����(),
								student.get����(), student.get����(), student.get����(), student.get���());
					}
				} // for e
				
				System.out.println("-----------------------------------------------------------");
				System.out.println();
				System.out.println("�޴� : 1.�л����� ��� 2. �л����� ����"); int ch = scanner.nextInt();
			
				
				if(ch==1) {
					System.out.println("��ȣ : ");	int ��ȣ = scanner.nextInt();
					System.out.println("�̸� : ");	String �̸� = scanner.next();
					System.out.println("���� : ");	int ���� = scanner.nextInt();
					System.out.println("���� : ");	int ���� = scanner.nextInt();
					System.out.println("���� : ");	int ���� = scanner.nextInt();
					
					int ���� = ����+����+����;
					double ��� = ����/3;
					
					Student student  = new Student(��ȣ, �̸�, ����, ����, ����, ����, ���);
					
					for(int i = 0; i<5; i++) {
						if(studentlist[i] == null) {
							studentlist[i] = student;
							break;
						}
					}
										
//					int i = 0;
//					for(Student temp : studentlist) {
//						if(temp == null) {
//							studentlist[i] = student;
//							break;
//						} // if e
//						i++;
//					} // for e
				} // if e
	
				else if(ch==2) {
					System.out.println("�л��̸� : ");	 String �̸� = scanner.next();					
					
					int i = 0;
					for(Student temp : studentlist) {
						if(temp.get�̸�().equals(�̸�)) {
							studentlist[i] = null;
							break;
						} // if e
						i++;
					} // for e
					
			
				} // else if e
				else {
					System.err.println("�˸�)�˼� ���� ��ȣ�Դϴ�.");
				} // else e
				
				
				
			} // try e
			catch(Exception e) {}
			
		} // while e
		
	} // me

} // ce
