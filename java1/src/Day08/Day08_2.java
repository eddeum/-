package Day08;

public class Day08_2 {
	
	public static void main(String[] args) {
		
		
		// p.245 : final
			// 최종적 뜻
			// 고정값 만들기
			// 사용되는 방법 : 1. 필드 선언시  2. 생성자에서
		
		// 1. 객체생성
		Person p1 = new Person("123456-1234567", "계백");
		
		// 2. 객체내 필드 수정
//		p1.nation = "USA";			// final 필드이면 수정불가
//		p1.ssn = "123456-9876543";	// 수정불가
		p1.name = "유재석";			// final 필드가 아닌경우 수정가능
		
		
		
	} // me

} // ce
