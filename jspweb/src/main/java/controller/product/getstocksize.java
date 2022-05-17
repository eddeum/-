package controller.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import dto.Stock;

/**
 * Servlet implementation class getstocksize
 */
@WebServlet("/product/getstocksize")
public class getstocksize extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getstocksize() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int pnum = Integer.parseInt(request.getParameter("pnum") );
		String scolor = request.getParameter("color");
		
		ArrayList<Stock> list = ProductDao.getproduDao().getstock(pnum);
		// 제품별 사이즈와 재고[문자열, map, json 등]
			// List 컬렉션 : 중복 O	[인덱스O]
			// Set 컬렉션 : 중복 X	[인덱스X]
			// Map 컬렉션 : key(set값/중복x) : value => entry엔트리
		Map<String, String> map = new TreeMap<>();
		for(Stock s : list) {
			if(s.getScolor().equals(scolor) ) {
				if(s.getSamount() == 0) {
					map.put(s.getSsize(), "품절" );
				}else {
					map.put(s.getSsize(), s.getSamount()+"개" );
				} // else end
			} // if end
		} // for end
		// 응답[1. HTML 2. 데이터]
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(map);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
