package Test;

import java.util.Scanner;

public class �׽�Ʈ2 {

	public static void main(String[] args) {
		
		�л�[] studentlist = new �л�[100];
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			try {
				
				System.out.println("-------------------------");
				System.out.println("------- ��  ��  ǥ --------");
				System.out.println("-------------------------");
				System.out.printf("��ȣ �̸� ���� ���� ���� ���� ��� ���� \n");
				System.out.println("-------------------------");
				
				for(�л� temp : studentlist) {
					if(temp != null) {
						System.out.println();
					}
				}
				
				
			} // try e
			catch(Exception e) {}
			
		} // while
		
	} // me
	
	
} // ce
