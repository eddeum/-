package Day09;

public class Day09_5 {

	public static void main(String[] args) {
		
		// 1. ��ü ����[�ڵ��� 1�� ����]
		Car myCar = new Car();
			// ���� �� Ÿ�̾ü�� 4�� -> myCar ����
		// 2. �޼ҵ� ȣ��
		for(int i = 1; i<=5; i++) {
			
			int problemLocation = myCar.run(); // �ڵ��� ȸ���޼ҵ� ȣ�� -> 5��
			
			switch(problemLocation) {
			case 1:
				System.out.println("�տ��� HankookTire�� ��ü");
				myCar.frontLeftTire = new HankookTire("�տ���", 15);
				// ����Ŭ���� ��ü�� = new ����Ŭ����();
				// ��ӹ����� ����!!!!!!
				break; // switch Ż��
			case 2:
				System.out.println("�տ����� KumhoTire�� ��ü");
				myCar.frontRightTire = new KumhoTire("�տ�����", 13);
				break;
			case 3:
				System.out.println("�ڿ��� HankookTire�� ��ü");
				myCar.backLeftTire = new HankookTire("�ڿ���", 14);
				break;
			case 4:
				System.out.println("�ڿ����� KumhoTire�� ��ü");
				myCar.backRightTrie = new KumhoTire("�ڿ�����", 17);
				break;
			} // switch e
			System.out.println("---------------------------------------");
			
		} // for e
	} // me
	
} // ce
