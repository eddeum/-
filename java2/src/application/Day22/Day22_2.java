package application.Day22;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import application.������;


public class Day22_2 {
	
	// 1. �ʵ�
		private Connection connection; // DB���� ��ü ����
	// 2. ������
		public Day22_2() {
			try { // JAVA�� �ܺο� ����� ������ �Ϲݿ��� �߻�
				// 1. DB ����̺� Ŭ���� ȣ��[DB ȸ�縶�� �ٸ��⶧���� �ϱ�X]
				Class.forName("com.mysql.cj.jdbc.Driver");
				// 2. DB ����
				connection = DriverManager.getConnection(
						// JDBC : JAVA DATABASE CONNECTION
						// jdbc:mysql://IP�ּ�(����[����pc]�̸� localhost):post��ȣ/DB�̸�?DB�ð�����(DB�ð������� ���û�����)
						// , ������, "DB��й�ȣ"
						"jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC",
						"root",
						"1234");
				// 3. Ȯ��
				System.out.println("[DB ���� ����]");
			}catch(Exception e) {
				System.out.println("[DB ���� ����]");
			} // catch e
		}
	// 3. ������ ���� �޼ҵ�޼ҵ�
		public boolean write(String �ۼ���, String ����) {
			
			try {
				// 1. SQL �ۼ�[DB�� ���̺� ������ ����]
					// DB�� ���̺� ������ ���� : insert into ���̺��(�ʵ��1, �ʵ��2) values(�ʵ��1�ǰ�, �ʵ��2�ǰ�)
				String sql = "insert into test(writer,content)values(?,?)";
				// 2. SQL ����[����� DB�� SQL ����]
					// PreparedStatement : ����� DB���� ���̺� ����(����,����,����,����)�Ҷ� ���� �������̽�
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, �ۼ���); // sql�� �ۼ��� ù���� ?�� �����ֱ�[1 : ù��° ?]
				ps.setString(2, ����); // [2 : �ι�° ?]
				// 3. SQL ����
				ps.executeUpdate(); // sql ���� ����
				// * ������ true
				return true;
				
			}catch(Exception e) {
				System.out.println("[SQL ���� ���� ���� : ]"+e);
			} // catch e
			
			// * ���н� false
			return false;
			
		}
	
	// 4. ������ ȣ�� �޼ҵ�
		public ArrayList<������> get(){
			
			// * DB���� ������ �����͸� ������ ����Ʈ ����
			ArrayList<������> �����͸�� = new ArrayList<>();
			try {
				// 1. SQL �ۼ�[������ ȣ��]
					// select *(����ʵ�) from ���̺�� : ��� �����͸� ��������
				String sql = "select * from test";
				// 2. SQL ����
				PreparedStatement ps = connection.prepareStatement(sql);
				// 3. SQL ���� [ResultSet �������̽� java.sql ��Ű��]
				ResultSet rs = ps.executeQuery(); //����� ��������
				
				// * ����� �ϳ��� �ƴϰ� ������ �̹Ƿ� �ݺ��� ����ؼ�
					// ���پ�[���ڵ�] ��üȭ -> ����Ʈ�� ����
				while(rs.next()) { // ���� ��[���ڵ�]�� ������
					// 1. ���پ�[���ڵ�]���� ��üȭ
					������ temp = new ������(
						rs.getInt(1), // �ش� ��[���ڵ�]�� ù��° �ʵ�[����]�� ��������
						rs.getString(2),
						rs.getString(3) );
					// 2. ��ü�� ����Ʈ�� ����ֱ�
					�����͸��.add(temp);
				}
				// �ݺ����� ����Ǹ� ����Ʈ ��ȯ

				// * ������ ������ ��� ��ȯ
				return �����͸��;
			}catch(Exception e) {
				System.out.println("[sql ���� ���� ���� : ]"+e);
			} // catch e
			// * ���н�
			return null;
		}
	

}
