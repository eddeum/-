package Day10;

public interface RemoteControl { // �������̽� ����
	
	// ���
		// 1. ����ʵ� : ������ ������
		public int MAX_VOLUME = 10;	// �������� �ִ����
		public int MIN_VOLUME = 0;	// �������� �ּҼ���
		
		// 2. �߻�޼ҵ�** : ����o����x
			// abstract : �߻�[�������̽������� ����]
		public void turnOn();				// {} : �߰�ȣ ����[����x]
		public void turnOff();				// ���� x
		public void setVolume(int volume);	// ���� x
		
		// 3. ����Ʈ�޼ҵ� : ����o����o[java8 �̻�]
		default void setMute(boolean mute) {
			if(mute) {
				System.out.println("���� ó���մϴ�.");
			} // if e
			else {
				System.out.println("���� �����մϴ�.");
			} // else e
		} // default e
		
		// 4. �����޼ҵ� : ����o����o[��ü���� ����]
		static void changeBattery() {
			System.out.println("�������� ��ȯ�մϴ�.");
		} // static e

}
