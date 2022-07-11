package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import dto.Member;
import dto.Vote;

public class Dao {
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public Dao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/xe","root","1234");
			System.out.println("DAO 연동성공");
		}catch(Exception e) {System.out.println("Dao에서 연동실패");}
	}
	
	// 호출용
	public static Dao dao = new Dao();
	public static Dao getDao() {return dao;}
	
	// 1. 후보조회
	public ArrayList<Member> getmember(){
		ArrayList<Member> memberlist = new ArrayList<Member>();
		String sql = "select "
				+ "a.M_no as 후보번호, a.M_NAME as 성명, b.P_NAME as 소속정당, a.P_SCHOOL as 학력, "
				+ "concat(substr(a.M_JUMIN,1,6),'-',substr(a.M_JUMIN,7,13)) as 주민번호, a.M_CITY as 지역구, "
				+ "concat(b.P_TEL1, '-', b.P_TEL2, '-', b.P_TEL3) as 대표전화 "
				+ "from tbl_member_202005 a join tbl_party_202005 b on a.P_CODE = b.P_CODE";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Member member = new Member();
				member.setM_NO(rs.getString(1) );
				member.setM_NAME(rs.getString(2) );
				member.setP_NAME(rs.getString(3) );
				member.setP_SCHOOL(rs.getString(4) );
				member.setM_JUMIN(rs.getString(5) ); 
				member.setM_CITY(rs.getString(6) );
				member.setP_TEL(rs.getString(7) ); 
				
				memberlist.add(member);
			} // while end
			return memberlist;
		}catch (Exception e) { System.out.println("후보조회오류 : "+ e );} 
		return null;
	}
	
	// 2. 투표하기
	public boolean vote(Vote vote) {
		String sql = "insert into xe.tbl_vote_202005(V_JUMIN, V_NAME, M_NO, V_TIME, V_AREA, V_CONFIRM)"
				+ "values(?, ?, ?, ?, ?, ?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, vote.getV_JUMIN() );
			ps.setString(2, vote.getV_NAME() );
			ps.setString(3, vote.getM_NO() );
			ps.setString(4, vote.getV_TIME() );
			ps.setString(5, vote.getV_AREA() );
			ps.setString(6, vote.getV_CONFIRM() );
			ps.executeUpdate();
			return true;
		}catch (Exception e) { System.out.println("투표하기오류 : "+ e );} 
		return false;
	}
	
	// 3. 투표검수조회 화면
	public ArrayList<Vote> getvotelist(){
		ArrayList<Vote> votelist = new ArrayList<Vote>();
		String sql = "select * from tbl_vote_202005 where V_AREA = '제1투표장'";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next() ) {
				Vote vote = new Vote(rs.getString(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getString(6) );
				votelist.add(vote);
			}
			return votelist;
		}catch (Exception e) { System.out.println("투표검수조회오류 : "+ e );} 
		return null;
	}
	
	// 4. 후보자등수 화면
	public ArrayList<Member> getvoteresult(){
		ArrayList<Member> voteresult = new ArrayList<Member>();
		String sql = "select a.M_no as 후보번호, a.M_NAME as 성명, "
				+ "count(case when b.V_CONFIRM='Y' then 1 end) as 총투표건수 "
				+ "from tbl_member_202005 a join tbl_vote_202005 b "
				+ "on a.M_NO = b.M_NO group by 성명 order by 총투표건수 desc";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next() ) {
				Member member = new Member();
				member.setM_NO(rs.getString(1) );
				member.setM_NAME(rs.getString(2) );
				member.setV_TOTAL(rs.getString(3) );
				voteresult.add(member);
			}
			return voteresult;
		}catch (Exception e) { System.out.println("후보자등수오류 : "+ e );} 
		return null;
	}
	

}
