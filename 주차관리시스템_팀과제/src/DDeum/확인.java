package DDeum;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Ȯ�� {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			try {
				System.out.println("�԰��� : "); 	String idate = scanner.next();
				System.out.println("�԰�ð� : ");	String itime = scanner.next();
				
				String intime = idate+itime;
				
				System.out.println("����� : "); 	String odate = scanner.next();
				System.out.println("���ð� : ");	String otime = scanner.next();
				
				String outtime = odate+otime;
				
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMddhhmm");
				Date in = simpleDateFormat.parse(intime);
				Date out = simpleDateFormat.parse(outtime);
				
				System.out.println(in);
				System.out.println(out);
				
				long difftime = (out.getTime() - in.getTime()) / 60000;
				
				System.out.println(difftime);
			}catch(Exception e) {}
		} // while e
		
		
		
		
	} // me
} // ce
