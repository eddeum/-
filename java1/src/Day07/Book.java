package Day07;

public class Book {

	// 1. �ʵ�
	String ISBN;	// ISBN[������ȣ = �ĺ���]
	String bname;	// ������
	String bwriter;	// �۰�
	boolean brental;// �����뿩����
	String mid;		// �뿩��ID
	
	// 2. ������
		// 1. ������� : �޼ҵ�ȣ���
	public Book() {}
		
		// 2. Ǯ������[����ʵ带�޴»�����] : �������
	public Book(String iSBN, String bname, String bwriter, boolean brental, String mid) {
		ISBN = iSBN;
		this.bname = bname;
		this.bwriter = bwriter;
		this.brental = brental;
		this.mid = mid;
	}
	
	// 3. �޼ҵ�
		// 1. �����˻�
	void �����˻�() {
		System.out.println("---------- �����˻� ������ ----------");
//		System.out.println("������ �˻� : "); String bname = Day07_5_BookApplication.scanner.next();
//		System.out.println("");
		
//		for(Book temp : Day07_5_BookApplication.booklist) {
//			if(temp != null && temp.bname.equals(bname)) {
//				System.out.printf("�����ڵ�:%s\t������:%s\t�۰�:%s\t�����뿩����:%s\t�뿩��ID:%s \n"
//						,temp.ISBN, temp.bname, temp.bwriter, temp.brental, temp.mid);
//				return;
//			} // if e
//		} // for e
//		System.err.println("�˸�))������ å�� ã�� �� �����ϴ�.");
	} // void e
	
		// 2. �������
	void �������() {
		System.out.println("---------- ������� ������ ----------");
		System.out.println("�����ڵ�\t������\t�۰�\t�뿩���ɿ���");
		
		for(Book temp : Day07_5_BookApplication.booklist) {
			if(temp != null) { // ������ �����ϸ�
				if(temp.brental)	// �����뿩�� �����ϸ�
					System.out.println(temp.ISBN+"\t"+temp.bname+"\t"+temp.bwriter+"\t"+"�뿩����");
				else // �ش絵���� �����뿩���ΰ� false
					System.out.println(temp.ISBN+"\t"+temp.bname+"\t"+temp.bwriter+"\t"+"�뿩��");
			} // if e	
		} // for e
	} // void e
	
		// 3. �����뿩
	void �����뿩(String loginid) {
		System.out.println("---------- �����뿩 ������ ----------");
		System.out.println("���� ISBN : ");	String isbn = Day07_5_BookApplication.scanner.next();
		
		for(Book temp : Day07_5_BookApplication.booklist) {
			// * �ӽð�ü : �迭�̸�
				// �迭�� 0���ε������� �������ε������� �ϳ��� �ӽ� ��ü ����
				// temp ���� X -> �迭�� i��°�� ���� O
			if(temp != null && temp.ISBN.equals(isbn)) {
				if(temp.brental) {
					System.out.println("�˸�))�ش絵�� �뿩�մϴ�.");
					temp.brental = false; // �뿩������ ���� ////////////////////////�����ϱ�
					temp.mid = loginid;					////////////////////////�����ϱ�
					return;
				} // if e
				else {
					System.out.println("�˸�))�ش絵�� �뿩���Դϴ�.");
					return;
				}  // else e
			} // if e
		} // for e
		
	} // void e
	
		// 4. �����ݳ�
	void �����ݳ�(String loginid) {
		System.out.println("---------- �����ݳ� ������ ----------");
		�����뿩���(loginid);
		System.out.println("���� ISBN : ");	String isbn = Day07_5_BookApplication.scanner.next();
		for(Book temp : Day07_5_BookApplication.booklist) {
			if(temp != null && temp.ISBN.equals(isbn)) { // �Է��� isbn�� ������
				if(temp.mid.equals(loginid)) { // �뿩��Id�� ���� �α��ε�id �����ϸ�
					if(temp.brental) { // �뿩���� �ƴϸ�
						System.out.println("�˸�))���� ������ �뿩���� �ƴմϴ�.");
					} // if e
					else { // �뿩���̸�
						System.out.println("�˸�))�ݳ� �Ϸ�!!!!");
						temp.brental = true;	////////////////////////�����ϱ�
						temp.mid = null;		////////////////////////�����ϱ�
						return;
					} // else e
				} // if e
				else {
					System.out.println("�˸�))ȸ������ �뿩�� ������ �ƴմϴ�.");
				} // else e
			} // if e
		} // for e
		
		
	} // void e
	
	// * ���� �α��� �� ȸ���� �뿩���� �������
	void �����뿩���(String loginid) {
		System.out.println("---------- ������� ������ ----------");
		System.out.println("�����ڵ�\t������\t�۰�\t�����뿩����");
		
		for(Book temp : Day07_5_BookApplication.booklist) {
			if(temp != null && temp.mid.equals(loginid)) {
				// * ������ �����ϸ鼭 �뿩id�� ���� �α�����id�� ������
				System.out.println(temp.ISBN+"\t"+temp.bname+"\t"+temp.bwriter+"\t"+"�뿩��");
			} // if e	
		} // for e
	} // void e

	
	
		// 5. �������
	void �������() {
		System.out.println("---------- ������� ������ ----------");
		// 1. �Է¹ޱ�
		System.out.println("ISBN : ");	String isbn = Day07_5_BookApplication.scanner.next();
		System.out.println("������ : ");	String bname = Day07_5_BookApplication.scanner.next();
		System.out.println("�۰� : ");	String bwriter = Day07_5_BookApplication.scanner.next();
		
			// * �ߺ�üũ[isbn]
			for(Book temp : Day07_5_BookApplication.booklist) {
				if(temp != null && temp.ISBN.equals(isbn)) {
					System.err.println("�˸�))���� ������� ISBN�Դϴ�.");
					return;	// ������� �޼ҵ� ����(��Ͻ���)
				} // if e
			} // for e
		
		// 2. ��üȭ[�����뿩���� = true, �뿩ȸ��id = null]
		Book book = new Book(isbn, bname, bwriter, true, null);
		
		// 3. �迭 ����[�ֱ�]
		int i = 0;
		for(Book temp : Day07_5_BookApplication.booklist) {
			if(temp == null) {
				Day07_5_BookApplication.booklist[i]=book;
				System.out.println("�˸�))��������� �Ϸ�Ǿ����ϴ�.");
				return;
			} // if e
			i++;
		} // for e
		
	} // void e
		// 6. ��������
	void ��������() {
		System.out.println("---------- �������� ������ ----------");
	} // void e
}
