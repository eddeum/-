package Test2;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.text.DateFormatter;

public class Controller {
	
	public static Parking[] parkinglist = new Parking[100];
	
	// 입차 메소드
	public static int 입차(String 차량번호) {
		
		java.util.Date date = new java.util.Date();
		SimpleDateFormat intime = new SimpleDateFormat("hh:mm");
		
		for(int i=0; i<parkinglist.length; i++) {
			if(parkinglist[i] == null) {
				Parking parking = new Parking(LocalDate.now(), 차량번호, intime.format(date));
				parkinglist[i] = parking;
				return 1;
			} // if e
			else if(parkinglist[i].get차량번호().equals(차량번호)) {
				return 2;
			} // else if e
		} // for e
		return 3;	
	} // 입차 e
	
	// 출차 메소드
	public static void 출차(String 차량번호) {
		
		java.util.Date date = new java.util.Date();
		SimpleDateFormat outtime = new SimpleDateFormat("hh:mm");
		
		for(int i = 0; i<parkinglist.length; i++) {
			if(parkinglist[i].get차량번호().equals(차량번호)) {
				parkinglist[i].set출차시간(outtime.format(date));
				
				java.util.Date itime = parkinglist[i].get입차시간();
				
			} // if e
		} // for e
	} // 출차 e
	
	
	
	
	
	
	
	
	
	
} // ce
