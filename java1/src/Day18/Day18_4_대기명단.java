package Day18;

import java.util.ArrayList;
import java.util.Scanner;

public class Day18_4_����� {
	
	public static void main(String[] args) {
		
		// ����� ���α׷�
			// �޴� : [��]1.����߰�  2.������  [������] 3. ���������
				// ����߰� : �ο����� �Է¹޾� ����ȣ ��ȯ
				// ������ : ����ȣ�� �Է¹޾� ��� ���
				// ��������� : ù��° ������� ����ȣ ȣ��
		Scanner scanner = new Scanner(System.in);
		
		int ����ȣ = 1; // ������ ����ȣ
		ArrayList<���> ����� = new ArrayList<>();
			// �������� ��� ��ü�� ������ �� �ִ� ����Ʈ��ü ����
		
		while(true) {
			
			// �ݺ����� �̿��� ����Ʈ�� ��� ��ü ȣ��
			System.out.println("����ȣ\t�ο���\t��⿹��ð�[�ε���]");
			for(��� temp : �����) {
				if(�����.indexOf(temp)==0) 	System.out.println(temp.����ȣ+"\t"+temp.�ο���+"\t �� ����");
				else						System.out.println(temp.����ȣ+"\t"+temp.�ο���+"\t"+�����.indexOf(temp)*3+"��");
			} // for e
			
			System.out.println("[��]1.����߰�  2.������  [������] 3.���������");
			int ch = scanner.nextInt();
			
			if(ch==1) {
				// 1. �Է¹��� ���� ������ ����
				System.out.println("��ȭ��ȣ : ");	String ��ȭ��ȣ = scanner.next();
				System.out.println("�ο��� : ");	int �ο��� = scanner.nextInt();
				// 2. 3�� ���� -> 1�� ��üȭ
				��� temp = new ���(����ȣ, ��ȭ��ȣ, �ο���);
				// 3. ��� �ο����� ����Ʈ�� ����
				�����.add(temp);
				����ȣ++; // * ����ȣ ����
				
			} // if e
			else if (ch==2) {
				System.out.println("����ȣ : ");	 int ��������ȣ = scanner.nextInt();
				// ����Ʈ�� ��ü �ʵ� �˻�
				for(��� temp : �����) { if(temp.����ȣ == ��������ȣ) {�����.remove(temp); break;}}
				// * ����� ����Ʈ���� �ϳ��� temp ȣ���ϴµ� ���࿡ temp�� ����ȣ�� �Է¹��� ��������ȣ�� ������ �ش� temp�� ������ �ݺ�������

			} // else if e
			else if(ch==3) {
				System.out.println("���� �տ� �ִ� ������� �����ŵ�ϴ�."); �����.remove(0); // 0��° �ε��� ����
			}
			else {}
			
		} // while e
		

	} // me

} // ce
