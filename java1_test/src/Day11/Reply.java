package Day11;

public class Reply {
	
	// 1. 필드
	private String content;
	private String password;
	private String wirter;
	private String date;
	
	// 2. 생성자
	public Reply() {}

	public Reply(String content, String password, String wirter, String date) {
		super();
		this.content = content;
		this.password = password;
		this.wirter = wirter;
		this.date = date;
	}
	
	// 3. 메소드
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getWirter() {
		return wirter;
	}

	public void setWirter(String wirter) {
		this.wirter = wirter;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	

}
