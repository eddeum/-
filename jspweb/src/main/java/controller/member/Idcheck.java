package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import dao.MemberDao;
import dto.Member;

// URL : 프로젝트명/경로
@WebServlet("/Idcheck")
public class Idcheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Idcheck() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String mid = request.getParameter("mid");
		
		// 1. Dao를 이용해서 해당 id가 있는지 체크
		boolean result = MemberDao.getmemberDao().idcheck(mid);
		// 2. 만약에 해당 아이디가 존재하면 1, 존재하지 않으면 2
		if(result) { // 아이디가 존재하면
			response.getWriter().print(1);
		}else { // 아이디가 존재하지 않으면
			response.getWriter().print(2);
		}
		
		System.out.println("js와 통신(아이디체크)");
		
		// 요청할때 request
		// 응답할때 response
			// ajax에게 데이터 보내기
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
