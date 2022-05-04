package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import dto.Member;

/**
 * Servlet implementation class update
 */
@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update() {
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
		
		request.setCharacterEncoding("UTF-8"); // 요청시 사용되는 인코딩타입 [ 한글 포함 ] 
		
		// 패스워드 체크[유효성 검사]
		String oldpassword = request.getParameter("oldpassword");
		String newpassword = request.getParameter("newpassword");
		
		// 수정 내용물
		int mnum = Integer.parseInt(request.getParameter("mnum") );
		String mname = request.getParameter("mname");
		String mphone = request.getParameter("mphone");
		String memail = request.getParameter("memail");
		String memailaddress = request.getParameter("memailaddress");
			String email = memail+"@"+memailaddress;
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String address3 = request.getParameter("address3");
		String address4 = request.getParameter("address4");
			String address = address1+"_"+address2+"_"+address3+"_"+address4;
		
		Member member = null;
		if(oldpassword.equals("") || newpassword.equals("") ) { // 패스워드 변경이 없을때
			member = new Member(mnum, null, null, mname, mphone, email, address, 0, null);
		}else { // 패스워드 변경이 있을때
			// 기존 패스워드 체크
			HttpSession session = request.getSession();
			String mid = (String)session.getAttribute("login");
			
			boolean result = MemberDao.getmemberDao().passwordcheck(mid, oldpassword);
			if(result) { // 기존패스워드가 동일하면
				member = new Member(mnum, null, newpassword, mname, mphone, email, address, 0, null);
			}else { // 동일하지 않으면
				response.sendRedirect("/jspweb/member/update.jsp?result=3");
				return;
			} // else e
		
		} // else e
		
		//System.out.println(member.toString()); // 확인용
		
		// DB 처리
		boolean result = MemberDao.getmemberDao().update(member);
		if(result) {
			response.sendRedirect("/jspweb/member/update.jsp?result=1");
		}else {
			response.sendRedirect("/jspweb/member/update.jsp?result=2");
		} // else e
	}

}
