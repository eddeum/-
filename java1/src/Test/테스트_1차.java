package Test;

import java.util.Scanner;

public class �׽�Ʈ_1�� {
	
	public static void main(String[] args) {
		
		// �迭
		�л�_1��[] �л��迭 = new �л�_1��[100];
		Scanner scanner = new Scanner(System.in);
		
		
		while(true) {
			try {
				System.out.println("�л� ���");
				// ���� ���
				System.out.println("1.��� 2.����  ���� : ");
				int ���� = scanner.nextInt();
				if(����==1) {
					System.out.println("��ȣ :");	 int ��ȣ = scanner.nextInt();
					System.out.println("�̸� :");	 String �̸� = scanner.next();
					System.out.println("���� :");	 int ���� = scanner.nextInt();
					System.out.println("���� :");	 int ���� = scanner.nextInt();
					System.out.println("���� :");	 int ���� = scanner.nextInt();
					
					int ���� = ����+����+����;
					double ��� = ����/3;
					
					�л�_1�� �л� = new �л�_1��();
					

					
					for(int i = 0; i<�л��迭.length; i++) {
						if(�л��迭[i] == null) {
							�л��迭[i] = �л�;
						} // if e
					}
					
					
				} // if e
				else if(����==2) {}
				else {}
			}
			catch(Exception e) {}
			
		} // while e
		
	} // me

} // ce
