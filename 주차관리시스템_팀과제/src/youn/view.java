package youn;

import java.util.ArrayList;
import java.util.Scanner;

import Chae.Car;

public class view {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		for (int i = 0 ; i <= 11 ; i++) { 
			// 12���� ����Ʈ ���� ������ȣ�� "" �־� ""�ϰ�� ���ڸ��� ���
			//0~11���� 1���� �þ�� �� 12�� ����
			youn.Car car = new youn.Car(i, "", "");
			//���ο� �ڵ��� ����(��Ʈ�ѷ� ����)

		Controller.carlist.add(car);
		}
		while (true) {
			System.out.println("���� ���� ���α׷�");
			int i = 1;
			for(youn.Car temp : Controller.carlist) {
				//temp
				if(temp.getCarnum() != "  ") {
					//������� carnum�� ���� ���� ��
					
					System.out.print("["+temp.getCarnum()+"]"+"\t");
				} // []���̿� carnum �߰�
				
				else if (temp.getCarnum().equals("  ")) {
					// �� �ܿ��� " "�� �� ������
					System.out.print("[    ]"+"\t");
					
				}
				//% :������ <- �� �Լ��� �̿��ؼ� 4���� �ڸ���
				if(i%4 == 0) { System.out.println(); }
				
				i++; //�ϳ�+�ؼ� �ٽ� ����
			}
				
			
			System.out.println("1. ���� 2. ���� 3. ����Ȯ��");
			int ch = scanner.nextInt();
			
			if(ch == 1) { //����
				System.out.println("���� ��ȣ�� �Է��ϼ���");
				String carnum = scanner.next();
				Controller.carin(carnum, null );
				
			} else if (ch == 2) { //����
				System.out.println("���� ��ȣ�� �Է��ϼ���.");
				String out = scanner.next();
				Controller.carout(out);
				
			}
		} // while end
		
		
		
		
/////////////////////////////////////////////////
	}

}
