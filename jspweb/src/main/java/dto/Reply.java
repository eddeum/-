package dto;

import dao.MemberDao;

public class Reply {

	private int rnum;
	private String rcontent;
	private String rdate;
	private int rindex;
	private int bnum;
	private int mnum;
	private String mid;
	
	public Reply() {}

	public Reply(int rnum, String rcontent, String rdate, int rindex, int bnum, int mnum, String mid) {
		super();
		this.rnum = rnum;
		this.rcontent = rcontent;
		this.rdate = rdate;
		this.rindex = rindex;
		this.bnum = bnum;
		this.mnum = mnum;
		this.mid = MemberDao.getmemberDao().getmid(mnum);
	}

	// 테스트용도 -> 객체정보(필드정보) 출력 메소드
	@Override
	public String toString() {
		return "Reply [rnum=" + rnum + ", rcontent=" + rcontent + ", rdate=" + rdate + ", rindex=" + rindex + ", bnum="
				+ bnum + ", mnum=" + mnum + ", mid=" + mid + "]";
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	public String getRcontent() {
		return rcontent;
	}

	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public int getRindex() {
		return rindex;
	}

	public void setRindex(int rindex) {
		this.rindex = rindex;
	}

	public int getBnum() {
		return bnum;
	}

	public void setBnum(int bnum) {
		this.bnum = bnum;
	}

	public int getMnum() {
		return mnum;
	}

	public void setMnum(int mnum) {
		this.mnum = mnum;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}
	

} // class end
