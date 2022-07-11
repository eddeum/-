package dto;

public class Orderdetail {

	private int orderdetailnum;
	private int orderdetailactive;
	private int snum; 
	private int samount;
	private int totalprice;
	private int ordernum;
	
	public Orderdetail() {}

	public Orderdetail(int orderdetailnum, int orderdetailactive, int snum, int samount, int totalprice, int ordernum) {
		super();
		this.orderdetailnum = orderdetailnum;
		this.orderdetailactive = orderdetailactive;
		this.snum = snum;
		this.samount = samount;
		this.totalprice = totalprice;
		this.ordernum = ordernum;
	}

	public int getOrderdetailnum() {
		return orderdetailnum;
	}

	public void setOrderdetailnum(int orderdetailnum) {
		this.orderdetailnum = orderdetailnum;
	}

	public int getOrderdetailactive() {
		return orderdetailactive;
	}

	public void setOrderdetailactive(int orderdetailactive) {
		this.orderdetailactive = orderdetailactive;
	}

	public int getSnum() {
		return snum;
	}

	public void setSnum(int snum) {
		this.snum = snum;
	}

	public int getSamount() {
		return samount;
	}

	public void setSamount(int samount) {
		this.samount = samount;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public int getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(int ordernum) {
		this.ordernum = ordernum;
	}

	// 테스트용
	@Override
	public String toString() {
		return "Orderdetail [orderdetailnum=" + orderdetailnum + ", orderdetailactive=" + orderdetailactive + ", snum="
				+ snum + ", samount=" + samount + ", totalprice=" + totalprice + ", ordernum=" + ordernum + "]";
	}
	
}
