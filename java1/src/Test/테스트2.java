package Test;

import java.util.Scanner;

public class 테스트2 {

	public static void main(String[] args) {
		
		학생[] studentlist = new 학생[100];
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			try {
				
				System.out.println("-------------------------");
				System.out.println("------- 성  적  표 --------");
				System.out.println("-------------------------");
				System.out.printf("번호 이름 국어 영어 수학 총점 평균 석차 \n");
				System.out.println("-------------------------");
				
				for(학생 temp : studentlist) {
					if(temp != null) {
						System.out.println();
					}
				}
				
				
			} // try e
			catch(Exception e) {}
			
		} // while
		
	} // me
	
	
} // ce
