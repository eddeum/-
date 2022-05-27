package dao;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mysql.cj.xdevapi.Statement;

import controller.admin.stockadd;
import dto.Cart;
import dto.Category;
import dto.Order;
import dto.Orderdetail;
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
	
	// 장바구니 수정 메소드
	public boolean updatecart(int cartnum, int samount, int totalprice) {
		String sql = "update cart set samount = "+samount+" , totalprice = "+totalprice+" where cartnum ="+cartnum;
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("장바구니수정오류"+e);} 
		return false;
	} // 장바구니 수정 end
	
	// 장바구니 삭제 메소드
	public boolean deletecart(int cartnum) {
		String sql = "delete from cart where cartnum="+cartnum;
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("장바구니삭제오류"+e);} 
		return false;
	} // 장바구니 삭제 end
	
	// 장바구니 상품개수 출력 메소드
	public int getcartnum(int mnum) {
		String sql = "select count(*) from cart where mnum= "+mnum;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next() ) {
				return rs.getInt(1);
			} // if end
		}catch(Exception e) {System.out.println("장바구니상품개수출력오류"+e);} 
		return 0;
	} // 장바구니 상품개수 end

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// 주문하기
	public boolean saveorder(Order order) {
		String sql = "insert into porder(ordername, orderphone, orderaddress, ordertotalpay, orderrequest, mnum) values(?, ?, ?, ?, ?, ?)";
		// ** insert 후에 자동 생성된 pk 값 가져오기
		try {
			ps = con.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS );
			ps.setString(1, order.getOrdername() );
			ps.setString(2, order.getOrderphone() );
			ps.setString(3, order.getOrderaddress() );
			ps.setInt(4, order.getOrdertotalpay() );
			ps.setString(5, order.getOrderrequest());
			ps.setInt(6, order.getMnum() );
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if(rs.next() ) {
				System.out.println("방금생성된pk값"+rs.getInt(1));
				int pk = rs.getInt(1);
				
				// cart -> porderdetail
				sql = "insert into porderdetail(samount, totalprice, ordernum, snum)"
						+"select samount, totalprice, "+pk+" , snum from cart where mnum = "+order.getMnum();
				ps = con.prepareStatement(sql);
				ps.executeUpdate();
				// cart -> delete
				sql = "delete from cart where mnum ="+order.getMnum();
				ps = con.prepareStatement(sql);
				ps.executeUpdate();
				return true;
			} // if end
		}catch(Exception e) {System.out.println("주문하기오류"+e);}
		
		return false;
	} // saveorder end
	
	// 주문내역 메소드
	public JSONArray getorder(int mnum) {
		String sql = "select a.ordernum as 주문번호, "
				+ "		a.orderdate as 주문일, "
				+ "        b.orderdetailnum as 주문상세번호 ,"
				+ "        b.orderdetailactive as 상품상태, "
				+ "        b.samount as 수량, "
				+ "        c.snum as 재고번호, "
				+ "        c.scolor as 색상, "
				+ "		c.ssize as 사이즈, "
				+ "        d.pnum as 제품번호, "
				+ "        d.pname as 제품명, "
				+ "        d.pimg as 제품사진 "
				+ " from porder a join porderdetail b on a.ordernum = b.ordernum "
				+ " join stock c on b.snum = c.snum "
				+ " join product d on c.pnum = d.pnum where a.mnum = "+mnum+" order by a.ordernum desc";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			// json 사용하는 이유 -> js로 전송하기 위해
			// arraylist 사용하는 이유 -> jsp 사용하려면
			
			JSONArray parentlist = new JSONArray(); 	// 상위 리스트[여러개의 하위 리스트]
			JSONArray childlist = new JSONArray(); 		// 하위 리스트
			int oldordernum = -1; 					// 이전 데이터의 주문번호 변수
			while(rs.next() ) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("ordernum", rs.getInt(1));
				jsonObject.put("orderdate", rs.getString(2));
				jsonObject.put("orderdetailnum", rs.getInt(3));
				jsonObject.put("orderdetailactive", rs.getInt(4));
				jsonObject.put("samount", rs.getInt(5));
				jsonObject.put("snum", rs.getInt(6));
				jsonObject.put("scolor", rs.getString(7));
				jsonObject.put("ssize", rs.getString(8));
				jsonObject.put("pnum", rs.getInt(9));
				jsonObject.put("pname", rs.getString(10));
				jsonObject.put("pimg", rs.getString(11));
				
				// 동일한 주문번호이면 동일한 리스트에 담기
					// { 키 : 값 }
					// {"ordernum" : [키 : 값, 키2 : 값2]}
				if(oldordernum == rs.getInt(1)) { // 앞전 주문번호와 현재 주문번호 동일하면
					childlist.put(jsonObject);
				}else {
					childlist = new JSONArray();	// 하위 리스트 초기화
					childlist.put(jsonObject);		// 하쉬 리스트에 데이터 담기
					parentlist.put(childlist);		// 상위 리스트에 하위 리스트 추가
				} // else end
				oldordernum = rs.getInt(1);	// 이전 주문번호 변수에 현재 주문번호 넣기
			} // while end
			return parentlist;
		}catch(Exception e) {System.out.println("주문내역오류"+e);}
		return null;
	} // 주문내역 end
	
	// 주문취소 메소드
	public boolean cancelorder(int orderdetailnum, int active) {
		String sql = "update porderdetail set orderdetailactive = "+active+ " where orderdetailnum = "+orderdetailnum;
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("주문취소오류"+e);}
		return false;
	} // 주문취소 end
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// 매출차트 데이터호출
	public JSONArray getchart(int type, int value) {
		
		String sql = "";
		JSONArray ja = new JSONArray();
		
		if(type == 1) { // 일별 매출
			sql = "select "
					+ "substring_index( orderdate, ' ', 1) as 날짜, "
					+ "sum(ordertotalpay) from porder "
					+ "group by 날짜 order by 날짜 desc";
		}else if(type == 2) { // 카테고리별 전체 판매량
			sql = "select"
					+ "	sum(a.samount), "
					+ "    d.cname "
					+ "from porderdetail a, stock b, product c, category d where a.snum = b.snum and b.pnum = c.pnum and c.cnum = d.cnum "
					+ "group by d.cname "
					+ "order by orderdetailnum desc; ";
		}else if(type == 3) { // 재고번호 -> 제품별 판매량 추이
			sql = "select "
					+ "	substring_index(a.orderdate, ' ', 1)  as 날짜, "
					+ " sum(b.samount) as 총판매수량 "
					+ "	from porder a, porderdetail b, stock c "
					+ " where a.ordernum = b.ordernum "
					+ " and b.snum = c.snum "
					+ " and c.pnum = (select pnum from stock where snum = "+value+") "
					+ " group by 날짜 order by 날짜 desc";
		} // else if end
	
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next() ) {
				JSONObject jo = new JSONObject();
				if(type == 1 || type == 3) {  // 일별 매출
					jo.put("date", rs.getString(1) );
					jo.put("value", rs.getInt(2) );
					ja.put(jo);
				}else if(type == 2) {  // 카테고리별 전체 판매량
					jo.put("value", rs.getInt(1) );
					jo.put("category", rs.getString(2) );
					ja.put(jo);
				} // else if end
			} // while end
			
			return ja;
		}catch(Exception e) {System.out.println("매출데이터호출오류"+e);}
		return null;
	} // 매출차트 데이터호출 end
	
	// 오늘 주문상세 호출
	public ArrayList<Orderdetail> getorderdetail(){
		ArrayList<Orderdetail> list = new ArrayList<Orderdetail>();
		String sql = "select a.*, substring_index(b.orderdate, ' ', 1)as 날짜 "
				+ "from porderdetail a, porder b "
				+ "where a.ordernum = b.ordernum "
				+ "and substring_index(b.orderdate, ' ', 1) = substring_index(now(), ' ', 1) "
				+ "and a.orderdetailactive = 3";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next() ) {
				Orderdetail orderdetail = new Orderdetail();
				orderdetail.setOrderdetailnum(rs.getInt(1));
				orderdetail.setOrderdetailactive(rs.getInt(2));
				orderdetail.setSnum(rs.getInt(3));
				orderdetail.setSamount(rs.getInt(4));
				orderdetail.setTotalprice(rs.getInt(5));
				orderdetail.setOrdernum(rs.getInt(6));
				list.add(orderdetail);
			} // while end
			return list;
		}catch(Exception e) {System.out.println("오늘주문상세호출오류"+e);}
		return null;
	} // 오늘주문 호출 end
	
} // class end
