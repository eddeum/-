package Day10;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class �Ե����� extends ���� {

	// 1. �ʵ�
	private String ����;
	private ArrayList<��ǰ> ��ǰ����Ʈ = new ArrayList<>();
	
	// 2. ������
	public �Ե�����() {}

	public �Ե�����(String ����, ArrayList<��ǰ> ��ǰ����Ʈ) {
		super();
		this.���� = ����;
		this.��ǰ����Ʈ = ��ǰ����Ʈ;
	}

	
	// 3. �޼ҵ�
	@Override
	public void ��ǰ���() {
		System.out.println("*** �Ե����� ��ǰ��� ***");
		int i = 1;
		for(��ǰ temp : ��ǰ����Ʈ) {
			System.out.print(i+ ". " + temp.get��ǰ��() + "(" + temp.get����() +")");
			i++;
		} // for e
		System.out.println();
	} // ��ǰ��� e

	@Override
	public void ��ǰ�߰�() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("*** �Ե����� ��ǰ�߰� ***");
		System.out.println("��ǰ�� : ");	String ��ǰ�� = scanner.next();
		System.out.println("��� : ");  	int ��� = scanner.nextInt();
		System.out.println("���� : ");  	int ���� = scanner.nextInt();
		
		��ǰ ��ǰ = new ��ǰ(��ǰ��, ���, ����);
		
		��ǰ����Ʈ.add(��ǰ);
		
		// * ����ó��
		try { // ����[����]�� �߻��Ұ� ���� �ڵ� ����(����)
		FileOutputStream outputStream = new FileOutputStream("D:/java/�Ե��������.txt", true);
		String �������� = ��ǰ�� +","+ ��� +","+ ���� +"\n";
		outputStream.write(��������.getBytes()); // ���ڿ�->����Ʈ
		} // try e
		catch(Exception e) {  // ����[����] ó��[���] : Exception Ŭ����	
		} // catch e
		System.out.println("�˸�)��ǰ ���� �Ϸ�~");
	} // ��ǰ�߰� e
	
	
} // ce
