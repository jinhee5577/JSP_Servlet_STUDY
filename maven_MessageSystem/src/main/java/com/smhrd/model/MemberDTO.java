package com.smhrd.model;

public class MemberDTO {
	// web_member 테이블에 대한 내용을 설계하는 DTO
	private String email;
	private String pw;
	private String tel;
	private String address;
	
	//생성자
	public MemberDTO(String email, String pw, String tel, String address) {
		super();
		this.email = email;
		this.pw = pw;
		this.tel = tel;
		this.address = address;
	}
	
	// 기본생성자 메서드
	public MemberDTO() {
	}
	

	// getter
	public String getEmail() {
		return email;
	}

	public String getPw() {
		return pw;
	}

	public String getTel() {
		return tel;
	}

	public String getAddress() {
		return address;
	}

	
	//setter
	public void setEmail(String email) {
		this.email = email;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	//
	
	
	
	
	

	
	

}
