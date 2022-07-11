package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import dto.Vote;

/**
 * Servlet implementation class vote
 */
@WebServlet("/vote")
public class vote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public vote() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String birth = request.getParameter("birth");
		String name = request.getParameter("name");
		String voteno = request.getParameter("voteno");
		String votetime = request.getParameter("votetime");
		String votearea = request.getParameter("votearea");
		String confirm = request.getParameter("confirm");
		
		Vote vote = new Vote(birth, name, voteno, votetime, votearea, confirm);
		
		boolean result = Dao.getDao().vote(vote);
		// 자바에서 js에게 HTML 전송
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter(); // HTML 에게 전송 객체생성
		out.println("<script> alert('투표하기 정보가 정상적으로 등록 되었습니다.'); location.href='/ezentest_최으뜸/index.jsp' </script>");
//		out.println("<script>");
//		out.println("alert('투표하기 정보가 정상적으로 등록 되었습니다.');");
//		out.println("location.href='/ezentest_최으뜸/main.jsp';");
//		out.println("</script>");
		out.close();
		
	}

}
