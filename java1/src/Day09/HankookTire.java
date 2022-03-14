package Day09;

public class HankookTire extends Tire{
			// 서브클래스 extends 슈퍼클래스
	// 1. 필드
	// 2. 생성자
	public HankookTire(String location, int maxRotation) {
		super(location, maxRotation);
		// super(인수1, 인수2) // 슈퍼클래스 내 [인수2개] 생성자 호출
	}
	
	// 3. 메소드
	@Override
	public boolean roll() {
		++accumulatedRotation;
		if(accumulatedRotation<maxRotation) {
			System.out.println(location + "HankookTire 수명 : " + (maxRotation-accumulatedRotation) +"회");
			return true;
		} // if e
		else {
			System.out.println("*** " + location + " HankookTire 펑크 ***");
			return false;
		} // else e
	} // boolean e

}
