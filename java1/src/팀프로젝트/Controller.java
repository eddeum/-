package ��������Ʈ;

import java.util.Calendar;

public class Controller {
	
	// ������ȣüũ �޼ҵ�
	public static boolean carcheck(int cnum) {
		String cnum2 = String.valueOf(cnum);
		if(cnum2.length() == 4) {
			return true;
		} // if e
		return false;
	} // ������ȣ e
	
	// ��¥üũ �޼ҵ�
	public static boolean datecheck(String idate) {
		int month = Integer.parseInt(idate)/100;
		int day = Integer.parseInt(idate)%100;
		Calendar calendar = Calendar.getInstance();
		calendar.set(2022, month-1, 1);
		int eday = calendar.getActualMaximum(calendar.DAY_OF_MONTH);
		if(1<=month && month<=12 && 1<=day && day<=eday) {
			return true;
		}
		return false;
	
	} // ��¥üũ e
	
	// �ð�üũ �޼ҵ�
	public static boolean timecheck(String itime) {
		int hour = Integer.parseInt(itime)/100;
		int minute = Integer.parseInt(itime)%100;
		if(-1<hour && hour<24 && -1<minute && minute<60) {
			return true;
		} // if e
		return false;
	} // �ð�üũ e

	// ���� �޼ҵ�
	public static void carin(int cnum, String idate, String itime) {
		
	}
	// ���� �޼ҵ�
	public static void carout() {}
	// �����ð�&��ݰ�� �޼ҵ�
	public static void pay() {}
	// ����Ȯ�� �޼ҵ�
	public static void sales() {}

}
