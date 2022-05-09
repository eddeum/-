package youn;

import java.util.ArrayList;
import java.util.Scanner;

import Chae.Car;

public class view {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		for (int i = 0 ; i <= 11 ; i++) { 
			// 12길이 리스트 생성 차량번호를 "" 넣어 ""일경우 빈자리로 출력
			//0~11까지 1개씩 늘어나며 총 12개 생성
			youn.Car car = new youn.Car(i, "", "");
			//새로운 자동차 생성(컨트롤러 참고)

		Controller.carlist.add(car);
		}
		while (true) {
			System.out.println("주차 관리 프로그램");
			int i = 1;
			for(youn.Car temp : Controller.carlist) {
				//temp
				if(temp.getCarnum() != "  ") {
					//빈공간과 carnum이 같지 않을 때
					
					System.out.print("["+temp.getCarnum()+"]"+"\t");
				} // []사이에 carnum 추가
				
				else if (temp.getCarnum().equals("  ")) {
					// 그 외에는 " "로 빈 공간력
					System.out.print("[    ]"+"\t");
					
				}
				//% :나머지 <- 이 함수를 이용해서 4개씩 자르기
				if(i%4 == 0) { System.out.println(); }
				
				i++; //하나+해서 다시 위로
			}
				
			
			System.out.println("1. 입차 2. 출차 3. 매출확인");
			int ch = scanner.nextInt();
			
			if(ch == 1) { //입차
				System.out.println("차량 번호를 입력하세요");
				String carnum = scanner.next();
				Controller.carin(carnum, null );
				
			} else if (ch == 2) { //출차
				System.out.println("차량 번호를 입력하세요.");
				String out = scanner.next();
				Controller.carout(out);
				
			}
		} // while end
		
		
		
		
/////////////////////////////////////////////////
	}

}
