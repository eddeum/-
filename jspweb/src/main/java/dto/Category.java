package dto;

public class Category {
	
	private int cnum;
    private String cname;

    public Category() {}

	public Category(int cnum, String cname) {
		super();
		this.cnum = cnum;
		this.cname = cname;
	}

	public int getCnum() {
		return cnum;
	}

	public void setCnum(int cnum) {
		this.cnum = cnum;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	// 테스트용
	@Override
	public String toString() {
		return "Category [cnum=" + cnum + ", cname=" + cname + "]";
	}

	
}
