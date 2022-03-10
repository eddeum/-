package Day07;

public class Member {

	// 1. �ʵ�
	int mno;		// ȸ����ȣ[�ڵ���ȣ, �ߺ�x]
	String id;		// ���̵�[�ߺ�x]
	String password;// ��й�ȣ
	String name;	// �̸�
	String phone;	// ����ó
	
	// 2. ������[�����ڸ�=Ŭ������]
		// 1. ������� : �޼ҵ�ȣ��� ��ü������
	public Member() {}
		// 2. ��� �ʵ带 �޴� ������ : ȸ�����Կ� ��ü������
	public Member(int mno, String id, String password, String name, String phone) {
		super();
		this.mno = mno;
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
	}
	
	// 3. �޼ҵ�
		// 1. ȸ������ �޼ҵ�[�μ�x��ȯo : ���Լ��� true/���Խ��� false]]
	boolean ȸ������() {
		System.out.println("-------- ȸ������ ������ --------");
		// 1. �Է¹޴´�[id, pw, name, phone]
		System.out.println("���̵� : ");	String id = 			Day07_5_BookApplication.scanner.next();
		
		// * ���̵��ߺ�üũ
		for(Member temp : Day07_5_BookApplication.members) {
			if(temp != null && temp.id.equals(id)) {
				// ���࿡ ������ �ƴϸ鼭 �迭�� id�� �Է¹��� id�� �����ϸ�
				System.err.println("�˸�))���� ������� ���̵� �Դϴ�.");
				return false;	// �Լ����� -> ���̵� �ߺ��Ǿ��� ������ false[���Խ���]
			} // if e
		} // for e
		
		System.out.println("��й�ȣ : ");	String password = 		Day07_5_BookApplication.scanner.next();
		System.out.println("�̸� : ");	String name = 			Day07_5_BookApplication.scanner.next();
		System.out.println("����ó : ");	String phone = 			Day07_5_BookApplication.scanner.next();
			// * scanner ��ü�� �ٸ� Ŭ���� �� static���� ����Ǿ�����.		// * Ŭ������.�ʵ��.�Լ���();
			// * static �ʵ�, �޼ҵ�� ��ü���� ȣ�Ⱑ��[Ŭ������.�ʵ��/�޼ҵ��]
		
			// * ȸ����ȣ �ڵ��ο�[���� �ֱٿ� ������ ȸ��[������ȸ��]�� ��ȣ+1]
			int bno = 0; // ȸ����ȣ �����ϴ� ����
			int j = 0;
			for(Member temp : Day07_5_BookApplication.members) {
				if(temp==null) { // nullã�� : null ã������ null-1�ϸ� ������ȸ���� �ε���
					if(j==0) {	// ù��° �ε���[0���ε���]�� null => ùȸ�� => ùȸ����ȣ : 1 �ο�
						bno = 1;
						break;
					} // if e
					else { // ù��° ȸ���� �ƴϸ�
						bno = Day07_5_BookApplication.members[j-1].mno+1;
											// null ��[������ȸ��] ��ȣ�� +1
						break;
					} // else e
				} // if e
				j++; // �ε��� ����
			} // for e
		
		
		// 2. 4������ -> ��üȭ -> 1��
		Member member = new Member(bno, id, password, name, phone);	// ��� �ʵ带 �޴� �����ڷ� ��ü����
		
		// 3. �迭�� �� ������ ã�Ƽ� ���ο� ȸ��[��ü] �ֱ�
		int i = 0; // �ݺ�Ƚ��[�ε���üũ]
		for(Member temp : Day07_5_BookApplication.members) {
			if(temp==null) { // ������̸�
				Day07_5_BookApplication.members[i] = member;	// �� �ε����� ���ο� ȸ�� ����
				System.out.println("�˸�))ȸ������ ȸ����ȣ : " + bno);
				return true; // ȸ������ �޼ҵ� ����[��ȯ : true]
			} // if e
			i++;
		} // for e
		// 4. ���� ������ true ��ȯ ���н� false ��ȯ
		return false; // ȸ������ �޼ҵ� ����[��ȯ : false]
		
	} // boolean e

		// 2. �α��� �޼ҵ�[�μ�x��ȯo
			// �α��μ����� ������ ���̵� ��ȯ/���н� NULL ��ȯ
	String �α���() {
		System.out.println("-------- �α��� ������ --------");
		// 1. �Է¹ޱ�
		System.out.println("���̵� : "); 	String id = Day07_5_BookApplication.scanner.next();
		System.out.println("��й�ȣ : ");	String password = Day07_5_BookApplication.scanner.next();
		
		// 2. �迭�� ��ü id�� password�� �Է��� ���� �����ϸ�
		for(Member temp : Day07_5_BookApplication.members) {
			if(temp != null && temp.id.equals(id) && temp.password.equals(password)) {
				// * ������ �ƴϸ鼭 id�� password�� �����ϸ�
				return temp.id; // ������ id ��ȯ
				
	
			} // if e
		} // for e
		// * �α��� ������ �Է��� id ��ȯ / ���н� null
		return null;	// ���н� null ��ȯ
	}
	
		// 3. ���̵�ã�� �޼ҵ�[�μ�x��ȯx] : �̸�, ����ó
	void ���̵�ã��() {
		System.out.println("-------- ���̵�ã�� ������ --------");
		// 1. �Է¹ޱ�
		System.out.println("�̸� : ");	String name = Day07_5_BookApplication.scanner.next();
		System.out.println("����ó : ");	String phone = Day07_5_BookApplication.scanner.next();
		// 2. �Է¹��� ���� �迭���� ã��
		for(Member temp : Day07_5_BookApplication.members) {
			if(temp != null && temp.name.equals(name) && temp.phone.equals(phone)) {
				System.out.println("�˸�))ȸ������ ���̵� : " + temp.id);
				return; // ������ ���� ã������ �ش� �޼ҵ� ����
			} // if e
		} // for e
		// 3. ã������ ã��id ����ϰ� ��ã������ ���� ���
		System.err.println("�˸�))������ ȸ�������� �����ϴ�.");
	}
		// 4. ��й�ȣã�� �޼ҵ�[�μ�x��ȯx] : ���̵�, ����ó
	void ��й�ȣã��() {
		System.out.println("-------- ��й�ȣã�� ������ --------");
		System.out.println("���̵� : ");	String id = Day07_5_BookApplication.scanner.next();
		System.out.println("����ó : ");	String phone = Day07_5_BookApplication.scanner.next();
		
		for(Member temp : Day07_5_BookApplication.members) {
			if(temp != null && temp.id.equals(id) && temp.phone.equals(phone)) {
				System.out.println("�˸�))ȸ���� ��й�ȣ : " + temp.password);
				return;
			} // if e
		} // for e
		System.err.println("�˸�))������ ȸ�������� �����ϴ�.");
	}
		// 5. ȸ��Ż�� �޼ҵ�
		// 6. ȸ������ �޼ҵ�
}
