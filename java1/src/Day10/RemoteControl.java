package Day10;

public interface RemoteControl { // 인터페이스 선언
	
	// 멤버
		// 1. 상수필드 : 고정된 데이터
		public int MAX_VOLUME = 10;	// 리모컨의 최대소음
		public int MIN_VOLUME = 0;	// 리모컨의 최소소음
		
		// 2. 추상메소드** : 선언o구현x
			// abstract : 추상[인터페이스에서는 생략]
		public void turnOn();				// {} : 중괄호 생략[구현x]
		public void turnOff();				// 구현 x
		public void setVolume(int volume);	// 구현 x
		
		// 3. 디폴트메소드 : 선언o구현o[java8 이상]
		default void setMute(boolean mute) {
			if(mute) {
				System.out.println("무음 처리합니다.");
			} // if e
			else {
				System.out.println("무음 해제합니다.");
			} // else e
		} // default e
		
		// 4. 정적메소드 : 선언o구현o[객체없이 가능]
		static void changeBattery() {
			System.out.println("건전지를 교환합니다.");
		} // static e

}
