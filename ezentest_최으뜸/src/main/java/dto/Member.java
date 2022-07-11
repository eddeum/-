package dto;

public class Member {
	
	private String M_NO;
	private String M_NAME;
	private String P_CODE;
	private String P_SCHOOL;
	private String M_JUMIN;
	private String M_CITY;
	private String P_NAME ; // join으로 인한 추가
	private String P_TEL;	// join으로 인한 추가
	private String V_TOTAL;
	
	public Member() {}

	public Member(String m_NO, String m_NAME, String p_CODE, String p_SCHOOL, String m_JUMIN, String m_CITY,
			String p_NAME, String p_TEL) {
		super();
		M_NO = m_NO;
		M_NAME = m_NAME;
		P_CODE = p_CODE;
		P_SCHOOL = p_SCHOOL;
		M_JUMIN = m_JUMIN;
		M_CITY = m_CITY;
		P_NAME = p_NAME;
		P_TEL = p_TEL;
	}

	public String getM_NO() {
		return M_NO;
	}

	public void setM_NO(String m_NO) {
		M_NO = m_NO;
	}

	public String getM_NAME() {
		return M_NAME;
	}

	public void setM_NAME(String m_NAME) {
		M_NAME = m_NAME;
	}

	public String getP_CODE() {
		return P_CODE;
	}

	public void setP_CODE(String p_CODE) {
		P_CODE = p_CODE;
	}

	public String getP_SCHOOL() {
		return P_SCHOOL;
	}

	public void setP_SCHOOL(String p_SCHOOL) {
		P_SCHOOL = p_SCHOOL;
	}

	public String getM_JUMIN() {
		return M_JUMIN;
	}

	public void setM_JUMIN(String m_JUMIN) {
		M_JUMIN = m_JUMIN;
	}

	public String getM_CITY() {
		return M_CITY;
	}

	public void setM_CITY(String m_CITY) {
		M_CITY = m_CITY;
	}

	public String getP_NAME() {
		return P_NAME;
	}

	public void setP_NAME(String p_NAME) {
		P_NAME = p_NAME;
	}

	public String getP_TEL() {
		return P_TEL;
	}

	public void setP_TEL(String p_TEL) {
		P_TEL = p_TEL;
	}

	public String getV_TOTAL() {
		return V_TOTAL;
	}

	public void setV_TOTAL(String v_TOTAL) {
		V_TOTAL = v_TOTAL;
	}

	

	

	
	

}
