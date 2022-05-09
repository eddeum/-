package youn;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

import youn.Car;

public class Controller {
	
	// 차량 리스트 
	public static ArrayList<Car> carlist = new ArrayList<>();
	// 모든 메소드는 static

	// 1. 입차 메소드
	public static boolean carin(String carnum, String intime) {
		for(int i = 0 ; i <=11 ; i++) { // 배열 인덱스위치를 얻기위해 i 변수 사용
			if(carlist.get(i).getCarnum().equals("")) { // 배열내 객체중 차량번호 "" 이면
				Car car = new Car(i, carnum, intime); // 매개변수로 객체 생성
				carlist.remove(i); // i번째 객체를 지우고 ( i, "" , "" )
				carlist.add(i,car); // 매개변수로 생성한 객체 삽입
				save();
				return true;
			}
		}
		
		return false;
	}

	// 2. 출차 메소드

//	public static boolean carout() {
//		carlist.get(0);
//		// 입력받은 차량번호와 카리스트에 저장된 차량번호를 비교
//		if( out.equals(carlist.get(carnum)) {
//			if(carnum == out) { //만일 두가지가 일치하면
//				//요금계산표 나타내고 출차 완료
//				System.out.println("출차가 완료되었습니다.");
//			}

	public static boolean carout(String out) { //요금 제외


		for(int i = 0; i<carlist.size(); i++) { //i가 0이고 주차장을 하나씩 비교해서 올라가고
			if(carlist != null && carlist.get(i).getCarnum().equals(out)) {
				//주차장이 비어있지 않고 입력한 차량번호와 비교
				
				carlist.remove(i); //동일한 인덱스를 삭제(차량번호 삭제)
				
				///****
				Car car = new Car(i, "", ""); //null이 되지않도록 "" 계속 추가
				//인덱스를 삭제했으므로 인덱스를 다시 추가하고
				// 삭제된 []를 추가하기 위해 새로운 car 생성
				// 하지않을시: 공간 하나가 완전히 삭제됨
				
				//삭제된 car를 추가
				carlist.add(i, car); //
				save(); // 파일내에서 삭제된 리스트 업데이트
				
				return true;
			} else { //같지 않을 경우
				}
		} //for end
		return false;
				 
			} //car out end
	
	//view를 이용해 출력했을 때 출차 후 [] 자리 남음

	
	// 3. 요금계산 메소드
	public static void pay() {
		//출차 메소드와 연계
		
		

	}
	
	// 4. 차량리스트 저장메소드
	public static void save() {
		
	}
	// 5. 차량 리스트 불러오기메소드
	public static void load() { 
	
	}

}