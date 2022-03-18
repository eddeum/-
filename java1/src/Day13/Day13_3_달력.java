package Day13;

import java.util.Calendar;
import java.util.Scanner;

public class Day13_3_달력 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("연도 : ");	int year = scanner.nextInt();
		System.out.print("월 : ");	int month = scanner.nextInt();
		
		달력(year, month);
		
	} // me
	
	// 1. 달력메소드
	public static void 달력(int year, int month) {
		while(true) { // 무한루프[종료조건 : 4번]
			// 1. 캘린더 클래스 내 현재 날짜/시간 객체 호출
			Calendar calendar = Calendar.getInstance();

			// 2. 연도, 월, 일
			//		int year = calendar.get(Calendar.YEAR);
			//		int month = calendar.get(Calendar.MONTH)+1; // +1 하는이유 : 0=1월 / 11=12월
			int day = calendar.get(Calendar.DAY_OF_MONTH);

			// * 해당 월의 1일의 요일찾기
			// 1. 사용자 정의 캘린더 설정
			calendar.set(year, month-1, 1); // 예) 2022년 3월 1일
			//			System.out.println("사용자가 날짜만들기 : " + calendar.toString());
			// 2. 3월 1일의 요일
			int sweek = calendar.get(Calendar.DAY_OF_WEEK);
			//			System.out.println("요일구하기: " + sweek);
			// 3. 3월의 마지막 일
			int eday = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
			//			System.out.println("해당날짜의 마지막 일수 : " + eday);

			//  3. 출력
			System.out.println("******** " + year + "년" + month + "월 ********" );
			System.out.println("일\t월\t화\t수\t목\t금\t토");

			// * 현재 월 1일의 위치 앞에 공백 채우기
			for(int i = 1; i<sweek; i++) {
				// 3월 1일 = 화 -> 3
				System.out.print("\t");
			}
			// 1일부터 마지막날짜 출력
			for(int i = 1; i<=eday; i++) {
				// i = 일수 출력
				System.out.print(i + "\t");
				// 토요일마다 줄바꿈처리[토요일=7] 요일이 7배수마다
				if(sweek%7 == 0) {System.out.println();} 
				sweek++; // 하루씩 요일 증가
			} // for e

			// 버튼[1.◀(이전달) 2.▶(다음달) 3.다시검색]
			try { // 만약에 try {} 안에서 예외[에러]가 발생하면 catch로 이동(프로그램 다운x)
				Scanner scanner = new Scanner(System.in);

				System.out.print("\n\n*** [1.◀(이전달) 2.▶(다음달) 3.다시검색 4.종료] *** "); int ch = scanner.nextInt();

				if(ch==1) {
					month -= 1;
					// 만약에 월이 0이 되면 연도1감소, 월 12값 설정
					if(month==0) {month =12; year -= 1;}
				} // if e
				else if (ch==2) {
					month += 1;
					// 만약에 월이 13월이 되면 연도1증가, 월 다시 1로 설정
					if(month == 13) {month = 1; year += 1;}
				} // else if e
				else if(ch==3) {
					System.out.print("연도 : ");	year = scanner.nextInt();
					System.out.print("월 : ");	month = scanner.nextInt();
				} // else if e
				else if(ch==4) {
					System.out.println("알림))달력 프로그램 종료");
					break; // 메소드 종료
				} // else if e
				else {
					System.out.println("알림))알 수 없는 번호입니다.");
				} // else e
			} catch(Exception e) { // 만약에 try{}에서 예외[오류] 발생하면 해당코드가 실행
				System.out.println("경고))정상적인 입력을 해주세요(관리자에게문의)");
			} // catch e

		} // while e
	
	} // 달력 e
	
	
	
	
} // ce
