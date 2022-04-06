package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.Product;

public class ProductDao {
	
	// 필드
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public static ProductDao productDao = new ProductDao();
	
	// 생성자
	public ProductDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC","root","1234");
		}catch(Exception e) {System.out.println("[SQL 연동 오류]"+e);}
	}

	////////////// line 10~23은 Dao 클래스마다 중복되므로 슈퍼클래스로 만들어서 사용하는게 좋음 //////////////
	
	// 메소드
	
	// 1. 제품 등록
	public boolean add(Product product) {
		try {
			String sql = "insert into product(pname, pimg, pcontent, pcategory, pprice, pactivation, mnum) values(?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, product.getPname());
			ps.setString(2, product.getPimg());
			ps.setString(3, product.getPcontent());
			ps.setString(4, product.getPcategory());
			ps.setInt(5, product.getPprice());
			ps.setInt(6, product.getPactivation());
			ps.setInt(7, product.getMnum());
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("[SQL 연동 오류]"+e);}
		return false;
	}
	
	// 2. 모든 제품 출력[tableview 사용x -> ArrayList 사용]
	public ArrayList<Product> list(){
		
		ArrayList<Product> productlist = new ArrayList<>();
		try {
			String sql = "select * from product";			// SQL 작성
			ps = conn.prepareStatement(sql);				// SQL 연결
			rs = ps.executeQuery();							// SQL 실행
			
			while(rs.next()) {								// SQL 결과[레코드 단위]
				Product product = new Product(rs.getInt(1), // 해당 레코드 객체화
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getInt(6), 
						rs.getInt(7), 
						rs.getString(8), 
						rs.getInt(9));
				productlist.add(product);
			} // while e
			return productlist;
		}catch(Exception e) {System.out.println("[SQL 연동 오류]"+e);}
		return null; // 만약에 실패시 NULL 반환
	}
	
	// 3. 제품 조회
	
	// 4. 제품 삭제
	public boolean delete(int pnum) {
		try {
			String sql = "delete from product where pnum=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pnum);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("[SQL 연동 오류]"+e);}
		return false;
	}
	
	// 5. 제품 수정
	public boolean update(Product product) {
		try {
			String sql = "update product set pname =?, pimg=?, pcontent=?, pcategory=?, pprice=? where pnum=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, product.getPname());
			ps.setString(2, product.getPimg());
			ps.setString(3, product.getPcontent());
			ps.setString(4, product.getPcategory());
			ps.setInt(5, product.getPprice());
			ps.setInt(6, product.getPnum());
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("[SQL 연동 오류]"+e);}
		return false;
	}
	
} // ce
