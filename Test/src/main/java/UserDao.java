import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class UserDao {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public static UserDao userDao = new UserDao();
	
	public UserDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC","root","1234");
			System.out.println("DB 연동 성공");
		}catch(Exception e) {
			System.out.println("DB 연동 실패"+e);
		}
	}
	
	

}
