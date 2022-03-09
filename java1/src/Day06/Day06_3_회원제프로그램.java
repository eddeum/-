package Day06;

import java.util.Scanner;

public class Day06_3_ȸ�������α׷� {

	public static void main(String[] args) {
		
		// ȸ���� ���α׷�[Ŭ���� ����]
			// 0. ȸ�� ���� => ȸ�� Ŭ���� �����
				// 1. �ʵ�
					// 1. ���̵� 2. ��й�ȣ 3. �̸� 4. ��ȭ��ȣ
			// 1. �ʱ�޴�[1. ȸ������ 2. �α��� 3. ���̵�ã�� 4. ��й�ȣã��]
				// 1. ȸ������ �� �Է¹޾� ����
				// 2. �α��� �� ���̵�� ��й�ȣ�� �����ϸ� �α���ó��
				// 3. ���̵�ã��� �̸��� ��ȭ��ȣ�� �����ϸ� ���̵� ���
				// 4. ��й�ȣã��� ���̵�� ��ȭ��ȣ�� �����ϸ� ��й�ȣ�� ���
		
		// ���� �����ϴ� ���� : main�޼ҵ带 �������� ����ϱ� ���ؼ�
		Scanner scanner = new Scanner(System.in);
		Member[] memberlist = new Member[100];	// Member Ŭ������ ������� ��ü(id,pw,name,phone) 100���� ������ �� �ִ� �迭 ����
		// ���࿡ Ŭ������ ���������(�Ʒ��� ���� ����)
		// 	�� String[][] memberlist = new Member[100][4]; 
		
		while(true) {	// [�������� : X]
			
			System.out.println("-------- ȸ����[Ŭ��������] ---------");
			System.out.println("1.ȸ������ 2.�α��� 3.���̵�ã�� 4.��й�ȣã��");
			System.out.println("���� : ");	int ch = scanner.nextInt();
			
			if(ch==1) { // ȸ������
				// 1. id, password, name, phone �Է¹ޱ� => ����4��
				System.out.println("----------- ȸ������ ������ -----------");
				System.out.println("���̵� : ");	String id = scanner.next();
				System.out.println("��й�ȣ : ");	String password = scanner.next();
				System.out.println("�̸� : ");	String name = scanner.next();
				System.out.println("����ó : ");	String phone = scanner.next();
				// 2. ��ü ����
				Member member = new Member();
				// 3. �Է¹��� ����4���� ��ü �� �ʵ忡 ����
				member.id = id;
				// ��ü�� �ʵ� = �Է¹����� ����
				member.password = password;
				member.name = name;
				member.phone = phone;
				
				// * ���̵� �ߺ�üũ
					// 1. �迭 �� ��ü �� �Է��� ���̵�� ������ ���̵� ã��
				boolean idcheck = false;
				for(Member temp : memberlist) {
					// * memberlist �迭 �� ��ü���� �ϳ��� temp�� ���� �ݺ�
					if(temp != null && temp.id.equals(id)) {
						// ���࿡ �ش� ��ü �� id�� �Է¹��� id�� ������
						System.err.println("�˸�))������� ���̵��Դϴ�.");
						idcheck = true;
						break;
					} // if e
				} // for e
				if(idcheck==false) { // ���̵� �ߺ��� ���� ��� ����
					// 4. ������ ��ü�� �����ϴ� �迭�� ����
						// ���� ������ -> ���⿡ �����ϰ� �Ǹ� {}�������� ��밡���ϱ� ����
							// 1. ���� �ε��� ã��[������ �ƴϸ� ����ȸ���� �����ϱ� ����]
					int i = 0; // �ε��� ��ġ ����;
					for(Member temp : memberlist) {
						// * memberlist �迭 �� member ��ü �ϳ��� ������ temp ���� �ݺ�
						// 2. ���� �ε����� ��ü ����
						if(temp == null) { // ���࿡ �ش� ��ü�� �����̸�
							memberlist[i]= member;	// �ش� �ε����� ���� ������� ��ü�� ����
							System.out.println("�˸�))ȸ������ ����");
							break;	// for�� ������[�ȳ����� ��� ���鿡 ������ ��ü�� ����Ǳ� ����]
						} // if e
						i++; // �ε��� ����
					} // for e
				} // if e	
				
			} // if e(ȸ������ ��)
			else if(ch==2) {
				
				// 1. �Է¹ޱ�
				System.out.println("----------- �α��� ������ -----------");
				System.out.println("���̵� : ");	String loginid = scanner.next();
				System.out.println("��й�ȣ : ");	String loginpassword = scanner.next();
				
				// 2. ���� �迭[memberlist] �� �Է¹��� �� ��
				boolean logincheck = false; // true : �α��μ��� / false : �α��ν������� ���� ����
				for(Member temp : memberlist) {
					// * memberlist �� 0�� �ε������� �� �ε������� �ϳ��� temp�� ����[�迭/����Ʈ �� ��� ��ü ȣ��]
					if(temp != null && temp.id.equals(loginid) && 
							temp.password.equals(loginpassword)) {
						// * ��ü�� null �϶��� equals �Ұ�[null �ƴ� ���¿����� equals ���]
						System.out.println("�˸�))�α��� ����");
						logincheck = true; // �α��� �����ߴٴ� ǥ�� �����
					} // if e
				} // for e
				
				// 3. �α��� ���� ����
				if(logincheck == false) { // �α��μ����ÿ��� �Ʒ� �ڵ� ���� �Ұ�
					System.err.println("�˸�))������ ȸ�������� �����ϴ�.");
				} // if e
			} // else if e(�α��� ��)
			else if(ch==3) { // ���̵� ã��
				// 1. �̸��� ����ó�� �Է¹޴´�.
				System.out.println("-------- ���̵�ã�� ������ --------");
				System.out.println("�̸� : ");	String name = scanner.next();
				System.out.println("����ó : ");	String phone = scanner.next();
				// 2. �迭�� ������ �̸��� ����ó�� �ִ��� Ȯ���Ѵ�.
				boolean findcheck = false;
				for(Member temp : memberlist) {	
					if(temp != null && temp.name.equals(name) &&
							temp.phone.equals(phone)) { // 3. ������ ��ü�� ������ �ش� ���̵� ���
						System.out.println("�˸�))���̵� ã�� ����");
						System.out.println("ȸ�� ID : " + temp.id);
						findcheck = true;
						break;
					} // if e
				} // for e
				// 4. ������ ���ٰ� ���
				if(findcheck == false) {
					System.err.println("�˸�))������ ȸ�������� �����ϴ�.[���̵� ã�� ����]");
				} // if e
				
			} // else if e
			else if(ch==4) { // ��й�ȣ ã��
				System.out.println("���̵� : ");	String id = scanner.next();
				System.out.println("����ó : ");	String phone = scanner.next();
				boolean findcheck2 = false;
				for(Member temp : memberlist) {
					if(temp != null && temp.id.equals(id)&&
							temp.phone.equals(phone)) {
						System.out.println("�˸�))��й�ȣ ã�� ����");
						System.out.println("ȸ�� ��й�ȣ : " + temp.password);
						findcheck2 = true;
						break;
					} // if e
				} // for e
				
				if(findcheck2==false) {
					System.err.println("�˸�))������ ȸ�������� �����ϴ�.[��й�ȣ ã�� ����]");
				} // if e
				
			} // else if e
			
			else {System.err.println("�˸�))�� �� ���� ��ȣ�Դϴ�.");}
			
		} // while e
		
	} // me
} // ce
