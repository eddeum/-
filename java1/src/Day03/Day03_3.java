package Day03;

import java.util.Scanner;

public class Day03_3 { //cs
	
	public static void main(String[] args) { //ms
		
		Scanner scanner = new Scanner(System.in);
		
		// ����6(����� ���� 2��)
		// ������ �Է¹޾� ������ 90�� �̻��̸� �հ� �ƴϸ� ����
//		System.out.print("���� �Է� : ");	int ���� = scanner.nextInt();
//		if (����>=90)System.out.println("�հ�");
//		else		System.out.println("���հ�");
		
		// ����7(����� ���� ������)
		// ������ �Է¹޾� ������ 90�� �̻��̸� A���
		//			   ������ 80�� �̻��̸� B���
		//			   ������ 70�� �̻��̸� C���
		//			   �׿� �����
//		System.out.print("���� �Է� : ");	int ����2 = scanner.nextInt();
//		if (����2>=90) 		System.out.println("A���");
//		else if (����2>=80)	System.out.println("B���");
//		else if (����2>=70)	System.out.println("C���");
//		else				System.out.println("�����");
		
		// ����8 : �α��� ������
		// [�Է�] : ���̵�� ��й�ȣ�� �Է¹ޱ�
		// [����] : ȸ�����̵� admin �̰�
		//			  ��й�ȣ�� 1234 ��쿡��
		//			�α��� ���� �ƴϸ� �α��� ���� ���
//		System.out.print("���̵� : ");	String ���̵� = scanner.next();
//			// char �ڷ���[���� 1�� ����]
//			// �ڷ������� ���ڿ��� ������ �� ����.
//				// 1. String Ŭ���� ����ϸ� ���ڿ� ���尡��
//				// 2. Char �迭/����Ʈ ����ϸ� ����
//		System.out.print("��й�ȣ : ");	int ��й�ȣ = scanner.nextInt();
//			// ��ü�� ����Ұ�
//				// '�ڹ�' >= <= == > < !=[�Ұ���]
//				// �ڷ��� ����ϴ� ������ ����� ��� ����
//				// Ŭ���� ����ϴ� ��ü�� ������ ��� �Ұ� -> �޼ҵ�[�̸� �������]
//					// ���ڿ� �񱳽� .equals
//					// ���ڿ�1.equals(���ڿ�2)
//		boolean	�α��μ��� = false;
//			// boolean : 1��Ʈ(true Ȥ�� false ����)
//		if (���̵�.equals("admin")) {	// ���̵�� ��ü�̱� ������ == �Ұ���  // ��ü�񱳽ÿ��� .equals() ���
//				// �Է��� ���̵� admin�̸�
//			
//			if(��й�ȣ == 1234) {	// ��й�ȣ�� �ڷ��� �����̱� ������ == ����
//					// �Է��� ��й�ȣ�� 1234dlf �̸�
//				
//				System.out.println("�α��� ����");
//				�α��μ��� = true;	// ���̵�� ��й�ȣ�� ��� �����ϸ� ������ ����
//			}
//			else {
//				System.out.println("�˸�) ��й�ȣ�� Ʋ�Ƚ��ϴ�.");
//			}
//			// �� ������ true �ΰ��
//			
//		} else { // �Է��� ���̵� admin�� �ƴϸ�
//			System.out.println("�˸�) ���̵� Ʋ�Ƚ��ϴ�.");
//		}
//		if(�α��μ��� == false)	System.out.println("�α��� ����");
			// �� ������ false �ΰ��
			// �α��� ���� ������ false �̸� ���
		
		// ����9
		// [�Է�] : ����, ����, ���� �Է¹ޱ�
		// [����] : ����� 90�� �̻��̸鼭 
		//				�������� 100�� �̸� ������ ���
		//				�������� 100�� �̸� ������ ���
		//				�������� 100�� �̸� ���п�� ���
		//		   ����� 80�� �̻��̸鼭 
		//				�������� 90���̻� �̸� '�������' ���
		//				�������� 90���̻� �̸� '��������' ���
		//				�������� 90���̻� �̸� '�������' ���
		//		    �׿� ����� 
		System.out.print("�������� : ");	int ���� = scanner.nextInt();
		System.out.print("�������� : ");	int ���� = scanner.nextInt();
		System.out.print("�������� : ");	int ���� = scanner.nextInt();
		int ��� = (����+����+����)/3;
		if (��� >= 90) {		// ��� 90�� �̻��̸�
			
			// if ��ø
			if (���� == 100)	System.out.println("������");
			if (���� == 100)	System.out.println("������");
			if (���� == 100)	System.out.println("���п��");
		}	// if e
		else if (��� >=80) {	// ��� 80�� �̻��̸�
			if (���� >= 90)	System.out.println("�������");
			if (���� >= 90)	System.out.println("�������");
			if (���� >= 90)	System.out.println("�������");	
		}	// elseif e
		else System.out.println("�����");	// �� �� �̸�
		
	} //me

} //ce
