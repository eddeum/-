package Day08;

import Day07.Member;

public class Bank {
	
	// 1. �ʵ�
	private int bnumber;
	private int bbalance;
	private String name;
	private String password;
	
	// 2. ������
		// 1. �������
	public Bank() {}
		// 2. Ǯ������
	public Bank(int bnumber, int bbalance, String name, String password) {
		this.bnumber = bnumber;
		this.bbalance = bbalance;
		this.name = name;
		this.password = password;
	}
	
	// 3. �޼ҵ�
	
	boolean ���»���() { ///////////////////////////////////////////
		System.out.println("----------- ���»��� ������ -----------");
		System.out.println("���¹�ȣ : ");	int bnumber = Day08_5.scanner.nextInt();
		
		// * ���¹�ȣ �ߺ�üũ
		for(Bank temp : Day08_5.banklist) {
			if(temp != null && temp.bnumber == bnumber) {
				System.err.println("�˸�)���� ������� ���¹�ȣ �Դϴ�.");
				return false;
			} // if e
		} // for e
		
		System.out.println("������ : ");		String name = Day08_5.scanner.next();
		System.out.println("���� ��й�ȣ : ");	String password = Day08_5.scanner.next();
		
		Bank bank = new Bank(bnumber, bbalance, name, password);
		
		int i = 0;
		for(Bank temp : Day08_5.banklist) {
			if(temp == null) {
				Day08_5.banklist[i]= bank;
				bank.bbalance = 0; 
				System.out.println("�˸�)���»��� �Ϸ�");
				return true;
			} // if e
			i++;
		} // for e
		return false;
	} // boolean e
	
	void �Ա�(String loginid) {//////////////////////////////
		System.out.println("----------- �Ա� ������ -----------");
		System.out.println("�Աݾ� : ");	int �Ա� = Day08_5.scanner.nextInt();
		
		System.out.println("���� ��й�ȣ : ");	String password = Day08_5.scanner.next();
		
		for(Bank temp : Day08_5.banklist) {
			if(temp != null && temp.password.equals(password)) {
				System.out.println("�˸�)" + �Ա� + "�� �ԱݵǾ����ϴ�.");
				temp.bbalance += �Ա�;	
//				temp.id = loginid; ///////////////////////
				break;
			} // if e
			else {
				System.err.println("�˸�)���� ��й�ȣ�� �ٸ��ϴ�.[�ԱݺҰ�]");
				break;
			} // else e
		} // for e
		
		
	} // void e
	void ���(String loginid) {
		System.out.println("----------- ��� ������ -----------");
		System.out.println("��ݾ� : ");	int ��� = Day08_5.scanner.nextInt();
		
		System.out.println("���� ��й�ȣ : "); String password = Day08_5.scanner.next();
		
		for(Bank temp : Day08_5.banklist) {
			if(temp != null && temp.password.equals(password)) {
				System.out.println("�˸�)" + ��� + "�� ��ݵǾ����ϴ�.");
				temp.bbalance -= ���;
				break;
			} // if e
			else {
				System.err.println("�˸�)���� ��й�ȣ�� �ٸ��ϴ�.[��ݺҰ�]");
				break;
			} // else e
		} // for e
		
	} // void e
	
	void ��ü(String loginid) {
		System.out.println("----------- ��ü ������ -----------");
		System.out.println("��ü ���¹�ȣ : "); int bnumber = Day08_5.scanner.nextInt();
		

		
		// ��ü�� ���¹�ȣ �Է�
		// ��ü�� ���¹�ȣ �����ϴ��� Ȯ����
		// ��ü�� �Է�
		// �� ���� �ܾ��� ��ü�׺��� ������ ��ü���� �ƴϸ� ��ü�Ұ�
		// �� ���� ��й�ȣ �Է� �� ������ ��ü �ƴϸ� ��ü�Ұ�		
		// ��ü �� �� ���� �ܾ׺��� Ȯ��
		// ��ü�� ���¹�ȣ �ܾ׺��� Ȯ��
		// ��ü�˸�����
		
		
		
	} // void e
	void ����() {
		System.out.println("----------- ���� ������ -----------");
	} // void e
	void ���¸��() {
		System.out.println("----------- ���¸�� ������ -----------");
		System.out.println("���¹�ȣ\t������\t�ܾ�");
		
		for(Bank temp : Day08_5.banklist) {
			if(temp != null) {
				System.out.println(temp.bnumber+"\t"+temp.name+"\t"+temp.bbalance);
			} // if e
		} // for e
	} // void e
	

}
