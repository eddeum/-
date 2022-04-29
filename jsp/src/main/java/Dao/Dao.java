package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Dto.Board;
import Dto.Member;

public class Dao {
	
	private Connection con; 		// db연결 클래스
	private PreparedStatement ps; 	// db조작 인터페이스
	private ResultSet rs;			// db결과 인터페이스
	
	public Dao() {
		//  jdbc
			// 1. 프로젝트내 build path -> mysqljdbc.jar 추가
			// 2. 프로젝트내 webapp -> web-inf-lib -> mysqljdbc.jar 추가
		
		// 1. db 서버 연동
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsptest?severTimezone=UTC", "root", "1234");
			System.out.println("연동성공");
		}catch (Exception e) {System.out.println("연동실패");}
	
	}
	
	// 회원가입 메소드
	public boolean signup(Member member) {
		
		// 1. SQL 작성
		String sql = "insert into member(mid, mpassword, mname) values(?, ?, ?)";
					// insert into 테이블(필드명1, 필드명2, 필드명3...) vales(값1, 값2, 값3...)
					// insert into 테이블 vales(값1, 값2, 값3, 값4....) -> 모든 필드에 넣을경우
		
		// 2. 연결된 DB에 SQL 연결
		try {
			ps = con.prepareStatement(sql);
		// 3. 각 ?에 데이터대입
			ps.setString(1, member.getMid() );
			ps.setString(2, member.getMpassword() );
			ps.setString(3, member.getMname() );
		// 4. sql 실행
			ps.executeUpdate();
			return true;
		}catch(Exception e) {
			System.out.println("오류 : "+e);
		}
		return false;
	} // 회원가입 end
	
	// 로그인 메소드
	public boolean login(String id, String password) {
		String sql = "select * from member where mid=? and mpassword=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			} // if end
		}catch(Exception e) {System.out.println("로그인오류 : "+e);}
		return false;
	} // 로그인 end
	
	// 회원탈퇴 메소드
	public boolean delete(String mid) {
		String sql = "delete from member where mid=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("회원탈퇴오류 : "+e);}
		return false;
	}
	
	// 게시물작성 메소드
	public boolean write(Board board) {
		String sql = "insert into board(btitle, bcontent, bwriter, bdate)values(?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, board.getBtitle());
			ps.setString(2, board.getBcontent());
			ps.setString(3, board.getBwriter());
			ps.setString(4, board.getBdate());
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("게시물작성오류 : "+e);}
		return false;
	} // 게시물작성 end
	
	// 게시물호출 메소드
	public ArrayList<Board> list(){
		ArrayList<Board> boardlist = new ArrayList<Board>(); // 리스트 선언[여러개 게시물 저장]
		String sql = "select * from board order by bno desc"; // 조건 없는 모든 레코드 출력
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Board board = new Board(rs.getInt(1),
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5) );
				boardlist.add(board);
			} // while e
			return boardlist;
		}catch(Exception e) {System.out.println("게시물호출오류 : "+e);}
		return null;
	} // 게시물호출 end
	
	// 개별 글 조회 메소드
	public Board get(int bno) {
		String sql = "select * from board where bno=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, bno);
			rs = ps.executeQuery();
			if(rs.next()) {
				Board board = new Board(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5) );
				return board;
			}
		}catch(Exception e) {System.out.println("게시물조회오류 : "+e);}
		return null;
	}
	
	// 게시물 삭제 메소드
	public boolean bdelete(int bno) {
		String sql = "delete from board where bno=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, bno);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("게시물삭제오류 : "+e);}
		return false;
	} // 게시물삭제 end

} // class end
