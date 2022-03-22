package 팀프로젝트;


public class Controller2 {
	
//	public static ArrayList<차클래스넣기> carlist = new ArrayList<>();
//	
//	// 1. 입차메소드
//	public static void enter() {
//		// 1. 객체화
//		// 2. 리스트에 저장
//		// 3. 파일에 저장
//		
//	} // 입차 e
//	// 2. 출차메소드
//	public static void out() {
//		
//	} // 출차 e
//	// 3. 입/출차 저장 메소드
//	public static void save() {
//		try {
//			// 1. 파일출력 클래스
//			FileOutputStream outputStream = new FileOutputStream("위치");
//			// 2. 파일에 작성할 내용[리스트 내 객체 1개씩 = 한줄씩 = 게시물 1개씩]
//			for(Car car : carlist) {
//				String 저장내용 =  car.getLocation() + "," + car.getCarnum() + "," + car.getIntime() +"\n";
//			// 3. 내용[문자열] -> 바이트열 변환
//			// 4. 내보내기[write()]	
////		outputStream.write(저장내용.getBytes());		
//			
//			} // for e
//		}catch(Exception e) {
//			System.err.println("알림))파일저장 실패");
//		} // catch e
//		
//	} // 저장 e
//	// 4. 입/출차 불러오기 메소드
//	public static void load() {
//		try {
//			// 1. 파일입력클래스
//			FileInputStream inputStream = new FileInputStream("위치");
//			// 2. 바이트배열 선언
//			byte[] bytes = new byte[1000];
//			// 3. 모든 바이트 읽어와서 바이트에 저장
//	//		inputStream.read(bytes);
//			// 4. 바이트 -> 문자열 변환
//			String file = new String(bytes);
//			// 5. 문자열 자르기[한줄씩(\n) -> 1개객체]
//			String[] board = file.split("\n");
//			
//			int i = 0;
//			for(String temp : board) {
//				if(i+1 == board.length) break;
//				// 6. 문자열 자르기[한줄(,) -> 각 필드]
//				String[] field = temp.split(",");				
//				
//				
//			} // for e	
//			
//			// 6. 문자열 자르기[한줄(,) -> 각 필드]
//			// 7. 객체화
//			// 8. 리스트 담기	
//		}catch(Exception e) {}
//	
//	} // 불러오기 e
//	// 5. 매출확인 메소드
//	public static void check() {
//		
//	} // 매출확인 e

} // ce
