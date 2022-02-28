package Day01;

import java.util.Scanner;

public class Day01_6 { // c s
	public static void main(String[] args) { // m s
		
		Scanner scanner = new Scanner(System.in);
		System.out.print(" 작성자 : ");	String 작성자 = scanner.next();
		System.out.print(" 내용 : ");		String 내용 = scanner.next();
		System.out.print(" 날짜 : ");		String 날짜 = scanner.next();
		// 4. 출력
		System.out.println("--------------방문록--------------");
		System.out.println("|순번||작성자|내용|날짜|");
		System.out.println("|" + 1 + "  |"  + "|" + 작성자 + "|" + "|"+ 내용 +"|" + "|"+ 날짜 + "|");
		
		
	} // m e

} // c e
