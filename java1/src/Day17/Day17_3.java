package Day17;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Day17_3 {
	
	public static void main(String[] args) {
		
		// CourseŬ���� ���׸��� ���Ŭ���� �ֱ�
		Course<Person> personCourse = new Course<>("�Ϲ��ΰ���", 5);
			personCourse.add(new Person("�Ϲ���"));
			personCourse.add(new Worker("������")); // O : ���Ŭ�������� ��� �޾ұ� ������ ����
			personCourse.add(new Student("�л�")); // O : ���Ŭ�������� ��� �޾ұ� ������ ����
			personCourse.add(new HighSchoolStudent("����л�")); // O : �л�Ŭ�������� ��� -> ���Ŭ�������� ��� �޾ұ� ������ ����
		// * ���׸��� ���� Ŭ������ �ڽ�Ŭ������ ���� ���� �ִ�.
		Course<Worker> workerCourse = new Course<>("�����ΰ���", 5);
			// workerCourse.add(new Person("�Ϲ���")); // X : �θ� Ŭ������ ���� ����.
			workerCourse.add(new Worker("������")); // O : ������ ����
			// workerCourse.add(new Student("�л�")); // X : �θ� Ŭ������ ������ �л�->������ ��ȯ �Ұ���
			// workerCourse.add(new HighSchoolStudent("����л�")); // X : ����л�->������ ��ȯ �Ұ���
		Course<Student> studentCourse = new Course<>("�л�����", 5);
			// studentCourse.add(new Person("�Ϲ���")); // X
			// studentCourse.add(new Worker("������")); // X
			studentCourse.add(new Student("�л�")); // O
			studentCourse.add(new HighSchoolStudent("����л�")); // O : �л� Ŭ�������� ��� �޾ұ� ������ ����
		Course<HighSchoolStudent> highschoolstudentCourse = new Course<>("����л�����", 5);
			// highschoolstudentCourse.add(new Person("�Ϲ���")); // X
			// highschoolstudentCourse.add(new Worker("������")); // X
			// highschoolstudentCourse.add(new Student("�л�")); // X
			 highschoolstudentCourse.add(new HighSchoolStudent("����л�")); // O
		
		// �޼ҵ� ȣ��
		�ڽ�������(personCourse);
		�ڽ�������(workerCourse);
		�ڽ�������(studentCourse);
		�ڽ�������(highschoolstudentCourse);
		
		// �޼ҵ� ȣ��
//		�л��ڽ�������(personCourse);
//		�л��ڽ�������(workerCourse);
		�л��ڽ�������(studentCourse);
		�л��ڽ�������(highschoolstudentCourse);
		
		�������ڽ�������(personCourse);
		�������ڽ�������(workerCourse);
//		�������ڽ�������(studentCourse);
//		�������ڽ�������(highschoolstudentCourse);
		 
			 
		// * Arraylist
//			ArrayList<Person> list = new ArrayList<>();
//			list.add(new Person("�Ϲ���"));
		
	} // me
	
	// ���ϵ�ī�� : ?[��� Ŭ���� ����]
		// Course<?> : ��� ���׸� ����
		// Course<? extends Ŭ������> : �ش� Ŭ�����κ��� ��� ����(�ڽ�) ���׸� Ŭ���� ����
		// Course<? super Ŭ������> : �ش� Ŭ�����κ��� ��� ��(�θ�) ���׸� Ŭ���� ����
	// 1.
	public static void �ڽ�������(Course<?>�ڽ����) {
						// �μ��κ��� ����ڽ��� ���׸� ����
						// �ڽ�<���> : ������׸� �ڽ��� ����
						// �ڽ�<?> : ��� ���׸� �ڽ��� ����
		System.out.println(�ڽ����.getName()+"��������� : "+Arrays.toString(�ڽ����.getStudents()));
							// Arrays : �迭 ���� �޼ҵ� ����
								// Arrays.toString(�迭��) : �ش� �迭�� ���� ��� ȣ��
	}
	
	// 2.
	public static void �л��ڽ�������(Course<? extends Student> �ڽ����) {
						// * �л� Ŭ�����κ��� ��ӹ��� ��� Ŭ������ ����
		System.out.println(�ڽ����.getName()+"��������� : "+Arrays.toString(�ڽ����.getStudents()));
	}
	// 3.
	public static void �������ڽ�������(Course<? super Worker> �ڽ���� ) {
		System.out.println(�ڽ����.getName()+"��������� : "+Arrays.toString(�ڽ����.getStudents()));
	}
	
	
	
	
	
} // ce
