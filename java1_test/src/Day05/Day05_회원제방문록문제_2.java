package Day05;

import java.util.Scanner;

public class Day05_ȸ�����湮�Ϲ���_2 {

	public static void main(String[] args) {
		
		String[][] memberlist = new String[100][3];
		String[][] boardlist = new String[100][3];	
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("---------------------------");
			System.out.println("-------- ȸ���� �湮�� --------");
			System.out.println("---------------------------");
			System.out.println("1. ȸ������ 2. �α��� ���� : ");	int ���� = scanner.nextInt();
			
			if(����==1) {
				System.out.println("---------------------------");
				System.out.println("------- ȸ������ ������ -------");
				System.out.println("ID : ");	String id = scanner.next();
				System.out.println("Password : ");	String pw = scanner.next();
				System.out.println("Name : ");	String name = scanner.next();
				
				boolean idcheck = true;
				for(int i = 0; i<memberlist.length; i++) {
					if(memberlist[i][0] != null && memberlist[i][0].equals(id)) {
						System.err.println("�˸�)������ ���̵� �����մϴ�.");
						idcheck = false;
						break;
					} // if e
				} // for e
				
				if(idcheck) {
					for(int i = 0; i<memberlist.length; i++) {
						if(memberlist[i][0] == null) {
							memberlist[i][0] = id; memberlist[i][1] = pw; memberlist[i][2] = name;
							System.out.println("�˸�)ȸ�������� �Ǿ����ϴ�.");
							break;
						} // if e
					} // for e
				} // if e
			} // if e
			else if(����==2) {
				System.out.println("---------------------------");
				System.out.println("-------- �α��� ������ --------");
				System.out.println("ID :");			String id = scanner.next();
				System.out.println("Password :");	String pw = scanner.next();
				
				boolean logincheck = false;
				for(int i = 0; i<memberlist.length; i++) {
					if(memberlist[i][0] != null && memberlist[i][0].equals(id) 
							&& memberlist[i][1].equals(pw)) {
						System.out.println("�˸�)�α��� ����");
						logincheck = true;
						
						while(true) {
							System.out.println("---------------------------");
							System.out.println("----------- �湮�� ----------");
							System.out.printf("��ȣ\t�ۼ���\t����\t���� \n");
							
							for(int j = 0; j<boardlist.length; j++) {
								if(boardlist[j][0] != null) {
									System.out.printf("%d\t%s\t%s\t%s \n", j, boardlist[j][2], 
											boardlist[j][0], boardlist[j][1]);
								} // if e
							} // for e
							
							System.out.println("1. �湮�ϳ���� 2. �α׾ƿ�  ���� : ");	int ����2 = scanner.nextInt();
							
							if(����2==1) {
								System.out.println("----------------------------");
								System.out.println("���� : ");	String ���� = scanner.next();
								System.out.println("���� : ");	String ���� = scanner.next();
								
								for(int j = 0; j<boardlist.length; j++) {
									if(boardlist[j][0] == null) {
										boardlist[j][0] = ����;	boardlist[j][1] = ���� ;	
										boardlist[j][2] = id;
										
										System.out.println("�˸�)�湮���� �ۼ��Ǿ����ϴ�.");
										break;
									} // if e
								} // for e
							} // if e
							else if(����2==2) {
								System.out.println("�˸�)�α׾ƿ�");
								break;
							} // else if e
							else System.err.println("�˸�)�� �� ���� ��ȣ�Դϴ�.");
						} // while e
						
					} // if e
				} // for e
				
				if(logincheck==false) System.err.println("�˸�)ȸ�������� ���ų� �ٸ��ϴ�.");
				
			} // else if e
			else System.err.println("�˸�)�� �� ���� ��ȣ�Դϴ�.");
			
			
		} // while e
		
	} // me
} // ce

// 22.03.07