package com.model;

public class memberDTO {

	
	private String email;
	private String pw;
	private String tel;
	private String addr;
	
	public memberDTO(String email, String pw, String tel, String addr) {
		this.email = email;
		this.pw = pw;
		this.tel = tel;
		this.addr = addr;
	}
	
	public memberDTO(String email, String pw) {
		this.email = email;
		this.pw = pw;
	}

	public String getEmail() {
		return email;
	}

	public String getPw() {
		return pw;
	}

	public String getTel() {
		return tel;
	}

	public String getAddr() {
		return addr;
	}
	
	
}
