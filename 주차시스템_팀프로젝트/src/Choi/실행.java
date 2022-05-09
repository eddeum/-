package Choi;

import java.util.ArrayList;
import java.util.Scanner;


public class 실행 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("입차 번호 : "); String 차번=scanner.next();
		System.out.println("입차 날짜(ex 0320) : "); String 입차날짜=scanner.next();
		System.out.println("출차 날짜(ex 1515) : "); String 입차시간=scanner.next();
		
		
		boolean result= 메소드.입차( 차번,입차날짜,입차시간);
		if(result==true) {System.out.println("입차성공");}
		else if(result==false) {System.out.println("입차실패");}
		
				
		
		
	}//m e
}
