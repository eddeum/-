package team;

public class Country {
	
	private int cnum;
    private String cname;
    private String cbuyer;
    private int ccost;
    private int clocation;
    
    public Country() {}

	public Country(int cnum, String cname, String cbuyer, int ccost, int clocation) {
		super();
		this.cnum = cnum;
		this.cname = cname;
		this.cbuyer = cbuyer;
		this.ccost = ccost;
		this.clocation = clocation;
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

	public String getCbuyer() {
		return cbuyer;
	}

	public void setCbuyer(String cbuyer) {
		this.cbuyer = cbuyer;
	}

	public int getCcost() {
		return ccost;
	}

	public void setCcost(int ccost) {
		this.ccost = ccost;
	}

	public int getClocation() {
		return clocation;
	}

	public void setClocation(int clocation) {
		this.clocation = clocation;
	}

    // 테스트용
	
	@Override
	public String toString() {
		return "Country [cnum=" + cnum + ", cname=" + cname + ", cbuyer=" + cbuyer + ", ccost=" + ccost + ", clocation="
				+ clocation + "]";
	}
	

}
