package Test2;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class 주차프로그램 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			try {
				System.out.println("--------------------------- 주차 현황 표 ---------------------------");
				System.out.println();
				System.out.print("\t\t\t"+DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm").format(LocalDateTime.now())+"\t\n");
				System.out.println();
				System.out.println("날짜\t\t차량번호\t\t입차시간\t\t출차시간\t\t금액");
				// 주차리스트 작성
					
					for(Parking temp : Controller.parkinglist) {
						if(temp != null) {
							if(temp.get출차시간() != null) {
								System.out.printf(temp.get날짜()+"\t\t"+temp.get차량번호()+"\t\t"+temp.get입차시간()+"\t\t"+temp.get출차시간()+"\t\t"+temp.get금액()+"\n");
							} // if e
							else {
								System.out.printf(temp.get날짜()+"\t"+temp.get차량번호()+"\t\t"+temp.get입차시간()+"\t\t"+"주차중"+"\t\t"+"정산전"+"\n");
							} // else e
						} // if e
					} // for e
						
				System.out.println();
				System.out.println("------------------------------------------------------------------");
				System.out.println("\t\t\t1. 입차    2. 출차");	int ch = scanner.nextInt();
				
				if(ch==1) {
					System.out.println("차량번호 입력 : ");	String 차량번호 = scanner.next();
					int result = Controller.입차(차량번호);
					if(result==1) {System.out.println("입차성공~!");}
					else if(result==2) {System.err.println("알림))중복된 차량번호입니다.");}
					else if (result==3) {System.err.println("알림))만차입니다.");}
				}
				else if(ch==2) {
					System.out.println("차량번호 입력 : ");	String 차량번호 = scanner.next();
					Controller.출차(차량번호);
				} // else if e
				else {
					System.err.println("알림))번호를 잘못입력하였습니다.");
				} // else e
				
				
			}catch(Exception e) {
				System.err.println("알림)오류발생(관리자에게문의)");
			} // catch e
		} // while e
		
		
		
		
		
		
		
		
		
	} // me

} // ce
