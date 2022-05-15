package team;

public class User {
	
	private int unum;
    private String mid;
    private int ulocation;
    private int umoney;
    private int uturn;
    
    public User() { }

	public User(int unum, String mid, int ulocation, int umoney, int uturn) {
		super();
		this.unum = unum;
		this.mid = mid;
		this.ulocation = ulocation;
		this.umoney = umoney;
		this.uturn = uturn;
	}

	public int getUnum() {
		return unum;
	}

	public void setUnum(int unum) {
		this.unum = unum;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public int getUlocation() {
		return ulocation;
	}

	public void setUlocation(int ulocation) {
		this.ulocation = ulocation;
	}

	public int getUmoney() {
		return umoney;
	}

	public void setUmoney(int umoney) {
		this.umoney = umoney;
	}

	public int getUturn() {
		return uturn;
	}

	public void setUturn(int uturn) {
		this.uturn = uturn;
	}

    // 테스트용
	@Override
	public String toString() {
		return "User [unum=" + unum + ", mid=" + mid + ", ulocation=" + ulocation + ", umoney=" + umoney + ", uturn="
				+ uturn + "]";
	}    

	
}
