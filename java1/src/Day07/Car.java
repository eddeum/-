package Day07;

public class Car {
	// Ŭ���� ����
	
	// 1. �ʵ�
	int gas;	// ��������
	// 2. ������
				// ������ ������ �⺻������
	// 3. �޼ҵ�
		 // 1. gas�� �ܺηκ��� �޾Ƽ� ���ο� �����ϴ� �޼ҵ� ����
	void setGas(int gas) { // �μ�o, ��ȯx
// ����x �޼ҵ��(�μ�1) { ���κ��� = �ܺκ��� }
		this.gas = gas;
// ���κ����� �ܺκ��� �̸��� �����Ҷ� �����ϴ� ���
		// this.�ʵ�� : ����(����Ŭ����)
	}
	
		// 2. ���κ��� gas�� ������ Ȯ��[0 = ��������][1�̻� = �����ִ�]
	boolean isLeftGas() { // �μ�x, ��ȯo
//  ����ȯ   �޼ҵ��()
		if(gas==0) {
			System.out.println("gas�� �����ϴ�.");
			return false; // ���κ����� gas�� 0�̸� false�� ��ȯ
		}
		else {
		System.out.println("gas�� �ֽ��ϴ�.");
		return true; // ���κ����� gas�� 0�� �ƴϸ� true�� ��ȯ
		}
	}
		// 3. gas�� 0�϶����� �����ϴµ� �����Ҷ����� ���� 1�� ����
		// gas�� 0�̸� �Լ�����
	void run(){ // �μ�x ��ȯx
		
		while(true) { // ���ѷ���[���� : 1. break  2.return  3.����ġ����]
			if(gas>0) {
				System.out.println("�޸��ϴ�.(gas�ܷ� : " + gas + ")");
				gas -= 1;	// gas���� 1�� ����
			} // if e
			else {
				System.out.println("����ϴ�.(gas�ܷ� : " + gas + ")");
				return;	 // �Լ� Ż��
				// break; -> ��밡�� [�ݺ��� Ż��]
			} // else e
		} // while e
	} // void e
}
