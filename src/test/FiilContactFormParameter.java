package test;

public class FiilContactFormParameter {
	private String nameF;
	private String nameL;
	private String address;
	private String phoneH;
	private String phoneM;
	private String phoneW;
	private String email1;
	private String email2;
	private String bday;
	private String bmonth;
	private String byear;
	private String address2;

	public FiilContactFormParameter(String nameF, String nameL, String address,
			String phoneH, String phoneM, String phoneW, String email1,
			String email2, String bday, String bmonth, String byear,
			String address2) {
		this.nameF = nameF;
		this.nameL = nameL;
		this.address = address;
		this.phoneH = phoneH;
		this.phoneM = phoneM;
		this.phoneW = phoneW;
		this.email1 = email1;
		this.email2 = email2;
		this.bday = bday;
		this.bmonth = bmonth;
		this.byear = byear;
		this.address2 = address2;
	}

	public String getNameF() {
		return nameF;
	}

	public String getNameL() {
		return nameL;
	}

	public String getAddress() {
		return address;
	}

	public String getPhoneH() {
		return phoneH;
	}

	public String getPhoneM() {
		return phoneM;
	}

	public String getPhoneW() {
		return phoneW;
	}

	public String getEmail1() {
		return email1;
	}

	public String getEmail2() {
		return email2;
	}

	public String getBday() {
		return bday;
	}

	public String getBmonth() {
		return bmonth;
	}

	public String getByear() {
		return byear;
	}

	public String getAddress2() {
		return address2;
	}
}