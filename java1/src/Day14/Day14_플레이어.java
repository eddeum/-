package Day14;

import java.util.Scanner;

public class Day14_�÷��̾� {
	
	// ���� [1. �Ҹ����/����  2. �������/����]
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in); // �Է°�ü
		
		boolean soundsw = true; // ���� �Ҹ� ��� ����
		boolean moviesw = true;	// ���� ���� ��� ����
		
		while(true) {
			System.out.print("1.�Ҹ���� 2.������� : ");
			int ch = scanner.nextInt();
			
			if(ch==1) {
				Sound sound = new Sound(); // ��ü ����
				
				if(soundsw) { // �Ҹ����
					sound.soundstop(true); // �Ҹ�����
					sound.start(); // ������ ����
//					Sound.stop = false; // �Ҹ�����
						// stop �ʵ忡 ���� ����� -> �ٷ� ����
					soundsw = false; // ������ ���� ���
				} // if e
				else {
					sound.soundstop(false); // �Ҹ� ����
//					Sound.stop = true; // �Ҹ����
					soundsw = true; // �������� ���� ���
				} // else e
			} // if e
		
			else if(ch==2) {
			
				Movie movie = new Movie();
				if(moviesw) {
					movie.moviestop(true); 	// �����
					movie.start(); 			// ������ ����
					moviesw = false;		// ���� ����
				} // if e
				else {
					movie.moviestop(false);	// �����
					moviesw = true;			// ���� ����
				} // else e		
			} // else if e
			
		}
		
		
	} // me
} // ce
