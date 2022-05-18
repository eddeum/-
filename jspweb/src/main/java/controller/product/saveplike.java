package controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import dao.ProductDao;

/**
 * Servlet implementation class saveplike
 */
@WebServlet("/product/saveplike")
public class saveplike extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public saveplike() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid = request.getParameter("mid");
		int mnum = MemberDao.getmemberDao().getmnum(mid);
		int pnum = Integer.parseInt(request.getParameter("pnum"));
		
		int result = ProductDao.getproduDao().saveplike(pnum, mnum);
		if(result == 1) {response.getWriter().print(result);}
		else if(result == 2) {response.getWriter().print(result);}
		else if(result == 3)  {response.getWriter().print(result);}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
