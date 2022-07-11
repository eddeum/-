package dto;

public class Order {
	
	private int ordernum;
	private String orderdate;
	private String ordername;
	private String orderphone;
	private String orderaddress ;
	private int ordertotalpay;
	private int orderactive;
	private String orderrequest;
	private int orderdelivernum;
	private int mnum;
	
	public Order() {}

	public Order(int ordernum, String orderdate, String ordername, String orderphone, String orderaddress,
			int ordertotalpay, int orderactive, String orderrequest, int orderdelivernum, int mnum) {
		super();
		this.ordernum = ordernum;
		this.orderdate = orderdate;
		this.ordername = ordername;
		this.orderphone = orderphone;
		this.orderaddress = orderaddress;
		this.ordertotalpay = ordertotalpay;
		this.orderactive = orderactive;
		this.orderrequest = orderrequest;
		this.orderdelivernum = orderdelivernum;
		this.mnum = mnum;
	}

	public int getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(int ordernum) {
		this.ordernum = ordernum;
	}

	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	public String getOrdername() {
		return ordername;
	}

	public void setOrdername(String ordername) {
		this.ordername = ordername;
	}

	public String getOrderphone() {
		return orderphone;
	}

	public void setOrderphone(String orderphone) {
		this.orderphone = orderphone;
	}

	public String getOrderaddress() {
		return orderaddress;
	}

	public void setOrderaddress(String orderaddress) {
		this.orderaddress = orderaddress;
	}

	public int getOrdertotalpay() {
		return ordertotalpay;
	}

	public void setOrdertotalpay(int ordertotalpay) {
		this.ordertotalpay = ordertotalpay;
	}

	public int getOrderactive() {
		return orderactive;
	}

	public void setOrderactive(int orderactive) {
		this.orderactive = orderactive;
	}

	public String getOrderrequest() {
		return orderrequest;
	}

	public void setOrderrequest(String orderrequest) {
		this.orderrequest = orderrequest;
	}

	public int getOrderdelivernum() {
		return orderdelivernum;
	}

	public void setOrderdelivernum(int orderdelivernum) {
		this.orderdelivernum = orderdelivernum;
	}

	public int getMnum() {
		return mnum;
	}

	public void setMnum(int mnum) {
		this.mnum = mnum;
	}

	
	// 테스트용
	@Override
	public String toString() {
		return "Order [ordernum=" + ordernum + ", orderdate=" + orderdate + ", ordername=" + ordername + ", orderphone="
				+ orderphone + ", orderaddress=" + orderaddress + ", ordertotalpay=" + ordertotalpay + ", orderactive="
				+ orderactive + ", orderrequest=" + orderrequest + ", orderdelivernum=" + orderdelivernum + ", mnum="
				+ mnum + "]";
	}

}
