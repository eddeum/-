package ���α׷��־������_������;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Controller {
	
	public static Car[] carlist = new Car[100];
	
	// �����޼ҵ�
	public static int ����(String ������ȣ) {
		
		for(int i = 0; i<carlist.length; i++) {
			if(carlist[i] == null) {
				Date date = new Date();
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm");
				String intime = simpleDateFormat.format(date);
				Car car = new Car(LocalDate.now(), ������ȣ, intime);
				carlist[i] = car;
				return 1;	
			} // if e
			else if(carlist[i].get������ȣ().equals(������ȣ)) {
				return 2;
			} // else if e
		} // for e
		return 3;
	} // ���� e
	
	// �����޼ҵ�
	public static int ����(String ������ȣ) {
		try {
			for(int i = 0; i<carlist.length; i++) {
				if(carlist[i].get������ȣ().equals(������ȣ)) {
					Date date = new Date();
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm");
					String outtime = simpleDateFormat.format(date);
					carlist[i].set�����ð�(outtime);
					
					long parkingtime = 0;
					Date in = simpleDateFormat.parse(carlist[i].get�����ð�());
					Date out = simpleDateFormat.parse(carlist[i].get�����ð�());
					parkingtime = (out.getTime()-in.getTime()) / 60000;
					int parkingtime2 = (int)parkingtime;
					
					int �ݾ� = 0;
						if(parkingtime2<30) {
							�ݾ� = 0;
						} // if e
						else if(parkingtime2>=30) {
							�ݾ� = (parkingtime2-30)/10 *1000;
						} // else if e
						return �ݾ�;
				} // if e
				
			} // for e
		}catch(Exception e) {}	
		return 0;
	} // ���� e
}
