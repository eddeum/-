package Day03;

import java.util.Scanner;

public class Day03_6 { // cs
	public static void main(String[] args) { // ms
		
		Scanner scanner = new Scanner(System.in);	// �Է°�ü
		
//		// ������1 : �Է¹��� �� ��ŭ * ���
//		System.out.print("����1) ������ : ");	int s1 = scanner.nextInt();
//		for(int i = 1; i<=s1; i++) {
//			// * i�� 1���� �Է¹��� ������ 1������ �ϸ鼭 ���๮ �ݺ�ó��
//			System.out.print("*");
//		}
//		
		// ������2 : �Է¹��� �� ��ŭ * ���[��, 5������ �ٹٲ� ó��]
//		System.out.print("����2) ������ : ");	int s2 = scanner.nextInt();
//		for(int i = 1; i<=s2; i++) {
//			// * i�� 1���� �Է¹��� ������ i�� 1�� �����ϸ鼭 ���๮ �ݺ�ó��
//			System.out.print("*");
//			// 5������ �ٹٲ� -> 5������� -> ���ã��
//			if(i%5==0)	System.out.println(); 	// �ٹٲ� ó��
//		}
//		
		// ������3 : �Է¹��� �� ��ŭ ���
		//				i = ��		s = ��
		//	*			i = 1		s = 1
		//	**			i = 2		s = 1 2
		//	***			i = 3		s = 1 2 3
		//	****		i = 4		s = 1 2 3 4
		//	*****		i = 5		s = 1 2 3 4 5
		//				i�� 1���� �Է¹��� ������ 1������ �ٹٲ�ó��
		//				s�� 1���� ���� �ټ����� 1������ �� ���
		
//		System.out.print("����3) �ټ� : ");	int line3 = scanner.nextInt();
//		for(int i = 1; i<=line3; i++) {
//			// * i�� 1���� �Է¹��� �� ������ 1�� ����
//			
//			// 1. �����
//			for(int s = 1; s<=i; s++) {
//				System.out.print("*");
//			}
//			// 2. �ٹٲ�ó��
//			System.out.println();	
//		}
			// ������
				// ����ڰ� 3�� �Է����� ��
				// i = 1	i<=3 [true] -> i++
					// s = 1	s<=1 [true] -> * -> s++
					// s = 2	s<=1 [false] -> �ݺ�������
				// �ٹٲ�
				// i = 2	i<=3 [true]
					// s = 1 	s<=1 [true] -> * -> s++
					// s = 2 	s<=2 [true] -> * -> s++
					// s = 3	s<=3 [false] -> �ݺ�������
				// �ٹٲ�
				// i = 3	i<=3 [true
					// s = 1 	s<=1 [true] -> * -> s++
					// s = 2 	s<=2 [true] -> * -> s++
					// s = 3	s<=3 [true] -> * -> s++
					// s = 4	s<=3 [false] -> �ݺ�������
				// �ٹٲ�
				// i = 4	i<=3 [false] for1 �ݺ�������
		// ������4 : �Է¹��� �� ��ŭ ���
		//			i = ��	s = *
		//	*****	i = 1	s = 5
		//	****	i = 2	s = 4	
		//	***		i = 3	s = 3		
		//	**		i = 4	s = 2
		//	*		i = 5	s = 1
		//			i�� 1���� �Է¹��� ������ 1������ �ٹٲ� ó��
		//			s�� 1���� (�Է¹��� ��-�����ټ�+1)���� 1������ �� ���
		
//		System.out.print("����4) �ټ� : ");	int line4 = scanner.nextInt();
//		for(int i = 1; i<=line4; i++) {
//			
//			// 1. �����
//			for(int s = 1; s<=line4-i+1; s++) {
//				System.out.print("*");
//			}
//			System.out.println("");
//		}
		
		// ������5 : �Է¹��� �� ��ŭ ���	
		//			i = ��	b = ����	s = ��
		//		*	i = 1	b = 4	s = 1
		//     **	i = 2	b = 3	s = 2
		//    ***	i = 3	b = 2	s = 3
		//   ****	i = 4	b = 1	s = 4
		//	*****	i = 5	b = 0	s = 5
		//			b�� �Է¹��� �ټ�-�����ټ�
		
		System.out.print("����5) �ټ� : ");	int line5 = scanner.nextInt();
		for(int i = 1; i<=line5; i++) {
			
			// 1. ����ó��(����ó�� �����ؾ��� -> ���ʺ��� ������ ��������)
			for(int b = 1; b<=line5-i; b++) {
				System.out.print(" ");	// ���� => �����̽���
			}
			// 2. �����
			for(int s = 1; s<=i; s++) {
				System.out.print("*");
			}
			// 3. �ٹٲ�
			System.out.println();
		}
		
	} // me

} //ce
