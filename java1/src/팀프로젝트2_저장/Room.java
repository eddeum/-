package 팀프로젝트2_저장;

import java.sql.Date;

public class Room {
	
	// 필드
	private String rname;
	private String rprice;
	private boolean reserve;
	private String name;
	private java.util.Date date;
	
	// 생성자
	public Room() {}

	public Room(String rname, String rprice, boolean reserve, String name, java.util.Date date) {
		super();
		this.rname = rname;
		this.rprice = rprice;
		this.reserve = reserve;
		this.name = name;
		this.date = date;
	}

	// 메소드
	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getRprice() {
		return rprice;
	}

	public void setRprice(String rprice) {
		this.rprice = rprice;
	}

	public boolean isReserve() {
		return reserve;
	}

	public void setReserve(boolean reserve) {
		this.reserve = reserve;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public java.util.Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}



	


	

}
