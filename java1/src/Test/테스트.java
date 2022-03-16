package Test;

import java.util.Scanner;

public class 테스트 {
	
	public static void main(String[] args) {
		
		// 배열
		학생[] 학생배열 = new 학생[100];
		Scanner scanner = new Scanner(System.in);
		
		
		while(true) {
			try {
				System.out.println("학생 목록");
				// 점수 출력
				System.out.println("1.등록 2.삭제  선택 : ");
				int 선택 = scanner.nextInt();
				if(선택==1) {
					System.out.println("번호 :");	 int 번호 = scanner.nextInt();
					System.out.println("이름 :");	 String 이름 = scanner.next();
					System.out.println("국어 :");	 int 국어 = scanner.nextInt();
					System.out.println("영어 :");	 int 영어 = scanner.nextInt();
					System.out.println("과학 :");	 int 과학 = scanner.nextInt();
					
					int 총점 = 국어+영어+과학;
					double 평균 = 총점/3;
					
					학생 학생 = new 학생();
					

					
					for(int i = 0; i<학생배열.length; i++) {
						if(학생배열[i] == null) {
							학생배열[i] = 학생;
						} // if e
					}
					
					
				} // if e
				else if(선택==2) {}
				else {}
			}
			catch(Exception e) {}
			
		} // while e
		
	} // me

} // ce
