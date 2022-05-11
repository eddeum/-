package dao;

import java.util.ArrayList;

import dto.Chat;

public class ChatDao extends Dao {

	public ChatDao() {
		super();
	}
	
	// 호출용
	public static ChatDao chatDao = new ChatDao();
	public static ChatDao getChatDao() {return chatDao;}
	
	// 채팅쓰기 메소드
	public boolean chatwrite(Chat chat) {
		String sql = "insert into chat(cname, ccontent) values(?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, chat.getCname() );
			ps.setString(2, chat.getCcontent() );
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("채팅쓰기오류"+e);}
		return false;
	} // 채팅쓰기 end
	
	// 채팅 출력 메소드
	public ArrayList<Chat> getchatlist(){
		ArrayList<Chat> chatlist = new ArrayList<Chat>();
		String sql = "select * from chat";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next() ) {
				Chat chat = new Chat(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3) );
				chatlist.add(chat);
			} // while end
			return chatlist;
		}catch(Exception e) {System.out.println("채팅출력오류"+e);}
		return null;
	} // 채팅출력 end
	
	
} // class end
