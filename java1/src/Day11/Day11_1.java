package Day11;

public class Day11_1 {
	
	// p.386 확인문제
		// 1. 3 [인터페이스 멤버 : 1.상수필드 2.추상메소드* 3.디폴트메소드 4.정적메소드]
		// 2. 4	[인터페이스 변수 = 구현객체]
			// 구현객체 = 클래스가 implements 한 객체
		// 3. Soundable 인터페이스, Dog 클래스, Cat 클래스 참고
		private static void printSound(Soundable soundable) {
//	 	접근제한자 	정적	   반환타입 메소드명	  (인수[변수, 배열, 객체, 인터페이스])
			System.out.println(soundable.sound());
		} // void e
		
		public static void dbWork(DataAccessObject dao) { // 4번 -> main 밖에 선언
			dao.select();
			dao.insert();
			dao.update();
			dao.delete();
		}

		public static void main(String[] args) {
		
			printSound(new Cat());					// 2
					// 구현객체
			printSound(new Dog());
	
			Soundable soundable = new Cat();		// 1
			Soundable[] soundables = new Cat[100];	// 3
		
		
		// 4. DataAccessObject 인터페이스, OracleDao 클래스, MysqDao 클래스 참고
			// Dao : DB 접근객체	Dto : 데이터이동객체		Vo : 	
		dbWork(new OracleDao());
		dbWork(new MysqDao());
			
		// 5. 익명객체[인터페이스가 직접 구현] ---> Action 인터페이스 참고
			// 구현객체 : 인터페이스 객체명 = new 클래스명();
			// 익명객체 : 인터페이스 객체명 = new 인터페이스(){구현}; // 1회용
		Action action = new	Action() {
			
			@Override
			public void work() {
				System.out.println("복사를 합니다.");
			}
			
		}; // 구현 끝
		
		action.work();	// 인터페이스 객체내 메소드 실행
			
		} // main e
	

}
