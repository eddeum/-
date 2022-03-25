package 팀플2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class 호텔예매 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		ArrayList<Room> roomlist = new ArrayList<>();
		
		roomlist.add(new Room("트윈룸","10,000",false,"유재석",new Date()));
		roomlist.add(new Room("스위트룸","10,000",false,"유재석",new Date()));
		 
		while(true) {
			System.out.println("----------------- 호텔 예약 프로그램 -----------------");
			System.out.println("날짜선택 : "); 	String 날짜 = scanner.next();
			boolean[] 예약가능 = new boolean[5];
			for(Room temp : roomlist) {
				
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMdd");
				if(simpleDateFormat.format(temp.getDate()).equals(날짜)) {
					if( temp.getRname().equals("트윈룸") ) {
						예약가능[0] = true;
					}
					if( temp.getRname().equals("더블룸") ) {
						예약가능[1] = true;	
					}
					if( temp.getRname().equals("바다뷰트윈룸") ) {
						예약가능[2] = true;
					}
					if( temp.getRname().equals("바다뷰더블룸") ) {
						예약가능[3] = true;
					}
					if( temp.getRname().equals("스위트룸") ) {
						예약가능[4] = true;
					}
				}
				
			}
			System.out.println();
			
				System.out.println("----------------- 방 예약 현황표 -----------------");
				System.out.println();
				System.out.println("번호\t방이름\t\t금액\t\t예약여부");
				System.out.println("0\t트윈룸\t10,000\t"+예약가능[0]);
				System.out.println("0\t더블룸\t0,000\t"+예약가능[1]);
				System.out.println("0\t바다뷰트윈룸\t30,000\t"+예약가능[2]);
				System.out.println("0\t바다뷰더블룸\t40,000\t"+예약가능[3]);
				System.out.println("0\t스위트룸\t50,000\t"+예약가능[4]);
				
		}
				
				
		
//			System.out.println("----------------- 방 예약 현황표 -----------------");
//			System.out.println();
//			System.out.println("번호\t방이름\t\t금액\t\t예약여부");
//			System.out.println();
			
//			for(int i = 0 ; i<roomlist.size(); i++) {
//				Room temp = roomlist.get(i);
//				System.out.println(i+1+"."+"\t"+temp.getRname()+"\t"+temp.getRprice()+"\t\t"+temp.getReserve());;
//			} // for e
			

			
// 1.			
//			for(int i = 0; i<roomlist.length; i++) {
//				for(int j = 0; j<3; j++) {
//					System.out.print(roomlist[i][j]);
//					} // for e
//				System.out.println();
//				} // for e
				
// 2.		
			
//				System.out.println("1"+"\t"+roomlist[0][0]+roomlist[0][1]+roomlist[0][2]);
//				System.out.println("2"+"\t"+roomlist[1][0]+roomlist[1][1]+roomlist[1][2]);
//				System.out.println("3"+"\t"+roomlist[2][0]+roomlist[2][1]+roomlist[2][2]);
//				System.out.println("4"+"\t"+roomlist[3][0]+roomlist[3][1]+roomlist[3][2]);
//				System.out.println("5"+"\t"+roomlist[4][0]+roomlist[4][1]+roomlist[4][2]);
//				
//				System.out.println("방 번호 선택 : "); int ch = scanner.nextInt();
//				
//			
//				for(int i = 0; i<roomlist.length; i++) {
//					if(roomlist[i][2]=="예약불가") {
//						System.err.println("알림))방이 이미 예약되었습니다.");
//					} // if e
//					else {
//						switch(ch) {
//							case 1:
//								roomlist[0][2]="\t예약불가";
//								break;
//							case 2:
//								roomlist[1][2]="\t예약불가";
//								break;
//							case 3:
//								roomlist[2][2]="\t예약불가";
//								break;
//							case 4:
//								roomlist[3][2]="\t예약불가";
//								break;
//							case 5:
//								roomlist[4][2]="\t예약불가";
//								break;
//						} // switch e
//					} // else e
//					
//				} // for e
			
						
//						if(ch==1) {
//							roomlist[0][2]="\t예약불가";
//							System.out.println(roomlist[0][0]+roomlist[0][1]+roomlist[0][2]);
//						} // if e
//						else if (ch==2) {
//							roomlist[1][2]="\t예약불가";
//							System.out.println(roomlist[1][0]+roomlist[1][1]+roomlist[1][2]);
//						} // else if e
//						else if (ch==3) {
//							roomlist[2][2]="\t예약불가";
//							System.out.println(roomlist[2][0]+roomlist[2][1]+roomlist[2][2]);
//						} // else if e
//						else if (ch==4) {
//							roomlist[3][2]="\t예약불가";
//							System.out.println(roomlist[3][0]+roomlist[3][1]+roomlist[3][2]);
//						} // else if e
//						else if (ch==5) {
//							roomlist[4][2]="\t예약불가";
//							System.out.println(roomlist[4][0]+roomlist[4][1]+roomlist[4][2]);
//						} // else if e
//						else {
//							System.out.println("알림)번호를 다시 입력해주세요.");
//						}


				
			
				
				
			
			
			

					
					
		
//			System.out.println("1.예약  2.예약취소");	int ch = scanner.nextInt();
//			
//			if(ch==1) {
//				System.out.println("날짜 선택 : "); int 날짜 = scanner.nextInt(); /////// 날짜받아오는방법????
//				
//				
//				
//				
//			
//				
//				
//				
//				
//				
//			}
//			else if(ch==2) {}
//			else {}
		
		} 
	
}


