package Day12;

import java.util.Random;
import java.util.Scanner;

public class Day12_4 {
	
	// ������ȣ ���� ���α׷�
	// ����
		// 1. ���� 0000~9999 ������ ���� 10���� �����ؼ� �迭�� ����
		// 2. ��� ���� ��ȣ�� �迭�� ����
		// 3. ���ڸ� ��ȣ�� Ȧ/¦ ����
		// 4. ���� ���ڸ� ��ȣ�� Ȧ���� ���� �迭�� ����
		// 5. ���� ���ڸ� ��ȣ�� ¦���� ���� �迭�� ����
		// 6. Ȧ������ �迭 ��� / ¦������ �迭 ���

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String[] carlist = new String[10];
		String[] evenlist = new String[10];
		String[] oddlist = new String[10];
		
		
		while(true) {
			
			// ��� ���� ��ȣ ���
			System.out.println("*** �������� ��� ������ȣ ***");
			for(String temp : carlist) {
				if(temp != null) System.out.println(temp);}
			
			for(String temp : carlist) {
				if(temp != null) {
					if(Integer.parseInt(temp)%2 == 0) { // ��%2 == 0 �������� 0�̸� ¦��
						System.out.println(temp+"[¦]");
						
						
						
			
			// Ȧ������ ��ȣ ���
			System.out.println("*** �������� ��� Ȧ�� ������ȣ ***");
		
						for(int i = 0; i<evenlist.length; i++) {
							if(evenlist[i] == null) {evenlist[i] = temp; break;}
						} // for e
						
					} // if e
					
					else { // ��%2 == 1 �������� 1�̸� ¦��
						System.out.println(temp+"[Ȧ]");
					}
				} // if e
				
			} // for e
			// ¦������ ��ȣ ���
			System.out.println("*** �������� ��� ¦�� ������ȣ ***");
			
			
			System.out.println("1.��������"); int ch = scanner.nextInt();
			if(ch==1) {
				// ������ȣ ���� ����
				Random random = new Random(); // ���� ��ü
				int intnum = random.nextInt(10000); // 0~9999 �� ���� �߻�
				String strnum = String.format("%04d", intnum); // %4d�� ��쿡�� �����̻��� -> 0769 -> ����769
												// ����
												// %d:����  %f:�Ǽ�  %s:���ڿ�  %c:����
												// %����d : ���ڸ�ŭ �ڸ���[���� �ش� �ڸ����� ������ ����]
												// %0����d : ���ڸ�ŭ �ڸ���[���� �ش� �ڸ����� ������ 0]
				// �迭�� ������ ã�� ������ȣ ����
				boolean save = false;
				for(int i = 0; i<carlist.length; i++) {
					if(carlist[i]==null) carlist[i] = strnum; save = true; break;
				} // for e
				
				// ¦��Ȧ�� �����й�
				
				
				
				
				
				
				
				// ���࿡ ������� ������ ����
				if(save==false) System.out.println("����[���� �Ұ�]");
				
				
			} // if e
		} // while e
		
		
		// �ۼ�
//		String[] carlist = new String[10];
//		String[] ocarlist = new String[10]; // Ȧ���迭
//		String[] ecarlist = new String[10]; // ¦���迭
//		
//		Random random = new Random();
//		int ������ȣ = random.nextInt(10000); // 0~9999 �� �����߻�
//		
//		int i = 0;
//		for(String temp : carlist) {
//			carlist[i] = ������ȣ;
//		} // for e
//		
		
	} // me

}
