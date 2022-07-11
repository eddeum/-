package controller.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import dao.MemberDao;
import dao.ProductDao;
import dto.Cart;
import dto.Stock;

/**
 * Servlet implementation class savecart
 */
@WebServlet("/product/savecart")
public class savecart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public savecart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pnum = Integer.parseInt(request.getParameter("pnum") ) ;
		
		// json형식 문자열 통신호출
		String data = request.getParameter("json");
		System.out.println(data);
		// json형식 문자열 -> json 객체로 변환
		try {
			// [{ }, { }, { }, { }] 문자열 -> JSONArray 변경
			// 1. 통신한 데이터를 JSONarray형으로 형변환
			JSONArray jsonArray = new JSONArray(data);
			// 2. 반복문을 이용한 jsonarray에서 jsonobject 호출
			
			int error = -1; // 여러개 DB처리중 오류 여부 저장[-1 : 인덱스 없다]
			int i = 0;
			for(i = 0; i<jsonArray.length(); i++) {
			// 3. jsonarray 배열내 i번째 객체 호출
				JSONObject jsonObject = jsonArray.getJSONObject(i);
			// 4. 해당 객체에 키를 이용한 값 호출
				System.out.println(jsonObject.get("pname") );
				System.out.println(jsonObject.get("color") );
				System.out.println(jsonObject.get("size") );
				System.out.println(jsonObject.get("amount") );
				System.out.println(jsonObject.get("pprice") );
				System.out.println(jsonObject.get("totalprice") );
				System.out.println(jsonObject.get("point") );
			// 5. json -> dto
				String mid = (String)request.getSession().getAttribute("login");
				int mnum = MemberDao.getmemberDao().getmnum(mid);
				// json객체명.get(키) -> 반환타입 : object -> String -> int
				int amount = Integer.parseInt(jsonObject.get("amount").toString() );
				int totalprice = Integer.parseInt(jsonObject.get("totalprice").toString() );
				// snum 구하기
				String color = jsonObject.get("color").toString();
				String size = jsonObject.get("size").toString();
				int snum = 0;
				ArrayList<Stock> list =  ProductDao.getproduDao().getstock(pnum);
				for(Stock s : list) {
					if(s.getSsize().equals(size) && s.getScolor().equals(color)) {
						snum = s.getSnum();
					} // if end
				} // for end
				Cart cart = new Cart(0, amount, totalprice, snum, mnum);
				System.out.println("json->dto :" + cart.toString() );
				
				boolean result = ProductDao.getproduDao().cartsave(cart);
				if(result == false) error = i;
			} // for end
			if(error == -1) {response.getWriter().print(-1);}
			else {response.getWriter().print(i);}
		}catch(Exception e) {}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
