package Day11;

public class Day11_2 {

	
	// p.422
		// 컴퓨터의 하드웨어 문제를 에러[실행불가능]
		// 사용자의 잘못된 조작 or 개발자의 잘못된 코딩의 오류 -> 예외
		// 종류 : 1.일반예외  2.실행예외
			// 일반예외 : 컴파일[실행]전에 예외를 검사[개발자에게 강제 예외처리(실행전) = 외부통신]
			// 실행예외 : 컴파일[실행]후에 예외를 검사[개발자의 경험으로 판단해서 예외처리]
		// 예외처리
			// 목적 : 에러가 발생하면 프로그램은 종료된다.[안정성에 문제가 생김]
			// 만약에 에러가 발생하면 대체 코드가 실행[프로그램이 종료되지 않게]
	
		/*
		 * try{
		 * 		예외가 발생할 것 같은 코드
		 * }catch(예외클래스 객체명) {
		 * 		 만약에 예외가 발생하면 실행되는 코드
		 * 	}
		 */
	
	public static void main(String[] args) {
	
		// p.423[NullpointerException]
		try {
			String data = null;
			System.out.println(data.toString());	// Object클래스 메소드 : toString() : 객체정보출력
				// 실행전에는 에러없다. 실행후에 에러발생[실행예외]
			// 에러가 발생하는 이유 : null은 메모리가 없기때문에 객체정보츨략 불가
		} // try e
		catch (NullPointerException 객체명) {
			System.out.println("예외발생 : " + 객체명);
		} // catch e
		
		// p.424[ArrayIndexOutOfBoundsException]
		try { // 예외가 발생할것 같은코드
			String [] 배열 = new String[2];	// String  2개를 저장할 수 있는 배열
			배열[0] = "a";	배열[1] = "b";	배열[2] = "c";
		}catch(ArrayIndexOutOfBoundsException e) {
				// 예외가발생한 예외클래스명 객체명 = 객체에 예외 이유가 저장됨
			// 만약에 예외가 발생하면 실행되는 코드
			System.out.println("예외발생 : " + e);
		} // catch e
		
		
		// p.426[NumberFormatException]
		try {
			String data1 =	"100";	// 문자열
			String data2 = "a100";	// 문자열
			int value1 = Integer.parseInt(data1); // "100" -> 100 
			int value2 = Integer.parseInt(data2); // "a100" -> x[a는 정수로 표현 불가능]
					// Integer.parseInt(문자열)
					// 단 : "100" --> 100 [가능] / "a100" --> a100[불가능]
			// 오류 발생 이유 : 문자열내 숫자형식은 변환이 가능하지만 문자열내 문자형식 변환이 불가능
			// 오류가 발생하면 catch이동[오류발생이후 코드실행 X]
			int result = value1 + value2;
			System.out.println(data1 + "+" + data2 + "=" + result);
			}catch(NumberFormatException e) {
				System.out.println("오류 발생 : " + e);
			} // catch e
		
		// p.428[
			String 문자열 = "유재석";	// 자바 클래스 중 하나[무조건 Object 상속]
			Object 슈퍼객체;			// 자바 클래스 내 최상위 클래스
		
			슈퍼객체 = 문자열;			// 자식 -> 부모 [가능]
			문자열 = (String)슈퍼객체;	// 부모 -> 자식 [블가능]
				// 강제형변환
				// 실행중에 형변환	
		// 예외처리 판단
			// 입출력(사용자입장) 관련된 코드[무조건 예외처리]
		
	} // me
	
}  // ce
