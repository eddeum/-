package ��������Ʈ2_����;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Controller {
	
	
	
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
	
	public static boolean ����(String ��¥, String name, int ch) {
		
		Room room = new Room(true, name, ��¥);
		
		for(int i = 0; i<ȣ�ڿ���.roomlist.size(); i++) {
//			if(ȣ�ڿ���.roomlist.get(i).getRname()==null) {
			if(ch==1) {
				ȣ�ڿ���.roomlist.get(i).setRname("Ʈ����");
				ȣ�ڿ���.roomlist.add(i, room);
				return true;
			} // if e
			if(ch==2) {
				ȣ�ڿ���.roomlist.get(i).setRname("�����");
				ȣ�ڿ���.roomlist.add(i, room);
				return true;
			}
//			}
		} // for e
	
		return false;
	
	} // ���� e

	

}
