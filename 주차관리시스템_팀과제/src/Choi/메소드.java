package Choi;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;

import javax.xml.crypto.Data;


public class 메소드 {
	
	public static ArrayList<Car> 차량목록 = new ArrayList<>();
	
	public static boolean 입차(String 차번, String 입차날짜, String 입차시간) {

		String mon=입차날짜.substring(0,2);
		String day=입차날짜.substring(3,4);
		for(int i=0;i<11;i++) {
			if(차량목록.get(i).get차량().equals("")) {
				
//				Car car=new Car(i, 차번,mon,day,입차시간);
			
			
			차량목록.remove(i);
//			차량목록.add(i, car);
			return true;
			}else {System.out.println("주차 할 자리가 없습니다.");}
		}return false;
	}
	
	public static void 출차() {}
	
	
	

}
