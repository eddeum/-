package Day10;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Day10_키오스크_1 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		ArrayList<상품> 상품리스트 = new ArrayList<>();
		
		try {
			FileInputStream inputStream = new FileInputStream("D:/java/롯데리아재고.txt");
			byte[] bytes = new byte[1024]; 			// 바이트 배열 선언
			inputStream.read(bytes); 				// 읽어와서 배열에 저장
			String 파일내용 = new String(bytes); 		// 바이트열 -> 문자열
			String [] 상품목록 = 파일내용.split("\n"); 	// String 자르기 메소드 = split("기준");
		
			for(String temp : 상품목록) {
				String[] 필드목록 = temp.split(",");
				상품 상품 = new 상품(필드목록[0],
						Integer.parseInt(필드목록[1]),
						Integer.parseInt(필드목록[2]));
			
				상품리스트.add(상품);
			} //for e
		
		} // try e
		catch(Exception e) {
		} // catch e
		
		키오스크 롯데리아 = new 롯데리아("유재석", 상품리스트);
		
		while(true) {
			
			롯데리아.제품목록();
			int ch = scanner.nextInt();
			if(ch==1) { // 관리자모드라 가정
				롯데리아.상품추가();
			} // if e
			else if(ch==2) {
				롯데리아.장바구니();
			} // else e
		} // while e
	} // me
	
} // ce
