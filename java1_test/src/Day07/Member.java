package Day07;

public class Member {
	
	// 1. �ʵ�
	int mno;
	String id;
	String password;
	String name;
	String phone;
	
	// 2. ������
		// 1. ������� : �޼ҵ�ȣ��� ��ü������
	public Member() {}
		// 2. Ǯ������ : ȸ�����Կ� ��ü������

	public Member(int mno, String id, String password, String name, String phone) {
		this.mno = mno;
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
	}
	
	// 3. �޼ҵ�
		// 1. ȸ������ �޼ҵ�[�μ�x��ȯo]
	boolean ȸ������() {
		System.out.println("-------- ȸ������ ������ -------- ");
		System.out.println("���̵� : "); String id = Day07_BookApplication.scanner.next();
		
		// * ���̵� �ߺ�üũ
		for(Member temp : Day07_BookApplication.memberlist) {
			if(temp != null && temp.id.equals(id)) {
				System.err.println("�˸�)���� ������� ���̵��Դϴ�.");
				return false; // �Լ����� ->���̵� �ߺ����� false(���Խ���)
			} // if e
		} // for e
		
		System.out.println("��й�ȣ : ");	String password = Day07_BookApplication.scanner.next();
		System.out.println("�̸� : "); 	String name = Day07_BookApplication.scanner.next();
		System.out.println("����ó : "); 	String phone = Day07_BookApplication.scanner.next();
		
		// * ȸ����ȣ �ڵ��ο�
		int mno = 0;
		int i = 0;
		for(Member temp : Day07_BookApplication.memberlist) {
			if(temp==null) {
				if(i==0) { // ù��° ȸ���� ���
					mno = 1;
					break;
				} // if e
				else {
					mno = Day07_BookApplication.memberlist[i-1].mno+1;
					break;
				} //  else e
			} // if e
			i++;
		} // for e
		
		Member member = new Member(mno, id, password, name, phone);
		
		int j = 0;
		for(Member temp : Day07_BookApplication.memberlist) {
			if(temp == null) {
				Day07_BookApplication.memberlist[j] = member;
				System.out.println("�˸�)ȸ������ ȸ����ȣ : "+ mno);
				return true;
			} // if e
			j++;
		} // for e
		
		return false;
	} // boolean e
	
	
		// 2. �α��� �޼ҵ�[�μ�x��ȯo]
			// �α��� ������ ������ ���̵� ��ȯ/���н� null ��ȯ
	String �α���() {
		System.out.println("-------- �α��� ������ -------- ");
		System.out.println("���̵� : "); 		String id = Day07_BookApplication.scanner.next();
		System.out.println("��й�ȣ : "); 	String password = Day07_BookApplication.scanner.next();
		
		for(Member temp : Day07_BookApplication.memberlist) {
			if(temp != null && temp.id.equals(id) && temp.password.equals(password)) {
				return temp.id;	//////////////////////////????
			} // if e
		} // for e
		
		return null; ///////////////////////////????
	} // String e
		// 3. ���̵�ã�� �޼ҵ�[�μ�x��ȯx] : �̸�, ����ó
	void ���̵�ã�� () {
		System.out.println("-------- ���̵�ã�� ������ -------- ");
		System.out.println("�̸� : ");	String name = Day07_BookApplication.scanner.next();
		System.out.println("����ó : ");	String phone = Day07_BookApplication.scanner.next();
		
		for(Member temp : Day07_BookApplication.memberlist) {
			if(temp != null && temp.name.equals(name) && temp.phone.equals(phone)) {
				System.out.println("�˸�)ȸ������ ���̵� : " + temp.id);
				return;
			} // if e
		} // for e
		System.err.println("�˸�)������ ȸ�������� �����ϴ�.[���̵�ã��]");
	} // void e
		// 4. ��й�ȣã�� �޼ҵ�[�μ�x��ȯx] : ���̵�, ����ó
	void ��й�ȣã�� () {
		System.out.println("-------- ��й�ȣã�� ������ -------- ");
		System.out.println("���̵� : ");	String id = Day07_BookApplication.scanner.next();
		System.out.println("����ó : ");	String phone = Day07_BookApplication.scanner.next();
		
		for(Member temp : Day07_BookApplication.memberlist) {
			if(temp != null && temp.id.equals(id) && temp.phone.equals(phone)){
				System.out.println("�˸�)ȸ������ ��й�ȣ : " + temp.password);
				return;
			} // if e
		} // for e
		System.err.println("�˸�)������ ȸ�������� �����ϴ�[��й�ȣã�� ����]");
	} // void e
	

} // ce
