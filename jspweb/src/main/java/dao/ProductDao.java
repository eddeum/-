package dao;

import java.util.ArrayList;

import dto.Category;
import dto.Product;
import dto.Stock;

public class ProductDao extends Dao {

	public ProductDao() {
		super();
	}
	
	// 호출용
	public static ProductDao productDao = new ProductDao();
	public static ProductDao getproduDao() {return productDao;}

///////////////////////////////////////////////////////////////////// 카테고리 /////////////////////////////////////////////////////////////////////
	// 1. 카테고리 등록
	public boolean csave(String cname) {
		String sql = "insert into category(cname)values('"+cname+"')";
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("카테고리등록오류"+e);}
		return false;
	} // 카테고리등록 end
	
	// 2. 카테고리 호출
	public ArrayList<Category> getcategorylist(){
		ArrayList<Category> categorylist = new ArrayList<Category>();
		String sql = "select * from category";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next() ) {
				Category category = new Category(rs.getInt(1), 
						 rs.getString(2) );
				categorylist.add(category);
			} // while end
			return categorylist;
		}catch(Exception e) {System.out.println("카테고리호출오류"+e);}
		return null;
	} // 카테고리호출 end
	
	// 3. 카테고리 수정
	
	// 4. 카테고리 삭제
	
////////////////////////////////////////////////////////////////////// 제품 //////////////////////////////////////////////////////////////////////
	// 1. 제품 등록 
	public boolean psave(Product product) {
		String sql = "insert into product(pname, pprice, pdiscount, pimg, cnum) values(?, ?, ?, ?, ?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, product.getPname() );
			ps.setInt(2, product.getPprice() );
			ps.setFloat(3, product.getPdiscount() );
			ps.setString(4, product.getPimg() );
			ps.setInt(5, product.getCnum() );
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("제품등록오류"+e);}
		return false;
	} // 제품등록 end
	// 2. 제품 모든 호출
	public ArrayList<Product> getproductlist(){return null;}
	// 3. 제품 개별 호출
	public Product getproduct() {return null;}
	// 4. 제품 수정
	// 5. 제품 삭제
////////////////////////////////////////////////////////////////////// 재고 //////////////////////////////////////////////////////////////////////
	// 1. 제품의 재고 등록
	public boolean ssave() {return false;}
	// 2. 제품의 재고 호출
	public Stock getstock() {return null;}
	// 3. 제품의 재고 수정
	// 4. 제품의 재고 삭제
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
} // class end
