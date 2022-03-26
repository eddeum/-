package 팀프로젝트2_저장;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class 호텔예매 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		ArrayList<Room> roomlist = new ArrayList<>();
		
		roomlist.add(new Room("트윈룸", "10,000원", false, "유재석", new java.util.Date()));
		
		while(true) {
			System.out.println("************** 호텔 예약 프로그램 **************");
			System.out.println("날짜입력(mmdd) :");	String 날짜 = scanner.next();
			
			boolean result = Controller.날짜체크(날짜);
			if(result=true) {
				
				boolean[] 예약가능 = new boolean[5];
				for(Room temp : roomlist) {
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMdd"); // 날짜를 MM(월)dd(일)의 String 형식의 객체생성
					if(simpleDateFormat.format(temp.getDate()).equals(날짜)) { // temp안의 날짜와 입력받은 날짜가 동일하고
						if(temp.getRname().equals("트윈룸")) { // temp안의 방이름이 트윈룸과 동일하면
							예약가능[0] = true;
						} // if e
						if(temp.getRname().equals("더블룸")) {
							예약가능[1] = true;
						} // if e
						if(temp.getRname().equals("바다뷰트윈룸")) {
							예약가능[2] = true;
						} // if e
						if(temp.getRname().equals("바다뷰더블룸")) {
							예약가능[3] = true;
						} // if e
						if(temp.getRname().equals("스위트룸")) {
							예약가능[4] = true;
						} // if e
						
					} // if e
				} // for e
				


				for(int i = 0; i<예약가능.length; i++) {
					if(예약가능[i]==true) {
						String 예약가능여부 = "예약불가";
					} // if e
					else {
						String 예약가능여부 = "예약가능";
					} // else e
				} // for e
				
				
				
				System.out.println("********* 방 예약 현황표 *********");
				System.out.println("번호\t방이름\t\t금액\t예약여부");
				System.out.println("1"+".\t"+"트윈룸\t\t"+"10,000원\t"+예약가능[0]);
				System.out.println("2"+".\t"+"더블룸\t\t"+"20,000원\t"+예약가능[1]);
				System.out.println("3"+".\t"+"바다뷰트윈룸\t"+"30,000원\t"+예약가능[2]);
				System.out.println("4"+".\t"+"바다뷰더블룸\t"+"40,000원\t"+예약가능[3]);
				System.out.println("5"+".\t"+"스위트룸\t\t"+"50,000원\t"+예약가능[4]);
				
//				int ch = scanner.nextInt();
//				
//				Controller.예약(날짜,ch);
//				
//				if(ch==1) {}
//				else if(ch==2) {}
//				else if (ch==3) {}
//				else if(ch==4) {}
//				else if(ch==5) {}
//				else {
//					System.out.println("알림))방 번호를 잘못입력하였습니다.");
//				} // else e
//				
//			} // if e
//			else {
//				System.out.println("알림))날짜를 잘못입력하였습니다.");
			}
			
			
		} // while e
		
	} // me

} // ce
