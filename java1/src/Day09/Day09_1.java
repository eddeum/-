package Day09;

public class Day09_1 {
	
	// p.277
	
		// 1. 3
		// 2. 4
		// 3. 4
		// 4. 3
		// 5. 1
			// 1. ��ü�� ������ X, �ν��Ͻ� ������ O
			// 2. this.�����
			//	  this.�ʵ��
			//	  this.�޼ҵ��
			//	  this() : �� ������ ȣ��
			//	  this(������, ������) : ������
		// 6. 4
			// 4. Override
		// 7. 2
		// 8. 2
			// static : �������
			// �� ��ü���� Ŭ������ ���� ���� ���� ---> new ��ü�� ����
			// �����ڿ����� static ��� �Ұ�
		// 9. 2
			// final : ���[�����Ұ�]
		// 10. 4
		// 11. 3
			// default : �ش� ��Ű�� / private : �ش� Ŭ����
		// 12. �ʵ� / ������ / �޼ҵ�
		// 13.
			/*
			 * String name; 
			 * String id;
			 * String password;
			 * int age;
			 */
		// 14. 
			/* ������ ����� : Ŭ���� �̸��� ����
			 * Member(String name, String id){
			 * this.name = name;
			 * this.id = id;
			 * }
			 */
		// 15. 
			/* �Ű����� : �μ� -> �޼ҵ� ȣ���  �޼ҵ�� ������ ������
			 * *** �α��� �޼ҵ�
			 * boolean login(String id, String password){
			 * if(id.equals("hong") && password.equals("12345"){
			 * 		// ���̵� hong�̸鼭 �н����尡 12345 �̸� true ��ȯ
			 * 	return true;
			 * }
			 * return false;
			 * }
			 * *** �α׾ƿ� �޼ҵ�[��ȯŸ�� �޼ҵ��(�μ�1, �μ�2){ }]
			 * void logout(String id){
			 * System.out.print("�α׾ƿ� �Ǿ����ϴ�.");
			 * }
			 */
		// 16. 
			/* ��ü�� ���� �޼ҵ� ȣ�� ����
			 * **** ������ �̸����� �޼ҵ� ���𰡴�[�� ���� �ٸ� �μ�[�Ű�����] ���]
			 * void println(int x){ // �ܺηκ��� int�� ������ �ܺηι޾� ��� �޼ҵ�
			 * 	System.oun.println(x);
			 * }
			 * void println(boolean x){ // �ܺηκ��� boolean�� ������ �ܺηι޾� ��� �޼ҵ�
			 * 	System.oun.println(x);
			 * }
			 * void println(double x){ // �ܺηκ��� double�� ������ �ܺηι޾� ��� �޼ҵ�
			 * 	System.oun.println(x);
			 * }
			 * void println(String x){ // �ܺηκ��� String�� ������ �ܺηι޾� ��� �޼ҵ�
			 * 	System.oun.println(x);
			 * }
			 * 
			 */
		// 17.
			/* **** ��ü�� �������� �ʰ� �޼ҵ带 ȣ���ϴ� ���(��� ������ ����Ҷ��� static ��� -> �޸𸮿뷮�� ŭ)
			 * static void println(int x){ // �ܺηκ��� int�� ������ �ܺηι޾� ��� �޼ҵ�
			 * 	System.oun.println(x);
			 * }
			 * static void println(boolean x){ // �ܺηκ��� boolean�� ������ �ܺηι޾� ��� �޼ҵ�
			 * 	System.oun.println(x);
			 * }
			 * static void println(double x){ // �ܺηκ��� double�� ������ �ܺηι޾� ��� �޼ҵ�
			 * 	System.oun.println(x);
			 * }
			 * static void println(String x){ // �ܺηκ��� String�� ������ �ܺηι޾� ��� �޼ҵ�
			 * 	System.oun.println(x);
			 * }
			 */
		// 18.
		// 19. Day08_5 ����� ��ũ ���α׷�[2�� ����] ��ü

}
