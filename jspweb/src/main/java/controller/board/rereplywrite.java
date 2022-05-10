package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dao.MemberDao;
import dto.Reply;

/**
 * Servlet implementation class rereplywrite
 */
@WebServlet("/board/rereplywrite")
public class rereplywrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public rereplywrite() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rindex = Integer.parseInt(request.getParameter("rnum") ); // rindex : 어떤 댓글의 대댓글인지 식별번호(상위 댓글번호)
		int bnum = Integer.parseInt(request.getParameter("bnum") );
		String rcontent = request.getParameter("rrcontent");
			String mid = (String)request.getSession().getAttribute("login");
		int mnum = MemberDao.getmemberDao().getmnum(mid);
		
		// 객체화
		Reply reply = new Reply(0, rcontent, null, rindex, bnum, mnum, null);
		// DB 처리
		boolean result = BoardDao.getBoardDao().replywrite(reply);
		if(result) {
			response.getWriter().print(1);
		}else {
			response.getWriter().print(2);
		} // else end
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
