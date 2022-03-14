package Day09;

public class Computer extends Calculator {
			// 서브클래스 extends 슈퍼클래스
	
	// 1. 필드
	// 2. 생성자
	// 3. 메소드
		// * 오버라이딩 [부모클래스 내 메소드 재정의(수정)]
		// ctrl + 스페이스바
// 	@Override : 상속받은 부모가 가지고 있는 메소드 호출(이클립스에서는 생략가능)
	double areaCircle(double r) {
		System.out.println("Computer 객체의 areaCircle() 실행");
		return Math.PI * r * r;
	}
	
	
	
} // ce
