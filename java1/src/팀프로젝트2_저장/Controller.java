package ��������Ʈ2_����;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import ddeum.Room;

public class Controller {
	
	public static ArrayList<Room> roomlist = new ArrayList<>();
	
	public static boolean ��¥üũ(String ��¥) {
		Calendar calendar = Calendar.getInstance(); // �Է¹��� ���� ������ ���� ���ϱ� ����
		int month = Integer.parseInt(��¥) / 100; // �Է¹��� ��¥ 4�ڸ����Ŀ��� ���� 2�ڸ��� '��'�� ����
		int day = Integer.parseInt(��¥) % 100; // �Է¹��� ��¥ 4�ڸ����Ŀ��� ���� 2�ڸ��� '��'�� ����
		calendar.set(2022, month-1, 1); // �Է¹��� ���� ���������ڸ� ���ϱ� ���� �� 1�Ϸ� ����
		int eday = calendar.getActualMaximum(calendar.DAY_OF_MONTH); // �Է¹��� ���� ���������� ����
		if(month>=1 && month<=12 && day>=1 && day<=eday) {
			return true;
		} // if e
		return false;
	} // ��¥üũ e
	public static void ����(String ��¥) {
		
		boolean[] ���డ�� = new boolean[5];
		for(Room temp : roomlist) { // roomlist�� �ִ� ����Ʈ�� temp�� �����Ͽ�
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMdd"); // ��¥�� MM(��)dd(��)�� String ������ ��ü����
			if(simpleDateFormat.format(temp.getDate()).equals(��¥)) { // temp���� ��¥�� �Է¹��� ��¥�� �����ϰ�
				if(temp.getRname().equals("Ʈ����")) { // temp���� ���̸��� Ʈ����� �����ϸ�
					���డ��[0] = true;
				} // if e
				if(temp.getRname().equals("�����")) {
					���డ��[1] = true;
				} // if e
				if(temp.getRname().equals("�ٴٺ�Ʈ����")) {
					���డ��[2] = true;
				} // if e
				if(temp.getRname().equals("�ٴٺ�����")) {
					���డ��[3] = true;
				} // if e
				if(temp.getRname().equals("����Ʈ��")) {
					���డ��[4] = true;
				} // if e
				
			} // if e
			
		} // for e
		
		
	} // ���� e
	

}
