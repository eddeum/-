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
	
	boolean ���»���(String loginname) { ///////////////////////////////////////////
		System.out.println("----------- ���»��� ������ -----------");
		System.out.println("���¹�ȣ : ");	int bnumber = Day08_5.scanner.nextInt();
		
		// * ���¹�ȣ �ߺ�üũ
		for(Bank temp : Day08_5.banklist) {
			if(temp != null && temp.bnumber == bnumber) {
				System.err.println("�˸�)���� ������� ���¹�ȣ �Դϴ�.");
				return false;
			} // if e
		} // for e
		
		System.out.println("���� ��й�ȣ : ");	String password = Day08_5.scanner.next();
		
		Bank bank = new Bank(bnumber, bbalance, name, password);
		
		int i = 0;
		for(Bank temp : Day08_5.banklist) {
			if(temp == null) {
				Day08_5.banklist[i]= bank;
				bbalance = 0;
				temp.name = loginname;
				System.out.println("�˸�)���»��� �Ϸ�");
				return true;
			} // if e
			i++;
		} // for e
		return false;
	} // boolean e
	
	void �Ա�() {
		System.out.println("----------- �Ա� ������ -----------");
		System.out.println("�Աݾ� : ");	int �Ա� = Day08_5.scanner.nextInt();
		System.out.println("�˸�)" + �Ա� + "�� �ԱݵǾ����ϴ�.");
		bbalance += �Ա�;
		
	} // void e
	void ���() {
		System.out.println("----------- ��� ������ -----------");
		System.out.println("��ݾ� : ");	int ��� = Day08_5.scanner.nextInt();
		System.out.println("�˸�)" + ��� + "�� ��ݵǾ����ϴ�.");
		bbalance -= ���;
		
		
	} // void e
	void ��ü() {
		System.out.println("----------- ��ü ������ -----------");
	} // void e
	void ����() {
		System.out.println("----------- ���� ������ -----------");
	} // void e
	void ���¸��() {
		System.out.println("----------- ���¸�� ������ -----------");
	} // void e
	

}
