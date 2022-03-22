package 팀프로젝트;

import java.util.ArrayList;
import java.util.Scanner;

import Day06.Car;

public class 연습 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String[] parklist = new String[12];
		///////////////////car, 실행, 관리자
		
		while(true) {
			System.out.println("******* 주차관리 시스템 *******");
			System.out.println("1.입차 2.출차 3. 매출확인   선택 :  "); int ch = scanner.nextInt();
			
			if(ch==1) {
				System.out.println("차량번호 입력 : "); int cnum = scanner.nextInt();
				
				
				for(int i = 0; i<=parklist.length; i++) {
					if(parklist[i] != null) {
						System.out.println("알림)만차입니다.");
					} // if e
					else {

					} // else e
				}// for e
			} // if e
			else if(ch==2) {
				System.out.println("차량번호 입력 : "); 	int cnum = scanner.nextInt();

				// 요금계산

				
			} // else if e
			else if(ch==3) {
				
			}
			else {
				System.err.println("알림))알 수 없는 번호입니다.");
			} // else e
			
		
		
		} // while e

	} // me
} // ce
