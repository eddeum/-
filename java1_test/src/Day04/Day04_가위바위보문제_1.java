package Day04;

import java.util.Random;
import java.util.Scanner;

public class Day04_가위바위보문제_1 { // cs
	
	public static void main(String[] args) { // ms
		
		int 플레이어;	int 컴퓨터;
		int 플레이어승리수 = 0;	int 컴퓨터승리수 = 0;
		int 게임수 = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("--------- 가위바위보 게임 ---------");
			System.out.println("가위(0)	바위(1)	보(2)	종료(3)");
			System.out.println("선택 : ");	
			
			플레이어 = scanner.nextInt();
			
			Random random = new Random();
			컴퓨터 = random.nextInt(3);	// 0~2까지 수만 입력받아야 하므로
			
			
			// 종료조건
			if(플레이어==3) {
				System.out.println("알림)게임종료");
				System.out.println("총 게임수 : " + 게임수);
				if(플레이어승리수>컴퓨터승리수) {
					System.out.println("최종승리자 : 플레이어 " + 플레이어승리수 + "판");
				} // if e
				else if(플레이어승리수<컴퓨터승리수) {
					System.out.println("최종승리자 : 컴퓨터 " + 컴퓨터승리수 + "판");
				} // else if e
				else {
					System.out.println("최종승리 : 무승부");
					break;
				} // else e
			} // if e
			
			else if(플레이어>=0 && 플레이어<=2){
				if((플레이어==0 && 컴퓨터==2) || (플레이어==1 && 컴퓨터==0) || (플레이어==2 && 컴퓨터==1)) {
					System.out.println("플레이어 승리");
					플레이어승리수 ++;
				} // if e
				else if((플레이어==0 && 컴퓨터==0) || (플레이어==1 && 컴퓨터==1) || (플레이어==2 && 컴퓨터==2)) {
					System.out.println("무승부");
				} // else if e
				else {
					System.out.println("컴퓨터 승리");
					컴퓨터승리수 ++;
				} // else e
				게임수 ++;
			} // else if e
			else {
				System.out.println("알림)알수없는 번호입니다.");
			} // else e
			
		} // while e
		
		
	} // me

} // ce
