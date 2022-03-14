package Day09;

public class Bank {
	
	// 1. 필드
	private String ano;
	private String password;
	private String owner;
	private int balance;
	
	// 2. 생성자
		// 1. 빈생성자
	public Bank() {}
		// 2. 풀생성자
	public Bank(String ano, String password, String owner, int balance) {
		super();
		this.ano = ano;
		this.password = password;
		this.owner = owner;
		this.balance = balance;
	}
	
	// 3. 메소드
		// get, set 메소드[필드가 private인 경우]
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
} // ce
