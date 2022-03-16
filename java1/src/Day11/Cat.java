package Day11;

public class Cat implements Soundable {
		// 클래스명	구현		인터페이스명
	// 추상메소드가 존재하면 구현해야함
	
	@Override
	public String sound() {
		return "야옹";	// print 안쓰는 이유 : Day11_1 에 이미 print를 씀
	}

}
