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
	
	// ���� �޼ҵ�
	public static int ����(String ������ȣ) {
		
		java.util.Date date = new java.util.Date();
		SimpleDateFormat intime = new SimpleDateFormat("hh:mm");
		
		for(int i=0; i<parkinglist.length; i++) {
			if(parkinglist[i] == null) {
				Parking parking = new Parking(LocalDate.now(), ������ȣ, intime.format(date));
				parkinglist[i] = parking;
				return 1;
			} // if e
			else if(parkinglist[i].get������ȣ().equals(������ȣ)) {
				return 2;
			} // else if e
		} // for e
		return 3;	
	} // ���� e
	
	// ���� �޼ҵ�
	public static void ����(String ������ȣ) {
		
		java.util.Date date = new java.util.Date();
		SimpleDateFormat outtime = new SimpleDateFormat("hh:mm");
		
		for(int i = 0; i<parkinglist.length; i++) {
			if(parkinglist[i].get������ȣ().equals(������ȣ)) {
				parkinglist[i].set�����ð�(outtime.format(date));
				
				java.util.Date itime = parkinglist[i].get�����ð�();
				
			} // if e
		} // for e
	} // ���� e
	
	
	
	
	
	
	
	
	
	
} // ce
