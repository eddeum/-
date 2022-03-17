package 프로그래밍언어활용;

import java.util.Scanner;

public class 프로그래밍언어활용_최으뜸 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Student[] studentlist = new Student[100];
		
		while(true) {
			try {
				System.out.println("-----------------------------------------------------------");
				System.out.println("\t\t성\t적\t표\t\t");
				System.out.println("-----------------------------------------------------------");
				System.out.printf("번호\t이름\t국어\t영어\t수학\t총점\t평균\t석차 \n");

				for(Student student : studentlist) {
					if(student != null) {
						System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\t%.1f \n",
								student.get번호(), student.get이름(), student.get국어(),
								student.get영어(), student.get수학(), student.get총점(), student.get평균());
					}
				} // for e
				
				System.out.println("-----------------------------------------------------------");
				System.out.println();
				System.out.println("메뉴 : 1.학생점수 등록 2. 학생점수 삭제"); int ch = scanner.nextInt();
			
				
				if(ch==1) {
					System.out.println("번호 : ");	int 번호 = scanner.nextInt();
					System.out.println("이름 : ");	String 이름 = scanner.next();
					System.out.println("국어 : ");	int 국어 = scanner.nextInt();
					System.out.println("영어 : ");	int 영어 = scanner.nextInt();
					System.out.println("수학 : ");	int 수학 = scanner.nextInt();
					
					int 총점 = 국어+영어+수학;
					double 평균 = 총점/3;
					
					Student student  = new Student(번호, 이름, 국어, 영어, 수학, 총점, 평균);
					
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
					System.out.println("학생이름 : ");	 String 이름 = scanner.next();					
					
					int i = 0;
					for(Student temp : studentlist) {
						if(temp.get이름().equals(이름)) {
							studentlist[i] = null;
							break;
						} // if e
						i++;
					} // for e
					
			
				} // else if e
				else {
					System.err.println("알림)알수 없는 번호입니다.");
				} // else e
				
				
				
			} // try e
			catch(Exception e) {}
			
		} // while e
		
	} // me

} // ce
