package Day03;

import java.util.Scanner;

public class Day03_3 { //cs
	
	public static void main(String[] args) { //ms
		
		Scanner scanner = new Scanner(System.in);
		
		// 문제6(경우의 수가 2개)
		// 점수를 입력받아 점수가 90점 이상이면 합격 아니면 불합
//		System.out.print("점수 입력 : ");	int 점수 = scanner.nextInt();
//		if (점수>=90)System.out.println("합격");
//		else		System.out.println("불합격");
		
		// 문제7(경우의 수가 여러개)
		// 점수를 입력받아 점수가 90점 이상이면 A등급
		//			   점수가 80점 이상이면 B등급
		//			   점수가 70점 이사이면 C등급
		//			   그외 재시험
//		System.out.print("점수 입력 : ");	int 점수2 = scanner.nextInt();
//		if (점수2>=90) 		System.out.println("A등급");
//		else if (점수2>=80)	System.out.println("B등급");
//		else if (점수2>=70)	System.out.println("C등급");
//		else				System.out.println("재시험");
		
		// 문제8 : 로그인 페이지
		// [입력] : 아이디와 비밀번호를 입력받기
		// [조건] : 회원아이디가 admin 이고
		//			  비밀번호가 1234 경우에는
		//			로그인 성공 아니면 로그인 실패 출력
//		System.out.print("아이디 : ");	String 아이디 = scanner.next();
//			// char 자료형[문자 1개 저장]
//			// 자료형으로 문자열을 저장할 수 없다.
//				// 1. String 클래스 사용하면 문자열 저장가능
//				// 2. Char 배열/리스트 사용하면 가능
//		System.out.print("비밀번호 : ");	int 비밀번호 = scanner.nextInt();
//			// 객체는 연산불가
//				// '자바' >= <= == > < !=[불가능]
//				// 자료형 사용하는 변수는 연산사 사용 가능
//				// 클래스 사용하는 객체는 연산자 사용 불가 -> 메소드[미리 만들어진]
//					// 문자열 비교시 .equals
//					// 문자열1.equals(문자열2)
//		boolean	로그인성공 = false;
//			// boolean : 1비트(true 혹은 false 저장)
//		if (아이디.equals("admin")) {	// 아이디는 객체이기 때문에 == 불가능  // 객체비교시에는 .equals() 사용
//				// 입력한 아이디가 admin이면
//			
//			if(비밀번호 == 1234) {	// 비밀번호는 자료형 변수이기 때문에 == 가능
//					// 입력한 비밀번호가 1234dlf 이면
//				
//				System.out.println("로그인 성공");
//				로그인성공 = true;	// 아이디와 비밀번호가 모두 동일하면 변수값 변경
//			}
//			else {
//				System.out.println("알림) 비밀번호가 틀렸습니다.");
//			}
//			// └ 조건이 true 인경우
//			
//		} else { // 입력한 아이디가 admin이 아니면
//			System.out.println("알림) 아이디가 틀렸습니다.");
//		}
//		if(로그인성공 == false)	System.out.println("로그인 실패");
			// └ 조건이 false 인경우
			// 로그인 성공 변수가 false 이면 출력
		
		// 문제9
		// [입력] : 국어, 영어, 수학 입력받기
		// [조건] : 평균이 90점 이상이면서 
		//				국어점수 100점 이면 국어우수 출력
		//				영어점수 100점 이면 영어우수 출력
		//				수학점수 100점 이면 수학우수 출력
		//		   평균이 80점 이상이면서 
		//				국어점수 90점이상 이면 '국어장려' 출력
		//				영어점수 90점이상 이면 '영어정려' 출력
		//				수학점수 90점이상 이면 '수학장려' 출력
		//		    그외 재시험 
		System.out.print("국어점수 : ");	int 국어 = scanner.nextInt();
		System.out.print("영어점수 : ");	int 영어 = scanner.nextInt();
		System.out.print("수학점수 : ");	int 수학 = scanner.nextInt();
		int 평균 = (국어+영어+수학)/3;
		if (평균 >= 90) {		// 평균 90점 이상이면
			
			// if 중첩
			if (국어 == 100)	System.out.println("국어우수");
			if (영어 == 100)	System.out.println("영어우수");
			if (수학 == 100)	System.out.println("수학우수");
		}	// if e
		else if (평균 >=80) {	// 평균 80점 이상이면
			if (국어 >= 90)	System.out.println("국어장려");
			if (영어 >= 90)	System.out.println("영어장려");
			if (수학 >= 90)	System.out.println("수학장려");	
		}	// elseif e
		else System.out.println("재시험");	// 그 외 이면
		
	} //me

} //ce
