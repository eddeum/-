package Day07;

public class Day07_2 {
	
	public static void main(String[] args) {
		
		// p.223~224 : 리턴값이 없는 메소드(void)
		
		// 1. 객체선언
		Car myCar = new Car();
	
		// 2. 메소드 호출[인수1개 -> 5]
		myCar.setGas(5);
		
		// 3. 메소드 호출[인수x, 반환=true혹은false]
		if(myCar.isLeftGas()) {
			System.out.println("출발합니다.");
		}
		
		// 4. 메소드 호출[인수x]
		if(myCar.isLeftGas()) {
			System.out.println("gas를 주입할 필요가 있습니다.");
		} // if e
		else {
			System.out.println("gas를 주입하세요.");
		} // else e
		
	} // me

} // ce
