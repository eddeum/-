package Day03;

import java.util.Scanner;

public class Day03_6_����� { // cs
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
		
//		System.out.print("����5) �ټ� : ");	int line5 = scanner.nextInt();
//		for(int i = 1; i<=line5; i++) {
//			
//			// 1. ����ó��(����ó�� �����ؾ��� -> ���ʺ��� ������ ��������)
//			for(int b = 1; b<=line5-i; b++) {
//				System.out.print(" ");	// ���� => �����̽���
//			}
//			// 2. �����
//			for(int s = 1; s<=i; s++) {
//				System.out.print("*");
//			}
//			// 3. �ٹٲ�
//			System.out.println();
//		} // for e
		
		// ������6 : �Է¹��� �� �� ��ŭ ��� 
		//				i = ��	b = ����			s = ��		
		// *****	 	i=1		b=				s = 1 2 3 4 5 
		//  ****		i=2		b=1				s = 1 2 3 4
		//	 ***		i=3		b=1 2			s = 1 2 3 
		//	  **		i=4		b=1 2 3 		s = 1 2
		//	   *		i=5		b=1 2 3 4 		s = 1
		//		    	b�� 1���� �����ټ�-1 ���� 1������ ���� ��� 
		//		    	s�� 1���� �Է¹�����-�����ټ�+1 ���� �� ��� 
		
//		System.out.print("����6) �ټ� : "); int line6 = scanner.nextInt();
//		
//		for( int i =1 ; i<=line6 ; i++ ) {
//			// 1. �������
//			for( int b = 1 ; b<=i-1 ; b++ ) {
//				System.out.print(" ");
//			} // for e
//			// 2. ����� 
//			for( int s = 1 ; s<=line6-i+1; s++ ) {
//				System.out.print("*");
//			} // for e
//			// 3. �ٹٲ�
//			System.out.println();
//		} // for e
		
		// ������7 : �Է¹��� �� �� ��ŭ ��� 
		//				i = ��		b = ����			s = ��	
		//     *		i=1			b= 1 2 3 4		s = 1 					i*2 = 2-1	
		//    ***		i=2			b= 1 2 3 		s = 1 2 3 				i*2 = 4-1
		//   *****		i=3			b= 1 2 			s = 1 2 3 4 5 			i*2 = 6-1
		// 	*******		i=4			b= 1			s = 1 2 3 4 5 6 7 		i*2 = 8-1
		// *********	i=5			b=				s = 1 2 3 4 5 6 7 8 9	i*2 = 10-1
		//			b�� 1���� �Է¹�����-�����ټ� ���� 1������ ���� ��� 
		//			s�� 1���� �����ټ�*2-1 ���� 1������ ���� ��� 
		
//		System.out.print("����7) �ټ� : "); int line7 = scanner.nextInt();
//		
//		for( int i = 1 ; i<=line7 ; i++ ) {
//			// 1. �������
//			for( int b= 1 ; b<=line7-i ; b++) {
//				System.out.print(" ");
//			} // for e
//			// 2. �����
//			for( int s= 1; s<=i*2-1; s++ ) {
//				System.out.print("*");
//				// System.out.print(i); // ����8
//			} // for e
//			// 3. �ٹٲ�
//			System.out.println();
//		} // for e
		
		// ������8 : �Է¹��� �� �� ��ŭ ��� 
		//				i = ��		b = ����			s = ��	
		//     1		i=1			b= 1 2 3 4		s = 1 					i*2 = 2-1	
		//    222		i=2			b= 1 2 3 		s = 1 2 3 				i*2 = 4-1
		//   33333		i=3			b= 1 2 			s = 1 2 3 4 5 			i*2 = 6-1
		// 	4444444		i=4			b= 1			s = 1 2 3 4 5 6 7 		i*2 = 8-1
		// 555555555	i=5			b=				s = 1 2 3 4 5 6 7 8 9	i*2 = 10-1
		//			b�� 1���� �Է¹�����-�����ټ� ���� 1������ ���� ��� 
		//			s�� 1���� �����ټ�*2-1 ���� 1������ ���� ��� 
		
//		System.out.println("����8) �ټ� : ");	int line8 = scanner.nextInt();
//		
//		for(int i = 1; i<=line8; i++) {
//			for(int b = 1; b<=line8-i; b++) {
//				System.out.print(" ");
//			} // for e
//			for(int s = 1; s<=i*2-1; s++) {
//				System.out.print(i);
//			} // for e
//			System.out.println();
//		} // for e
		
		// ������9
		//				i = ��		b = ����			s = ��	
		//  *********	i=1			b= 				s = 1 2 3 4 5 6 7 8 9 					
		//   *******	i=2			b= 1  			s = 1 2 3 4 5 6 7 				
		//    *****		i=3			b= 1 2 			s = 1 2 3 4 5 			
		// 	   ***		i=4			b= 1 2 3		s = 1 2 3  		
		//      *		i=5			b= 1 2 3 4		s = 1	
		//			b�� 1���� �Է¹�����-1 ���� 1������ ���� ��� 
		//			s�� 1���� �Է¹�����*2-(�����ټ�*2-1) ���� 1������ ���� ��� 
		
//		System.out.print("����9 ���� �Է� : ");	int ����9 = scanner.nextInt();
//		for( int i = 1 ; i<=����9 ; i++ ) {
//			// �������
//			for( int b = 1 ; b<=i-1 ; b++ ) {System.out.print(" ");}
//			//�����
//			for( int s = 1 ; s<= ����9*2 - (i*2-1) ; s++ ) {System.out.print("*");}
//			//�ٹٲ�
//			System.out.println();
//		}
//		
		// ������10
		
		System.out.print("����10 ���� �Է� : ");	int ����10 = scanner.nextInt();
		for( int i = 1 ; i<=����10/2 ; i++ ) {
			// 1. �������
			for( int b= 1 ; b<=����10/2-i ; b++) {
				System.out.print(" ");
			}
			// 2. �����
			for( int s= 1; s<=i*2-1; s++ ) {
				System.out.print("*");
			}
			// 3. �ٹٲ�
			System.out.println();
		}
		for( int i = 1 ; i<=����10/2 ; i++ ) {
			// �������
			for( int b = 1 ; b<=i-1 ; b++ ) {System.out.print(" ");}
			//�����
			for( int s = 1 ; s<= ����10/2*2 - (i*2-1) ; s++ ) {System.out.print("*");}
			//�ٹٲ�
			System.out.println();
		}
		
		// ������11
		System.out.print("����11 ���� �Է� : ");	int ����11 = scanner.nextInt();
		
		for( int i = 1 ; i<=����11 ; i++ ) { // i = �� = ���� 
			for( int j = 1 ; j<=����11 ; j++ ) { // j = �� = ���� 
				if( i == j ) System.out.print("*"); // �� = �� ������ ��� ����� 
				else if( (i+j) == (����11+1) ) System.out.print("*"); // �� �� ���� ���Ѱ��� �ִ��ټ�+1 �� ������ ��� �����
				else System.out.print(" ");
			}
			// �ٹٲ� 
			System.out.println();
		}
		
		//������12
		
		System.out.print("����12 ���� �Է� : ");	int N = scanner.nextInt();
	      int col = 0;
	      int space = 2;
	      
	      for(int i=1; i<=N; i++) {
	         for(int j=0; j<i; j++)
	            System.out.print("*");
	         
	         for(int j=(i-1)*2; j<(N*2)-2; j++)
	            System.out.print(" ");
	         for(int j=0; j<i; j++)
	            System.out.print("*");
	         
	         System.out.println();
	      }
	      
	      for(int i=N; i<(N*2)-1; i++) {
	         for(int j=col; j<N-1; j++)
	            System.out.print("*");
	         
	         for(int j=0; j<space; j++)
	            System.out.print(" ");
	         
	         for(int j=col; j<N-1; j++)
	            System.out.print("*");
	         
	         System.out.println();
	         col ++;
	         space += 2;
	      }
		
	      //������13
	      	System.out.print("����13 ���� �Է� : "); 	 int n = scanner.nextInt();
	         
	        String map[] = new String[n];
	        map[0] = "  *  ";
	        map[1] = " * * ";
	        map[2] = "*****";
	         
	        for (int k = 1; 3 * (int)Math.pow(2, k) <= n; ++k) {
	        	
	        	 int bottom = 3 * (int)Math.pow(2, k);
	             int middle = bottom / 2;
	              
	             for (int i = middle; i < bottom; ++i) {
	                 map[i] = map[i - middle] + " " + map[i -middle];
	             }
	              
	             String space2 = "";
	             while (space2.length() < middle) {
	                 space2 += " ";
	             }
	             for (int i = 0; i < middle; ++i) {
	                 map[i] = space2 + map[i] + space2;
	             }
	            
	        }
	         
	        for (int i = 0; i < n; ++i) {
	            System.out.println(map[i]);
	        }
		
	} // me

} //ce
