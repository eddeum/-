package Day10;

import java.util.ArrayList;
import java.util.Scanner;

public class Day10_��������_����Ʈ����_1 {

	public static void main(String[] args) {
		
		ArrayList<Book> booklist = new ArrayList<>();
		
		Scanner scanner = new Scanner(System.in);
		
		while(true){
			System.out.println("1.��� 2.��� 3.���� 4.����");
			System.out.println("���� : ");	int ch = scanner.nextInt();
			
			if(ch==1) {
				System.out.println("������ : "); 	String ������ = scanner.next();
				System.out.println("���� : "); 	String ���� = scanner.next();
				
				Book book = new Book(������, ����);
				
				booklist.add(book);
				
			} // if e
			
			else if(ch==2) {
				System.out.println("������\t����");
				for(Book book : booklist) {
					System.out.println(book.get������()+"\t"+book.get����());
				} // for e
			} // else if e
			
			else if(ch==3) {
				System.out.println("������ ������ : ");	String ������ = scanner.next();
				for(Book book : booklist) {
					if(book.get������().equals(������)) {
						booklist.remove(book);
						break;
					} // if e
				} // for e
			} // else if e
			
			else if(ch==4) {
				System.out.println("������ ������ : ");	String ������ = scanner.next();
				
				for(Book book : booklist) {
					if(book.get������().equals(������)) {
						System.out.println("������ �����̸� : ");	String ���� = scanner.next();
						book.set����(����);
					} // if e
				} // for e
			} // else if e
		
			else {
				System.err.println("�˸�)�� �� ���� ��ȣ�Դϴ�.");
			} // else e
		} // while e
		
		
	} // me
} // ce
