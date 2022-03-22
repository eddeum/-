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
				System.out.println("\t\t\t성\t적\t표\t\t\t");
				System.out.println("------------------------------------------------------------");
				System.out.printf("번호\t이름\t국어\t영어\t수학\t총점\t평균\t석차 \n");
				System.out.println("------------------------------------------------------------");
				
				// 개인 석차 기준으로 배열내 인덱스 정렬 (모르겠음!!!!!!!!!!!!!!!!!!!!)
					for(int i = 0; i<studentlist.length; i++) {
						for(int j = 0; j<studentlist.length; j++) {
							if(studentlist[i] != null && studentlist[j] != null) {
								if(studentlist[i].get총점()>studentlist[j].get총점()) {
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
								temp.get번호(), temp.get이름(), temp.get국어(), temp.get영어(),
								temp.get수학(), temp.get총점(), temp.get평균(), e+1);
					} // if e
					e++;
				} // for e
				
				
				
				System.out.println("------------------------------------------------------------");
				System.out.println();
				System.out.println("메뉴 : 1. 학생점수 등록 2. 학생점수 삭제");	int ch = scanner.nextInt();
				
				if(ch==1) {
					System.out.println("번호 입력 : ");	int 번호 = scanner.nextInt();
					System.out.println("이름 입력 : ");	String 이름 = scanner.next();
					System.out.println("국어 입력 : ");	int 국어 = scanner.nextInt();
					System.out.println("영어 입력 : ");	int 영어 = scanner.nextInt();
					System.out.println("수학 입력 : ");	int 수학 = scanner.nextInt();
					
					boolean nocheck = false;
					for(Student temp : studentlist) {
						if(temp != null && temp.get번호() == 번호) {
							System.err.println("알림))중복된 번호입니다.");
							nocheck = true;
							break;
						} // if e
					} // for e
					if(nocheck == false) {
						int 총점 = 국어+영어+수학;
						double 평균 = 총점/3.0; //////////////////3.0??????????
							
						Student student = new Student(번호, 이름, 국어, 영어, 수학, 총점, 평균);
							
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
					System.out.println("삭제할 학생 번호 입력 : ");	int 번호 = scanner.nextInt();
					
					int i = 0;
					for(Student temp : studentlist) {
						if(temp != null && temp.get번호() == 번호) {
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
					System.err.println("알림))알 수 없는 번호입니다.");
				} // else e
				
				
				
			} // try e
			catch (Exception e) {
				System.out.println("오류!!!!!!!!");
			} // catch e
			
		} // while e
		
		
	} // main e
	
	
} // ce
