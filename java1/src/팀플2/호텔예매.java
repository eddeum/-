package ����2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class ȣ�ڿ��� {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		ArrayList<Room> roomlist = new ArrayList<>();
		
		roomlist.add(new Room("Ʈ����","10,000",false,"���缮",new Date()));
		roomlist.add(new Room("����Ʈ��","10,000",false,"���缮",new Date()));
		 
		while(true) {
			System.out.println("----------------- ȣ�� ���� ���α׷� -----------------");
			System.out.println("��¥���� : "); 	String ��¥ = scanner.next();
			boolean[] ���డ�� = new boolean[5];
			for(Room temp : roomlist) {
				
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMdd");
				if(simpleDateFormat.format(temp.getDate()).equals(��¥)) {
					if( temp.getRname().equals("Ʈ����") ) {
						���డ��[0] = true;
					}
					if( temp.getRname().equals("�����") ) {
						���డ��[1] = true;	
					}
					if( temp.getRname().equals("�ٴٺ�Ʈ����") ) {
						���డ��[2] = true;
					}
					if( temp.getRname().equals("�ٴٺ�����") ) {
						���డ��[3] = true;
					}
					if( temp.getRname().equals("����Ʈ��") ) {
						���డ��[4] = true;
					}
				}
				
			}
			System.out.println();
			
				System.out.println("----------------- �� ���� ��Ȳǥ -----------------");
				System.out.println();
				System.out.println("��ȣ\t���̸�\t\t�ݾ�\t\t���࿩��");
				System.out.println("0\tƮ����\t10,000\t"+���డ��[0]);
				System.out.println("0\t�����\t0,000\t"+���డ��[1]);
				System.out.println("0\t�ٴٺ�Ʈ����\t30,000\t"+���డ��[2]);
				System.out.println("0\t�ٴٺ�����\t40,000\t"+���డ��[3]);
				System.out.println("0\t����Ʈ��\t50,000\t"+���డ��[4]);
				
		}
				
				
		
//			System.out.println("----------------- �� ���� ��Ȳǥ -----------------");
//			System.out.println();
//			System.out.println("��ȣ\t���̸�\t\t�ݾ�\t\t���࿩��");
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
//				System.out.println("�� ��ȣ ���� : "); int ch = scanner.nextInt();
//				
//			
//				for(int i = 0; i<roomlist.length; i++) {
//					if(roomlist[i][2]=="����Ұ�") {
//						System.err.println("�˸�))���� �̹� ����Ǿ����ϴ�.");
//					} // if e
//					else {
//						switch(ch) {
//							case 1:
//								roomlist[0][2]="\t����Ұ�";
//								break;
//							case 2:
//								roomlist[1][2]="\t����Ұ�";
//								break;
//							case 3:
//								roomlist[2][2]="\t����Ұ�";
//								break;
//							case 4:
//								roomlist[3][2]="\t����Ұ�";
//								break;
//							case 5:
//								roomlist[4][2]="\t����Ұ�";
//								break;
//						} // switch e
//					} // else e
//					
//				} // for e
			
						
//						if(ch==1) {
//							roomlist[0][2]="\t����Ұ�";
//							System.out.println(roomlist[0][0]+roomlist[0][1]+roomlist[0][2]);
//						} // if e
//						else if (ch==2) {
//							roomlist[1][2]="\t����Ұ�";
//							System.out.println(roomlist[1][0]+roomlist[1][1]+roomlist[1][2]);
//						} // else if e
//						else if (ch==3) {
//							roomlist[2][2]="\t����Ұ�";
//							System.out.println(roomlist[2][0]+roomlist[2][1]+roomlist[2][2]);
//						} // else if e
//						else if (ch==4) {
//							roomlist[3][2]="\t����Ұ�";
//							System.out.println(roomlist[3][0]+roomlist[3][1]+roomlist[3][2]);
//						} // else if e
//						else if (ch==5) {
//							roomlist[4][2]="\t����Ұ�";
//							System.out.println(roomlist[4][0]+roomlist[4][1]+roomlist[4][2]);
//						} // else if e
//						else {
//							System.out.println("�˸�)��ȣ�� �ٽ� �Է����ּ���.");
//						}


				
			
				
				
			
			
			

					
					
		
//			System.out.println("1.����  2.�������");	int ch = scanner.nextInt();
//			
//			if(ch==1) {
//				System.out.println("��¥ ���� : "); int ��¥ = scanner.nextInt(); /////// ��¥�޾ƿ��¹��????
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


