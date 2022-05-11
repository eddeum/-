package dto;

public class Chat {
	
	private int cnum;
    private String cname;
    private String ccontent;
    
    public Chat() {}

	public Chat(int cnum, String cname, String ccontent) {
		super();
		this.cnum = cnum;
		this.cname = cname;
		this.ccontent = ccontent;
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

	public String getCcontent() {
		return ccontent;
	}

	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}
    
    

}
