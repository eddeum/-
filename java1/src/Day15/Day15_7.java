package Day15;

import java.awt.Toolkit;

public class Day15_7 {
	
	public static void main(String[] args) {
		
		// p.601 ������ ����
			// 1. Thread.sleep(�и���) : �־��� �ð����� �Ͻ�����
					// �ð� ���� : �и���(1/1000��)
					// �Ϲ� ���� �߻� : �Ͻ��������¿��� �־��� �ð��� �Ǳ����� ������[����] �Ǿ����� �̸� ó���ڵ�
			// 2. Thread.yield() : �ٸ� �����忡�� ���� �纸[������=�Ͻ�����]
			// 3. Thread.join() : �ٸ� �������� ���Ḧ ��ٸ�[�ٸ� �����尡 ���������� ��ٸ�]
		
		// p.602 sleep ����
//		Toolkit toolkit = Toolkit.getDefaultToolkit(); // �Ҹ� ���� Ŭ����
//		for(int i=0; i<10; i++) { // 10�� �ݺ�
//			toolkit.beep(); // �Ҹ�����[�Ҹ� 1�� �۵��߿� for���� ����]
//			try {
//			Thread.sleep(3000); // �� ������ 3�ʰ� �Ͻ�����
//			}catch(Exception e) {}
//		}
		
//		// p.604~606 yield()
//		// 1. ��ü ����
//		ThreadA threadA = new ThreadA();
//		// 2. ��ü ����
//		ThreadB threadB = new ThreadB();
//		// 3. ������ ����
//		threadA.start();
//		threadB.start();
//		// 4. ������ 3�ʰ� �Ͻ�����
//		try {Thread.sleep(3000);}
//		catch(Exception e) {}
//		// 5. ������A�� work �� ����[�ش� ������ �Ͻ�����]
//		threadA.work = false; // -> Thread.yield();
//		
//		// 4. ������ 3�ʰ� �Ͻ�����
//		try {Thread.sleep(3000);}
//		catch(Exception e) {}	
//		// 5. ������A�� work �� ����[�ش� ������ �Ͻ����� Ǯ��]
//		threadA.work = true;
//		
//		// 4. ������ 3�ʰ� �Ͻ�����
//		try {Thread.sleep(3000);}
//		catch(Exception e) {}	
//		// 6. ������A, ������B ����
//		threadA.stop = true;
//		threadB.stop = true;
//		// 7. 
//		threadA.stop(); // �������� �ʴ� �޼ҵ�[���� : �������� ������ �����Ƿ�]
//		
		
		// p.607 : join()
		// 1. ��ü ����
		SumThread sumThread = new SumThread();
		// 2. ������ ����
		sumThread.start();
		// 3. main������� sumThread������ join -> �ϳ��� ������
		try { sumThread.join();} // �Ϲ� ����ó�� �߻�
		catch(Exception e) {}
		// 4.
		System.out.println("1~100 �� : " + sumThread.getsum());
		// * main �����尡 join �������� : 0
			// SumThread�� ���ϱ⸦ ���������� main������ sum ���
		// * main �����尡 join ������ : 5050
		
	} // me

} // ce
