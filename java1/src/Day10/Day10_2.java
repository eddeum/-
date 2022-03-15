package Day10;

public class Day10_2 {

	public static void main(String[] args) {
		
		// �������̽�[�߻�޼ҵ�]
			// ���� : ������ �����Ͽ� ������ ����� ����
				// ���� �ٸ� Ŭ������ ���� ��ü���� �����Ѹ������� ����
			// �߻� : ����[O], ����[X]
				// �������̽����� �����ϰ� �� Ŭ�������� �����Ѵ�.[������]
			// ��) �������̽� : ����Ű, A��ư, B��ư
			//		ö�ǰ��� Ŭ����
			//		�� A��ư : ���� / B��ư : ���
			//		�౸���� Ŭ����
			//		�� A��ư : �� / B��ư : ���
		
		// 1. �������̽� ��ü ����
		RemoteControl rc;
			// �������̽���	 ��ü��
		// 2. �������̽��� �ڷ����� �޸� �Ҵ�
		rc = new Television();
		// 3. �������̽� ����
		rc.turnOn(); 		// TV ���� �޼ҵ�
		rc.turnOff(); 		// TV ���� �޼ҵ�
		rc.setVolume(10);	// TV ���� ���� �޼ҵ��
		
		System.out.println("������ ���� : TV -> Audio ��ü");
		
		// 4. �������̽��� Ŭ�����޸� ��ü[TV -> Audio]
		rc = new Audio();
		rc.turnOn();
		rc.turnOff();
		rc.setVolume(5);

		// ** �͸�����ü : Ŭ�������� �������̽� �߻�޼ҵ� ����
		RemoteControl rc2 = new RemoteControl() {
			// �������̽��� ��ü�� = new �������̽���	
			@Override
			public void turnOn() {
				System.out.println("������ �մϴ�.");
			}
			
			@Override
			public void turnOff() {
				System.out.println("������ ���ϴ�.");
			}
			
			@Override
			public void setVolume(int volume) {
				System.out.println("���� ���� : " + volume);
			}
		};
		
		rc2.turnOn();
		rc2.turnOff();
		rc2.setVolume(10);
		
		
		// ����Ʈ �޼ҵ� ȣ��
		rc2.setMute(true); // �������̽����� �̹� �����Ǿ��ִ� �޼ҵ�
		
		
		// ���� �޼ҵ� ȣ��
		RemoteControl.changeBattery();
		
		// �޸� �Ҵ� �޴� ���
			// �޸� �Ҵ� �ؾߵǴ� ���� 
			// �� �ܺ� Ŭ����/ �������̽� �ʵ�(������), �޼ҵ�(������) ���� 
			// 1. new ������[��ü����]
			// 2. static ������[��������]
		
	} // me
} // ce
