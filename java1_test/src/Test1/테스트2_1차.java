package Test1;

import java.util.Scanner;

import Test.�л�_1��;

public class �׽�Ʈ2_1�� {

	public static void main(String[] args) {
		
		�л�_1��[] studentlist = new �л�_1��[100];
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			try {
				
				System.out.println("-------------------------");
				System.out.println("------- ��  ��  ǥ --------");
				System.out.println("-------------------------");
				System.out.printf("��ȣ �̸� ���� ���� ���� ���� ��� ���� \n");
				System.out.println("-------------------------");
				
				for(�л�_1�� temp : studentlist) {
					if(temp != null) {
						System.out.println();
					}
				}
				
				
			} // try e
			catch(Exception e) {}
			
		} // while
		
	} // me
	
	
} // ce
