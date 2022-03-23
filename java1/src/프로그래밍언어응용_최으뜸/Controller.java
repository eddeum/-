package 프로그래밍언어응용_최으뜸;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Controller {
	
	public static Car[] carlist = new Car[100];
	
	// 입차메소드
	public static int 입차(String 차량번호) {
		
		for(int i = 0; i<carlist.length; i++) {
			if(carlist[i] == null) {
				Date date = new Date();
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm");
				String intime = simpleDateFormat.format(date);
				Car car = new Car(LocalDate.now(), 차량번호, intime);
				carlist[i] = car;
				return 1;	
			} // if e
			else if(carlist[i].get차량번호().equals(차량번호)) {
				return 2;
			} // else if e
		} // for e
		return 3;
	} // 입차 e
	
	// 출차메소드
	public static int 출차(String 차량번호) {
		try {
			for(int i = 0; i<carlist.length; i++) {
				if(carlist[i].get차량번호().equals(차량번호)) {
					Date date = new Date();
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm");
					String outtime = simpleDateFormat.format(date);
					carlist[i].set출차시간(outtime);
					
					long parkingtime = 0;
					Date in = simpleDateFormat.parse(carlist[i].get입차시간());
					Date out = simpleDateFormat.parse(carlist[i].get출차시간());
					parkingtime = (out.getTime()-in.getTime()) / 60000;
					int parkingtime2 = (int)parkingtime;
					
					int 금액 = 0;
						if(parkingtime2<30) {
							금액 = 0;
						} // if e
						else if(parkingtime2>=30) {
							금액 = (parkingtime2-30)/10 *1000;
						} // else if e
						return 금액;
				} // if e
				
			} // for e
		}catch(Exception e) {}	
		return 0;
	} // 출차 e
}
