package 팀프로젝트;

import java.util.Scanner;

public class 주차관리시스템 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String[] parklo = {"[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]",
				"[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"};
		
		while(true) {
			
			for(int i = 0; i<parklo.length; i++) {
				System.out.print(parklo[i]);
				
				if(i%4==0) {
					System.out.println();
				} // if e
			} // for e
			
			while(true) {
				try {
					System.out.println("******** 주차관리 시스템 ********");
					System.out.println("1.입차 2.출차 3.매출확인");
					System.out.println("선택 : ");	int ch = scanner.nextInt();
					if(ch==1) {
						System.out.println("차량번호 입력 : ");	int cnum = scanner.nextInt();
						System.out.println("입차일 입력 : ");	String idate = scanner.next();
						System.out.println("입차시간 입력 : ");	String itime = scanner.next();
						
						boolean result = Controller.carcheck(cnum); // 차량번호체크
						boolean result2 = Controller.datecheck(idate); // 날짜체크
						boolean result3 = Controller.timecheck(itime); // 시간체크
						
						if(result==false) {
							System.err.println("알림)차량번호가 잘못입력되었습니다.");
						} // if e
						else {
							if(result2==false) {
								System.err.println("알림)날짜가 잘못입력되었습니다.");
							} // if e
							
						}// else e

						
						
					} // if e
					else if(ch==2) {}
					else if(ch==3) {}
					else {
						System.err.println("알림))잘못된 번호입니다.");
					} // else e
				}catch(Exception e) {
					System.err.println("알림))오류입니다.(관리자에게 문의)");
				} // catch e
				
				
			} // while e
			
			
			
			
			
		} // while e
		
		
	} // me

} // ce
