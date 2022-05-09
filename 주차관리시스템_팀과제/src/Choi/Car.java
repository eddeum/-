package Choi;

public class Car {
	
	String 입차시간;
	String 출차시간;
	String 차량;
	public Car(String 입차시간, String 출차시간, String 차량) {
		super();
		this.입차시간 = 입차시간;
		this.출차시간 = 출차시간;
		this.차량 = 차량;
	}
	public Car() {}
	public String get입차시간() {
		return 입차시간;
	}
	public void set입차시간(String 입차시간) {
		this.입차시간 = 입차시간;
	}
	public String get출차시간() {
		return 출차시간;
	}
	public void set출차시간(String 출차시간) {
		this.출차시간 = 출차시간;
	}
	public String get차량() {
		return 차량;
	}
	public void set차량(String 차량) {
		this.차량 = 차량;
	}
	
	

}
