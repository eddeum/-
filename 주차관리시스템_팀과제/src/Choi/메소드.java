package Choi;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;

import javax.xml.crypto.Data;


public class �޼ҵ� {
	
	public static ArrayList<Car> ������� = new ArrayList<>();
	
	public static boolean ����(String ����, String ������¥, String �����ð�) {

		String mon=������¥.substring(0,2);
		String day=������¥.substring(3,4);
		for(int i=0;i<11;i++) {
			if(�������.get(i).get����().equals("")) {
				
//				Car car=new Car(i, ����,mon,day,�����ð�);
			
			
			�������.remove(i);
//			�������.add(i, car);
			return true;
			}else {System.out.println("���� �� �ڸ��� �����ϴ�.");}
		}return false;
	}
	
	public static void ����() {}
	
	
	

}
