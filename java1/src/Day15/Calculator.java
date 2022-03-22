package Day15;

public class Calculator {
	
	// vlfem
	private int memory;
	
	// 메소드
	public int getMemory() {
		return memory;
	}
	// 메소드
		// 문제점 : 스레드1이 100을 넣고 (스레드2가 50을 넣고[값 변경]) 100을 출력 -----> 최종 50으로 출력
		// 문제해결[synchronized : 동기화]
			// 스레드 1이 100 넣고 (스레드2이 대기중) 100출력
				// 스레드2는 스레드1의 메소드종료가 될때까지 대기상태
	public synchronized void setMemory(int memory) {
		this.memory = memory;
		// 2초간 일시정지 -> 코드가 짧아서 너무빨리진행됨
		try {Thread.sleep(2000);}
		catch(Exception e) {}
		// memory 출력
		System.out.println(Thread.currentThread().getName()+":"+this.memory);
	}

}
