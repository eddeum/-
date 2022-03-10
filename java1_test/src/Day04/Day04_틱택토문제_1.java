package Day04;

import java.util.Random;
import java.util.Scanner;

public class Day04_틱택토문제_1 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String[] 게임판 = {"[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"};
		
		String 승리알 = ""; ////////////////////////////////////////????
		
		while(true) {
			for(int i = 0; i<게임판.length; i++) {
				System.out.print(게임판[i]);
				
				if(i%3==2) System.out.println();
			} // for e
			
			while(true) {
				System.out.println("게임자 위치선택 : ");	int gamer = scanner.nextInt();
				if(게임판[gamer].equals("[ ]")) {
					게임판[gamer] = "[O]";
					break;
				} // if e
				else {
					System.err.println("알림)해당 위치에 이미 알이 존재합니다.[재선택]");
				} // else e
			} // while e
			
			while(true) {
				
				Random random = new Random();
				int computer = random.nextInt(9);	// 0~8 사이의 난수 int형으로 
				if(게임판[computer].equals("[ ]")) {
					게임판[computer] = "[X]";
					break;
				} // if e
			} // while e
			
			for(int i = 0; i<=6; i+=3) {
				if(게임판[i].equals(게임판[i+1]) && 게임판[i+1].equals(게임판[i+2])) {
					승리알 = 게임판[i];
				} // if e
			} // for e
			
			for(int i = 0; i<=2; i++) {
				if(게임판[i].equals(게임판[i+3]) && 게임판[i+3].equals(게임판[i+6])) {
					승리알 = 게임판[i];
				} // if e
			} // for e
			
			if(게임판[0].equals(게임판[4]) && 게임판[4].equals(게임판[8])) {
				승리알 = 게임판[0];
			} // if e
			if(게임판[2].equals(게임판[4]) && 게임판[4].equals(게임판[6])) {
				승리알 = 게임판[2];
			} // if e
			
			if(승리알.equals("[O]")) {
				System.out.println("알림)) 플레이어 승리");
			} // if e
			
			if(승리알.equals("[X]")) {
				System.out.println("알림)) 컴퓨터 승리");
			} // if e
			
		} // while e
		
	} // me
	
} // ce
