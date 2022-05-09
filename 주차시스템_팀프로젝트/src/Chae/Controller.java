package Chae;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Controller  {
	
	// ���� ����Ʈ , ����׹迭
	public static ArrayList<Car> carlist = new ArrayList<>();
	public static int[] totalcharge = new int[12];
	
	// ��� �޼ҵ�� static
	
	// 0 . ��¥üũ �޼ҵ�
	public static boolean checkdate(String date) {
		Calendar calendar = Calendar.getInstance(); // �Է¹��� ���� ���������� ���ϱ� ���� ��ü ����
		String month = date.substring(0,2); // �Է¹��� ����4�ڸ��� ��, �Ϸ� ����
		String day = date.substring(2,4); // �Է¹��� ����4�ڸ��� ��, �Ϸ� ����
		calendar.set(2022, Integer.parseInt(month)-1, 1); // �������� ���ϱ����� �Է¹��� ���� calendar ����
		int eday = calendar.getActualMaximum(calendar.DAY_OF_MONTH); // �Է¹��� ���� ���������� ����
		if(1 <=Integer.parseInt(month) && Integer.parseInt(month) <= 12) { // �Է¹������� 1~12���ϰ��
			if(1 <= Integer.parseInt(day) && Integer.parseInt(day) <= eday) { // �Է¹������� 1~�������� ���
				return true; // ���� ��ȯ
			}
			return false ; // ���� [��¥ �߸��Է�]
		}
		return false ;  // ���� [��¥ �߸��Է�]
	}
	
	// 0. �ð�üũ �޼ҵ�
	public static boolean checktime(String time) {
		String hour = time.substring(0,2); // �Է¹��� �ð� 4�ڸ��� ��, ������ ����
		String minute = time.substring(2,4); // �Է¹��� �ð� 4�ڸ��� ��, ������ ����
		if(0 <= Integer.parseInt(hour) && Integer.parseInt(hour) < 24) { // �Է¹����ð��� 0��~23�� �ϰ��
			if(0 <= Integer.parseInt(minute) && Integer.parseInt(minute) < 60) { // �Է¹��� ���� 0~59�� �ϰ��
				return true ; // ���� ��ȯ
			}
			return false ; // ���� [ �ð� �߸��Է� ]
		}
		return false ; // ���� [ �ð� �߸��Է� ]
	}
	
	// 0. �����ð� üũ �޼ҵ�
	public static boolean checkouttimedate (String carnum, String outtime) {
		int i = 0 ; // �Է��� ����ȣ�� �ε��� ��ȣ�� ã������ ���� ����
		for (Car temp : carlist) {
			if(temp.getCarnum().equals(carnum)) {
				break;
			}
			i++;
		}
		long diffTime = 0 ;
		try {
			Date in = new SimpleDateFormat("MMddhhmm").parse(carlist.get(i).getIntime());
			Date out = new SimpleDateFormat("MMddhhmm").parse(outtime);
			diffTime = (out.getTime() - in.getTime()) / 60000 ; // �����ð�-�����ð� �� ������ ���
		}
		catch (Exception e) {
		}
		if (diffTime > 0 ) { // �����ð��� 0 ���� Ŭ�� ( �����ð��� ���� �����ð��� �������)
			return true;
		}
		else{ // �� �� �Է��� �����ð��� �����ð� ������ ���
			return false;
		}
		
	}
	

	// 1. ���� �޼ҵ�
	public static boolean carin(String carnum, String intime) {
		for(int i = 0 ; i <=11 ; i++) { // �迭 �ε�����ġ�� ������� i ���� ���
			if(carlist.get(i).getCarnum().equals("")) { // �迭�� ��ü�� ������ȣ "" �̸�
				Car car = new Car(i, carnum, intime); // �Ű������� ��ü ����
				carlist.remove(i); // i��° ��ü�� ����� ( i, "" , "" )
				carlist.add(i,car); // �Ű������� ������ ��ü ����
				save();
				return true;
			}
		}
		return false;
	}

	// 2. ���� �޼ҵ�
	public static String carout(String carnum) {
		for(int i = 0 ; i <=11 ; i++) { // �迭 �ε�����ġ�� ������� i ���� ���
			if(carlist.get(i).getCarnum().equals(carnum)) { // �迭�� ��ü�� ������ȣ�� �Ű������� ���� ������ȣ�� ������
				String intime = carlist.get(i).getIntime(); // ������ intime �����͸� �޾Ƽ� �����صΰ�
				carlist.remove(i); // i��° ��ü�� ����� ( i, carnum , intime )
				Car car = new Car(i, "", ""); // ������ȣ ����ִ� ��ü �����ؼ�
				carlist.add(i,car); // i�� �ε����� ����
				save();
				return intime; // ���� ������ ���� �����ð� ����
			}
		}
		return null ; // �������н� null ����
	}
	
	// 3. ��ݰ�� �޼ҵ�
	public static int pay(String carnum, String outtime, String intime) { // ������ �ð��޾Ƽ� �ð����� ���
		long diffMin = 0 ; int charge = 0 ;
		try {
			Date in = new SimpleDateFormat("MMddhhmm").parse(intime);
			Date out = new SimpleDateFormat("MMddhhmm").parse(outtime);
			diffMin = (out.getTime() - in.getTime()) / 60000 ; // �ð����̸� ������ ����Ͽ� long���� ��ȯ
			int minute = (int)diffMin ; // long�ڷ����� int�� ����ȯ
			charge  = ((minute-30)/10+1)*1000 ; // �ð�����(��) * 1000 �������
			if (minute <= 30) { // 30�� �̳� ����
				charge = 0 ;
			}
		}
		catch (Exception e) {
		}
		return charge; // ������� ��ȯ
	}
	
	// 4. ������ �޼ҵ�
	public static void volume(String date, int charge) { // ��������, ������� �Ű����� �޾Ƽ�
		String month = date.substring(0,2); // �� ���ε����� �����Ͽ� (��)
		switch(month) { // 1~12���ϰ�� totalcharge�迭�� ����
			case "01" : totalcharge[0] += charge ; break;
			case "02" : totalcharge[1] += charge ; break;
			case "03" : totalcharge[2] += charge ; break;
			case "04" : totalcharge[3] += charge ; break;
			case "05" : totalcharge[4] += charge ; break;
			case "06" : totalcharge[5] += charge ; break;
			case "07" : totalcharge[6] += charge ; break;
			case "08" : totalcharge[7] += charge ; break;
			case "09" : totalcharge[8] += charge ; break;
			case "10" : totalcharge[9] += charge ; break;
			case "11" : totalcharge[10] += charge ; break;
			case "12" : totalcharge[11] += charge ; break;
		} 
	}
		
	// 5. ��������Ʈ ����޼ҵ�
	public static void save() {		
		try {
			FileOutputStream outputStream = new FileOutputStream("C:/java/������.txt"); // ������°�ü
			for(Car temp : carlist) {
				String file = temp.getLocation()+","+temp.getCarnum()+","+temp.getIntime()+"\n"; 
				outputStream.write(file.getBytes()); // ��������
			}
		}
		catch (Exception e) {
		}	
	}
	// 6. ���� ����Ʈ �ҷ�����޼ҵ�
	public static void load() { 
		try {
			FileInputStream inputStream = new FileInputStream("C:/java/������.txt"); // �����Է°�ü
			byte[] bytes = new byte[1024]; // ����Ʈ�迭 ����
			inputStream.read(bytes); // ����Ʈ �о�ͼ� ����Ʈ�迭�� ����
			String file = new String(bytes); // ����Ʈ -> ���ڿ�
			String[] list = file.split("\n"); // ���ڿ��ڸ���
			int i = 0 ;
			for(String temp : list) {
				if( i+1 == list.length) {
					break;
				}
				String[] field = temp.split(","); // ���ڿ� �ڸ���
				Car car = new Car(Integer.parseInt(field[0]),field[1],field[2]); // ��ü����
				carlist.remove(i);
				carlist.add(i,car); // ����Ʈ ����
				i++;
			}
		}
		catch (Exception e) {
		}
		
	
	}
}
