package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.Product;
import dto.Room;
import dto.Roomlive;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RoomDao {
	
	// 필드
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public static RoomDao roomDao = new RoomDao();
	
	// 생성자
	public RoomDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC","root","1234");
		}catch(Exception e) {System.out.println("[SQL 연동 오류]"+e);}
	}

	////////////// line 10~23은 Dao 클래스마다 중복되므로 슈퍼클래스로 만들어서 사용하는게 좋음 //////////////
	
	// 메소드
	// 1. 방 저장 메소드
	public boolean roomadd(Room room) {
		try {
			String sql = "insert into room(roname, roip)values(?,?)";
						// 테이블에 레코드 추가하는 문법 : "insert into 테이블명(필드1, 필드2) values(?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, room.getRoname());
			ps.setString(2, room.getRoip());
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("[SQL 연동 오류]"+e);}
		return false;
	} // roomadd end
	
	// 2. 방번호 호출 메소드[방번호 = 포트번호로 사용할 예정]
	public int getroomnum() { // 가장 최근에 등록된 방 번호 가져오기
		try {
			String sql = "select max(ronum) from room";
				// 테이블에서 조회/검색하는 문법 : "select 표시할필드명(*의 경우 모든필드) from 테이블명";
				// max(필드명) : 필드의 가장 큰값 ----> DB 함수
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			} // if e
		}catch(Exception e) {System.out.println("[SQL 연동 오류]"+e);}
		return 0;
	} // getroomnum end
	
	// 3. 모든 방 호출 메소드[tableview 가 -> ObservableList만 사용가능]
	public ObservableList<Room> roomlist(){
		
		ObservableList<Room> roomlist = FXCollections.observableArrayList();
		try {
			String sql = "select * from room order by ronum desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(); // select -> query // insert, update, delete -> update
			// rs = Resultset 인터페이스 객체 : select의 결과 가져오기
				// resultset의 초기값은 null
				// rs.next() : select 결과의 레코드 1개 가져오기
				// rs(null) -> rs.next() -> rs(결과의첫번째레코드) -> rs.next() -> rs(결과의두번째레코드)
			while(rs.next()) {
				Room room = new Room(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						0);
				roomlist.add(room);
			}  // while e
			return roomlist;
		}catch(Exception e) {System.out.println("[SQL 연동 오류]"+e);}
		return null;
	} // roomlist end
	
	// 4. 채팅방 접속 명단 추가
	public boolean addroomlive(Roomlive roomlive) {
		try {
			String sql = "insert into roomlive(ronum,mid)values(?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, roomlive.getRonum());
			ps.setString(2, roomlive.getMid());
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("[SQL 연동 오류]"+e);}
		return false;
	} // addroomlive end
	
	// 5. 채팅방 접속된 모든 명단 호출
	public ArrayList<Roomlive> getroomlivelist(int ronum){
		ArrayList<Roomlive> roomlivelist = new ArrayList<>();
		try {
			String sql = "select * from roomlive where ronum =?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, ronum);
			rs = ps.executeQuery();
			while(rs.next()) {
				Roomlive roomlive = new Roomlive(rs.getInt(1), rs.getInt(2), rs.getString(3) );
				roomlivelist.add(roomlive);
			} // while e
			return roomlivelist;
		}catch(Exception e) {System.out.println("[SQL 연동 오류]"+e);}
		return null;
	} // getroomlivelist end
	
	// 6. 채팅방 접속 명단 삭제
	public boolean roomlivedelete(String mid) {
		try {
			String sql = "delete from roomlive where mid=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, mid);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("[SQL 연동 오류]"+e);}
		return false;
	} // roomlivedelet end
	
	// 7. 채팅방 삭제[조건 : 해당 채팅방에 접속인원이 0이면]
	public boolean roomdelete(int ronum) {
		
		// 만약에 해당 방번호로 roomlive에서 검색했을때
			// 검색결과가 존재하면 방 삭제 X
			// 검색결과가 없으면 방 삭제 O
		try {
			String sql = "select * from roomlive where ronum=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, ronum);
			rs = ps.executeQuery();
				// rs.next() : 반환타입[다음 레코드가 있으면 true]
				//			  		[다음 레코드가 없으면 false]
			if(rs.next()) { // 결과가 존재하면 방삭제 X
				return false;
			}else { // 결과가 없으면 방삭제 O
				String sql2 = "delete from room where ronum =?";
				ps = conn.prepareStatement(sql2);
				ps.setInt(1, ronum);
				ps.executeUpdate();
				return true; // 접속 명단이 없는 방 삭제 성공
			} // else e
			
		}catch(Exception e) {System.out.println("[SQL 연동 오류]"+e);}
		return false;
	} // roomdelete end
	
	
} // ce
