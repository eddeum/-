package 팀프로젝트;

public class Parking {
	
	// 1. 필드
	private int location;
	private int carnum;
	private String intime;
	private String outtime;
	private int fee;
	
	// 2. 생성자
	public Parking() {}

	public Parking(int location, int carnum, String intime, String outtime, int fee) {
		super();
		this.location = location;
		this.carnum = carnum;
		this.intime = intime;
		this.outtime = outtime;
		this.fee = fee;
	}

	// 3. 메소드
	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public int getCarnum() {
		return carnum;
	}

	public void setCarnum(int carnum) {
		this.carnum = carnum;
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
