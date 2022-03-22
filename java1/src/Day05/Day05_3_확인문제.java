package Day05;

import java.util.Scanner;

public class Day05_3_확인문제 {
	
	public static void main(String[] args) {
		
		// p.182 7번예제
		int max = 0;	// 최대값 저장하는 변수
		int[] array = {1, 5, 3, 8, 2};	// 선언 + 초기화
		
		for(int i = 0; i<array.length; i++) {
			//* i는 0부터 배열의 길이(5)까지 1씩증가하면서 실행 반복처리
			if(max<array[i])	max = array[i];
			//* 만약 max보다 i번째 인덱스의 값이 더 크면 max에 i번째 값 대입
		} // for e			
		System.out.println("max : " + max);
		
		
		// p.182 8번예제
		int[][] array2 = {
				{95, 86},
				{83, 92, 96},
				{78, 83, 93, 87, 88}
		}; // int e
		
		int sum = 0;
		double avg = 0.0;
		
		int count = 0;	// 점수의 개수[칸 개수]
		// 2차원 배열내 모든 데이터 호출
		for(int i = 0; i<array2.length; i++) { //* 행은 0부터 배열의 행길이(3)미만까지 1씩증가
			for(int j = 0; j<array2[i].length; j++) { //* 열은 0부터 배열의 열길이(2, 3, 5 -> 행마다 다름)미만까지 1씩증가
				sum += array2[i][j]; // 누적합계
			} // for e
			count += array2[i].length;	// 열길이의 누적합계
		} // for e
		
		avg = (double)sum / count;
		
		System.out.println("sum : " + sum);
		System.out.println("avg : " + avg);
		
		// p.183 9번예제
		boolean run = true;	// while문 스위치 변수
		int studentNum = 0;	// 학생수 변수
		int[] scores = null;// 점수 배열
		Scanner scanner = new Scanner(System.in);	// 입력객체
		
		// while(true)
		while(run) { // 무한루프[종료조건 : 5번 입력시 종료]
			System.out.println("--------------------------------------");
			System.out.println("1.학생수 2. 점수입력 3.점수리스트 4.분석 5. 종료");
			System.out.println("--------------------------------------");
			System.out.println("선택 : ");
			
			int selectNo = scanner.nextInt();
			
			if(selectNo==1) {	// 학생수 입력받기
				System.out.print("학생수>");	studentNum = scanner.nextInt();
				// 입력받은 학생 수 만큼 배열길이 변경
				scores = new int[studentNum]; // 호출(선언은 int로 시작)
			} // if e
			else if(selectNo==2) {	// 학생 점수 입력받기
				for (int i = 0; i<scores.length; i++) { // 배열내 모든 인덱스만큼 반복처리
					System.out.printf("scores[%d] : \n", i);	scores[i] = scanner.nextInt(); // 입력받아 i번째 인덱스에 저장
				} // for e
			} // else if e
			else if(selectNo==3) {	// 학생 점수 출력하기
				for(int i = 0; i<scores.length; i++) { // 배열내 모든 인덱스만큼 반복처리
					System.out.printf("scores[%d] : %d \n" , i, scores[i]);
				} // for e
			} // else if e
			else if(selectNo==4) {
				int max2 = 0;
				int 총합계 = 0;
				double avg2 = 0.0;
				
				for(int i = 0; i<scores.length; i++) {
					
					// 최고점수 구하기
					if(max2 < scores[i])	max2 = scores[i];	// i번째 인덱스에 데이터 대입
					// 누적합계
					총합계 += scores[i];
				} // for e
				
				// 평균점수 구하기
				avg2 = (double)총합계 / scores.length;
				
				System.out.println("최고 점수 : " + max2);
				System.out.println("평균 점수 : " + avg2);
			} // else if e
			else if(selectNo==5) {
				System.out.println("프로그램 종료");
				run = false; // 반복문 탈출 (혹은 break;로 사용해도 동일한 역할을함)
			} // else if e
		} // while e
		
		
		
	} // me

} // ce
