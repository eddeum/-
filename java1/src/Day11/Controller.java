package Day11;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class Controller {

	// 모든 메소드는 static
	// C(등록)R(읽기)U(수정)D(삭제)
	
	// 0. 게시물 리스트
	public static ArrayList<Board> boardlist = new ArrayList<>();
	
	
	// 2. 쓰기메소드
	public static void write(String 제목, String 내용, String 작성자, String 비밀번호) {
		// 1. 객체화[변수가 4개 -> 1개 객체]
		Board board = new Board(제목, 내용, 작성자, 비밀번호);
		// 2. 리스트에 저장
		boardlist.add(board);
		// 3. 파일에 저장
		save();
		
	} // 쓰기 e

	// 4. 수정메소드
	public static void update() {}
	// 5. 삭제메소드
	public static void delete() {
		
	} // 삭제 e
	// 6. 댓글쓰기메소드
	public static void replywrite() {}
	// 7. 게시물저장/수정메소드
	public static void save() {
		// 리스트내 모든 게시물을 파일에 저장
		try {
			// 1. 파일출력 클래스
			FileOutputStream outputStream = new FileOutputStream("D:/java/게시물파일.txt");
			// 2. 파일에 작성할 내용[리스트 내 객체 1개씩 = 한줄씩 = 게시물 1개씩]
			for(Board board : boardlist) {
				String 작성내용 = board.getTitle()+","+board.getContent()+","+
						board.getPassword()+","+board.getWriter()+","+
						board.getViewcount()+","+board.getDate()+"\n";
			// 3. 내용[문자열] -> 바이트열 변환
			// 4. 내보내기[write()]				
				outputStream.write(작성내용.getBytes());
			} // for e

		}// try e
		catch(Exception e) {
			System.err.println("알림]]파일저장 실패(관리자에게 문의)");
		} // catch e
	
	} // 게시물저장 e
	
	// 8. 게시물불러오기메소드[프로그램 시작]파일 ---> 리스트
	public static void load() {
		try {
			FileInputStream inputStream = new FileInputStream("D:/java/게시물파일.txt");	// 1. 파일입력클래스
			byte[] bytes = new byte[1000];			// 2. 바이트배열 선언
			inputStream.read(bytes);				// 3. 모든 바이트 읽어와서 바이트에 저장
			 String file = new String(bytes);		// 4. 바이트 -> 문자열 변환
			 String[] boards = file.split("\n");	// 5. 문자열 자르기[한줄씩(\n) -> 1개객체]
			 
			 int i = 0;
			 for( String temp : boards) { // 배열내 문자열 하나씩 꺼내기
				 if(i+1 == boards.length) break;	// 마지막 인덱스[객체]제외 -> 마지막 아래 공백을 없애려고(\n 기준으로 쪼갤시 조각이 1개 더생김 : \n 3개 -> 조각 4개)
				 String[] field = temp.split(",");	// 6. 문자열 자르기[한줄(,) -> 각 필드
				 Board board = new Board(field[0], field[1], field[2],
						field[3], Integer.parseInt(field[4]), field[5], null);			// 7. 객체화
				 							// 조회수는 정수형이므로 형변환(Integer.parseInt(문자열)
				 boardlist.add(board);					// 8. 리스트 담기	
				 i++; // 인덱스 증가
			 } // for e
		} catch (Exception e) {
			System.out.println("알림]]파일로드 실패(관리자에게 문의)");
		} // catch e
		
	} // 게시물불러오기 e
	
	
	
} // ce
