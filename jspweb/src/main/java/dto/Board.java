package dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import dao.MemberDao;

public class Board {
	
	private int bnum;
    private String btitle;
    private String bcontent;
    private int mnum;
    private int bview;
    private String bdate;
    private String bfile;
    private String mid; // 화면 표시용
    
    
    public Board() {}

	public Board(int bnum, String btitle, String bcontent, int mnum, int bview, String bdate, String bfile,
			String mid) {
		super();
		this.bnum = bnum;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.mnum = mnum;
		this.bview = bview;
		// 작성일이 오늘이면 시간만 표시 아니면 날짜만 표시
			// 현재 날짜 : LocalDate.now()
		if(bdate != null) {
			DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // 날짜 형식 변환 설정
			String today = dateformat.format(LocalDate.now() ); // 오늘날짜를 문자열변환
			String boardday = bdate.split(" ")[0];
			String boardtime = bdate.split(" ")[1];
								// db에 저장된 게시물 등록날짜의 날짜/시간 중에 split으로 분리후 앞에 있는 날짜만 가져오기
			if(today.equals(boardday) ) { // 현재날짜와 게시물등록날짜와 동일하면
				this.bdate = boardtime;
			}else { // 동일하지 않으면
				this.bdate = boardday;
			} // else end
		}else {
			this.bdate = bdate;
		}

		this.bfile = bfile;
		this.mid = MemberDao.getmemberDao().getmid(mnum);
	}

	
	
	public int getBnum() {
		return bnum;
	}

	public void setBnum(int bnum) {
		this.bnum = bnum;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public int getMnum() {
		return mnum;
	}

	public void setMnum(int mnum) {
		this.mnum = mnum;
	}

	public int getBview() {
		return bview;
	}

	public void setBview(int bview) {
		this.bview = bview;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public String getBfile() {
		return bfile;
	}

	public void setBfile(String bfile) {
		this.bfile = bfile;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	// 테스트용도 -> 객체정보(필드정보) 출력 메소드
	@Override
	public String toString() {
		return "Board [bnum=" + bnum + ", btitle=" + btitle + ", bcontent=" + bcontent + ", mnum=" + mnum + ", bview="
				+ bview + ", bdate=" + bdate + ", bfile=" + bfile + ", mid=" + mid + "]";
	}
	

}
