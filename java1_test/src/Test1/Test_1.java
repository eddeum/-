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
				System.out.println("         성      적      표          ");
				System.out.println("-----------------------------------");
				System.out.printf("번호\t이름\t국어\t영어\t수학\t총점\t평균\t석차\n");
				System.out.println("-----------------------------------");
				
				for(Student temp : studentlist) {
					if(temp != null) {
						System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d\n",
								temp.get번호(), temp.get이름(), temp.get국어(), temp.get영어(), temp.get수학(),
								temp.get총점(), temp.get평균(), temp.get석차());
		
					} // if e

				} // for e
				
				System.out.println("-----------------------------------");
				System.out.println();
				System.out.println("메뉴 : 1.학생점수 등록 2.학생점수 삭제");
				int ch = scanner.nextInt();
				
				if(ch==1) {
					
					System.out.println("번호 : ");	int 번호 = scanner.nextInt();	
					System.out.println("이름 : ");	String 이름 = scanner.next();
					System.out.println("국어 : ");	int 국어 = scanner.nextInt();
					System.out.println("영어 : ");	int 영어 = scanner.nextInt();
					System.out.println("수학 : ");	int 수학 = scanner.nextInt();
				
					int 총점 = 국어 + 영어 + 수학;
					double 평균 = 총점/3;
					int 석차 = 1;
				
					Test1.Student student = new Test1.Student(번호, 이름, 국어, 영어, 수학, 총점, 평균, 석차);
				
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
					System.err.println("알림)알 수 없는 번호입니다.");
				} // else e
//				
				
				
			} // try e
			catch (Exception e) {}
			
		} // while e
		
	} // me

} // ce
