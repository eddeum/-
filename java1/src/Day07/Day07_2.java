package Day07;

public class Day07_2 {
	
	public static void main(String[] args) {
		
		// p.223~224 : ���ϰ��� ���� �޼ҵ�(void)
		
		// 1. ��ü����
		Car myCar = new Car();
	
		// 2. �޼ҵ� ȣ��[�μ�1�� -> 5]
		myCar.setGas(5);
		
		// 3. �޼ҵ� ȣ��[�μ�x, ��ȯ=trueȤ��false]
		if(myCar.isLeftGas()) {
			System.out.println("����մϴ�.");
		}
		
		// 4. �޼ҵ� ȣ��[�μ�x]
		if(myCar.isLeftGas()) {
			System.out.println("gas�� ������ �ʿ䰡 �ֽ��ϴ�.");
		} // if e
		else {
			System.out.println("gas�� �����ϼ���.");
		} // else e
		
	} // me

} // ce
