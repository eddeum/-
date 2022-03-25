package Day17;

public class Course<T> {
			// <���׸��̸�> : �ܺηκ��� ������ �ڷ���
	// 1. �ʵ�
	private String name; // ������ : ���ڿ�
	private T[] students; // �л��迭 : ??? -> �ܺο��� ���� �ڷ���[�Ű�]
	
	// 2. ������[�ܺηκ��� ������� �ο����� �޾Ƽ� �ο�����ŭ ���׸�Ÿ������ �迭�� �޸��Ҵ�]
	public Course(String name, int capacity) {
					// ������	, �ο���
		this.name = name;
		students = (T[])new Object[capacity];
					// * �Ű�Ÿ������ new(�޸��Ҵ�) �ȵ�
					// 1. new Object[�ο���] : �ο�����ŭ object �迭 ����
					// 2. object �迭 ---> T[] �迭�� ��������ȯ
					// * Object ũ������ �ֻ���[�θ�] �̱� ������ ����	
	}
	// 3. �޼ҵ�
		// ������ ȣ�� �޼ҵ�
	public String getName() {return name;}
		// �л��迭 ȣ�� �޼ҵ�
	public T[] getStudents() {return students;}
		// �л��迭�� ��ü �߰��ϱ�[ArraylistŬ���� ���� ��İ� ����]
	public void add(T t) {
		for(int i = 0; i<students.length; i++) {
			if(students[i] == null) {
				students[i] = t;
				break;
			}
		}
	}
}
