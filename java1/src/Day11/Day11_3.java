package Day11;

public class Day11_3 {
	
	// p.440 예외던지기
		// 목적 : 모든 메소드에서 try{}~catch(){} 사용시 코드가 복잡해짐 -> 한 곳으로 예외 이동
	
	public static void main(String[] args) {
		try {
			findclass();
		}catch(Exception e) {}
		
		try {
			withdraw(30000);
		}catch(Exception e) {
			System.out.println(e);
		} // catch e
		
	} // me	
	public static void findclass() throws Exception {
		
		// 1. 예외 던지기[메소드명() throws 예외클래스명]
		Class clazz = Class.forName("java.lang.String2");
			
		// 2. try~catch
//		try { // 예외가 발생할 것 같은 코드(실행예외) 혹은 일반예외[무조건]
//			Class clazz = Class.forName("java.lang.String2");
//							// 클래스찾기 메소드
//		}catch(Exception e) { // 예외가 발생하면 실행되는 코드
//			// Exception : 예외클래스 중 슈퍼클래스이므로 모든 예외를 저장가능
//			System.out.println(e);
//		} // catch e
	} // void e
	
	// p. 444~445 : 예외 만들기
	public static void withdraw(int money) throws Exception {
		if(20000<money) {
			throw new Exception("잔고부족");
		} // if e
	} // void e
	
	
	// p.448 확인문제
	
			// 1. 4 [예외 만들기 기능]
			// 2. 3 [finally {} 무조건 실행되는 코드]
			// 3. 4 [throws : 예외던지기	/ throw : 예외만들기]
			// 4. 2
			// 5. 3 [멀티 catch 순서 : 자식클래스 먼저 -> 부모클래스 마지막]
			// 6. 	
			//		10
			//		숫자로 변환할 수 없음[배열내 2a -> 정수형 변환x(숫자형식변환 오류 발생)]
			//		10
			//		인덱스를 초과했음
			//		10

	

} // ce
