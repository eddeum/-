package Test;

import java.util.Scanner;

public class Day06_ȸ�������α׷�����_2 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Member[] memberlist = new Member[100];
		
		while(true) {
			System.out.println("------------- ȸ���� -------------");
			System.out.println("1.ȸ������ 2.�α��� 3.���̵�ã�� 4.��й�ȣã��");
			System.out.println("���� : ");	int ch = scanner.nextInt();
			
			if(ch==1) {
				System.out.println("------------ ȸ������ ------------");
				System.out.println("���̵� : ");		String id = scanner.next();
				System.out.println("��й�ȣ : "); 	String password = scanner.next();
				System.out.println("�̸� : "); 		String name = scanner.next();
				System.out.println("��ȭ��ȣ : "); 	String phone = scanner.next();
				
				Member member = new Member();
				
				member.id = id;
				member.password = password;
				member.name = name;
				member.phone = phone;
				
				boolean idcheck = true;
				for(Member temp : memberlist) {
					if(temp != null && temp.id.equals(id)) {
						System.err.println("�˸�)�̹� �����ϴ� ���̵��Դϴ�.");
						idcheck = false;
						break;
					} // if e
				} // for e
				if(idcheck == true) {
					int i = 0;
					for(Member temp : memberlist) {
						if(temp == null) {
							memberlist[i] = member;
							System.out.println("ȸ������ ����");
							break;
						} // if e
						i++;
					} // for e
				} // if e
			
			} // if e
			else if(ch==2) {
				System.out.println("---------- �α��� ----------");
				System.out.println("���̵� : ");	String loginid = scanner.next();
				System.out.println("��й�ȣ : ");	String loginpw = scanner.next();
				
				boolean logincheck = false;
				for(Member temp : memberlist) {
					if(temp != null && temp.id.equals(loginid) && temp.password.equals(loginpw)) {
						System.out.println("�α��� ����");
						logincheck = true;
						break;
					} // if e
				} // for e
				if(logincheck == false) {
					System.err.println("�˸�))������ ȸ�������� �����ϴ�.");
				} // if e
			} // else if e
			
			else if(ch==3) {
				System.out.println("---------- ���̵�ã�� ----------");
				System.out.println("�̸� : ");	String name = scanner.next();
				System.out.println("��ȭ��ȣ : ");	String phone = scanner.next();
				
				boolean findid = false;
				for(Member temp : memberlist) {
					if(temp != null && temp.name.equals(name) && temp.phone.equals(phone)) {
						System.out.println("���̵� ã�� ����");
						System.out.println("ȸ������ ���̵� : " + temp.id);
						findid = true;
						break;
					} // if e
				} // for e
				if(findid == false) {
					System.err.println("�˸�))������ ȸ�������� �����ϴ�.[���̵�ã�� ����]");
				} // if e
			} // else if e
			else if(ch==4) {
				
				System.out.println("---------- ��й�ȣã�� ----------");
				System.out.println("���̵� : ");	String id = scanner.next();
				System.out.println("��ȭ��ȣ : ");	String phone = scanner.next();
				
				boolean findpw = false;
				for(Member temp : memberlist) {
					if(temp != null && temp.id.equals(id) && temp.phone.equals(phone)) {
						System.out.println("��й�ȣ ã�� ����");
						System.out.println("ȸ������ ��й�ȣ : " + temp.password);
						findpw = true;
						break;	
					} // if e
				} // for e
				if(findpw == false) {
					System.err.println("������ ȸ�������� �����ϴ�.[��й�ȣã�� ����]");
				} // if e
			} // else if e
			
			else {
				System.err.println("�˸�)�� �� ���� ��ȣ�Դϴ�.");
			} // else e
			
		} // while e
	} // me

} // ce
