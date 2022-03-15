package Day10;

public class Television implements RemoteControl, Searchable {
		// Ŭ������ implements(�����ϴ�) �������̽���
	
	private int volume;
	// ctrl + �����̽���(�ڵ��ϼ�) : ���׶��+A or �����ʸ��콺 -> Source -> implement
	@Override
	public void turnOn() {
		System.out.println("TV�� �մϴ�");
	}
	@Override
	public void turnOff() {
		System.out.println("TV�� ���ϴ�.");
	}
	@Override
	public void setVolume(int volume) {
		if(volume > RemoteControl.MAX_VOLUME) {
			// �������� �ִ�������� ũ�� ������ 10���� ����[����]
			this.volume = RemoteControl.MAX_VOLUME;
		} // if e
		else if(volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		} // else if e
		else {
			this.volume = volume;
		} // else e
		System.out.println("���� TV ���� : " + this.volume);
	}
	
	@Override
	public void search(String url) {
		System.out.println(url + "�� �˻��մϴ�.");	
	}
	
	
	@Override // ����Ʈ �޼ҵ嵵 ������ ����
	public void setMute(boolean mute) {
		RemoteControl.super.setMute(mute);
	}
	
}
