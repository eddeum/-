package Day04;

import java.util.Random;
import java.util.Scanner;

public class Day04_�ζ��Ǻ��⹮��_1 { // cs
	
	public static void main(String[] args) { // ms
		
		int[] ����ڹ�ȣ = new int[6];
		int[] ��÷��ȣ = new int[6];
		
		Scanner scanner = new Scanner(System.in);
		
		for(int i = 0; i<6; i++) {
			System.out.print("1~45 ���� �Է� : ");
			int ��ȣ = scanner.nextInt();
			
			boolean ��� = true;
			
			if(��ȣ<1 || ��ȣ>45) {
				System.out.println("�˸�)�� �� ���� ��ȣ�Դϴ�.");
				i--;
				��� = false;
			} // if e
			
			for(int j = 0 ; j<6; j++) {
				if(��ȣ==����ڹ�ȣ[j]) {
					System.out.println("�˸�)�̹� ������ ��ȣ�Դϴ�.");
					i--; // i���ϴ� ������?????????????
					��� = false;
				} // if e
			} // for e
			if(���==true) ����ڹ�ȣ[i]=��ȣ;
		} // for e
		
		System.out.println("\n����ڰ� ������ ��ȣ : ");
		for(int temp : ����ڹ�ȣ) {
			System.out.print(temp+"\t");
		} // for e
		
		for(int i = 0; i<6; i++) {
			Random random = new Random();
			int ��÷ = random.nextInt(45)+1;
			
			boolean ��� = true;
			
			for(int j = 0; j<6; j++) {
				if(��÷==��÷��ȣ[j]) {
					System.out.println("�˸�)�̹� �ߺ��� ��ȣ�Դϴ�.");
					i--;
					��� = false;
				} // if e
			} // for e
			if (���==true) ��÷��ȣ[i] = ��÷;
		} // for e
		
		System.out.println("\n��÷ ��ȣ : ");
		for(int temp : ��÷��ȣ) {
			System.out.print(temp + "\t");
		} // for e
		
		int �����Ѽ� = 0;
		for(int i = 0; i<����ڹ�ȣ.length; i++) {
			for(int j = 0; j<��÷��ȣ.length; j++) {
				if(����ڹ�ȣ[i]==��÷��ȣ[j]) {
					�����Ѽ�++;
				} // if e
			} // for e
		} // for e
		
		System.out.println("\n������ �� : " +�����Ѽ�);
		
		
		
	} // me

} // ce
