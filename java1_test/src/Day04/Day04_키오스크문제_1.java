package Day04;

import java.util.Scanner;

public class Day04_Ű����ũ����_1 { // cs
	
	public static void main(String[] args) { // ms
		
		Scanner scanner = new Scanner(System.in);
		
		int �ݶ���� = 10;	int ȯŸ��� = 10;	int ���̴���� = 10;
		int �ݶ󱸸ż� = 0;	int ȯŸ���ż� = 0;	int ���̴ٱ��ż� = 0;
		
		while(true) {
			System.out.println("------------------- �޴� -------------------");
			System.out.println("1. �ݶ�[300] 2. ȯŸ[200] 3. ���̴�[100] 4. ����");
			System.out.println(">>> ���� :");	int ���� = scanner.nextInt();
			
			if(����==1) {
				if(�ݶ󱸸ż�==0) {
					System.out.println("�˸�)��� �����մϴ�.");
				} // if e
				else {
				System.out.println("�ݶ� ��ҽ��ϴ�.");
				�ݶ󱸸ż�++;
				�ݶ����--;
				} // else e
			} // if e
			else if(����==2) {
				if(ȯŸ���ż�==0) {
					System.out.println("�˸�)��� �����մϴ�.");
				} // if e
				else {
				System.out.println("ȯŸ�� ��ҽ��ϴ�.");
				ȯŸ���ż�++;
				ȯŸ���--;
				} // else e
			} // else if e
			else if(����==3) {
				if(���̴ٱ��ż�==0) {
					System.out.println("�˸�)��� �����մϴ�.");
				} // if e
				else {
				System.out.println("���̴ٸ� ��ҽ��ϴ�.");
				���̴ٱ��ż�++;
				���̴����--;
				} // else e
			} // else if e
			else if(����==4) {
				System.out.println("---------------- ���� ��ǰ��� ----------------");
				System.out.println("��ǰ��\t����\t�ݾ�");
				if(�ݶ󱸸ż�>=1) {System.out.println("�ݶ�\t" + �ݶ󱸸ż� + "\t" + (�ݶ󱸸ż�*300));}
				if(ȯŸ���ż�>=1) {System.out.println("ȯŸ\t" + ȯŸ���ż� + "\t" + (ȯŸ���ż�*200));}
				if(���̴ٱ��ż�>=1) {System.out.println("���̴�\t" + ���̴ٱ��ż� + "\t" + (���̴ٱ��ż�*100));}
				int �Ѱ����� = (�ݶ󱸸ż�*300)+(ȯŸ���ż�*200)+(���̴ٱ��ż�*100);
				System.out.println("��ǰ �� ������ : " + �Ѱ����� + "��");
				System.out.println("--------------------------------------------");
				System.out.println("1. ����	2. ���"); int ����2 = scanner.nextInt();
				
				if(����2==1) {
					while(true) {
						System.out.println("�ݾ� : ");	int �ݾ� = scanner.nextInt();			
						if(�ݾ�<�Ѱ�����) {
							System.out.println("�˸�)�ݾ��� �����մϴ�.");
						} // if e
						else {
							System.out.println("������ �Ϸ�Ǿ����ϴ�.");
							System.out.println("�ܵ��� " +(�ݾ�-�Ѱ�����)+ "�� �Դϴ�.");
							�ݶ󱸸ż� = 0;	ȯŸ���ż� = 0;	���̴ٱ��ż� = 0;
							break;
						} // else e
					} // while e
				} // if e
				else if(����2==2) {
					System.out.println("�˸�)���Ÿ�� ��� ����� ");
					�ݶ����+=�ݶ󱸸ż�;	ȯŸ���+=ȯŸ���ż�;	���̴����+=���̴ٱ��ż�;
					�ݶ󱸸ż� = 0;	ȯŸ���ż� = 0;	���̴ٱ��ż� = 0;
				}
				else {
					System.out.println("�˸�)�˼����� ��ȣ�Դϴ�.");
				} // else e
				
			} // else if e
			else {
				System.out.println("�˸�)�˼����� ��ȣ�Դϴ�.");
			} // else e
			
				
				
 		} // while e
		
	} //me

} // ce

// 22.03.05