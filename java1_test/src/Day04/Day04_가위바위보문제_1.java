package Day04;

import java.util.Random;
import java.util.Scanner;

public class Day04_��������������_1 { // cs
	
	public static void main(String[] args) { // ms
		
		int �÷��̾�;	int ��ǻ��;
		int �÷��̾�¸��� = 0;	int ��ǻ�ͽ¸��� = 0;
		int ���Ӽ� = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("--------- ���������� ���� ---------");
			System.out.println("����(0)	����(1)	��(2)	����(3)");
			System.out.println("���� : ");	
			
			�÷��̾� = scanner.nextInt();
			
			Random random = new Random();
			��ǻ�� = random.nextInt(3);	// 0~2���� ���� �Է¹޾ƾ� �ϹǷ�
			
			
			// ��������
			if(�÷��̾�==3) {
				System.out.println("�˸�)��������");
				System.out.println("�� ���Ӽ� : " + ���Ӽ�);
				if(�÷��̾�¸���>��ǻ�ͽ¸���) {
					System.out.println("�����¸��� : �÷��̾� " + �÷��̾�¸��� + "��");
				} // if e
				else if(�÷��̾�¸���<��ǻ�ͽ¸���) {
					System.out.println("�����¸��� : ��ǻ�� " + ��ǻ�ͽ¸��� + "��");
				} // else if e
				else {
					System.out.println("�����¸� : ���º�");
					break;
				} // else e
			} // if e
			
			else if(�÷��̾�>=0 && �÷��̾�<=2){
				if((�÷��̾�==0 && ��ǻ��==2) || (�÷��̾�==1 && ��ǻ��==0) || (�÷��̾�==2 && ��ǻ��==1)) {
					System.out.println("�÷��̾� �¸�");
					�÷��̾�¸��� ++;
				} // if e
				else if((�÷��̾�==0 && ��ǻ��==0) || (�÷��̾�==1 && ��ǻ��==1) || (�÷��̾�==2 && ��ǻ��==2)) {
					System.out.println("���º�");
				} // else if e
				else {
					System.out.println("��ǻ�� �¸�");
					��ǻ�ͽ¸��� ++;
				} // else e
				���Ӽ� ++;
			} // else if e
			else {
				System.out.println("�˸�)�˼����� ��ȣ�Դϴ�.");
			} // else e
			
		} // while e
		
		
	} // me

} // ce
