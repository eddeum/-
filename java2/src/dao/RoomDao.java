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
	
	// �ʵ�
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public static RoomDao roomDao = new RoomDao();
	
	// ������
	public RoomDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC","root","1234");
		}catch(Exception e) {System.out.println("[SQL ���� ����]"+e);}
	}

	////////////// line 10~23�� Dao Ŭ�������� �ߺ��ǹǷ� ����Ŭ������ ���� ����ϴ°� ���� //////////////
	
	// �޼ҵ�
	// 1. �� ���� �޼ҵ�
	public boolean roomadd(Room room) {
		try {
			String sql = "insert into room(roname, roip)values(?,?)";
						// ���̺� ���ڵ� �߰��ϴ� ���� : "insert into ���̺��(�ʵ�1, �ʵ�2) values(?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, room.getRoname());
			ps.setString(2, room.getRoip());
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("[SQL ���� ����]"+e);}
		return false;
	} // roomadd end
	
	// 2. ���ȣ ȣ�� �޼ҵ�[���ȣ = ��Ʈ��ȣ�� ����� ����]
	public int getroomnum() { // ���� �ֱٿ� ��ϵ� �� ��ȣ ��������
		try {
			String sql = "select max(ronum) from room";
				// ���̺��� ��ȸ/�˻��ϴ� ���� : "select ǥ�����ʵ��(*�� ��� ����ʵ�) from ���̺��";
				// max(�ʵ��) : �ʵ��� ���� ū�� ----> DB �Լ�
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			} // if e
		}catch(Exception e) {System.out.println("[SQL ���� ����]"+e);}
		return 0;
	} // getroomnum end
	
	// 3. ��� �� ȣ�� �޼ҵ�[tableview �� -> ObservableList�� ��밡��]
	public ObservableList<Room> roomlist(){
		
		ObservableList<Room> roomlist = FXCollections.observableArrayList();
		try {
			String sql = "select * from room order by ronum desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(); // select -> query // insert, update, delete -> update
			// rs = Resultset �������̽� ��ü : select�� ��� ��������
				// resultset�� �ʱⰪ�� null
				// rs.next() : select ����� ���ڵ� 1�� ��������
				// rs(null) -> rs.next() -> rs(�����ù��°���ڵ�) -> rs.next() -> rs(����ǵι�°���ڵ�)
			while(rs.next()) {
				Room room = new Room(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						0);
				roomlist.add(room);
			}  // while e
			return roomlist;
		}catch(Exception e) {System.out.println("[SQL ���� ����]"+e);}
		return null;
	} // roomlist end
	
	// 4. ä�ù� ���� ��� �߰�
	public boolean addroomlive(Roomlive roomlive) {
		try {
			String sql = "insert into roomlive(ronum,mid)values(?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, roomlive.getRonum());
			ps.setString(2, roomlive.getMid());
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("[SQL ���� ����]"+e);}
		return false;
	} // addroomlive end
	
	// 5. ä�ù� ���ӵ� ��� ��� ȣ��
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
		}catch(Exception e) {System.out.println("[SQL ���� ����]"+e);}
		return null;
	} // getroomlivelist end
	
	// 6. ä�ù� ���� ��� ����
	public boolean roomlivedelete(String mid) {
		try {
			String sql = "delete from roomlive where mid=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, mid);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("[SQL ���� ����]"+e);}
		return false;
	} // roomlivedelet end
	
	// 7. ä�ù� ����[���� : �ش� ä�ù濡 �����ο��� 0�̸�]
	public boolean roomdelete(int ronum) {
		
		// ���࿡ �ش� ���ȣ�� roomlive���� �˻�������
			// �˻������ �����ϸ� �� ���� X
			// �˻������ ������ �� ���� O
		try {
			String sql = "select * from roomlive where ronum=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, ronum);
			rs = ps.executeQuery();
				// rs.next() : ��ȯŸ��[���� ���ڵ尡 ������ true]
				//			  		[���� ���ڵ尡 ������ false]
			if(rs.next()) { // ����� �����ϸ� ����� X
				return false;
			}else { // ����� ������ ����� O
				String sql2 = "delete from room where ronum =?";
				ps = conn.prepareStatement(sql2);
				ps.setInt(1, ronum);
				ps.executeUpdate();
				return true; // ���� ����� ���� �� ���� ����
			} // else e
			
		}catch(Exception e) {System.out.println("[SQL ���� ����]"+e);}
		return false;
	} // roomdelete end
	
	
} // ce
