package Day05;

import java.util.Scanner;

public class Day05_3_Ȯ�ι��� {
	
	public static void main(String[] args) {
		
		// p.182 7������
		int max = 0;	// �ִ밪 �����ϴ� ����
		int[] array = {1, 5, 3, 8, 2};	// ���� + �ʱ�ȭ
		
		for(int i = 0; i<array.length; i++) {
			//* i�� 0���� �迭�� ����(5)���� 1�������ϸ鼭 ���� �ݺ�ó��
			if(max<array[i])	max = array[i];
			//* ���� max���� i��° �ε����� ���� �� ũ�� max�� i��° �� ����
		} // for e			
		System.out.println("max : " + max);
		
		
		// p.182 8������
		int[][] array2 = {
				{95, 86},
				{83, 92, 96},
				{78, 83, 93, 87, 88}
		}; // int e
		
		int sum = 0;
		double avg = 0.0;
		
		int count = 0;	// ������ ����[ĭ ����]
		// 2���� �迭�� ��� ������ ȣ��
		for(int i = 0; i<array2.length; i++) { //* ���� 0���� �迭�� �����(3)�̸����� 1������
			for(int j = 0; j<array2[i].length; j++) { //* ���� 0���� �迭�� ������(2, 3, 5 -> �ึ�� �ٸ�)�̸����� 1������
				sum += array2[i][j]; // �����հ�
			} // for e
			count += array2[i].length;	// �������� �����հ�
		} // for e
		
		avg = (double)sum / count;
		
		System.out.println("sum : " + sum);
		System.out.println("avg : " + avg);
		
		// p.183 9������
		boolean run = true;	// while�� ����ġ ����
		int studentNum = 0;	// �л��� ����
		int[] scores = null;// ���� �迭
		Scanner scanner = new Scanner(System.in);	// �Է°�ü
		
		// while(true)
		while(run) { // ���ѷ���[�������� : 5�� �Է½� ����]
			System.out.println("--------------------------------------");
			System.out.println("1.�л��� 2. �����Է� 3.��������Ʈ 4.�м� 5. ����");
			System.out.println("--------------------------------------");
			System.out.println("���� : ");
			
			int selectNo = scanner.nextInt();
			
			if(selectNo==1) {	// �л��� �Է¹ޱ�
				System.out.print("�л���>");	studentNum = scanner.nextInt();
				// �Է¹��� �л� �� ��ŭ �迭���� ����
				scores = new int[studentNum]; // ȣ��(������ int�� ����)
			} // if e
			else if(selectNo==2) {	// �л� ���� �Է¹ޱ�
				for (int i = 0; i<scores.length; i++) { // �迭�� ��� �ε�����ŭ �ݺ�ó��
					System.out.printf("scores[%d] : \n", i);	scores[i] = scanner.nextInt(); // �Է¹޾� i��° �ε����� ����
				} // for e
			} // else if e
			else if(selectNo==3) {	// �л� ���� ����ϱ�
				for(int i = 0; i<scores.length; i++) { // �迭�� ��� �ε�����ŭ �ݺ�ó��
					System.out.printf("scores[%d] : %d \n" , i, scores[i]);
				} // for e
			} // else if e
			else if(selectNo==4) {
				int max2 = 0;
				int ���հ� = 0;
				double avg2 = 0.0;
				
				for(int i = 0; i<scores.length; i++) {
					
					// �ְ����� ���ϱ�
					if(max2 < scores[i])	max2 = scores[i];	// i��° �ε����� ������ ����
					// �����հ�
					���հ� += scores[i];
				} // for e
				
				// ������� ���ϱ�
				avg2 = (double)���հ� / scores.length;
				
				System.out.println("�ְ� ���� : " + max2);
				System.out.println("��� ���� : " + avg2);
			} // else if e
			else if(selectNo==5) {
				System.out.println("���α׷� ����");
				run = false; // �ݺ��� Ż�� (Ȥ�� break;�� ����ص� ������ ��������)
			} // else if e
		} // while e
		
		
		
	} // me

} // ce
