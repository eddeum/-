package controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import dao.ProductDao;

/**
 * Servlet implementation class updatecart
 */
@WebServlet("/product/updatecart")
public class updatecart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatecart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String json = request.getParameter("json"); // json 변수 요청
		try {
			JSONArray jsonArray = new JSONArray(json);				// json배열로 형변환
			for(int i = 0; i<jsonArray.length(); i++) {				
				JSONObject jsonObject = jsonArray.getJSONObject(i);	// json배열 내 json객체를 하나씩 호출
				int cartnum = Integer.parseInt(jsonObject.get("cartnum").toString() );	// 객체내 key를 이용한 value 호출
				int samount = Integer.parseInt(jsonObject.get("samount").toString() );
				int totalprice =  Integer.parseInt(jsonObject.get("totalprice").toString() );
				ProductDao.getproduDao().updatecart(cartnum, samount, totalprice); // DAO를 이용한 수량/금액 업데이트 처리
				
				
			} // for end
		} catch (Exception e) {System.out.println("updatecart서블릿오류 : " +e);}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
