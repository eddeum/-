package Day09;

public class KumhoTire extends Tire {
	
	// 1. �ʵ�
	// 2. ������
	public KumhoTire(String location, int maxRotation) {
		super(location, maxRotation);
		// ����Ŭ������ ������[�ڵ� ���̱�]
	}
	
	// 3. �޼ҵ�
	@Override
	public boolean roll() {
		++accumulatedRotation;
		if(accumulatedRotation<maxRotation) {
			System.out.println(location + "KumhoTire ���� : " + (maxRotation-accumulatedRotation) +"ȸ");
			return true;
		} // if e
		else {
			System.out.println("*** " + location + " KumhoTire ��ũ ***");
			return false;
		} // else e
	} // boolean e

} // ce
