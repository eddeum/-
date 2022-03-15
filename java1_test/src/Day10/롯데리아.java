package Day10;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class 롯데리아 extends 점포 {

	// 1. 필드
	private String 점주;
	private ArrayList<상품> 상품리스트 = new ArrayList<>();
	
	// 2. 생성자
	public 롯데리아() {}

	public 롯데리아(String 점주, ArrayList<상품> 상품리스트) {
		super();
		this.점주 = 점주;
		this.상품리스트 = 상품리스트;
	}

	
	// 3. 메소드
	@Override
	public void 제품목록() {
		System.out.println("*** 롯데리아 제품목록 ***");
		int i = 1;
		for(상품 temp : 상품리스트) {
			System.out.print(i+ ". " + temp.get상품명() + "(" + temp.get가격() +")");
			i++;
		} // for e
		System.out.println();
	} // 제품목록 e

	@Override
	public void 상품추가() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("*** 롯데리아 상품추가 ***");
		System.out.println("상품명 : ");	String 상품명 = scanner.next();
		System.out.println("재고 : ");  	int 재고 = scanner.nextInt();
		System.out.println("가격 : ");  	int 가격 = scanner.nextInt();
		
		상품 상품 = new 상품(상품명, 재고, 가격);
		
		상품리스트.add(상품);
		
		// * 파일처리
		try { // 예외[오류]가 발생할것 같은 코드 묶음(예상)
		FileOutputStream outputStream = new FileOutputStream("D:/java/롯데리아재고.txt", true);
		String 내보내기 = 상품명 +","+ 재고 +","+ 가격 +"\n";
		outputStream.write(내보내기.getBytes()); // 문자열->바이트
		} // try e
		catch(Exception e) {  // 예외[오류] 처리[잡기] : Exception 클래스	
		} // catch e
		System.out.println("알림)상품 저장 완료~");
	} // 상품추가 e
	
	
} // ce
