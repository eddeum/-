package Day10;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Day10_Ű����ũ_1 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		ArrayList<��ǰ> ��ǰ����Ʈ = new ArrayList<>();
		
		try {
			FileInputStream inputStream = new FileInputStream("D:/java/�Ե��������.txt");
			byte[] bytes = new byte[1024]; 			// ����Ʈ �迭 ����
			inputStream.read(bytes); 				// �о�ͼ� �迭�� ����
			String ���ϳ��� = new String(bytes); 		// ����Ʈ�� -> ���ڿ�
			String [] ��ǰ��� = ���ϳ���.split("\n"); 	// String �ڸ��� �޼ҵ� = split("����");
		
			for(String temp : ��ǰ���) {
				String[] �ʵ��� = temp.split(",");
				��ǰ ��ǰ = new ��ǰ(�ʵ���[0],
						Integer.parseInt(�ʵ���[1]),
						Integer.parseInt(�ʵ���[2]));
			
				��ǰ����Ʈ.add(��ǰ);
			} //for e
		
		} // try e
		catch(Exception e) {
		} // catch e
		
		Ű����ũ �Ե����� = new �Ե�����("���缮", ��ǰ����Ʈ);
		
		while(true) {
			
			�Ե�����.��ǰ���();
			int ch = scanner.nextInt();
			if(ch==1) { // �����ڸ��� ����
				�Ե�����.��ǰ�߰�();
			} // if e
			else if(ch==2) {
				�Ե�����.��ٱ���();
			} // else e
		} // while e
	} // me
	
} // ce
