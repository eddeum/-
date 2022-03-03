package Day03;

import java.util.Scanner;

public class Day03_6 { // cs
	public static void main(String[] args) { // ms
		
		Scanner scanner = new Scanner(System.in);	// 입력객체
		
//		// 별문제1 : 입력받은 수 만큼 * 출력
//		System.out.print("문제1) 별개수 : ");	int s1 = scanner.nextInt();
//		for(int i = 1; i<=s1; i++) {
//			// * i는 1부터 입력받은 수까지 1씩증가 하면서 실행문 반복처리
//			System.out.print("*");
//		}
//		
		// 별문제2 : 입력받은 수 만큼 * 출력[단, 5개마다 줄바꿈 처리]
//		System.out.print("문제2) 별개수 : ");	int s2 = scanner.nextInt();
//		for(int i = 1; i<=s2; i++) {
//			// * i는 1부터 입력받은 수까지 i는 1씩 증가하면서 실행문 반복처리
//			System.out.print("*");
//			// 5개마다 줄바꿈 -> 5배수마다 -> 배수찾기
//			if(i%5==0)	System.out.println(); 	// 줄바꿈 처리
//		}
//		
		// 별문제3 : 입력받은 줄 만큼 출력
		//				i = 줄		s = 별
		//	*			i = 1		s = 1
		//	**			i = 2		s = 1 2
		//	***			i = 3		s = 1 2 3
		//	****		i = 4		s = 1 2 3 4
		//	*****		i = 5		s = 1 2 3 4 5
		//				i는 1부터 입력받은 수까지 1씩증가 줄바꿈처리
		//				s는 1부터 현재 줄수까지 1씩증가 별 출력
		
//		System.out.print("문제3) 줄수 : ");	int line3 = scanner.nextInt();
//		for(int i = 1; i<=line3; i++) {
//			// * i는 1부터 입력받은 줄 수까지 1씩 증가
//			
//			// 1. 별찍기
//			for(int s = 1; s<=i; s++) {
//				System.out.print("*");
//			}
//			// 2. 줄바꿈처리
//			System.out.println();	
//		}
			// 순서도
				// 사용자가 3을 입력했을 때
				// i = 1	i<=3 [true] -> i++
					// s = 1	s<=1 [true] -> * -> s++
					// s = 2	s<=1 [false] -> 반복문종료
				// 줄바꿈
				// i = 2	i<=3 [true]
					// s = 1 	s<=1 [true] -> * -> s++
					// s = 2 	s<=2 [true] -> * -> s++
					// s = 3	s<=3 [false] -> 반복문종료
				// 줄바꿈
				// i = 3	i<=3 [true
					// s = 1 	s<=1 [true] -> * -> s++
					// s = 2 	s<=2 [true] -> * -> s++
					// s = 3	s<=3 [true] -> * -> s++
					// s = 4	s<=3 [false] -> 반복문종료
				// 줄바꿈
				// i = 4	i<=3 [false] for1 반복문종료
		// 별문제4 : 입력받은 줄 만큼 출력
		//			i = 줄	s = *
		//	*****	i = 1	s = 5
		//	****	i = 2	s = 4	
		//	***		i = 3	s = 3		
		//	**		i = 4	s = 2
		//	*		i = 5	s = 1
		//			i는 1부터 입력받은 수까지 1씩증가 줄바꿈 처리
		//			s는 1부터 (입력받은 수-현재줄수+1)까지 1씩증가 별 출력
		
//		System.out.print("문제4) 줄수 : ");	int line4 = scanner.nextInt();
//		for(int i = 1; i<=line4; i++) {
//			
//			// 1. 별찍기
//			for(int s = 1; s<=line4-i+1; s++) {
//				System.out.print("*");
//			}
//			System.out.println("");
//		}
		
		// 별문제5 : 입력받은 줄 만큼 출력	
		//			i = 줄	b = 공백	s = 별
		//		*	i = 1	b = 4	s = 1
		//     **	i = 2	b = 3	s = 2
		//    ***	i = 3	b = 2	s = 3
		//   ****	i = 4	b = 1	s = 4
		//	*****	i = 5	b = 0	s = 5
		//			b는 입력받을 줄수-현재줄수
		
		System.out.print("문제5) 줄수 : ");	int line5 = scanner.nextInt();
		for(int i = 1; i<=line5; i++) {
			
			// 1. 공백처리(공백처리 먼저해야함 -> 왼쪽부터 공백이 먼저있음)
			for(int b = 1; b<=line5-i; b++) {
				System.out.print(" ");	// 공백 => 스페이스바
			}
			// 2. 별찍기
			for(int s = 1; s<=i; s++) {
				System.out.print("*");
			}
			// 3. 줄바꿈
			System.out.println();
		}
		
	} // me

} //ce
