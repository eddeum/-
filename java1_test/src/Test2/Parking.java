package Test2;

import java.time.LocalDate;
import java.time.LocalTime;

public class Parking {
	
	// 1. �ʵ�
	private LocalDate ��¥;
	private String ������ȣ;
	private String �����ð�;
	private String �����ð�;
	private int �ݾ�;
	
	// 2. ������
	public Parking() {}

	public Parking(LocalDate ��¥, String ������ȣ, String �����ð�, String �����ð�, int �ݾ�) {
		super();
		this.��¥ = ��¥;
		this.������ȣ = ������ȣ;
		this.�����ð� = �����ð�;
		this.�����ð� = �����ð�;
		this.�ݾ� = �ݾ�;
	}


	public Parking(LocalDate ��¥, String ������ȣ, String �����ð�) {
		super();
		this.��¥ = ��¥;
		this.������ȣ = ������ȣ;
		this.�����ð� = �����ð�;
	}

	// 3. �޼ҵ�
	public LocalDate get��¥() {
		return ��¥;
	}

	public void set��¥(LocalDate ��¥) {
		this.��¥ = ��¥;
	}

	public String get������ȣ() {
		return ������ȣ;
	}

	public void set������ȣ(String ������ȣ) {
		this.������ȣ = ������ȣ;
	}

	public String get�����ð�() {
		return �����ð�;
	}

	public void set�����ð�(String �����ð�) {
		this.�����ð� = �����ð�;
	}

	public String get�����ð�() {
		return �����ð�;
	}

	public void set�����ð�(String �����ð�) {
		this.�����ð� = �����ð�;
	}

	public int get�ݾ�() {
		return �ݾ�;
	}

	public void set�ݾ�(int �ݾ�) {
		this.�ݾ� = �ݾ�;
	}



	
	
	
	

}
