package Day09;

public class HankookTire extends Tire{
			// ����Ŭ���� extends ����Ŭ����
	// 1. �ʵ�
	// 2. ������
	public HankookTire(String location, int maxRotation) {
		super(location, maxRotation);
		// super(�μ�1, �μ�2) // ����Ŭ���� �� [�μ�2��] ������ ȣ��
	}
	
	// 3. �޼ҵ�
	@Override
	public boolean roll() {
		++accumulatedRotation;
		if(accumulatedRotation<maxRotation) {
			System.out.println(location + "HankookTire ���� : " + (maxRotation-accumulatedRotation) +"ȸ");
			return true;
		} // if e
		else {
			System.out.println("*** " + location + " HankookTire ��ũ ***");
			return false;
		} // else e
	} // boolean e

}
