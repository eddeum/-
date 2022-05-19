package dao;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import controller.admin.stockadd;
import dto.Cart;
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
	public Product getproduct(int pnum) {
		String sql = "select * from product where pnum="+pnum;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next() ) {
				Product product = new Product(rs.getInt(1), 
						rs.getString(2), 
						rs.getInt(3), 
						rs.getFloat(4), 
						rs.getInt(5), 
						rs.getString(6), 
						rs.getInt(7) );
					return product;
			} // if end
		}catch(Exception e) {System.out.println("개별제품호출오류"+e);}
		return null;
	} // 개별 제품 호출
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
	// 1. 관심등록
	public int saveplike(int pnum, int mnum) {
		// 1. 검색
		try {
			String sql = "select plikenum from plike where pnum="+pnum+" and mnum="+mnum;
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next() ) { // 2. 만약에 존재하면 삭제처리
				sql = "delete from plike where plikenum= "+rs.getInt(1);
				ps = con.prepareStatement(sql);
				ps.executeUpdate();
				return 2; // 삭제
			}else { // 3. 만약에 존재하지 않으면 등록처리
				sql = "insert into plike(pnum, mnum) values("+pnum+", "+mnum+")";
				ps = con.prepareStatement(sql);
				ps.executeUpdate();
				return 1; // 등록
			}
		}catch(Exception e) {System.out.println("관심등록오류"+e);} 
		return 3; // 4. 등록오류
	} // 관심등록 end
	
	// 2. 관심등록 여부 확인 메소드
	public boolean getplike(int pnum, int mnum) {
		String sql = "select * from plike where pnum = "+pnum+" and mnum ="+mnum;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next() ) return true;
		}catch(Exception e) {System.out.println("관심등록확인오류"+e);} 
		return false;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// 1. 장바구니 등록
	public boolean cartsave(Cart cart) {
	
		try {
			// 1. 장바구니 내에 동일한 제품이 존재하면 수량만 업데이트 처리
			String sql = "select cartnum from cart where snum = "+cart.getSnum()+" and mnum = "+cart.getMnum();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next() ) { // 동일한 제품이 존재하면
				sql = "update cart set samount = samount + "+cart.getSamount()+ " , totalprice = totalprice + "+cart.getTotalprice()+
						" where cartnum = "+rs.getInt(1);
				ps = con.prepareStatement(sql);
				ps.executeUpdate();
				return true;
			}else { // 존재하지 않으면 등록
			// 2. 존재하지 않으면 등록
				sql = "insert into cart(samount, totalprice, snum, mnum) values(?, ?, ?, ?)";
				ps = con.prepareStatement(sql);
				ps.setInt(1, cart.getSamount() );
				ps.setInt(2, cart.getTotalprice() );
				ps.setInt(3, cart.getSnum() );
				ps.setInt(4, cart.getMnum() );
				ps.executeUpdate();
				return true;
			} // else end
		}catch(Exception e) {System.out.println("장바구니등록오류"+e);} 
		return false;
	} // 장바구니등록 end
	
	// 2. 장바구니 출력
	public JSONArray getcart(int mnum) {
		JSONArray jsonArray = new JSONArray();
		String sql = "select"
				+ " A.cartnum as 장바구니번호,"
				+ " A.samount as 구매수량,"
				+ " A.totalprice as 총금액,"
				+ " B.scolor as 색상,"
				+ " B.ssize as 사이즈,"
				+ " B.pnum as 제품번호,"
				+ " C.pname as 제품명,"
				+ " C.pimg as 제품이미지"
				+ " from cart A join stock B on A.snum = B.snum join product C on B.pnum = C.pnum where A.mnum = "+mnum;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next() ) {
				// 결과내 하나씩 모든 레코드를 -> 하나씩
				JSONObject object = new JSONObject();
				object.put("cartnum", rs.getInt(1) );
				object.put("samount", rs.getInt(2) );
				object.put("totalprice", rs.getInt(3) );
				object.put("scolor", rs.getString(4) );
				object.put("ssize", rs.getString(5) );
				object.put("pnum", rs.getInt(6) );
				object.put("pname", rs.getString(7) );
				object.put("pimg", rs.getString(8) );
				// 하나씩 json객체를 json배열에 담기
				jsonArray.put(object);
			} // while end
			System.out.println(jsonArray.toString() );
			return jsonArray;
		}catch(Exception e) {System.out.println("장바구니출력오류"+e);} 
		return null;
	} // 장바구니 end

	
	
} // class end
