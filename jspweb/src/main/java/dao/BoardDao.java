package dao;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import dto.Board;
import dto.Member;
import dto.Reply;

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
			} // while end
			return boardlist;
		}catch(Exception e) {System.out.println("모든게시물출력오류"+e);}
		return null;
	} // 모든게시물 출력 end
	
	// 3. 개별 게시물 출력 메소드[인수 : 게시물번호]
	public Board getboard(int bnum) {
		String sql = "select * from board where bnum="+bnum;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next() ) {
				Board board = new Board(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getInt(4), 
						rs.getInt(5), 
						rs.getString(6), 
						rs.getString(7), 
						null );
				return board;
			}
		}catch(Exception e) {System.out.println("개별게시물출력오류"+e);}
		return null;
	} // 개별게시물 출력 end
	
	// 3-2 회원별 게시물 출력 메소드
	public ArrayList<Board> getmyboard(int mnum) {
		ArrayList<Board> myboardlist = new ArrayList<Board>();
		String sql = "select *from board where mnum = "+mnum;
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
						null );
				myboardlist.add(board);
			} // while end
			return myboardlist;
		}catch(Exception e) {System.out.println("회원별게시물출력오류"+e);}
		return null;
	}
	
	// 4. 게시물 수정 메소드[인수 : 게시물번호 / 수정된 내용]
	public boolean update(Board board) {
		String sql = "update board set btitle=?, bcontent=?, bfile=? where bnum=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, board.getBtitle() );
			ps.setString(2, board.getBcontent() );
			ps.setString(3, board.getBfile() );
			ps.setInt(4, board.getBnum() );
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("게시물수정오류"+e);}
		return false;
	} // 게시물수정 end
	
	// 5. 게시물 삭제 메소드[인수 : 게시물번호]
	public boolean delete(int bnum) {
		String sql = "delete from board where bnum="+bnum;
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("게시물삭제오류"+e);}
		return false;
	} // 게시물삭제 end
	
	// 5-2 첨부파일만 삭제(null로 변경) 메소드
	public boolean filedelete(int bnum) {
		String sql = "update board set bfile = null where bnum = "+bnum;
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("첨부파일null변경오류"+e);}
		return false;
	} // 첨부파일 null end
	
	// 6. 게시물 조회 증가 메소드[인수 : 증가할 게시물번호]
	public boolean increview(int bnum) {
		String sql = "update board set bview = bview+1 where bnum = "+bnum;
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("게시물조회수증가오류"+e);}
		return false;
	} // 게시물 조회수 증가 end
	
	// 7. 댓글 작성 메소드[인수 : 작성된 데이터들 = dto]
	public boolean replywrite(Reply reply) {
		String sql = "insert into reply(rcontent, rindex, bnum, mnum) values(?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, reply.getRcontent() );
			ps.setInt(2, reply.getRindex() );
			ps.setInt(3, reply.getBnum() );
			ps.setInt(4, reply.getMnum() );
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("댓글작성오류"+e);}
		return false;
	} // 댓글작성 end
	
	// 8. 댓글 출력 메소드
	public ArrayList<Reply> replylist(int bnum) {
		ArrayList<Reply> replylist = new ArrayList<Reply>();
		String sql = "select * from reply where bnum = "+bnum+" and rindex = 0";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next() ) {
				Reply reply = new Reply(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getInt(4), 
						rs.getInt(5), 
						rs.getInt(6),
						null);
				replylist.add(reply);
			} // while end
			return replylist;
		}catch(Exception e) {System.out.println("댓글출력오류"+e);}
		return null;
	} // 댓글출력 end
	
	// 8-2 대댓글 출력 메소드
	public ArrayList<Reply> rereplylist(int bnum, int rnum){
		ArrayList<Reply> rereplylist = new ArrayList<Reply>();
		String sql = "select * from reply where bnum = "+bnum+" and rindex = "+rnum;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next() ) {
				Reply reply = new Reply(rs.getInt(1),
						rs.getString(2), 
						rs.getString(3), 
						rs.getInt(4), 
						rs.getInt(5), 
						rs.getInt(6), 
						null);
				rereplylist.add(reply);
			} // while end
			return rereplylist;
		}catch(Exception e) {System.out.println("대댓글출력오류"+e);}
		return null;
	} // 대댓글출력 end
	
	// 9. 댓글 수정 메소드[인수 : 수정할 댓글 번호]
	public boolean replyupdate(int rnum, String rcontent) {
		String sql = "update reply set rcontent = "+rcontent+" where rnum = "+rnum+" or rindex = "+rnum;
		try {
			ps = con.prepareStatement(sql);

			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("댓글수정오류"+e);}
		return false;
	} // 댓글수정 end
	
	// 10. 댓글 삭제 메소드[인수 : 삭제할 댓글 번호]
	public boolean replydelete(int rnum) {
		String sql = "delete from reply where rnum = "+rnum+" or rindex = "+rnum;
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("댓글삭제오류"+e);}
		return false;
	} // 댓글삭제 end
	
}
