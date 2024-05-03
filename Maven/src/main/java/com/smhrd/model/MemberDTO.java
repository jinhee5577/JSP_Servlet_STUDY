package com.smhrd.model;

public class MemberDTO {
	private String id;
	private String pw;
	private String nic;
	
	// 생성자.
	public MemberDTO(String id, String pw, String nic) {
		this.id = id;
		this.pw = pw;
		this.nic = nic;
	}
	// 두번째 생성자.
	public MemberDTO(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	
	//getter
	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public String getNic() {
		return nic;
	}
	
	

}
