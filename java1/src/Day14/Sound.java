package Day14;

public class Sound extends Thread {

	static boolean stop = true; // [true 시작 false 종료]
	
	// 메소드
	public void soundstop(boolean stop) {
		this.stop = stop;
		if(this.stop) 	{System.out.println("소리재생시작");}
		else		{System.out.println("소리끄기");}
	}
	
	@Override
	public void run() {
		
		while(this.stop) { // stop변수가 true이면 무한루프[종료조건 : stop 변수가 false 이면]
			System.out.println("소리가 재생중");
			try {
				Thread.sleep(1000);
			}catch(Exception e) {}
			
			
			
		}
		
	}
	
	
}
