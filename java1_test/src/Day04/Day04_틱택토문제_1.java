package Day04;

import java.util.Random;
import java.util.Scanner;

public class Day04_ƽ���乮��_1 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String[] ������ = {"[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"};
		
		String �¸��� = ""; ////////////////////////////////////////????
		
		while(true) {
			for(int i = 0; i<������.length; i++) {
				System.out.print(������[i]);
				
				if(i%3==2) System.out.println();
			} // for e
			
			while(true) {
				System.out.println("������ ��ġ���� : ");	int gamer = scanner.nextInt();
				if(������[gamer].equals("[ ]")) {
					������[gamer] = "[O]";
					break;
				} // if e
				else {
					System.err.println("�˸�)�ش� ��ġ�� �̹� ���� �����մϴ�.[�缱��]");
				} // else e
			} // while e
			
			while(true) {
				
				Random random = new Random();
				int computer = random.nextInt(9);	// 0~8 ������ ���� int������ 
				if(������[computer].equals("[ ]")) {
					������[computer] = "[X]";
					break;
				} // if e
			} // while e
			
			for(int i = 0; i<=6; i+=3) {
				if(������[i].equals(������[i+1]) && ������[i+1].equals(������[i+2])) {
					�¸��� = ������[i];
				} // if e
			} // for e
			
			for(int i = 0; i<=2; i++) {
				if(������[i].equals(������[i+3]) && ������[i+3].equals(������[i+6])) {
					�¸��� = ������[i];
				} // if e
			} // for e
			
			if(������[0].equals(������[4]) && ������[4].equals(������[8])) {
				�¸��� = ������[0];
			} // if e
			if(������[2].equals(������[4]) && ������[4].equals(������[6])) {
				�¸��� = ������[2];
			} // if e
			
			if(�¸���.equals("[O]")) {
				System.out.println("�˸�)) �÷��̾� �¸�");
			} // if e
			
			if(�¸���.equals("[X]")) {
				System.out.println("�˸�)) ��ǻ�� �¸�");
			} // if e
			
		} // while e
		
	} // me
	
} // ce
