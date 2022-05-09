package DDeum;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Controller {
	
	public static ArrayList<Car> carlist = new ArrayList<>();
	public static int[] totalcharge = new int[12];
	
	// 0. ��¥ �޼ҵ�
	public static boolean datecheck(String date) {
		int month = Integer.parseInt(date) / 100;
		int day = Integer.parseInt(date) % 100;
		if(month>=1 && month<=12 && day>=1 && day<=31 ) {
			return true;
		} // if e
		return false; // ��¥ ����
	} // ��¥üũ e
	
	// 0. �ð� üũ �޼ҵ�
	public static boolean timecheck(String time) {
		int hour = Integer.parseInt(time) / 100 ;
		int minute = Integer.parseInt(time) % 100 ;
		if(hour>-1 && hour<24 && minute>-1 && minute<60) {
			return true;
		} // if e
		return false; // �ð� ����

	} // �ð�üũ e
	
	// 1. �����޼ҵ�
	public static boolean carin(int cnum, String intime) {
		

		for(int i = 0; i<12; i++){
			if(carlist.get(i).getLocation().equals(null)){
//				carlist.get(i).setCnum(cnum);
//				carlist.get(i).getIntime(); ////////////////////////////////////
				save();
				return true;
			} // if e
		} // for e
		return false;
	} // ���� e
	
	// 2. �����޼ҵ�
	public static void carout() {
		
	} // ���� e
	
	// 3. ��/���� ���� �޼ҵ�
	public static void save() {
		try {
			// 1. ������� Ŭ����
			FileOutputStream outputStream = new FileOutputStream("��ġ");
			// 2. ���Ͽ� �ۼ��� ����[����Ʈ �� ��ü 1���� = ���پ� = �Խù� 1����]
			for(Car car : carlist) {
				String ���峻�� =  car.getLocation() + "," + car.getCnum() + "," + car.getIntime() +"\n";
			// 3. ����[���ڿ�] -> ����Ʈ�� ��ȯ
			// 4. ��������[write()]	
				outputStream.write(���峻��.getBytes());		
			
			} // for e
		}catch(Exception e) {
			System.err.println("�˸�))�������� ����");
		} // catch e
		
	} // ���� e
	
	// 4. ��/���� �ҷ����� �޼ҵ�
	public static void load() {
		try {
			// 1. �����Է�Ŭ����
			FileInputStream InputStream = new FileInputStream("��ġ");
			// 2. ����Ʈ�迭 ����
			byte[] bytes = new byte[1000];
			// 3. ��� ����Ʈ �о�ͼ� ����Ʈ�� ����
			InputStream.read(bytes);
			// 4. ����Ʈ -> ���ڿ� ��ȯ
			String file = new String(bytes);
			// 5. ���ڿ� �ڸ���[���پ�(\n) -> 1����ü]
			String[] board = file.split("\n");
			
			int i = 0;
			for(String temp : board) {
				if(i+1 == board.length) break;
				// 6. ���ڿ� �ڸ���[����(,) -> �� �ʵ�]
				String[] field = temp.split(",");				
			} // for e	
			
			// 6. ���ڿ� �ڸ���[����(,) -> �� �ʵ�]
			// 7. ��üȭ
			// 8. ����Ʈ ���	
		}catch(Exception e) {} // catch e
		
	} // �ҷ����� e
	
	// 5. �����ð���� �޼ҵ�
	public static int parktime(int cnum, String outtime) {
		try {
			long parktime = 0;
			int i = 0;
			for(Car temp : carlist) {
				if(temp.getCnum() == cnum) {
					String in = temp.getIntime();
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMddhhmm");
					Date indate = simpleDateFormat.parse(in);
					Date outdate = simpleDateFormat.parse(outtime);
					
					parktime = (outdate.getTime() - indate.getTime()) / 60000;
					int parktime2 =(int)parktime;
					return parktime2 ;
				} // if e
			}i++;
		}catch(Exception e)	{}
		return 0;
	} // �����ð����e

	// 6. ��ݰ�� �޼ҵ�
	public static int pay(int parkingtime) {
		try {
			int fee = 0;
			if(parkingtime<30) {
				fee = 0;
			}
			else if(parkingtime>=30 && parkingtime<1440) {
				fee = parkingtime * 100;
			}
			else if(parkingtime==1440) {
				fee = (parkingtime/1440)*50000;
			} // else if e
			else { // �����ð��� 24�ð��� �Ѿ ���
				fee = ((parkingtime/1440)*50000)+((parkingtime%1440)*100);
			} // else e
			return fee;
		}catch(Exception e) {}
		return 0; /////////////////////////////
	} // ��ݰ�� e
	
	// 7. ����Ȯ�� �޼ҵ�
	public static void sales(String date, int ���) {
		int month = Integer.parseInt(date)/100;
		switch(month) {
		case 1 : totalcharge[0] += ���; break;
		case 2 : totalcharge[1] += ���; break;
		case 3 : totalcharge[2] += ���; break;
		case 4 : totalcharge[3] += ���; break;
		case 5 : totalcharge[4] += ���; break;
		case 6 : totalcharge[5] += ���; break;
		case 7 : totalcharge[6] += ���; break;
		case 8 : totalcharge[7] += ���; break;
		case 9 : totalcharge[8] += ���; break;
		case 10 : totalcharge[9] += ���; break;
		case 11 : totalcharge[10] += ���; break;
		case 12 : totalcharge[11] += ���; break;
		} // switch e
	} // ����Ȯ�� e

}
