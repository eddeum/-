package Test1;

import java.rmi.StubNotFoundException;
import java.util.Scanner;

public class Test_2 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Student[] studentlist = new Student[100];
		
		while(true) {
			try {
				System.out.println("------------------------------------------------------------");
				System.out.println("\t\t\t��\t��\tǥ\t\t\t");
				System.out.println("------------------------------------------------------------");
				System.out.printf("��ȣ\t�̸�\t����\t����\t����\t����\t���\t���� \n");
				System.out.println("------------------------------------------------------------");
				
				// ���� ���� �������� �迭�� �ε��� ���� (�𸣰���!!!!!!!!!!!!!!!!!!!!)
					for(int i = 0; i<studentlist.length; i++) {
						for(int j = 0; j<studentlist.length; j++) {
							if(studentlist[i] != null && studentlist[j] != null) {
								if(studentlist[i].get����()>studentlist[j].get����()) {
									Student[] temp = new Student[1];
									temp[0] = studentlist[i];
									studentlist[i] = studentlist[j];
									studentlist[j] = temp[0];

								} // if e	
							} // if e
								
						} // for e
					} // for e
				
				int e = 0;
				for(Student temp : studentlist) {
					if(temp != null) {
						System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d \n",
								temp.get��ȣ(), temp.get�̸�(), temp.get����(), temp.get����(),
								temp.get����(), temp.get����(), temp.get���(), e+1);
					} // if e
					e++;
				} // for e
				
				
				
				System.out.println("------------------------------------------------------------");
				System.out.println();
				System.out.println("�޴� : 1. �л����� ��� 2. �л����� ����");	int ch = scanner.nextInt();
				
				if(ch==1) {
					System.out.println("��ȣ �Է� : ");	int ��ȣ = scanner.nextInt();
					System.out.println("�̸� �Է� : ");	String �̸� = scanner.next();
					System.out.println("���� �Է� : ");	int ���� = scanner.nextInt();
					System.out.println("���� �Է� : ");	int ���� = scanner.nextInt();
					System.out.println("���� �Է� : ");	int ���� = scanner.nextInt();
					
					boolean nocheck = false;
					for(Student temp : studentlist) {
						if(temp != null && temp.get��ȣ() == ��ȣ) {
							System.err.println("�˸�))�ߺ��� ��ȣ�Դϴ�.");
							nocheck = true;
							break;
						} // if e
					} // for e
					if(nocheck == false) {
						int ���� = ����+����+����;
						double ��� = ����/3.0; //////////////////3.0??????????
							
						Student student = new Student(��ȣ, �̸�, ����, ����, ����, ����, ���);
							
						int i = 0;
						for(Student temp : studentlist) {
							if(temp == null) {
								studentlist[i] = student;
								break;
							} // if e
							i++;
						} // for e
					} // if e
						
					
				} // if e
				else if(ch==2) {
					System.out.println("������ �л� ��ȣ �Է� : ");	int ��ȣ = scanner.nextInt();
					
					int i = 0;
					for(Student temp : studentlist) {
						if(temp != null && temp.get��ȣ() == ��ȣ) {
							for(int j = i; j<studentlist.length; j++) {
								if(j==studentlist.length-1) {
									studentlist[studentlist.length-1] = null;
								} // if e
								else {
									studentlist[j]= studentlist[j+1];
								} // else e
							} // for e
						} // if e
						i++;
					} // for e
					
				} // else if e
				else {
					System.err.println("�˸�))�� �� ���� ��ȣ�Դϴ�.");
				} // else e
				
				
				
			} // try e
			catch (Exception e) {
				System.out.println("����!!!!!!!!");
			} // catch e
			
		} // while e
		
		
	} // main e
	
	
} // ce
