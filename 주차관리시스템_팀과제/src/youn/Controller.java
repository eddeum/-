package youn;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

import youn.Car;

public class Controller {
	
	// ���� ����Ʈ 
	public static ArrayList<Car> carlist = new ArrayList<>();
	// ��� �޼ҵ�� static

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

//	public static boolean carout() {
//		carlist.get(0);
//		// �Է¹��� ������ȣ�� ī����Ʈ�� ����� ������ȣ�� ��
//		if( out.equals(carlist.get(carnum)) {
//			if(carnum == out) { //���� �ΰ����� ��ġ�ϸ�
//				//��ݰ��ǥ ��Ÿ���� ���� �Ϸ�
//				System.out.println("������ �Ϸ�Ǿ����ϴ�.");
//			}

	public static boolean carout(String out) { //��� ����


		for(int i = 0; i<carlist.size(); i++) { //i�� 0�̰� �������� �ϳ��� ���ؼ� �ö󰡰�
			if(carlist != null && carlist.get(i).getCarnum().equals(out)) {
				//�������� ������� �ʰ� �Է��� ������ȣ�� ��
				
				carlist.remove(i); //������ �ε����� ����(������ȣ ����)
				
				///****
				Car car = new Car(i, "", ""); //null�� �����ʵ��� "" ��� �߰�
				//�ε����� ���������Ƿ� �ε����� �ٽ� �߰��ϰ�
				// ������ []�� �߰��ϱ� ���� ���ο� car ����
				// ����������: ���� �ϳ��� ������ ������
				
				//������ car�� �߰�
				carlist.add(i, car); //
				save(); // ���ϳ����� ������ ����Ʈ ������Ʈ
				
				return true;
			} else { //���� ���� ���
				}
		} //for end
		return false;
				 
			} //car out end
	
	//view�� �̿��� ������� �� ���� �� [] �ڸ� ����

	
	// 3. ��ݰ�� �޼ҵ�
	public static void pay() {
		//���� �޼ҵ�� ����
		
		

	}
	
	// 4. ��������Ʈ ����޼ҵ�
	public static void save() {
		
	}
	// 5. ���� ����Ʈ �ҷ�����޼ҵ�
	public static void load() { 
	
	}

}