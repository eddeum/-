package dao;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import dto.Board;

public class BoardDao extends Dao {

	public BoardDao() {
		super();	// 슈퍼클래스 호출(db 연동)
	}
	
	// 호출용
	public static BoardDao boardDao = new BoardDao();
	public static BoardDao getBoardDao() {return boardDao;}

	// 1. 게시물 쓰기 메소드[인수 : 작성된 데이터들 = dto]
	public boolean write(Board board) {
		String sql = "insert into board(btitle, bcontent, mnum, bfile)values(?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, board.getBtitle() );
			ps.setString(2, board.getBcontent() );
			ps.setInt(3, board.getMnum() );
			ps.setString(4, board.getBfile() );
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("게시물쓰기오류"+e);}
		return false;
	} // 게시물쓰기 end
	
	// 2. 모든 게시물 출력 메소드[추후기능 검색 : 조건]
	public ArrayList<Board> getboardlist() {
		ArrayList<Board> boardlist = new ArrayList<Board>();
		String sql = "select a.* ,b.mid  FROM board a left join member b on a.mnum = b.mnum order by bnum desc";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next() ) {
				Board board = new Board(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getInt(4), 
						rs.getInt(5), 
						rs.getString(6), 
						rs.getString(7), 
						rs.getString(8) );
				boardlist.add(board);
				System.out.println("확인중");
			} // while end
			return boardlist;
		}catch(Exception e) {System.out.println("모든게시물출력오류"+e);}
		return null;
	} // 모든게시물 출력 end
	
	// 3. 개별 게시물 출력 메소드[인수 : 게시물번호]
	public Board getboard() {return null;}
	// 4. 게시물 수정 메소드[인수 : 게시물번호 / 수정된 내용]
	public boolean update(Board board) {return false;}
	// 5. 게시물 삭제 메소드[인수 : 게시물번호]
	public boolean delete(int bnum) {return false;}
	// 6. 게시물 조회 증가 메소드[인수 : 증가할 게시물번호]
	public boolean increview(int bnum) {return false;}
	// 7. 댓글 작성 메소드[인수 : 작성된 데이터들 = dto]
	public boolean replywrite() {return false;}
	// 8. 댓글 출력 메소드
	public boolean replylist() {return false;}
	// 9. 댓글 수정 메소드[인수 : 수정할 댓글 번호]
	public boolean replyupdate() {return false;}
	// 10. 댓글 삭제 메소드[인수 : 삭제할 댓글 번호]
	public boolean replydelete() {return false;}
	
}
