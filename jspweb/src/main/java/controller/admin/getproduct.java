package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import dto.Product;

/**
 * Servlet implementation class getproduct
 */
@WebServlet("/admin/getproduct")
public class getproduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getproduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 변수요청
		String type = request.getParameter("type");
		int cnum = Integer.parseInt(request.getParameter("cnum") );
		// 응답 객체 설정
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		// DB 처리
		ArrayList<Product> list = ProductDao.getproduDao().getproductlist();
		String html = ""; // 반환될 html의 변수 선언
		// 반환 타입
		if(type != null && type.equals("option") ) {
			for(Product temp : list) {
				if(temp.getCnum() == cnum) {
					html += "<option value=\""+temp.getPnum() +"\">"+temp.getPname()+"</option>";
				} // if end
			} // for end
		}else {
			
		} // else end
		// 반환
		out.print(html);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
