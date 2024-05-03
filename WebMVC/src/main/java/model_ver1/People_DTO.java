package model_ver1;

public class People_DTO {
	private String name;
	private String major;
	private String phone;
	
	// 생성자.
	public People_DTO(String name, String major, String phone) {
		this.name = name;
		this.major = major;
		this.phone = phone;
	}

	
	// getter
	public String getName() {
		return name;
	}

	public String getMajor() {
		return major;
	}

	public String getPhone() {
		return phone;
	}
	
	
	

}
