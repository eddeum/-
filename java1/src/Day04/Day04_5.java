package Day04;

import java.util.Random;
import java.util.Scanner;

public class Day04_5 { // cs
	
	// 로또 판별기
	/* 사용자 6개 수 입력받기 -> 배열 저장
	 * 	1. 1~45 사이의 수만 입력받기 아니면 재입력
	 * 	2. 중복x 재입력
	 * 추첨번호 : 컴퓨터 난수 6개 발생 -> 배열 저장
	 * 	1. 1~45 사이
	 * 	2. 중복x
	 * 사용자번호와 컴퓨ㅓ 추첨번호와 동일 수의 개수
	 */
	
	public static void main(String[] args) { // ms
		
		// 준비
		int[] 사용자번호 = new int[6]; // 사용자가 선택한 번호
		int[] 추첨번호 = new int[6]; // 컴퓨터가 난수 번호
		Scanner scanner = new Scanner(System.in);
		
		// 1. 사용자에게 입력받기
		for(int i = 0; i<사용자번호.length; i++) {
			// i는 0부터 5까지 1씩 증가반복 => 6회반복
			System.out.println("1~45 사이 입력 :");
			int 번호 = scanner.nextInt();
			
			boolean 통과 = true; /// 저장되는 조건 변수
			
			// 조건1(1~45 사이의 수만 입력받기)
			if (번호 < 1 || 번호 > 45) {
				System.out.println("알림)) 선택할 수 없는 번호입니다.[재입력]");
				// 1보다 작거나 45보다 크면 선택할 수 없는 번호입력시 재입력
				i--; // 현재 i는 정상입력을 못했기 때문에...
				통과 = false; // 저장 x
			} // if e
			
			// 조건2 : 중복체크(중복 -> 재입력x)
				// 1. 배열내 모든 인덱스 호출
				// 2. 입력받은 값과 같은지 비교
			for(int j = 0; j<6; j++) {
				if(번호 == 사용자번호[j]) {
					// 2. 입력받은 값과 j번째 인덱스값과 같은지 비교
					System.out.println("알림)) 이미 선택한 번호입니다.[재입력]");
					i--;
					통과 = false; // 저장x
				} // if e
				
			} // for e
			
			// 정상입력이면 배열 저장하기
			사용자번호[i] = 번호;
			
		} // for e
		
		System.out.println("\n \t사용자가 선택한 번호\t : ");
		// * 사용자 배열내 모든 인덱스 출력
		for(int temp : 사용자번호) {
			System.out.print(temp + "\t");
		} // for e
		
		// 2. 컴퓨터가 난수생성
		for(int i = 0; i<6; i++) {
			
			Random random = new Random(); // 1. 난수객체
			int 추첨 = random.nextInt(44)+1;	// 2. 난수를 int형으로 가져오기
								// random.nextInt() : +- 20억 사이 중 난수 발생
								// random.nextInt(수) : 0 ~ 수 전까지 사이 중 난수 발생
								// randim.nextInt(수)+ 시작번호 : 시작번호 ~ 수 사이 중 난수 발생
			
			// 조건1 : 중복체크
			boolean 통과 = true;
			for(int temp : 추첨번호) {
				if(추첨 == temp) {
					i--;	// 중복이 있을경우 현재 i 예외
					통과 = false; // 저장x
				} // if e
			} // for e
			if(통과) 추첨번호[i] = 추첨;
	
		} // for e
		System.out.println("\n \t추첨번호\t : ");
		// * 배열내 모든 인덱스 출력
		for(int temp : 추첨번호) {
			System.out.print(temp + "\t");
		} // for e
		
		// 3. 비교 = 두 배열간 동일한 수 찾기(기준점하나를 잡고 비교)
		int 동일한수 = 0;
//		// 방법1
//		for(int i = 0; i<사용자번호.length; i++) {
//			// i가 비교 기준점
//			for(int j = 0; j<추첨번호.length; j++) {
//				if(사용자번호[i] == 추첨번호[j]) {
//					// 사용자 배열 내 i번째 인덱스와 
//					// 컴퓨터 배열내 j번째 인덱스의 수가 동일하면
//					동일한수++;
//				} // if e
//			} // for e
//		} // for e
		
		// 방법2
		for(int 비교기준 : 사용자번호) {
			// 사용자 배열내 하나씩 비교기준 대입
			for(int 비교대상 : 추첨번호) {
				// 추첨번호 배열내 하나씩 비교대상 대입
				if(비교기준 == 비교대상) 동일한수++;
			} // for e
		} // for e
		
		System.out.println("\n동일한 수 : " + 동일한수);
			
		
		
	} // me

} // ce
