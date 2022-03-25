package Day17;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Day17_3 {
	
	public static void main(String[] args) {
		
		// Course클래스 제네릭에 사람클래스 넣기
		Course<Person> personCourse = new Course<>("일반인과정", 5);
			personCourse.add(new Person("일반인"));
			personCourse.add(new Worker("직장인")); // O : 사람클래스에게 상속 받았기 때문에 가능
			personCourse.add(new Student("학생")); // O : 사람클래스에게 상속 받았기 때문에 가능
			personCourse.add(new HighSchoolStudent("고등학생")); // O : 학생클래스에게 상속 -> 사람클래스에게 상속 받았기 때문에 가능
		// * 제네릭에 들어가는 클래스는 자식클래스도 같이 들어갈수 있다.
		Course<Worker> workerCourse = new Course<>("직장인과정", 5);
			// workerCourse.add(new Person("일반인")); // X : 부모 클래스는 들어갈수 없다.
			workerCourse.add(new Worker("직장인")); // O : 본인은 가능
			// workerCourse.add(new Student("학생")); // X : 부모 클래스는 같지만 학생->직장인 변환 불가능
			// workerCourse.add(new HighSchoolStudent("고등학생")); // X : 고등학생->직장인 변환 불가능
		Course<Student> studentCourse = new Course<>("학생과정", 5);
			// studentCourse.add(new Person("일반인")); // X
			// studentCourse.add(new Worker("직장인")); // X
			studentCourse.add(new Student("학생")); // O
			studentCourse.add(new HighSchoolStudent("고등학생")); // O : 학생 클래스에게 상속 받았기 때문에 가능
		Course<HighSchoolStudent> highschoolstudentCourse = new Course<>("고등학생과정", 5);
			// highschoolstudentCourse.add(new Person("일반인")); // X
			// highschoolstudentCourse.add(new Worker("직장인")); // X
			// highschoolstudentCourse.add(new Student("학생")); // X
			 highschoolstudentCourse.add(new HighSchoolStudent("고등학생")); // O
		
		// 메소드 호출
		코스명단출력(personCourse);
		코스명단출력(workerCourse);
		코스명단출력(studentCourse);
		코스명단출력(highschoolstudentCourse);
		
		// 메소드 호출
//		학생코스명단출력(personCourse);
//		학생코스명단출력(workerCourse);
		학생코스명단출력(studentCourse);
		학생코스명단출력(highschoolstudentCourse);
		
		직장인코스명단출력(personCourse);
		직장인코스명단출력(workerCourse);
//		직장인코스명단출력(studentCourse);
//		직장인코스명단출력(highschoolstudentCourse);
		 
			 
		// * Arraylist
//			ArrayList<Person> list = new ArrayList<>();
//			list.add(new Person("일반인"));
		
	} // me
	
	// 와일드카드 : ?[모든 클래스 대응]
		// Course<?> : 모든 제네릭 가능
		// Course<? extends 클래스명> : 해당 클래스로부터 상속 받은(자식) 제네릭 클래스 가능
		// Course<? super 클래스명> : 해당 클래스로부터 상속 준(부모) 제네릭 클래스 가능
	// 1.
	public static void 코스명단출력(Course<?>코스명단) {
						// 인수로부터 모든코스의 제네릭 받음
						// 코스<사람> : 사람제네릭 코스만 가능
						// 코스<?> : 모든 제네릭 코스가 가능
		System.out.println(코스명단.getName()+"수강생명단 : "+Arrays.toString(코스명단.getStudents()));
							// Arrays : 배열 관련 메소드 제공
								// Arrays.toString(배열명) : 해당 배열내 내용 모두 호출
	}
	
	// 2.
	public static void 학생코스명단출력(Course<? extends Student> 코스명단) {
						// * 학생 클래스로부터 상속받은 모든 클래스만 가능
		System.out.println(코스명단.getName()+"수강생명단 : "+Arrays.toString(코스명단.getStudents()));
	}
	// 3.
	public static void 직장인코스명단출력(Course<? super Worker> 코스명단 ) {
		System.out.println(코스명단.getName()+"수강생명단 : "+Arrays.toString(코스명단.getStudents()));
	}
	
	
	
	
	
} // ce
