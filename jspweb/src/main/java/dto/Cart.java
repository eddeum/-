package dto;

public class Cart {
	
	 private int cartnum;
	 private int samount;
	 private int totalprice; 
	 private int snum;
	 private int mnum; 

	 public Cart() {}

	public Cart(int cartnum, int samount, int totalprice, int snum, int mnum) {
		super();
		this.cartnum = cartnum;
		this.samount = samount;
		this.totalprice = totalprice;
		this.snum = snum;
		this.mnum = mnum;
	}

	public int getCartnum() {
		return cartnum;
	}

	public void setCartnum(int cartnum) {
		this.cartnum = cartnum;
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

	public int getSnum() {
		return snum;
	}

	public void setSnum(int snum) {
		this.snum = snum;
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
		return "Cart [cartnum=" + cartnum + ", samount=" + samount + ", totalprice=" + totalprice + ", snum=" + snum
				+ ", mnum=" + mnum + "]";
	}

	
}
