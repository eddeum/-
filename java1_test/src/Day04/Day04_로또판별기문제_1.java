package Day04;

import java.util.Random;
import java.util.Scanner;

public class Day04_로또판별기문제_1 { // cs
	
	public static void main(String[] args) { // ms
		
		int[] 사용자번호 = new int[6];
		int[] 추첨번호 = new int[6];
		
		Scanner scanner = new Scanner(System.in);
		
		for(int i = 0; i<6; i++) {
			System.out.print("1~45 사이 입력 : ");
			int 번호 = scanner.nextInt();
			
			boolean 통과 = true;
			
			if(번호<1 || 번호>45) {
				System.out.println("알림)알 수 없는 번호입니다.");
				i--;
				통과 = false;
			} // if e
			
			for(int j = 0 ; j<6; j++) {
				if(번호==사용자번호[j]) {
					System.out.println("알림)이미 선택한 번호입니다.");
					i--; // i로하는 이유는?????????????
					통과 = false;
				} // if e
			} // for e
			if(통과==true) 사용자번호[i]=번호;
		} // for e
		
		System.out.println("\n사용자가 선택한 번호 : ");
		for(int temp : 사용자번호) {
			System.out.print(temp+"\t");
		} // for e
		
		for(int i = 0; i<6; i++) {
			Random random = new Random();
			int 추첨 = random.nextInt(45)+1;
			
			boolean 통과 = true;
			
			for(int j = 0; j<6; j++) {
				if(추첨==추첨번호[j]) {
					System.out.println("알림)이미 중복된 번호입니다.");
					i--;
					통과 = false;
				} // if e
			} // for e
			if (통과==true) 추첨번호[i] = 추첨;
		} // for e
		
		System.out.println("\n추첨 번호 : ");
		for(int temp : 추첨번호) {
			System.out.print(temp + "\t");
		} // for e
		
		int 동일한수 = 0;
		for(int i = 0; i<사용자번호.length; i++) {
			for(int j = 0; j<추첨번호.length; j++) {
				if(사용자번호[i]==추첨번호[j]) {
					동일한수++;
				} // if e
			} // for e
		} // for e
		
		System.out.println("\n동일한 수 : " +동일한수);
		
		
		
	} // me

} // ce
