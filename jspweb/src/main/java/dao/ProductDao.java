package dao;

import java.util.ArrayList;import controller.admin.stockadd;
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
	// 2. 모든 제품 호출
	public ArrayList<Product> getproductlist(){
		ArrayList<Product> productlist = new ArrayList<Product>();
		String sql = "select * from product";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next() ) {
				Product product = new Product(rs.getInt(1), 
						rs.getString(2), 
						rs.getInt(3), 
						rs.getFloat(4), 
						rs.getInt(5), 
						rs.getString(6), 
						rs.getInt(7) );
				productlist.add(product);
			} // while end
			return productlist;
		}catch(Exception e) {System.out.println("모든제품호출오류"+e);}
		return null;
	} // 모든제품호출 end
	
	// 3. 개별 제품 호출
	public Product getproduct() {return null;}
	// 4. 제품 수정
	
	// 4-2. 제품 상태 변경
	public boolean activechange(int pnum, int active) {
		String sql = "update product set pactive = "+active+" where pnum="+pnum;
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("제품상태변경오류"+e);}
		return false;
	}
	
	// 5. 제품 삭제
////////////////////////////////////////////////////////////////////// 재고 //////////////////////////////////////////////////////////////////////
	// 1. 제품의 재고 등록
	public boolean ssave(Stock stock) {
		String sql = "insert into stock(scolor, ssize, samount, pnum) values(?, ?, ?, ?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, stock.getScolor() );
			ps.setString(2, stock.getSsize() );
			ps.setInt(3, stock.getSamount() );
			ps.setInt(4, stock.getPnum() );
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("재고등록오류"+e);}
		return false;
	} // 재고등록 end
	
	// 2. 제품의 재고 호출
	public ArrayList<Stock> getstock(int pnum) {
		ArrayList<Stock> slist = new ArrayList<Stock>();
		String sql = "select * from stock where pnum="+pnum;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next() ) {
				Stock stock = new Stock(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getInt(4), 
						rs.getString(5), 
						rs.getString(6), 
						rs.getInt(7) );
				slist.add(stock);
			} // while end
			return slist;
		}catch(Exception e) {System.out.println("재고호출오류"+e);}
		return null;
	} // 재고호출 end
	
	// 3. 제품의 재고 수정
	public boolean stockupdate(int snum, int samount) {
		String sql = "update stock set samount = "+samount+" where snum ="+snum;
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("재고수정오류"+e);}
		return false;
	} // 재고수정 end
	
	// 4. 제품의 재고 삭제
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
} // class end
