package Day09;

public class Student extends People {
			// ����Ŭ���� extends ����Ŭ����
	// 1. �ʵ�
	public int studentNo;
	// 2. ������
	public Student(String name, String ssn, int studentNo) {
		// �θ�Ŭ������ ��� �ʵ� �ʱ�ȭ[���ֱ�]
		// 1. �ʵ忡 ����
//		this.name = name;
//		this.ssn = ssn;
//		this.studentNo = studentNo;
		// 2. �����ڿ� ����
		super(name, ssn);
		this.studentNo = studentNo;
	}
	// 3. �޼ҵ�
	
}
