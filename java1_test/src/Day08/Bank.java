package Day08;

public class Bank {
	
	// 1. �ʵ�
	int ano;
	int balance;
	String owner;
	String bpassword;
	
	
	// 2. ������
		// 1. �������
	public Bank() {}
		// 2. Ǯ������
	public Bank(int ano, int balance, String owner, String bpassword) {
		this.ano = ano;
		this.balance = balance;
		this.owner = owner;
		this.bpassword = bpassword;
	}
		// 3. 3�� ������
	public Bank(int ano, String owner, String bpassword) {
			this.ano = ano;
			this.owner = owner;
			this.bpassword = bpassword;
		}
	
	// 3. �޼ҵ�
		// 1. ���»���
	boolean ���»���() { 
		System.out.println("----------- ���»��� -----------");
		System.out.println("���¹�ȣ : "); int ano = Day08_����Ϲ�ũ���α׷�_1.scanner.nextInt();
		
		//* �����ߺ�üũ
		for(Bank temp : Day08_����Ϲ�ũ���α׷�_1.banklist) {
			if(temp != null && temp.ano == ano) {
				System.err.println("�˸�)�ߺ��� ���¹�ȣ�Դϴ�.");
				return false;
			} // if e
		} // for e

		System.out.println("������ : ");		String owner = Day08_����Ϲ�ũ���α׷�_1.scanner.next();
		System.out.println("���� ��й�ȣ : "); String bpassword = Day08_����Ϲ�ũ���α׷�_1.scanner.next();
		System.out.println("�ʱ��Աݾ� : ");	int money = Day08_����Ϲ�ũ���α׷�_1.scanner.nextInt();
		
		Bank bank = new Bank(ano,owner, bpassword);
		
		int i = 0;
		for(Bank temp : Day08_����Ϲ�ũ���α׷�_1.banklist) {
			if(temp == null) {
				Day08_����Ϲ�ũ���α׷�_1.banklist[i] = bank;
				Day08_����Ϲ�ũ���α׷�_1.banklist[i].balance = money;
				System.out.println("���»��� �Ϸ�!");
				return true;
			} // if e
			i++;
		} // for e
		return false;
	} // boolean e
	
		// 2. �Ա�
	void �Ա�() {
		System.out.println("----------- �Ա� -----------");
		System.out.println("���¹�ȣ : ");		int ano = Day08_����Ϲ�ũ���α׷�_1.scanner.nextInt();
		System.out.println("�Աݾ� : ");		int �Ա� = Day08_����Ϲ�ũ���α׷�_1.scanner.nextInt();
		System.out.println("���� ��й�ȣ : ");	String bpassword = Day08_����Ϲ�ũ���α׷�_1.scanner.next();
		
		int i = 0;
		for(Bank temp : Day08_����Ϲ�ũ���α׷�_1.banklist) {
			if(temp != null && temp.ano == ano && temp.bpassword.equals(bpassword)) {
				System.out.println(�Ա�+"�� �ԱݵǾ����ϴ�.");
				Day08_����Ϲ�ũ���α׷�_1.banklist[i].balance += �Ա�;
				return;
			} // if e
			i++;
		} // for e
		System.err.println("�˸�)������ ������ �����ϴ�[�ԱݺҰ�]");
	} // void e
	
		// 3. ���
	void ���() { //// �ܾ�Ȯ���ϱ�
		System.out.println("----------- ��� -----------");
		System.out.println("���¹�ȣ : "); 	int ano = Day08_����Ϲ�ũ���α׷�_1.scanner.nextInt();
		System.out.println("��ݾ� : "); 		int ��� = Day08_����Ϲ�ũ���α׷�_1.scanner.nextInt();
		System.out.println("���� ��й�ȣ : "); String bpassword = Day08_����Ϲ�ũ���α׷�_1.scanner.next();
		
		int i = 0;
		for(Bank temp : Day08_����Ϲ�ũ���α׷�_1.banklist) {
			if(temp != null && temp.ano == ano && temp.bpassword.equals(bpassword)) {
				System.out.println(���+"�� ��ݵǾ����ϴ�");
				Day08_����Ϲ�ũ���α׷�_1.banklist[i].balance -= ���;
				return;
			} // if e
		} // for e	
		
	} // void e
		// 4. ��ü
	void ��ü () {
		System.out.println("----------- ��ü -----------");
		System.out.println("��ü���¹�ȣ : "); 	int ano = Day08_����Ϲ�ũ���α׷�_1.scanner.nextInt();
		System.out.println("��ü�� : "); 		int ��ü = Day08_����Ϲ�ũ���α׷�_1.scanner.nextInt();
		System.out.println("���� ��й�ȣ : "); String bpassword = Day08_����Ϲ�ũ���α׷�_1.scanner.next();
		
	
	} // void e
		// 5. ����
	void ���� () {}
		// 6. �� ���¸��
	void ������(String name) {
		System.out.println("----------- �� ���¸�� -----------");
		System.out.println("����\t���¹�ȣ\t�ܾ�");
		
		int i = 0;
		for(Bank temp : Day08_����Ϲ�ũ���α׷�_1.banklist) {
			if(temp != null && temp.owner.equals(name)) {
				System.out.println(i+"\t"+temp.ano+"\t"+temp.balance);
			} // if e
			i++;
		} // for e
	} // void e
	
	
	
	

} // ce
