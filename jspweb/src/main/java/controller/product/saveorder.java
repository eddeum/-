package controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import dao.MemberDao;
import dao.ProductDao;
import dto.Order;

/**
 * Servlet implementation class saveorder
 */
@WebServlet("/product/saveorder")
public class saveorder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public saveorder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid = (String)request.getSession().getAttribute("login");
		int mnum = MemberDao.getmemberDao().getmnum(mid);
		
		String json = request.getParameter("orderjson");	// 변수요청
		try {
			JSONObject jsonObject = new JSONObject(json);		// json객체 형 변환
			// json 객체내 key 이용한 value 호출
			String ordername = jsonObject.get("ordername").toString();
			String orderphone = jsonObject.get("orderphone").toString(); 
			String orderaddress = jsonObject.get("orderaddress").toString();
			int totalpay = Integer.parseInt(jsonObject.get("ordertotalpay").toString() );
			String orderrequest = jsonObject.get("orderrequest").toString(); 
			
			Order order = new Order(0, null, ordername, orderphone, orderaddress, totalpay, 0, orderrequest, 0, mnum);
		
			System.out.println(order);
			
			// 1. 주문 DB처리[PK]
			boolean result = ProductDao.getproduDao().saveorder(order);
			// 2. js 응답처리
			response.getWriter().print(result);
		
		}catch (Exception e) {System.out.println("saveorder서블릿오류 : "+e);	}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
