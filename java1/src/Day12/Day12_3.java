package Day12;

import java.io.IOException;

public class Day12_3 {

	public static void main(String[] args) throws IOException {
		
		// 도서 검색 프로그램
			// [조건]
			// 1. 입력받기[System.in.read()]
			// 2. String 배열 내 여러 도서가 저장
				// String[] 도서목록 = {
				//			"된다! 네이버 블로그&포스트"
				//			"스프링 부로 실전 활용 마스터"
				//			"Tucker의 Go 언어 프로그래밍"
				//			"혼자 공부하는 C 언어"
				//	}
			// 3. 검색기능, 수정기능
				// 검색기능 : 특정 문자를 입력받아 도서내 포함된 문자가 있으면 모두 출력
					// 예시) '언어' 검색 -> "Tucker의 Go 언어 프로그래밍" / "혼자 공부하는 C 언어"
				// 수정기능 : 수정할 도서명의 일부를 입력받아 출력된 도서명 중 번호를 선택
					// 예시)'수정' 수정 -> 선택된 도서명의 수정할 문자와 새로운 문자 입력받아 -> 수정완료
		
		String[] 도서목록 = {"된다! 네이버 블로그&포스트", "스프링 부로 실전 활용 마스터", 
				"Tucker의 Go 언어 프로그래밍", "혼자 공부하는 C 언어"};
		
		while(true) {

				System.out.println("1.검색 2.수정");
				byte[] bytes = new byte[100];
				int count = System.in.read(bytes); // 키보드로부터 [스트림] 바이트를 읽어오기 // 일반예외 발생 -> 예외 떠넘기기
				// count : 읽어온 바이트개수 세기
				String ch = new String(bytes, 0, count-2); // 바이트배열 -> 문자열 변환[-2차감 = \n\r이 무조건 들어가기 때문에 두개를 제거해야됨]
				
				if(ch.equals("1")) {
					System.out.println("*** 검색 ***");
					System.out.println("검색 : "); count = System.in.read(bytes);
					String search = new String(bytes, 0 , count-2); // 찾을문자
					
					System.out.println("*** 검색 결과 ***");
					for(String temp : 도서목록) {
						// 방법1
//						if(temp.indexOf(search)!= -1) { // 해당 문자열내 찾을 문자의 인덱스가 존재하면
//							// indexOf 메소드에서 -1이 반환되는 경우는 동일한 단어가 없을경우 -> 검색x
//							System.out.println(temp); // 해당 문자열 내 찾을문자가 존재하면 출력
//						} // if e
						
						// 방법2
						if(temp.contains(search)) { // 문자열.contains("찾을문자") : 문자열내 찾을문자가 true[있다] / false[없다]
							System.out.println(temp);
						} // if e
					} // for e	
				} // if e
				
				else if(ch.equals("2")) {
					System.out.println("*** 수정 ***");
					System.out.println("수정할 도서명 : "); 
					count = System.in.read(bytes);					 // 키보드로부터 바이트 읽어와서 배열에 저장
					String search = new String(bytes, 0, count-2); 	// 0번인덱스 바이트부터 -2 제외한 인덱스까지
					
					int i = 0; // 인덱스
					for(String temp : 도서목록) {
						if(temp.contains(search)) {
							// 문자열.contains("찾을문자") : 문자열내 찾을문자가 true[있다] / false[없다]
							System.out.println("도서번호 : " + i+ "\t교재명: " + temp);
						} // if e
						i++;
					} // for e
					// 도서번호[인덱스] 입력받아 수정하기
					System.out.println("도서번호 선택 : ");
						count = System.in.read(bytes);
						String ch2 = new String(bytes, 0, count-2);
						// ch2 문자열로 입력받음 ----> 인덱스[숫자]변환
						int index = Integer.parseInt(ch2);
					// 수정 내용 입력받기
					System.out.println("기존 문자 : ");
						count = System.in.read(bytes);
						String oldstr = new String(bytes, 0, count-2);
					System.out.println("새로운 문자 : ");
						count = System.in.read(bytes);
						String newstr = new String(bytes, 0, count-2);
						
					// 수정처리
					도서목록[index] = 도서목록[index].replace(oldstr, newstr);
					// 배열내 도서명 = 수정된 도서명을 대입
					System.out.println("변경되었습니다.");
				} // else if e
				
				
		} // while e
		
		
	} // me
} // ce
