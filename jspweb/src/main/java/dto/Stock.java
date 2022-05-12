package dto;

public class Stock {

	private int snum;
	private String scolor;
    private String ssize;
    private int samount;
    private String firstdate;
    private String updatedate;
    private int pnum;
    
    public Stock() {}

	public Stock(int snum, String scolor, String ssize, int samount, String firstdate, String updatedate, int pnum) {
		super();
		this.snum = snum;
		this.scolor = scolor;
		this.ssize = ssize;
		this.samount = samount;
		this.firstdate = firstdate;
		this.updatedate = updatedate;
		this.pnum = pnum;
	}

	public int getSnum() {
		return snum;
	}

	public void setSnum(int snum) {
		this.snum = snum;
	}

	public String getScolor() {
		return scolor;
	}

	public void setScolor(String scolor) {
		this.scolor = scolor;
	}

	public String getSsize() {
		return ssize;
	}

	public void setSsize(String ssize) {
		this.ssize = ssize;
	}

	public int getSamount() {
		return samount;
	}

	public void setSamount(int samount) {
		this.samount = samount;
	}

	public String getFirstdate() {
		return firstdate;
	}

	public void setFirstdate(String firstdate) {
		this.firstdate = firstdate;
	}

	public String getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}

	public int getPnum() {
		return pnum;
	}

	public void setPnum(int pnum) {
		this.pnum = pnum;
	}

	// 테스트용
	@Override
	public String toString() {
		return "Stock [snum=" + snum + ", scolor=" + scolor + ", ssize=" + ssize + ", samount=" + samount
				+ ", firstdate=" + firstdate + ", updatedate=" + updatedate + ", pnum=" + pnum + "]";
	}
    
}
