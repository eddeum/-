package Day08;

public class Member {
	
	// 1. �ʵ�
	String id;
	String password;
	String name;
	String phone;
	
	// 2. ������
		// 1. �������
	public Member() {}
		// 2. Ǯ������
	public Member(String id, String password, String name, String phone) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
	}
	
	// 3. �޼ҵ�
		// 1. ȸ������ �޼ҵ�
	boolean ȸ������() { // �μ�x��ȯo(���Լ���true)
		System.out.println("--------- ȸ������ ������ ---------");
		System.out.println("���̵� : ");	String id = Day08_����Ϲ�ũ���α׷�_1.scanner.next();
		
		// * ���̵� �ߺ�üũ
		for(Member temp : Day08_����Ϲ�ũ���α׷�_1.memberlist) {
			if(temp != null && temp.id.equals(id)) {
				System.err.println("�˸�)������ ���̵� �����մϴ�.");
				return false;
			} // if e
		} // for e
		
		System.out.println("��й�ȣ : ");		String password = Day08_����Ϲ�ũ���α׷�_1.scanner.next();
		System.out.println("�̸� : ");		String name = Day08_����Ϲ�ũ���α׷�_1.scanner.next();
		System.out.println("����ó : ");		String phone = Day08_����Ϲ�ũ���α׷�_1.scanner.next();
		
		Member member = new Member();
		
		int i = 0;
		for(Member temp : Day08_����Ϲ�ũ���α׷�_1.memberlist) {
			if(temp == null) {
				Day08_����Ϲ�ũ���α׷�_1.memberlist[i] = member;
				return true;
			} // if e
			i++;
		} // for e
		return false;
	} // boolean e
	
		// 2. �α��� �޼ҵ�
	String �α���() { // �μ�x��ȯo(�α��μ����� ���̵� ��ȯ)
		System.out.println("--------- �α��� ������ ---------");
		System.out.println("���̵� : ");	String id = Day08_����Ϲ�ũ���α׷�_1.scanner.next();
		System.out.println("��й�ȣ : ");	String password = Day08_����Ϲ�ũ���α׷�_1.scanner.next();
		
		for(Member temp : Day08_����Ϲ�ũ���α׷�_1.memberlist) {
			if(temp != null && temp.id.equals(id) && temp.password.equals(password)) {
				return temp.id; ////////////////////////////
			} // if e
		} // for e	
		return null;
	} // String e
	
		// 3. ���̵�ã�� �޼ҵ�
	void ���̵�ã��() { // �μ�x��ȯx (�̸�,����ó �Է�)
		System.out.println("--------- ���̵�ã�� ������ ---------");
		System.out.println("�̸� : "); 	String name = Day08_����Ϲ�ũ���α׷�_1.scanner.next();
		System.out.println("����ó : "); 	String phone = Day08_����Ϲ�ũ���α׷�_1.scanner.next();
		
		for(Member temp : Day08_����Ϲ�ũ���α׷�_1.memberlist) {
			if(temp != null && temp.name.equals(name) && temp.name.equals(phone)) {
				System.out.println("���̵� ã�� ����!");
				System.out.println("ȸ������ ���̵� : " + temp.id);
				return;
			} // if e
		} // for e
		System.err.println("�˸�)������ ȸ�������� �����ϴ�.[���̵�ã�� ����]");
	} // void e
	
		// 4. ��й�ȣã�� �޼ҵ�
	void ��й�ȣã��() { // �μ�x��ȯx (���̵�, ����ó �Է�)
		System.out.println("--------- ��й�ȣã�� ������ ---------");
		System.out.println("���̵� : ");	String id = Day08_����Ϲ�ũ���α׷�_1.scanner.next();
		System.out.println("����ó : ");	String phone = Day08_����Ϲ�ũ���α׷�_1.scanner.next();
		
		for(Member temp : Day08_����Ϲ�ũ���α׷�_1.memberlist) {
			if(temp != null && temp.id.equals(id) && temp.phone.equals(phone)) {
				System.out.println("��й�ȣ ã�� ����!");
				System.out.println("ȸ������ ��й�ȣ : " + temp.password);
				return;
			} // if e
		} // for e
		System.err.println("�˸�)������ ȸ�������� �����ϴ�.[��й�ȣã�� ����]");
	} // void e
	

} // ce
