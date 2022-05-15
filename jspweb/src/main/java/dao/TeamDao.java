package dao;

import java.util.ArrayList;

import team.Country;
import team.User;

public class TeamDao extends Dao {

	public TeamDao() {
		super();
	}
	
	// 호출용
	public static TeamDao teamDao = new TeamDao();
	public static TeamDao getTeamDao() {return teamDao;}
	
	// 1. 나라 호출 메소드
	public ArrayList<Country> getcountry(){
		ArrayList<Country> clist = new ArrayList<Country>();
		String sql = "select * from country";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next() ) {
				Country country = new Country(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getInt(4), 
						rs.getInt(5) );
				clist.add(country);
			} // while end
			return clist;
		}catch(Exception e) {System.out.println("나라호출오류"+e);}
		return null;
	} // 나라호출 end
	
	// 2. 게임접속 메소드
	public boolean gameconnect(String mid) {
		String sql = "insert into user(mid, ulocation, umoney, uturn) values(?, ?, ?, ?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid );
			ps.setInt(2, 1 );
			ps.setInt(3, 500000 );
			ps.setInt(4, 0 );
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("게임접속오류"+e);}
		return false;
	} // 게임접속 end
	
	// 3. 게임접속자명단 호출 메소드
	public ArrayList<User> getuser(){
		ArrayList<User> ulist = new ArrayList<User>();
		String sql = "select * from user";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next() ) {
				User user = new User(rs.getInt(1), 
						rs.getString(2), 
						rs.getInt(3), 
						rs.getInt(4), 
						rs.getInt(5) );
				ulist.add(user);
			} // while end
			return ulist;
		}catch(Exception e) {System.out.println("접속명단호출오류"+e);}
		return null;
	} // 게임접속자명단 호출 end
}
