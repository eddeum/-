package Day14;

import java.awt.Toolkit;

public class BeepTask implements Runnable {
					// �����ϴ� [Runnable]
	// implements ���� �߻�޼ҵ� ��!! �����ϱ�
		// ctrl+�����̽���(�ڵ��ϼ�)
	@Override
	public void run() { // Runnable �������̽��� run�޼ҵ� �����ϱ�
	
		Toolkit toolkit = Toolkit.getDefaultToolkit(); // 1. ��ü����
		for(int i = 0; i<5; i++) { // 2. 5ȸ �ݺ�
			toolkit.beep(); // �Ҹ�����
			try { 
			Thread.sleep(500); // �Ϲݿ��ܰ� ������ �߻� -> ����ó�� ������
			}catch(Exception e) {}
		}
	
	} 
	
	
	
	
	
	
	
}



