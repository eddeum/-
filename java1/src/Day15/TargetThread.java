package Day15;

public class TargetThread extends Thread {

	// ����ó��
	@Override
	public void run() { 					// ������ ���� : NEW -> ��ü�����ǰ� ��Ƽ������ ���� ��
		
		for(long i = 0; i<1000000000; i++) {// ������ ���� : RUNNABLE -> ��Ƽ������ ���� ��
						// 10�� �ݺ�			
		} // for e

		// 1.5�ʰ� ���[�̸��� = 1/1000��]
		try {Thread.sleep(1500);}			// ������ ���� : WAITING -> ��Ƽ������ �Ͻ�����
		catch(Exception e) {}
			
		for(long i = 0; i<1000000000; i++) {
						// 10�� �ݺ�
		} // for e

	} // run �޼ҵ尡 ����Ǹ� 					// ������ ���� : TERMINATED -> ��Ƽ������ ����
	
	
}
