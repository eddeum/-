package Day10;

import java.util.Scanner;

public class 평가연습 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Student[] studentlist = new Student[100];
		
		
		
		while(true) {
			
			System.out.println("-----------------------------------");
			System.out.println("         성      적      표          ");
			System.out.println("-----------------------------------");
			System.out.printf("번호 이름 국어 영어 수학 총점 평균 석차 \n");


			for(Student temp : studentlist) {
				if(temp != null) {
					System.out.printf("%d %s %d %d %d %d %.2f %d \n",
							temp.get번호(), temp.get이름(), temp.get국어(), temp.get영어(), temp.get수학(),
							temp.get총점(), temp.get평균(), temp.get석차());
				} // if e

			} // for e
			
			
			System.out.println("-----------------------------------");
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
//				int 석차 = 1;
//				for(int j = 0; j<studentlist.length; j++) {
//					if(studentlist[j] != null && studentlist[i].get총점()<studentlist[j].get총점()) {
//						studentlist[j].set석차(석차);
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
				System.err.println("알림)알 수 없는 번호입니다.");
			} // else e
			
			
		} // while e
		
	} // me
} // ce
