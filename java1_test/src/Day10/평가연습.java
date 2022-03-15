package Day10;

import java.util.Scanner;

public class 평가연습 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String[][] 성적리스트 = new String[100][8];
		
		while(true) {
			
			System.out.println("-----------------------------------");
			System.out.println("         성      적      표          ");
			System.out.println("-----------------------------------");
			System.out.println("번호  이름  국어  영어  수학  총점  평균  석차");
			System.out.printf();
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
			
			for(int i =1; i<=5; i++) {
				if(성적리스트[i][0] == null) {
				성적리스트[i][0] = 번호; 성적리스트[i][1] = 이름; 성적리스트[i][2] = 국어; 성적리스트[i][3] = 영어;
				성적리스트[i][4] = 수학; 성적리스트[i][5] = 총점; 성적리스트[i][6] = 평균; 성적리스트[i][7] = 석차;
				} // if e
			} // for e
			
			
				
				
			} // if e
			else if (ch==2) {
				
			} // else if e
			else {
				System.err.println("알림)알 수 없는 번호입니다.");
			} // else e
			
			
		} // while e
		
	} // me
} // ce
