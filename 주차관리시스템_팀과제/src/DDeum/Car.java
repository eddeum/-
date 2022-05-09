package DDeum;

public class Car { 
	
	// 1. 鞘靛
	private String location = null;
	private int cnum;
	private String intime;
	private String outtime;
	private int fee;
	
	// 2. 积己磊
		// 1. 后积己磊
	public Car() {}
	
		public Car(int cnum, String intime) {
		super();
		this.cnum = cnum;
		this.intime = intime;
	}
		public Car(String location, int cnum, String intime) {
		super();
		this.location = location ;
		this.cnum = cnum;
		this.intime = intime;
	}

		
	// 2. 钱积己磊
		public Car(String location, int cnum, String intime, String outtime, int fee) {
			super();
			this.location = location;
			this.cnum = cnum;
			this.intime = intime;
			this.outtime = outtime;
			this.fee = fee;
		}

		// 3. 皋家靛

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public int getCnum() {
			return cnum;
		}

		public void setCnum(int cnum) {
			this.cnum = cnum;
		}

		public String getIntime() {
			return intime;
		}

		public void setIntime(String intime) {
			this.intime = intime;
		}

		public String getOuttime() {
			return outtime;
		}

		public void setOuttime(String outtime) {
			this.outtime = outtime;
		}

		public int getFee() {
			return fee;
		}

		public void setFee(int fee) {
			this.fee = fee;
		}


		

}
