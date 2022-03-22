package Test1;

import java.util.Scanner;

import Test.학생_1차;

public class 테스트2_1차 {

	public static void main(String[] args) {
		
		학생_1차[] studentlist = new 학생_1차[100];
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			try {
				
				System.out.println("-------------------------");
				System.out.println("------- 성  적  표 --------");
				System.out.println("-------------------------");
				System.out.printf("번호 이름 국어 영어 수학 총점 평균 석차 \n");
				System.out.println("-------------------------");
				
				for(학생_1차 temp : studentlist) {
					if(temp != null) {
						System.out.println();
					}
				}
				
				
			} // try e
			catch(Exception e) {}
			
		} // while
		
	} // me
	
	
} // ce
