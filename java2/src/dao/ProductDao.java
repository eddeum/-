package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductDao {
	
	// �ʵ�
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public static ProductDao productDao = new ProductDao();
	
	// ������
	public ProductDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC","root","1234");
		}catch(Exception e) {System.out.println("[DB ���� ����]"+e);}
	}

	////////////// line 10~23�� Dao Ŭ�������� �ߺ��ǹǷ� ����Ŭ������ ���� ����ϴ°� ���� //////////////
	
	// �޼ҵ�
	
} // ce
