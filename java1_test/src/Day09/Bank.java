package Day09;

public class Bank {
	
	// 1. �ʵ�
	private String ano;
	private String password;
	private String owner;
	private int balance;
	
	// 2. ������
		// 1. �������
	public Bank() {}
		// 2. Ǯ������
	public Bank(String ano, String password, String owner, int balance) {
		super();
		this.ano = ano;
		this.password = password;
		this.owner = owner;
		this.balance = balance;
	}
	
	// 3. �޼ҵ�
		// get, set �޼ҵ�[�ʵ尡 private�� ���]
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
