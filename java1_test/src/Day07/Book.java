package Day07;

public class Book {

	// 1. �ʵ�
	String ISBN;
	String bname;
	String writer;
	boolean rental;
	String mid;
	
	// 2. ������
		// 1. �������
	public Book() {}
		// 2. Ǯ������

	public Book(String iSBN, String bname, String writer, boolean rental, String mid) {
		ISBN = iSBN;
		this.bname = bname;
		this.writer = writer;
		this.rental = rental;
		this.mid = mid;
	}
	
	// 3. �޼ҵ�
		// 1. �����˻� �޼ҵ�
	void �����˻�() {
		System.out.println("--------- �����˻� ������ ---------");
	} // void e
		
		// 2. ������� �޼ҵ�
	void �������() {
		System.out.println("--------- ������� ������ ---------");
		System.out.println("�����ڵ�\t������\t�۰�\t�뿩���ɿ���");
		
		for(Book temp : Day07_BookApplication.booklist) {
			if(temp != null) {
				if(temp.rental)
					System.out.println(temp.ISBN+"\t"+temp.bname+"\t"+temp.writer+"\t"+"�뿩����");
				else
					System.out.println(temp.ISBN+"\t"+temp.bname+"\t"+temp.writer+"\t"+"�뿩��");
			} // if e
		} // for e
		
	} // void e
		
		// 3. �����뿩 �޼ҵ�
	void �����뿩() {
		System.out.println("--------- �����뿩 ������ ---------");
		System.out.println("���� ISBN : ");	String isbn = Day07_BookApplication.scanner.next();
		
		for(Book temp : Day07_BookApplication.booklist) {
			if(temp != null && temp.ISBN.equals(isbn)) {
				if(temp.rental) {
					System.out.println("�˸�)�ش絵���� �뿩�մϴ�.");
					temp.rental = false;
					temp.mid = ////////////////////////
					return;
				} // if e
				else {
					System.out.println("�˸�)�ش絵�� �뿩���Դϴ�.");
					return;
				} // else e
			} // if e
		} // for e

	} // void e
		
		// 4. �����ݳ� �޼ҵ�
	void �����ݳ�() {
		System.out.println("--------- �����ݳ� ������ ---------");
		�����뿩���(loginid); //////////////////????
		System.out.println("���� ISBN : "); String isbn = Day07_BookApplication.scanner.next();
		
		for(Book temp : Day07_BookApplication.booklist) {
			if(temp != null && temp.ISBN.equals(isbn)) {
				if(temp.mid.equals(loginid)) { //////////////??????
					if(temp.rental) {
						System.out.println("�˸�)���� ������ �뿩���� �ƴմϴ�.");
					} // if e
					else {
						System.out.println("�˸�)�ݳ��Ϸ� !!");
						temp.rental = true;
						temp.mid = null;
						return;
					} // else e
				} // if e
				else {
					System.out.println("�˸�)ȸ������ �뿩�� ������ �ƴմϴ�.");
				} // else e
			} // if e
		} // for e

	} //void e
	
	// * ���� �α��� �� ȸ���� �뿩���� �������
	void �����뿩���() {
		System.out.println("--------- �����뿩��� ������ ---------");
		System.out.println("�����ڵ�\t������\t�۰�\t�����뿩����");
		
		for(Book temp : Day07_BookApplication.booklist) {
			if(temp != null && temp.mid.equals(loginid)) {
				System.out.println(temp.ISBN+"\t"+temp.bname+"\t"+temp.writer+"\t"+"�뿩��");
			} // if e
		} // for e
		
	} // void e
		
		// 5. ������� �޼ҵ�
	void �������() {
		System.out.println("--------- ������� ������ ---------");
		System.out.println("ISBN : ");	String isbn = Day07_BookApplication.scanner.next();
		System.out.println("������ : ");	String bname = Day07_BookApplication.scanner.next();
		System.out.println("�۰� : ");	String writer = Day07_BookApplication.scanner.next();
		
		// * ISBN �ߺ�üũ
		for(Book temp : Day07_BookApplication.booklist) {
			if(temp != null && temp.ISBN.equals(isbn)) {
				System.out.println("�˸�)���� ������� ISBN�Դϴ�.");
				return;
			} // if e
		} // for e
		
		// * ��üȭ[�����뿩���� = true(�뿩����), �뿩ȸ��id = null]
		Book book = new Book(isbn, bname, writer, true, null)
		
		int i = 0;
		for(Book temp : Day07_BookApplication.booklist) {
			if(temp == null) {
				Day07_BookApplication.booklist[i] = book;
				System.out.println("�˸�)��������� �Ϸ�Ǿ����ϴ�.");
				return;
			} // if e
			i++;
		} // for e
				
	} // void e
		
		// 6. �������� �޼ҵ�
	void ��������() {
		System.out.println("--------- �������� ������ ---------");
	} // void e

	
	
	
}
