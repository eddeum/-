package Test;

import java.util.Scanner;

public class Day05_�����뿩���α׷�����_1 {

	public static void main(String[] args) {
		
		String[][] memberlist = new String[100][2];
		String[][] booklist = new String[100][3];
		
		Scanner scanner = new Scanner(System.in);
		
		while(true){
			
			System.out.println("------- ���� �뿩 ���α׷� -------");
			System.out.println("1. ȸ������ 2. �α���");
			System.out.println("-----------------------------");
			System.out.println("���� : ");	int ���� = scanner.nextInt();
			
			if(����==1) {
				System.out.println("------- ȸ������ ������ ------ ");
				System.out.println("ID : ");		String id = scanner.next();
				System.out.println("Password : "); 	String pw = scanner.next();
				
				boolean idcheck = true;
				
				for(int i = 0; i<memberlist.length; i++) {
					if(memberlist[i][0] != null && memberlist[i][0].equals(id)) {
						System.err.println("�˸�))������ ���̵� �����մϴ�.");
						idcheck = false;
						break;
					} // if e
				} // for e
				
				if(idcheck) {
					for(int i = 0; i<memberlist.length; i++) {
						if(memberlist[i][0] == null) {
							memberlist[i][0] = id;	memberlist[i][1] = pw;
						} // if e
						System.out.println("ȸ�������� �Ϸ�Ǿ����ϴ�.");
						break;
					} // for e
				} // if e
			} // if e
			else if(����==2) {
				
			} // else if e
			else System.err.println("�˸�))�� �� ���� ��ȣ�Դϴ�.");
		} // while e
		
	} // me
} // ce
